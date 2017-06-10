package com.sb205.missing_pieces.Shelf;

import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.Color;
import java.util.Arrays;

import javax.annotation.Nullable;

/**
 * User: brandon3055
 * Date: 06/01/2015
 *
 * This is a simple tile entity implementing IInventory that can store 4 item stacks
 */
public class TileEntityShelf extends TileEntity implements IInventory {
	// Create and initialize the items variable that will store store the items
	final int NUMBER_OF_SLOTS = 4;
	private ItemStack[] itemStacks = new ItemStack[NUMBER_OF_SLOTS];

	/* The following are some IInventory methods you are required to override */
	public TileEntityShelf(){
		for(int slot = 0; slot < NUMBER_OF_SLOTS; slot++){
			itemStacks[slot] = new ItemStack(Blocks.AIR,1);
		}
	}
	// Gets the number of slots in the inventory
	@Override
	public int getSizeInventory() {
		return itemStacks.length;
	}

	// Gets the stack in the given slot
	@Override
	public ItemStack getStackInSlot(int slotIndex) {
		return itemStacks[slotIndex];
		
	}

	/**
	 * Removes some of the units from itemstack in the given slot, and returns as a separate itemstack
 	 * @param slotIndex the slot number to remove the items from
	 * @param count the number of units to remove
	 * @return a new itemstack containing the units removed from the slot
	 */
	@Override
	public ItemStack decrStackSize(int slotIndex, int count) {
		ItemStack itemStackInSlot = getStackInSlot(slotIndex);
		if (itemStackInSlot == null) return new ItemStack(Blocks.AIR,1);
		if (itemStackInSlot == new ItemStack(Blocks.AIR,1)) return itemStackInSlot;

		ItemStack itemStackRemoved;
		if (itemStackInSlot.getCount() <= count) {
			itemStackRemoved = itemStackInSlot;
			setInventorySlotContents(slotIndex, new ItemStack(Blocks.AIR,1));
		} else {
			itemStackRemoved = itemStackInSlot.splitStack(count);
			if (itemStackInSlot.getCount() == 0) {
				setInventorySlotContents(slotIndex, new ItemStack(Blocks.AIR,1));
			}
		}
	  markDirty();
		return itemStackRemoved;
	}

	// overwrites the stack in the given slotIndex with the given stack
	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemstack) {
		itemStacks[slotIndex] = itemstack;
		//if (itemstack != null && itemstack.func_190916_E() > getInventoryStackLimit()) {
	//		itemstack.func_190916_E() = getInventoryStackLimit();
	//	}
		//System.out.println("setInventoryContents: " + slotIndex + " " + itemstack);
		markDirty();
	}

	// This is the maximum number if items allowed in each slot
	// This only affects things such as hoppers trying to insert items you need to use the container to enforce this for players
	// inserting items via the gui
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	// Return true if the given player is able to use this block. In this case it checks that
	// 1) the world tileentity hasn't been replaced in the meantime, and
	// 2) the player isn't too far away from the centre of the block
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (this.world.getTileEntity(this.pos) != this) return false;
		final double X_CENTRE_OFFSET = 0.5;
		final double Y_CENTRE_OFFSET = 0.5;
		final double Z_CENTRE_OFFSET = 0.5;
		final double MAXIMUM_DISTANCE_SQ = 8.0 * 8.0;
		return player.getDistanceSq(pos.getX() + X_CENTRE_OFFSET, pos.getY() + Y_CENTRE_OFFSET, pos.getZ() + Z_CENTRE_OFFSET) < MAXIMUM_DISTANCE_SQ;
	}

	// Return true if the given stack is allowed to go in the given slot.  In this case, we can insert anything.
	// This only affects things such as hoppers trying to insert items you need to use the container to enforce this for players
	// inserting items via the gui
	@Override
	public boolean isItemValidForSlot(int slotIndex, ItemStack itemstack) {
		return true;
	}

	// This is where you save any data that you don't want to lose when the tile entity unloads
	// In this case, it saves the itemstacks stored in the container
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.writeToNBT(parentNBTTagCompound); // The super call is required to save and load the tileEntity's location
		// to use an analogy with Java, this code generates an array of hashmaps
		// The itemStack in each slot is converted to an NBTTagCompound, which is effectively a hashmap of key->value pairs such
		//   as slot=1, id=2353, count=1, etc
		// Each of these NBTTagCompound are then inserted into NBTTagList, which is similar to an array.
		NBTTagList dataForAllSlots = new NBTTagList();
		for (int i = 0; i < this.itemStacks.length; ++i) {
			if (this.itemStacks[i] != null)	{
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);

			}
		}
		// the array of hashmaps is then inserted into the parent hashmap for the container
		parentNBTTagCompound.setTag("Items", dataForAllSlots);
		//System.out.println("writetoNBT");
		return parentNBTTagCompound;
		
		
	}


	// This is where you load the data that you saved in writeToNBT
	@Override
	public void readFromNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.readFromNBT(parentNBTTagCompound); // The super call is required to save and load the tiles location
		final byte NBT_TYPE_COMPOUND = 10;       // See NBTBase.createNewByType() for a listing
		
		NBTTagList dataForAllSlots = parentNBTTagCompound.getTagList("Items", NBT_TYPE_COMPOUND);

		Arrays.fill(itemStacks, new ItemStack(Blocks.AIR,1));           // set all slots to empty
		for (int i = 0; i < dataForAllSlots.tagCount(); ++i) {
			NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
			int slotIndex = dataForOneSlot.getByte("Slot") & 255;

			if (slotIndex >= 0 && slotIndex < this.itemStacks.length) {
				//this.itemStacks[slotIndex] = ItemStack.loadItemStackFromNBT(dataForOneSlot);
				setInventorySlotContents(slotIndex, new ItemStack(dataForOneSlot));
				//System.out.println("loaditem: " + slotIndex + " " + this.itemStacks[slotIndex]);
			}
		}
		//System.out.println("pos:" + this.getPos());
		//System.out.println("readfromNBT");
	}

	// set all slots to empty
	@Override
	public void clear() {
		Arrays.fill(itemStacks, new ItemStack(Blocks.AIR,1));
	}

	// will add a key for this container to the lang file so we can name it in the GUI
	public String getName() {
		return "tile.shelf.name";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	// standard code to look up what the human-readable name is
	@Override
	public ITextComponent getDisplayName() {
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	// -----------------------------------------------------------------------------------------------------------
	// The following methods are not needed for this example but are part of IInventory so they must be implemented

	/**
	 * This method removes the entire contents of the given slot and returns it.
	 * Used by containers such as crafting tables which return any items in their slots when you close the GUI
	 * @param slotIndex
	 * @return
	 */
	//@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) {
		ItemStack itemStack = getStackInSlot(slotIndex);
		if (itemStack != null) setInventorySlotContents(slotIndex, new ItemStack(Blocks.AIR,1));
		return itemStack;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {}

	@Override
	public int getFieldCount() {
		return 0;
	}
	
	
	

	// When the world loads from disk, the server needs to send the TileEntity information to the client
	//  it uses getUpdatePacket() and onDataPacket() to do this

	
	@Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
		int metadata = getBlockMetadata();

        return new SPacketUpdateTileEntity(this.pos, metadata, this.getUpdateTag());
    }

    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
		//System.out.println("onDataPacket");

	}


	/**
	 * Don't render the shelf if the player is too far away
	 * @return the maximum distance squared at which the TESR should render
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public double getMaxRenderDistanceSquared()
	{
		final int MAXIMUM_DISTANCE_IN_BLOCKS = 32;
		return MAXIMUM_DISTANCE_IN_BLOCKS * MAXIMUM_DISTANCE_IN_BLOCKS;
	}

	/** Return an appropriate bounding box enclosing the TESR
	 * This method is used to control whether the TESR should be rendered or not, depending on where the player is looking.
	 * The default is the AABB for the parent block, which might be too small if the TESR renders outside the borders of the
	 *   parent block.
	 * If you get the boundary too small, the TESR may disappear when you aren't looking directly at it.
	 * @return an appropriately size AABB for the TileEntity
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getRenderBoundingBox()
	{
		// if your render should always be performed regardless of where the player is looking, use infinite
		AxisAlignedBB infiniteExample = INFINITE_EXTENT_AABB;

		// our gem will stay above the block, up to 1 block higher, so our bounding box is from [x,y,z] to  [x+1, y+2, z+1]
		AxisAlignedBB aabb = new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
		return aabb;
	}

	//@Override
	public String getCommandSenderName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack itemStack = getStackInSlot(index);
		setInventorySlotContents(index, new ItemStack(Blocks.AIR,1));
		return itemStack;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}




	
}
