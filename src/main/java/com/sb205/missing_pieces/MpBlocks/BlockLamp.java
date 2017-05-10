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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */

public class BlockLamp extends Block {

	public BlockLamp(Material mat) {
	    super(mat);
	    this.setCreativeTab(CreativeTabs.DECORATIONS);   // the block will appear on the Blocks tab in creative
	    this.setLightLevel(1.0F);					// This causes lamp to give light.
	    this.setHardness(0.5F);
	}

	  public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	  public static final PropertyDirection PROPERTYCEILING = PropertyDirection.create("ceiling", EnumFacing.Plane.VERTICAL);
			

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
		    	// clicked on the side of a block so be wall mounted.
		    	ceiling = EnumFacing.DOWN;
		    	enumfacing = EnumFacing.SOUTH;
		    	break;

		    case SOUTH:
		    	// clicked on the side of a block so be wall mounted.
		    	ceiling = EnumFacing.DOWN;
		    	enumfacing = EnumFacing.NORTH;
		    	break;

		    case EAST:
		    	// clicked on the side of a block so be wall mounted.
		    	ceiling = EnumFacing.DOWN;
		    	enumfacing = EnumFacing.WEST;
		    	break;

		    case WEST:
		    	// clicked on the side of a block so be wall mounted.
		    	ceiling = EnumFacing.DOWN;
		    	enumfacing = EnumFacing.EAST;
		    	break;
		    	
		    default:
	    	case UP:
	    		enumfacing = EnumFacing.SOUTH;
	    		ceiling = EnumFacing.UP;
	    		break;
		    		
	    }
	    return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYCEILING, ceiling);
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

	  @Override
	  protected BlockStateContainer createBlockState()
	  {
	    return new BlockStateContainer(this, new IProperty[] {PROPERTYFACING, PROPERTYCEILING});
	  }
	  @Override
	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return getAxisAlignedBBFromFacing(getFacingFromState(state), getCeilingFromState(state));
	    }

	  public EnumFacing getFacingFromState(IBlockState state)
	  {
	    EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);

	    return facing;
	  }
	  public EnumFacing getCeilingFromState(IBlockState state){
		  EnumFacing ceiling = (EnumFacing)state.getValue(PROPERTYCEILING);
		  return ceiling;
	  }

	  @Override
	  public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	  {
		  EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);
		  EnumFacing ceiling = (EnumFacing)state.getValue(PROPERTYCEILING);

		  return getAxisAlignedBBFromFacing(facing, ceiling);
		  //return new AxisAlignedBB((double)pos.getX() + this.minX, (double)pos.getY() + this.minY, (double)pos.getZ() + this.minZ, (double)pos.getX() + this.maxX, (double)pos.getY() + this.maxY, (double)pos.getZ() + this.maxZ);
	  }


	  private AxisAlignedBB getAxisAlignedBBFromFacing(EnumFacing facing, EnumFacing ceiling)
	  {
		  double minX, minY, minZ;
		  double maxX, maxY, maxZ;

		  switch(ceiling){
		  case UP:
			  if( facing == EnumFacing.NORTH){
				  // item on ceiling
				  minX = minY = minZ = 5/16.0F;
				  maxX = maxZ = 11/16.0F;
				  maxY = 13/16.0;
				  //System.out.println("ceiling");
			  } else {
				  // item on floor (SOUTH)
				  minX = minZ = 4.5/16.0F;
				  minY = 0.0F;
				  maxX = maxZ = 11/16.0F;
				  maxY = 13/16.0F;
				  //System.out.println("floor");
			  }
			  break;
		  default:
		  case DOWN:  // These are mounted on the side wall
			  switch( facing){
			  default:
			  case NORTH:
				  minX = 5/16.0F;
				  minY = minZ = 0.0F;
				  maxX = maxZ = 11/16.0F;
				  maxY = 13/16.0F;
				  //System.out.println("north");
				  break;

			  case EAST:
				  minY = 0.0F;
				  minX = minZ = 5/16.0F;
				  maxX = 16/16.0F;
				  maxZ = 11/16.0F;
				  maxY = 13/16.0F;
				  //System.out.println("east");
				  break;

			  case SOUTH:
				  minX = minZ = 5/16.0F;
				  minY = 0.0F;
				  maxX = 11/16.0F;
				  maxZ = 16/16.0F;
				  maxY = 13/16.0F;
				  //System.out.println("south");
				  break;

			  case WEST:
				  minX = minY = 0.0F;
				  minZ = 5/16.0F;
				  maxX = maxZ = 11/16.0F;
				  maxY = 13/16.0F;
				  //System.out.println("west");
				  break;

			  }
		  }

		  return new AxisAlignedBB( minX,  minY, minZ, 
				   					maxX,  maxY, maxZ);
	  }

	//---------------------------------------------------------
public String getOredictName()
{
	  	// convert string modid_object_type to objectType
	  	String name = this.getUnlocalizedName().substring(5);
	  	//System.out.println("UnlocalName: "+this.getUnlocalizedName());
	  	//System.out.println("Name: "+name);
	  	String parts[] = name.split("_");
		String firstLetter = parts[1].substring(0,1);
	  return parts[0]+":"+firstLetter.toUpperCase(Locale.ENGLISH)+":"+parts[1].substring(1);
}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	// used by the renderer to control lighting and visibility of other blocks.
	// set to false because this block doesn't fill the entire 1x1x1 space
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	// used by the renderer to control lighting and visibility of other blocks, also by
	// (eg) wall or fence to control whether the fence joins itself to this block
	// set to false because this block doesn't fill the entire 1x1x1 space
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	// render using a BakedModel
	// not strictly required because the default (super method) is 3.
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

}