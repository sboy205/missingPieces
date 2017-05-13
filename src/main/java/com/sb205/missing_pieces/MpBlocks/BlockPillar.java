package com.sb205.missing_pieces.MpBlocks;

import java.util.Locale;

import com.sb205.missing_pieces.Config.MpConfiguration;
import com.sb205.missing_pieces.Utilities.BlockInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */
public class BlockPillar extends MpBlock 
{
  
  public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
  public static final PropertyDirection PROPERTYCEILING = PropertyDirection.create("ceiling", EnumFacing.Plane.VERTICAL);

  public BlockPillar(Material mType, Float matHardness,	String toolClass, int toolLevel)
  {
	super(mType, matHardness, toolClass, toolLevel);

    this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);   // the block will appear on the Blocks tab in creative
    this.setHardness(matHardness);
    this.setHarvestLevel(toolClass, toolLevel);

  }

  @Override
  public IBlockState getStateFromMeta(int meta)
  {
	    EnumFacing facing = EnumFacing.getHorizontal(meta);
	    EnumFacing ceiling = ((meta & 4)==0) ? (EnumFacing.UP):(EnumFacing.DOWN);
	    return this.getDefaultState().withProperty(PROPERTYFACING, facing).withProperty(PROPERTYCEILING,  ceiling);
  }

  @Override
  public int getMetaFromState(IBlockState state)
  {
	    EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);
	    EnumFacing ceiling = (EnumFacing)state.getValue(PROPERTYCEILING);
	    
	    int facingbits = facing.getHorizontalIndex() + ((ceiling == EnumFacing.DOWN) ? (4):(0));
	    return facingbits;
  }

  // when the block is placed, set the appropriate facing direction based on which way the player is looking
  @Override
  public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
  {
	    // find the quadrant the player is facing
  EnumFacing enumfacing = EnumFacing.NORTH;
  EnumFacing ceiling = EnumFacing.UP;
  switch(blockFaceClickedOn){
  	case DOWN:
  		// clicked on Ceiling, so indicate Ceiling
  		enumfacing = EnumFacing.NORTH;
  		ceiling = EnumFacing.UP;
  		break;
  	
    case NORTH:
    case SOUTH:
    case EAST:
    case WEST:
    	ceiling = EnumFacing.DOWN;
    	enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);
    	//System.out.println("ceiling is down");
    	break;
	    	
	    default:
  	case UP:
  		enumfacing = EnumFacing.SOUTH;
  		ceiling = EnumFacing.UP;
  		break;
	    		
  }
  return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYCEILING, ceiling);
  }

  // necessary to define which properties your blocks use
  // will also affect the variants listed in the blockstates model file
  @Override
  protected BlockStateContainer createBlockState()
  {
	    return new BlockStateContainer(this, new IProperty[] {PROPERTYFACING, PROPERTYCEILING});
  }

  @Override
  public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World worldIn, BlockPos pos)
  {
      EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);
      EnumFacing ceiling = (EnumFacing)state.getValue(PROPERTYCEILING);

      return getAxisAlignedBBFromFacing(facing, ceiling, pos);
  }

  @Override
  @SideOnly(Side.CLIENT)
  public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
  {
      EnumFacing enumfacing = (EnumFacing)worldIn.getBlockState(pos).getValue(PROPERTYFACING);
     EnumFacing ceiling = (EnumFacing)worldIn.getBlockState(pos).getValue(PROPERTYCEILING);

      return getAxisAlignedBBFromFacing(enumfacing, ceiling, pos);
  }
 
  private AxisAlignedBB getAxisAlignedBBFromFacing(EnumFacing facing, EnumFacing ceiling, BlockPos pos)
  {
    	double minX, minY, minZ;
    	double maxX, maxY, maxZ;

      switch(ceiling){
      default:
      case UP:
    	  // Item is vertical
      		minX = minZ = 2/16.0F;
      		maxX = maxZ = 14/16.0F;
      		minY = 0.0F;
      		maxY = 16/16.0;
      	break;
      	
      case DOWN:  // These are mounted on the side wall
      	switch( facing){
  	    default:
  	    case NORTH:
  	    case SOUTH:
      		minY = minX = 2/16.0F;
      		maxY = maxX = 14/16.0F;
      		minZ = 0.0F;
      		maxZ = 16/16.0;
  	    	//System.out.println("north");
  	    	break;
  	    	
  	    case EAST:
  	    case WEST:
      		minY = minZ = 2/16.0F;
      		maxY = maxZ = 14/16.0F;
      		minX = 0.0F;
      		maxX = 16/16.0;
  	    	//System.out.println("east");
  	    	break;
	
      	}
      }
      return new AxisAlignedBB(minX, minY, minZ, 
    		  					maxX,  maxY, maxZ);
    
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
  // set to true because this block occupies the entire 1x1x1 space
  // not strictly required because the default (super method) is true
  @Override
  public boolean isFullCube(IBlockState state) {
    return false;
  }

  @Override
  public EnumBlockRenderType getRenderType(IBlockState state) {
    return EnumBlockRenderType.MODEL;
  }
}
