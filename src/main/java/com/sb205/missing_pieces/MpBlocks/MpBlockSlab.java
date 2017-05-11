package com.sb205.missing_pieces.MpBlocks;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPurpurSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */
public class MpBlockSlab  extends BlockSlab 
{
	
    /** 
     * The property used for the variant. 
     * Needed for interactions with ItemSlab. 
     */ 
    private static final PropertyBool VARIANT_PROPERTY = 
        PropertyBool.create("variant"); 
 
 
    /** 
     * Resistance value for the material. 
     */ 
     private static final float RESISTANCE = 10.0f; 

 
    /** 
     * The bit in metadata used by the half property. 
     */ 
    private static final int HALF_META_BIT = 8; 



  public MpBlockSlab(Material mType, Float matHardness,	String toolClass, int toolLevel)
  {
      super(mType);
      this.setHardness(matHardness);
      this.setHarvestLevel(toolClass, toolLevel);

	  this.useNeighborBrightness = !this.isDouble(); // only use if half slab
	  setResistance(RESISTANCE);
	  if(!this.isDouble()) {
		  this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);   // the block will appear on the Blocks tab in creative
	  }
	  
	  IBlockState blockState = this.blockState.getBaseState();
	  if (!this.isDouble()) {

		 // blockState = blockState.withProperty(HALF, EnumBlockHalf.BOTTOM);
	  } else {
		  blockState = blockState.withProperty(VARIANT_PROPERTY, false);  
	  }
	  
	  setDefaultState(blockState);
	  
  }

  @Override
  public EnumBlockRenderType getRenderType(IBlockState state) {
    return EnumBlockRenderType.MODEL;
  }



@Override
public String getUnlocalizedName(int meta) {
	return this.getUnlocalizedName();
}



@Override
public IProperty getVariantProperty() {
	return VARIANT_PROPERTY;
}




@Override 
     public final int getMetaFromState(final IBlockState state) { 
         if (this.isDouble()) { 
            return 0; 
         } 
 

         if ((EnumBlockHalf) state.getValue(HALF) == EnumBlockHalf.TOP) { 
             return HALF_META_BIT; 
         } else { 
             return 0; 
         } 
     } 

/** 
* Gets a block state from metadata. 
* @param meta the metadata or pattern value. 
* @return a block state with the meta encoded as the variant property. 
*/ 
@Override 
public final IBlockState getStateFromMeta(final int meta) { 
	IBlockState blockState = this.getDefaultState(); 
	blockState = blockState.withProperty(VARIANT_PROPERTY, false); 

	if (!this.isDouble()) { 
		EnumBlockHalf value = EnumBlockHalf.BOTTOM; 
		if ((meta & HALF_META_BIT) != 0) { 
			value = EnumBlockHalf.TOP; 
		} 
		blockState = blockState.withProperty(HALF, value); 
	} 

	return blockState; 
} 

@Override
public boolean isDouble() {
	return false;
}




 
 
/** 
 * Creates the block state object. 
 * @return the block state with properties defined. 
 */ 
@Override 
protected final BlockStateContainer createBlockState() { 
	if (this.isDouble()) { 
		return new BlockStateContainer(this, new IProperty[] {VARIANT_PROPERTY}); 
	} else { 
		return new BlockStateContainer( 
					this, 
					new IProperty[] {VARIANT_PROPERTY, HALF}); 
	} 
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
@Override
public Comparable<?> getTypeForItem(ItemStack stack) {
	IBlockState iblockState = this.getStateFromMeta(stack.getMetadata());

    //return iblockState.getValue(iproperty);
	return iblockState.getValue(VARIANT_PROPERTY);

}


}
