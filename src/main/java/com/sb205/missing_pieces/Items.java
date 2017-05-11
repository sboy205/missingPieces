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
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Items {

	// Declare all Items here.. only one spindle .. used to make tables and chairs
	public static ItemSpindle item_spindle;


		
	// Init Calls
	public static void preInitCommon() {
		item_spindle = 	createSpindle("spindle",	MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] );

	};
	
	public static void initClientOnly(){
		registerItem(item_spindle, 	MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] );

	}

	// Create helper functions... made public for other mods to use.
	public static ItemSpindle createSpindle(String name, Boolean enabled){

		ItemSpindle spindle = null;
		if(enabled) {
			//System.out.println("create Spindle");
		    spindle = (ItemSpindle)(new ItemSpindle().setUnlocalizedName(name));
			GameRegistry.register(spindle.setRegistryName(name));
		    OreDictionary.registerOre("MaterialSpindle", spindle);
		    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(spindle, 4),
		        	"A",
		        	"B",
		        	"A",
		        	'A', net.minecraft.init.Blocks.PLANKS,
		    	    'B', net.minecraft.init.Items.STICK
			    ));
		    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(spindle, 4),
		        	"A",
		        	"B",
		        	"A",
		        	'A', "plankWood", 
		    	    'B', "stickWood"
			    ));
			

	    }
	    return spindle;
	};

	public static void registerItem(Item item, Boolean enabled){
	    final int DEFAULT_ITEM_SUBTYPE = 0;

		if(enabled) { 
			// Take "item." off name to get actual name.
			System.out.println("register Item: " + item);
			String name = item.getUnlocalizedName().substring(5);
		    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("missing_pieces:"+name, "inventory");
		    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		}
	}

}
