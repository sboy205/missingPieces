package com.sb205.missing_pieces.MpBlocks;

import java.util.Locale;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumBlockRenderType;
/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */

public class MpBlockStairs extends BlockStairs{
    /** 
     * Resistance value for the material. 
     */ 
     private static final float RESISTANCE = 10.0f; 


	  public MpBlockStairs(Float matHardness,	String toolClass, int toolLevel)
	  {
	      super(Blocks.OAK_STAIRS.getDefaultState());
	      this.setHardness(matHardness);
	      this.setHarvestLevel(toolClass, toolLevel);

		  setResistance(RESISTANCE);
	  
	    this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);   // the block will appear on the Blocks tab in creative
	  }

	  public String getOredictName()
	  {
		  	// convert string modid_object_type to objectType
		  	String name = this.getUnlocalizedName().substring(5);
		  	String parts[] = name.split("_");
			String firstLetter = parts[1].substring(0,1);
		  return parts[0]+":"+firstLetter.toUpperCase(Locale.ENGLISH)+":"+parts[1].substring(1);
	  }

	  

	  // render using a BakedModel (
	  // not strictly required because the default (super method) is 3.
	  @Override
	  public EnumBlockRenderType getRenderType(IBlockState state) {
	    return EnumBlockRenderType.MODEL;
	  }
	}