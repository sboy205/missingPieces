package com.sb205.missing_pieces;

import com.sb205.missing_pieces.Config.MpConfiguration;
import com.sb205.missing_pieces.Config.MpConfiguration.ConfigInfo;
import com.sb205.missing_pieces.MpBlocks.BlockChair;
import com.sb205.missing_pieces.MpItems.ItemSpindle;
import com.sb205.missing_pieces.Utilities.BlockInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public class Items {

	// Declare all Items here.. only one spindle .. used to make tables and chairs
	public static ItemSpindle item_spindle;
	public static ItemSpindle item_flat_spindle;
	public static ItemSpindle item_tall_spindle;
	public static ItemSpindle item_bent_spindle;
	private static IForgeRegistry<Item> itemRegistry;



		
	// Init Calls
	public static void preInitCommon() {
		itemRegistry =ForgeRegistries.ITEMS; 

		item_spindle = 			createSpindle("spindle",		1, MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] );
		item_flat_spindle = 	createSpindle("flat_spindle",	2, MpConfiguration.BlockEnable[ConfigInfo.MISC_FLAT_SPINDLE.ordinal()] );
		item_tall_spindle = 	createSpindle("tall_spindle",	3, MpConfiguration.BlockEnable[ConfigInfo.MISC_TALL_SPINDLE.ordinal()] );
		item_bent_spindle = 	createSpindle("bent_spindle",	4, MpConfiguration.BlockEnable[ConfigInfo.MISC_BENT_SPINDLE.ordinal()] );

	};
	
	public static void initClientOnly(){
		registerItem(item_spindle, 			MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] );
		registerItem(item_flat_spindle, 	MpConfiguration.BlockEnable[ConfigInfo.MISC_FLAT_SPINDLE.ordinal()] );
		registerItem(item_tall_spindle, 	MpConfiguration.BlockEnable[ConfigInfo.MISC_TALL_SPINDLE.ordinal()] );
		registerItem(item_bent_spindle, 	MpConfiguration.BlockEnable[ConfigInfo.MISC_BENT_SPINDLE.ordinal()] );

	}

	// Create helper functions... made public for other mods to use.
	public static ItemSpindle createSpindle(String name, int type, Boolean enabled){

		ItemSpindle spindle = null;
		if(enabled) {
			//System.out.println("create Spindle");
		    spindle = (ItemSpindle)(new ItemSpindle().setUnlocalizedName(name));
		    ResourceLocation resource = new ResourceLocation(MissingPieces.MODID + ":"+ name);
			itemRegistry.register(spindle.setRegistryName(name));
		    OreDictionary.registerOre("MaterialSpindle", spindle);
		    switch( type){
		    default:
		    case 1: // spindle
			    GameRegistry.addShapedRecipe(resource ,
			    		new ResourceLocation(MissingPieces.MODID + ":"+ "spindle"),
			    		new ItemStack(spindle, 4),
			        	"A",
			        	"B",
			        	"A",
			        	'A', net.minecraft.init.Blocks.PLANKS,
			    	    'B', net.minecraft.init.Items.STICK
				    );
			    GameRegistry.addShapedRecipe(resource,
			    		new ResourceLocation(MissingPieces.MODID + ":"+ "spindle"), new ItemStack(spindle, 4),
			        	"A",
			        	"B",
			        	"A",
			        	'A', "plankWood", 
			    	    'B', "stickWood"
				    );
			    break;
		    case 2: // Flat Spindle
			    GameRegistry.addShapedRecipe(resource,
			    		new ResourceLocation(MissingPieces.MODID + ":"+ "spindle"), new ItemStack(spindle, 4),
			        	"   ",
			        	"PSP",
			        	"   ",
			        	'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE),
			    	    'P', net.minecraft.init.Blocks.PLANKS
				    );
			    GameRegistry.addShapedRecipe(resource,
			    		new ResourceLocation(MissingPieces.MODID + ":"+ "spindle"), new ItemStack(spindle, 4),
			        	"   ",
			        	"PSP",
			        	"   ",
			        	'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE), 
			    	    'P', "plankWood"
				    );

		    	break;
		    case 3: // tall spindle
			    GameRegistry.addShapedRecipe(resource,
			    		new ResourceLocation(MissingPieces.MODID + ":"+ "spindle"), new ItemStack(spindle, 3),
			        	"S",
			        	"S",
			        	"S",
			        	'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE) 
				    );

		    	break;
		    case 4: // bent spindle
			    GameRegistry.addShapedRecipe(resource,
			    		new ResourceLocation(MissingPieces.MODID + ":"+ "spindle"), new ItemStack(spindle, 3),
			        	"S  ",
			        	" S ",
			        	" S ",
			        	'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE)
				    );

		    	break;
		    }
			

	    }
	    return spindle;
	};

	public static void registerItem(Item item, Boolean enabled){
	    final int DEFAULT_ITEM_SUBTYPE = 0;

		if(enabled) { 
			// Take "item." off name to get actual name.
			//System.out.println("register Item: " + item);
			String name = item.getUnlocalizedName().substring(5);
		    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("missing_pieces:"+name, "inventory");
		    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		}
	}

}
