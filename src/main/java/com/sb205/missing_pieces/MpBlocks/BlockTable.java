package com.sb205.missing_pieces.MpBlocks;

import java.util.Locale;

import com.sb205.missing_pieces.Config.MpConfiguration;
import com.sb205.missing_pieces.Utilities.BlockInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */
public class BlockTable extends MpBlock
{

  public BlockTable(Material mType)
  {
	super(mType, 0.5F, "axe", 1);
    this.setCreativeTab(CreativeTabs.DECORATIONS);   // the block will appear on the Decorations tab in creative
    this.setHardness(0.5F);

  }

  @SideOnly(Side.CLIENT)
  public BlockRenderLayer getBlockLayer()
  {
    return BlockRenderLayer.CUTOUT_MIPPED;
  }

  // used by the renderer to control lighting and visibility of other blocks.
  // set to true because this block is opaque and occupies the entire 1x1x1 space
  // not strictly required because the default (super method) is true
  @Override
  public boolean isOpaqueCube(IBlockState state) {
    return false;
  }

  // used by the renderer to control lighting and visibility of other blocks, also by
  // (eg) wall or fence to control whether the fence joins itself to this block
  // set to false because this block doesn't occupy the entire 1x1x1 space
  @Override
  public boolean isFullCube(IBlockState state) {
    return false;
  }

  @Override
  public EnumBlockRenderType getRenderType(IBlockState state) {
    return EnumBlockRenderType.MODEL;
  }
}
