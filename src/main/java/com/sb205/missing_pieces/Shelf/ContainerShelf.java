package com.sb205.missing_pieces.Shelf;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */
public class ContainerShelf extends Container {

	// Stores a reference to the tile entity instance for later use
	private TileEntityShelf tileEntityShelf;

	// must assign a slot number to each of the slots used by the GUI.
	// For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
	// Each time we add a Slot to the container, it automatically increases the slotIndex, which means
	//  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
	//  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
	//  36 - 39 = TileInventory slots, which map to our TileEntity slot numbers 0 - 3)

	private final int HOTBAR_SLOT_COUNT = 9;
	private final int PLAYER_INVENTORY_ROW_COUNT = 3;
	private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
	private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
	private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

	private final int VANILLA_FIRST_SLOT_INDEX = 0;
	private final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
	private final int TE_INVENTORY_SLOT_COUNT = 4;

	public ContainerShelf(InventoryPlayer invPlayer, TileEntityShelf tileEntityShelf) {
		this.tileEntityShelf = tileEntityShelf;

		final int SLOT_X_SPACING = 18;
		final int SLOT_Y_SPACING = 18;
		final int HOTBAR_XPOS = 8;
		final int HOTBAR_YPOS = 140;
		// Add the players hotbar to the gui - the [xpos, ypos] location of each item
		for (int x = 0; x < HOTBAR_SLOT_COUNT; x++) {
			int slotNumber = x;
			addSlotToContainer(new Slot(invPlayer, slotNumber, HOTBAR_XPOS + SLOT_X_SPACING * x, HOTBAR_YPOS));
		}

		final int PLAYER_INVENTORY_XPOS = 8;
		final int PLAYER_INVENTORY_YPOS = 82;
		// Add the rest of the players inventory to the gui
		for (int y = 0; y < PLAYER_INVENTORY_ROW_COUNT; y++) {
			for (int x = 0; x < PLAYER_INVENTORY_COLUMN_COUNT; x++) {
				int slotNumber = HOTBAR_SLOT_COUNT + y * PLAYER_INVENTORY_COLUMN_COUNT + x;
				int xpos = PLAYER_INVENTORY_XPOS + x * SLOT_X_SPACING;
				int ypos = PLAYER_INVENTORY_YPOS + y * SLOT_Y_SPACING;
				addSlotToContainer(new Slot(invPlayer, slotNumber,  xpos, ypos));
			}
		}

		if (TE_INVENTORY_SLOT_COUNT != tileEntityShelf.getSizeInventory()) {
			System.err.println("Mismatched slot count in ContainerBasic(" + TE_INVENTORY_SLOT_COUNT
												  + ") and TileInventory (" + tileEntityShelf.getSizeInventory()+")");
		}
		final int TILE_INVENTORY_X1POS = 62;
		final int TILE_INVENTORY_Y1POS = 20;
		final int TILE_INVENTORY_X2POS = TILE_INVENTORY_X1POS + 2*SLOT_X_SPACING;
		final int TILE_INVENTORY_Y2POS = 51;
		// Add the tile inventory container to the gui
		addSlotToContainer(new Slot(tileEntityShelf, 0, TILE_INVENTORY_X1POS, TILE_INVENTORY_Y1POS));
		addSlotToContainer(new Slot(tileEntityShelf, 1, TILE_INVENTORY_X2POS, TILE_INVENTORY_Y1POS));
		addSlotToContainer(new Slot(tileEntityShelf, 2, TILE_INVENTORY_X1POS, TILE_INVENTORY_Y2POS));
		addSlotToContainer(new Slot(tileEntityShelf, 3, TILE_INVENTORY_X2POS, TILE_INVENTORY_Y2POS));
		
	}

	// Vanilla calls this method every tick to make sure the player is still able to access the inventory, and if not closes the gui
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileEntityShelf.isUseableByPlayer(player);
	}

	// This is where you specify what happens when a player shift clicks a slot in the gui
	//  (when you shift click a slot in the TileEntity Inventory, it moves it to the first available position in the hotbar and/or
	//    player inventory.  When you you shift-click a hotbar or player inventory item, it moves it to the first available
	//    position in the TileEntity inventory)
	// At the very least you must override this and return null or the game will crash when the player shift clicks a slot
	// returns null if the source slot is empty, or if none of the the source slot items could be moved
	//   otherwise, returns a copy of the source stack
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int sourceSlotIndex)
	{
		Slot sourceSlot = (Slot)inventorySlots.get(sourceSlotIndex);
		if (sourceSlot == null || !sourceSlot.getHasStack()) return null;
		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		// Check if the slot clicked is one of the vanilla container slots
		if (sourceSlotIndex >= VANILLA_FIRST_SLOT_INDEX && sourceSlotIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
			// This is a vanilla container slot so merge the stack into the tile inventory
			if (!mergeItemStack(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)){
				return null;
			}
		} else if (sourceSlotIndex >= TE_INVENTORY_FIRST_SLOT_INDEX && sourceSlotIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
			// This is a TE slot so merge the stack into the players inventory
			if (!mergeItemStack(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
				return null;
			}
		} else {
			System.err.print("Invalid slotIndex:" + sourceSlotIndex);
			return null;
		}

		// If stack size == 0 (the entire stack was moved) set slot contents to null
		if (sourceStack.stackSize == 0) {
			sourceSlot.putStack(null);
		} else {
			sourceSlot.onSlotChanged();
		}

		sourceSlot.onPickupFromSlot(player, sourceStack);
		return copyOfSourceStack;
	}

	// pass the close container message to the tileEntityInventory (not strictly needed for this example)
	//  see ContainerChest and TileEntityChest
	@Override
	public void onContainerClosed(EntityPlayer playerIn)
	{
		super.onContainerClosed(playerIn);
		this.tileEntityShelf.closeInventory(playerIn);
	}
}
