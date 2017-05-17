package com.sb205.missing_pieces.MpItems;

import com.sb205.missing_pieces.MpBlocks.EnumChairTypes;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;

/**
 * User: The Grey Ghost
 * Date: 27/12/2014
 * We need a custom item to represent the different sub-types (colours) of BlockVariants.
 * The Itemstack metadata represents the subtype.
 * You could also re-use ItemMultiTexture or ItemCloth or ItemColored.
 * Look at Item.registerItems() for inspiration
 */
public class ItemBlockChair extends  ItemBlock
{
  // you must use Block in the constructor, not BlockVariants, otherwise you won't be able to register the block properly.
  //   i.e. using GameRegistry.registerBlock(block, ItemBlockVariants.class, name)
  public ItemBlockChair(Block block)
  {
    super(block);
    this.setMaxDamage(0);
    this.setHasSubtypes(true);
  }

  @Override
  public int getMetadata(int metadata)
  {
    return metadata;
  }

  // create a unique unlocalised name for each colour, so that we can give each one a unique name
  @Override
  public String getUnlocalizedName(ItemStack stack)
  {
    EnumChairTypes chairType = EnumChairTypes.getType(stack.getMetadata());
    if (chairType == EnumChairTypes.SPINDLE){
    	//System.out.println("itemblockchair: suname:" + super.getUnlocalizedName());
    	return super.getUnlocalizedName(); //+ "_" + chairType.getName();
    } else {
    	//System.out.println("itemblockchair: uname:" + super.getUnlocalizedName() + " : " + chairType.getName());
    	return super.getUnlocalizedName() + "_" + chairType.getName();	    	
    }
  }
}
