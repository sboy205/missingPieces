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

public class BlockCandelabra extends Block {

	public BlockCandelabra(Material material) {
	    super(material);
	    this.setCreativeTab(CreativeTabs.DECORATIONS);   // the block will appear on the Blocks tab in creative
	    this.setLightLevel(1.0F);
	    this.setHardness(0.5F);

	}

	  public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	  public static final PropertyDirection PROPERTYCEILING = PropertyDirection.create("ceiling", EnumFacing.Plane.VERTICAL);
	  // when the block is placed, set the appropriate facing direction based on which way the player is looking
	  // the colour of block is contained in meta, it corresponds to the values we used for getSubBlocks
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
	    		// Clicked on floor or block top so be a candelabra
	    		enumfacing = EnumFacing.SOUTH;
	    		ceiling = EnumFacing.UP;
	    		break;
		    		
	    }
	    return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYCEILING, ceiling);
	  }
	  @Override
	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return getAxisAlignedBBFromFacing(getFacingFromState(state), getCeilingFromState(state));
	    }
	  private AxisAlignedBB getAxisAlignedBBFromFacing(EnumFacing facing, EnumFacing ceiling)
	  {
		  double minX, minY, minZ;
		  double maxX, maxY, maxZ;

		  switch(ceiling){
		  case UP:
			  if( facing == EnumFacing.NORTH){
				  // item on ceiling
				  minX = minY = minZ = 0.0/16.0F;
				  maxX = maxZ = 16.0/16.0F;
				  maxY = 16.0/16.0;
				  //System.out.println("ceiling");
			  } else {
				  // item on floor (SOUTH)
				  minX = minY = minZ = 0.0/16.0F;
				  maxX = maxZ = 16.0/16.0F;
				  maxY = 16.0/16.0;
				  //System.out.println("floor");
			  }
			  break;
		  default:
		  case DOWN:  // These are mounted on the side wall
			  switch( facing){
			  default:
			  case NORTH:
				  minX = 1.5/16.0F;
				  minY = 2/16.0F;
				  minZ = 0/16.0F;
				  maxX = 14.5/16.0F;
				  maxY = 15/16.0F;
				  maxZ = 12/16.0F;
				  //System.out.println("north");
				  break;

			  case EAST:
				  minZ = 1.5/16.0F;
				  minY = 2/16.0F;
				  minX = 4/16.0F;
				  maxZ = 14.5/16.0F;
				  maxY = 15/16.0F;
				  maxX = 16/16.0F;

				  //System.out.println("east");
				  break;

			  case SOUTH:
				  minX = 1.5/16.0F;
				  minY = 2/16.0F;
				  minZ = 4/16.0F;
				  maxX = 14.5/16.0F;
				  maxY = 15/16.0F;
				  maxZ = 16/16.0F;
				  //System.out.println("south");
				  break;

			  case WEST:
				  minZ = 1.5/16.0F;
				  minY = 2/16.0F;
				  minX = 0/16.0F;
				  maxZ = 14.5/16.0F;
				  maxY = 15/16.0F;
				  maxX = 12/16.0F;
				  //System.out.println("west");
				  break;

			  }
		  }

		  return new AxisAlignedBB( minX,  minY, minZ, 
				   					maxX,  maxY, maxZ);
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

	  // getStateFromMeta, getMetaFromState are used to interconvert between the block's property values and
	  //   the stored metadata (which must be an integer in the range 0 - 15 inclusive)
	  // The property is encode as:
	  // - lower two bits = facing direction (i.e. 0, 1, 2, 3)
	  // - upper two bits = colour (i.e. 0, 4, 8, 12)
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

	  // necessary to define which properties your blocks use
	  // will also affect the variants listed in the blockstates model file
	  @Override
	  protected BlockStateContainer createBlockState()
	  {
	    return new BlockStateContainer(this, new IProperty[] {PROPERTYFACING, PROPERTYCEILING});
	  }

	  public String getOredictName()
	  {
		  	// convert string modid_object_type to objectType
		  	String name = this.getUnlocalizedName().substring(5);
		  	String parts[] = name.split("_");
			String firstLetter = parts[1].substring(0,1);
		  return parts[0]+":"+firstLetter.toUpperCase(Locale.ENGLISH)+":"+parts[1].substring(1);
	  }
	  public String getName()
	  {
		  // remove the "tile." from the unlocalized name
		  return this.getUnlocalizedName().substring(5);
	  }
	//---------------------------------------------------------
	  @Override
	  public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te, ItemStack stack)
	  {
	  	super.harvestBlock(worldIn, player, pos, state, te, stack);
	  }

	// the block will render in the SOLID layer.  See http://greyminecraftcoder.blogspot.co.at/2014/12/block-rendering-18.html for more information.
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	// used by the renderer to control lighting and visibility of other blocks.
	// set to false because this block doesn't fill the entire 1x1x1 space
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {		
		return false;
	}

	// used by the renderer to control lighting and visibility of other blocks, also by
	// (eg) wall or fence to control whether the fence joins itself to this block
	// set to false because this block doesn't fill the entire 1x1x1 space
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}

	// render using a BakedModel
	// not strictly required because the default (super method) is 3.
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

}