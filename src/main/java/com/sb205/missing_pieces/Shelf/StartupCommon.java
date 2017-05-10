package com.sb205.missing_pieces.Shelf;

import com.sb205.missing_pieces.GuiHandlerRegistry;
import com.sb205.missing_pieces.MissingPieces;
import com.sb205.missing_pieces.Shelf.BlockShelf.ShelfInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */
public class StartupCommon
{
	public static Block blockShelf, shelf_oak;  // this holds the unique instance of your block

	public static void preInitCommon()
	{
		for (ShelfInfo shelf: ShelfInfo.values()) {
			  if(shelf.enabled) {

				// each instance of your block should have a name that is unique within your mod.  use lower case.
			    GameRegistry.registerBlock(blockShelf, shelf.getName());

			    // Each of your tile entities needs to be registered with a name that is unique to your mod.
				GameRegistry.registerTileEntity(TileEntityShelf.class, shelf.getName());
				// you don't need to register an item corresponding to the block, GameRegistry.registerBlock does this automatically.
				
			    GameRegistry.addRecipe(new ItemStack(blockShelf, 3),
			        	" A ",
			        	"ABA",
			        	" A ",
			        	'A', shelf.shelfIngredientA,
			        	'B', BlockType.BT_CHEST
			    );
			  }
		}

		// You need to register a GUIHandler for the container.  However there can be only one handler per mod, so for the purposes
		//   of this project, we create a single GuiHandlerRegistry for all examples.
		// We register this GuiHandlerRegistry with the NetworkRegistry, and then tell the GuiHandlerRegistry about
		//   each example's GuiHandler, in this case GuiHandler, so that when it gets a request from NetworkRegistry,
		//   it passes the request on to the correct example's GuiHandler.
		NetworkRegistry.INSTANCE.registerGuiHandler(MissingPieces.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerShelf(), GuiHandlerShelf.getGuiID());
	}

	public static void initCommon()
	{
	}

	public static void postInitCommon()
	{
	}
}
