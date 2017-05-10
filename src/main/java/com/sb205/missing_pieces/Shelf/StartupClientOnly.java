package com.sb205.missing_pieces.Shelf;



import com.sb205.missing_pieces.Shelf.BlockShelf.ShelfInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * User: sboy205
 * Date: 06/01/2015
 *
 * The Startup class for this example is called during startup, in the following order:
 *  preInitCommon
 *  preInitClientOnly
 *  initCommon
 *  initClientOnly
 *  postInitCommon
 *  postInitClientOnly
 *  See MinecraftByExample class for more information
 */
public class StartupClientOnly
{
	public static void preInitClientOnly()
	{
	    //Item itemBlockVariants = GameRegistry.findItem("missing_pieces", "mbe03_block_variants");

	    // need to add the variants to the bakery so it knows what models are available for rendering the different subtypes
	    //ModelBakery.addVariantName(itemBlockVariants, "missing_pieces:shelf_model",
	   //         "missing_pieces:shelf_model",
	    //        "missing_pieces:shelf_model",
	    //        "missing_pieces:shelf_model");

	}

	public static void initClientOnly()
	{

		final int DEFAULT_ITEM_SUBTYPE = 0;
		for (ShelfInfo shelf: ShelfInfo.values() ) {
			if(shelf.enabled) { 

				Item itemBlockShelf = GameRegistry.findItem("missing_pieces", shelf.getName());
				ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("missing_pieces:"+shelf.getName(), "inventory");
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockShelf, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
			}

		}
	    
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShelf.class, new TileEntitySpecialRendererShelf());

	}

	public static void postInitClientOnly()
	{
	}
}
