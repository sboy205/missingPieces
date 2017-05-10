package com.sb205.missing_pieces.Shelf;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */
public class GuiHandlerShelf implements IGuiHandler {
	private static final int GUIID_SB205MP = 30;
	public static int getGuiID() {return GUIID_SB205MP;}

	// Gets the server side element for the given gui id- this should return a container
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityShelf) {
			TileEntityShelf tileEntityInventoryBasic = (TileEntityShelf) tileEntity;
			return new ContainerShelf(player.inventory, tileEntityInventoryBasic);
		}
		return null;
	}

	// Gets the client side element for the given gui id- this should return a gui
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityShelf) {
			TileEntityShelf tileEntityInventoryBasic = (TileEntityShelf) tileEntity;
			return new GuiInventoryShelf(player.inventory, tileEntityInventoryBasic);
		}
		return null;
	}
}
