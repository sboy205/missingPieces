package com.sb205.missing_pieces.MpBlocks;

import com.sb205.missing_pieces.Utilities.MountableUtil;
import com.sb205.missing_pieces.MpBlocks.EnumChairTypes;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */
public class BlockChair extends MpBlock 
{
  public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

  public static final PropertyEnum CHAIR_TYPE = PropertyEnum.create("type", EnumChairTypes.class);
  
  public BlockChair(Material mType, EnumChairTypes chairType)
  {
	super(mType, 0.5F, "axe", 1);
    this.setCreativeTab(CreativeTabs.DECORATIONS);   // the block will appear on the Blocks tab in creative
    this.setHardness(0.5F);
    this.setDefaultState(this.blockState.getBaseState().withProperty(CHAIR_TYPE, chairType));
  }

  @Override
  public IBlockState getStateFromMeta(int meta)
  {
    EnumFacing facing = EnumFacing.getHorizontal(meta);

    EnumChairTypes chairType = EnumChairTypes.getType(meta);
    return this.getDefaultState().withProperty(PROPERTYFACING, facing).withProperty(CHAIR_TYPE, chairType);
  }

  @Override
  public int getMetaFromState(IBlockState state)
  {
    EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);

    EnumChairTypes chairType = (EnumChairTypes)state.getValue(CHAIR_TYPE);
    int facingbits = facing.getHorizontalIndex()+chairType.getMeta();
    return facingbits;
  }

  // when the block is placed, set the appropriate facing direction based on which way the player is looking
  @Override

  public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
  {
	    // find the quadrant the player is facing
    EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);
    //System.out.println("placing chair meta: " + meta);
    EnumChairTypes enumtype = EnumChairTypes.getType(meta);
    //System.out.println("Chair placed x:" + hitX + " y:" + hitY + " z:" + hitZ);
    return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(CHAIR_TYPE,enumtype);
  }
  
  // Make Chair mountable
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY)
	{
		//System.out.println("Sitting in Chair x:" + pos.getX() + " y:" + pos.getY()  + " z:" + pos.getZ());
		double height = 7/16.0;
	    EnumChairTypes chairType = (EnumChairTypes)state.getValue(CHAIR_TYPE);
	    switch(chairType){
	    case STRAIGHT:
	    	height = 7/16.0;
	    	break;
	    case TALL:
	    	height = 10/16.0;
	    	break;
	    case ADIRONDACK:
	    	height = 6/16.0;
	    	break;
	    default:
	    case SPINDLE:
	    	height = 7/16.0;
	    	break;
	    }
		return MountableUtil.MountBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, height);
	}

  // necessary to define which properties your blocks use
  // will also affect the variants listed in the blockstates model file
  @Override
  protected BlockStateContainer createBlockState()
  {
    return new BlockStateContainer(this, new IProperty[] {PROPERTYFACING, CHAIR_TYPE});
  }
  
  @Override
  public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te, ItemStack stack)

  {
  	super.harvestBlock(worldIn, player, pos, state, te, stack);
  	//System.out.println("Harvest Chair");
  }
/*
  @Override
  public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World worldIn, BlockPos pos)
  {
      return getAxisAlignedBBFromFacing(pos);
      //return new AxisAlignedBB((double)pos.getX() + this.minX, (double)pos.getY() + this.minY, (double)pos.getZ() + this.minZ, (double)pos.getX() + this.maxX, (double)pos.getY() + this.maxY, (double)pos.getZ() + this.maxZ);
  }
*/
  @Override
  @SideOnly(Side.CLIENT)
  public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
  {
      return getAxisAlignedBBFromFacing(pos);
  }
  private AxisAlignedBB getAxisAlignedBBFromFacing(BlockPos pos)
  {
    	double minX, minY, minZ;
    	double maxX, maxY, maxZ;

	  // Item is vertical
  		minX = minZ = 3/16.0F;
  		maxX = maxZ = 13/16.0F;
  		minY = 0.0F;
  		maxY = 20/16.0;

       return new AxisAlignedBB( minX,  minY,  minZ, 
      						    maxX,  maxY,  maxZ);
   
  }


  // the block will render in the SOLID layer.  See http://greyminecraftcoder.blogspot.co.at/2014/12/block-rendering-18.html for more information.
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

  // render using a BakedModel (mbe01_block_simple.json --> mbe01_block_simple_model.json)
  // not strictly required because the default (super method) is 3.
  @Override
  public EnumBlockRenderType getRenderType(IBlockState state) {
    return EnumBlockRenderType.MODEL;
  }
  @Override
  public String getUnlocalizedName(){
	  	IBlockState state = this.getDefaultState();
	    EnumChairTypes chairType = (EnumChairTypes)state.getValue(CHAIR_TYPE);
	    if (chairType == EnumChairTypes.SPINDLE){
	    	return super.getUnlocalizedName();
	    } else {
	    	return super.getUnlocalizedName() + "_" + chairType.getName();	    	
	    }
  }
  
  /**
   * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
   */
  @SideOnly(Side.CLIENT)
  public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
  {
	   EnumChairTypes[] allTypes = EnumChairTypes.values();
	   for (EnumChairTypes type : allTypes) {
		   //System.out.println("subBlock: " + itemIn.getUnlocalizedName() + ":" + type.getName());
	     list.add(new ItemStack(itemIn, 1, type.getMeta()));
	   }
  }
}