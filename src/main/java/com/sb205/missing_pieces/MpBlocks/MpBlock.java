package com.sb205.missing_pieces.MpBlocks;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MpBlock extends Block {

	  public MpBlock(Material mType, Float matHardness,	String toolClass, int toolLevel)
	  {
	    super(mType);
	    this.setHardness(matHardness);
	    this.setHarvestLevel(toolClass, toolLevel);

	  }
	  public String getOredictName()
	  {
		  	// convert string modid_object_type to objectType
		  	String name = this.getUnlocalizedName().substring(5);
		  	String parts[] = name.split("_");
		  	String firstLetter0 = parts[0].substring(0,1);
		  	String firstLetter1 = parts[1].substring(0,1);
			if (parts.length ==3){
				return parts[2]+firstLetter0.toUpperCase(Locale.ENGLISH)+parts[0].substring(1)+firstLetter1.toUpperCase(Locale.ENGLISH)+parts[1].substring(1);
			} else if (parts.length == 4){
					String firstLetter2 = parts[2].substring(0,1);
					return parts[3]+firstLetter0.toUpperCase(Locale.ENGLISH)+parts[0].substring(1)+
									firstLetter1.toUpperCase(Locale.ENGLISH)+parts[1].substring(1)+
									firstLetter2.toUpperCase(Locale.ENGLISH)+parts[2].substring(1);
			} else {
				// must be 2 parts
				return parts[1]+firstLetter0.toUpperCase(Locale.ENGLISH)+parts[0].substring(1);	
			}
		  
	  }

}
