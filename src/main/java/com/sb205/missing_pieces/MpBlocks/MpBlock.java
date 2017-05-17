package com.sb205.missing_pieces.MpBlocks;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

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
				if (parts[2].contains(".")){
					String pieces[] = parts[2].toString().split("\\.");
					//System.out.println("3parts:"+ parts[0] +" : "+ parts[1] +" : "+pieces[0]+" : ");

					//return pieces[0]+firstLetter0.toUpperCase(Locale.ENGLISH)+parts[0].substring(1);	
					return pieces[0]+firstLetter0.toUpperCase(Locale.ENGLISH)+parts[0].substring(1)+firstLetter1.toUpperCase(Locale.ENGLISH)+parts[1].substring(1);

				} else {
					//System.out.println("3parts:"+ parts[0] +" : "+ parts[1]+" : "+ parts[2]+" :");
					return parts[2]+firstLetter0.toUpperCase(Locale.ENGLISH)+parts[0].substring(1)+firstLetter1.toUpperCase(Locale.ENGLISH)+parts[1].substring(1);
				}
			} else if (parts.length == 4){
					//System.out.println("4parts:"+ parts[0] +" : "+ parts[1]+" : "+ parts[2]+" :"+parts[3]+" :");
					String firstLetter2 = parts[2].substring(0,1);
					return parts[3]+firstLetter0.toUpperCase(Locale.ENGLISH)+parts[0].substring(1)+
									firstLetter1.toUpperCase(Locale.ENGLISH)+parts[1].substring(1)+
									firstLetter2.toUpperCase(Locale.ENGLISH)+parts[2].substring(1);
			} else {
				// must be 2 parts
				if (parts[1].contains(".")){
					String composite = parts[1];
					String pieces[] = composite.split("\\.");
					//System.out.println("2parts:"+ parts[0] +" : "+ pieces[0]+" : "+composite+":");

					return pieces[0]+firstLetter0.toUpperCase(Locale.ENGLISH)+parts[0].substring(1);	

				} else {
					return parts[1]+firstLetter0.toUpperCase(Locale.ENGLISH)+parts[0].substring(1);	

				}
			}
		  
	  }

}
