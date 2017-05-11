package com.sb205.missing_pieces.MpBlocks;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.sb205.missing_pieces.Config.MpConfiguration;
import com.sb205.missing_pieces.Utilities.BlockInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStairs.EnumHalf;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWedge extends  BlockStairs {
	/**
	 * User: sboy205
	 * Date: 5/9/2017
	 *
	 */
	public BlockWedge(Material mType, Float matHardness,	String toolClass, int toolLevel){
		super(Blocks.STONE_STAIRS.getDefaultState() );
	    this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);   // the block will appear on the Blocks tab in creative
	    this.useNeighborBrightness = true;
	    this.setHardness(matHardness);
	    if (mType == Material.GROUND){  // only set this for the dirt wedges
	    	this.setTickRandomly(true);
	    }
	    this.setHarvestLevel(toolClass, toolLevel);
	}
	
	@Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player){
   	 	if((this == com.sb205.missing_pieces.Blocks.grass_path_wedge)||
   	 			(this == com.sb205.missing_pieces.Blocks.grass_wedge)) {
   	 		// Only grass wedge and grass path wedge are silk harvestable.
   	 		//System.out.println("canSilkHarvest called - true");
			return true;
   	 	} else {
   	 		//System.out.println("canSilkHarvest called - false");
   	 		return false;
   	 	}
	}
	
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        { 
            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2)
            {
                worldIn.setBlockState(pos, com.sb205.missing_pieces.Blocks.dirt_wedge.getDefaultState());
            }
            else
            {
      
                if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
                {
                	// If well lighted
                    for (int i = 0; i < 4; ++i)
                    {
                    	//check neighbors
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                        {
                            return;
                        }

                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);
                        IBlockState curBlockState = worldIn.getBlockState(pos);
                        BlockStairs.EnumShape enumShape = (BlockStairs.EnumShape)curBlockState.getValue(SHAPE);
                        BlockStairs.EnumHalf enumhalf = (BlockStairs.EnumHalf)curBlockState.getValue(HALF);
                        EnumFacing direction = (EnumFacing)curBlockState.getValue(FACING);
                        // if I am dirt wedge and the random block near me is either grass or a grass wedge... 
                        if (( curBlockState.getBlock() == com.sb205.missing_pieces.Blocks.dirt_wedge) && 
                        	(iblockstate1.getBlock() == Blocks.GRASS || iblockstate1.getBlock() == com.sb205.missing_pieces.Blocks.grass_wedge))
                        {
                        	//then I become a grass wedge
                        	//System.out.println("setting a " + curBlockState.getBlock().getUnlocalizedName() + " to grass wedge");
                            worldIn.setBlockState(pos, com.sb205.missing_pieces.Blocks.grass_wedge.getDefaultState().withProperty(FACING, direction).withProperty(HALF, enumhalf).withProperty(SHAPE, enumShape));
                        }
                    }
                }
            }
        }
    }
    
    public void flatten(World worldIn, BlockPos pos){
    	if( worldIn.getBlockState(pos).getBlock() != com.sb205.missing_pieces.Blocks.grass_wedge){
    		//System.out.println("Not a grass wedge!!");
    		return;
    	}
        EnumFacing direction = (EnumFacing)worldIn.getBlockState(pos).getValue(FACING);
    	EnumShape shape = worldIn.getBlockState(pos).getValue(SHAPE);
    	EnumHalf half = worldIn.getBlockState(pos).getValue(HALF);
    	worldIn.setBlockState(pos, com.sb205.missing_pieces.Blocks.grass_path_wedge.getDefaultState().withProperty(FACING, direction).withProperty(HALF, half).withProperty(SHAPE,shape));
    }
    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        BlockWedge wedge = (BlockWedge) state.getBlock();
        if ((wedge == com.sb205.missing_pieces.Blocks.grass_wedge) ||
        	 (wedge == com.sb205.missing_pieces.Blocks.grass_path_wedge)) {
        	return Item.getItemFromBlock(com.sb205.missing_pieces.Blocks.dirt_wedge);
        } else {
        	return Item.getItemFromBlock(this);	
        }
    }

    /**
     * B: .. T: xx
     * B: .. T: xx
     */
    protected static final AxisAlignedBB AABB_SLAB_TOP = new AxisAlignedBB(0.0D, 0.75D, 0.0D, 1.0D, 1.0D, 1.0D);
    /**
     * B: .. T: x.
     * B: .. T: x.
     */
    protected static final AxisAlignedBB AABB_QTR_TOP1_WEST = new AxisAlignedBB(0.0D, 0.75D, 0.0D, 0.25D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP2_WEST = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 0.75D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP3_WEST = new AxisAlignedBB(0.0D, 0.25D, 0.0D, 0.75D, 0.50D, 1.0D);
    /**
     * B: .. T: .x
     * B: .. T: .x
     */
    protected static final AxisAlignedBB AABB_QTR_TOP1_EAST = new AxisAlignedBB(0.75D, 0.75D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP2_EAST = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 0.75D, 0.75D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP3_EAST = new AxisAlignedBB(0.25D, 0.25D, 0.0D, 0.5D, 0.5D, 1.0D);
    /**
     * B: .. T: xx
     * B: .. T: ..
     */
    protected static final AxisAlignedBB AABB_QTR_TOP1_NORTH = new AxisAlignedBB(0.0D, 0.75D, 0.0D, 1.0D, 1.0D, 0.25D);
    protected static final AxisAlignedBB AABB_QTR_TOP2_NORTH = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 0.75D, 0.5D);
    protected static final AxisAlignedBB AABB_QTR_TOP3_NORTH = new AxisAlignedBB(0.0D, 0.25D, 0.0D, 1.0D, 0.5D, 0.75D);
    /**
     * B: .. T: ..
     * B: .. T: xx
     */
    protected static final AxisAlignedBB AABB_QTR_TOP1_SOUTH = new AxisAlignedBB(0.0D, 0.75D, 0.75D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP2_SOUTH = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 1.0D, 0.75D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP3_SOUTH = new AxisAlignedBB(0.0D, 0.25D, 0.25D, 1.0D, 0.50D, 1.0D);
    /**
     * B: .. T: x.
     * B: .. T: ..
     */
    protected static final AxisAlignedBB AABB_OCT_TOP1_NW = new AxisAlignedBB(0.0D, 0.75D, 0.0D, 0.75D, 1.0D, 0.75D);
    protected static final AxisAlignedBB AABB_OCT_TOP2_NW = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 0.75D, 0.5D);
    protected static final AxisAlignedBB AABB_OCT_TOP3_NW = new AxisAlignedBB(0.0D, 0.25D, 0.0D, 0.25D, 0.5D, 0.25D);
    /**
     * B: .. T: .x
     * B: .. T: ..
     */
    protected static final AxisAlignedBB AABB_OCT_TOP1_NE = new AxisAlignedBB(0.75D, 0.75D, 0.0D, 1.0D, 1.0D, 0.25D);
    protected static final AxisAlignedBB AABB_OCT_TOP2_NE = new AxisAlignedBB(0.5D, 0.50D, 0.0D, 1.0D, 0.75D, 0.5D);
    protected static final AxisAlignedBB AABB_OCT_TOP3_NE = new AxisAlignedBB(0.25D, 0.25D, 0.0D, 1.0D, 0.50D, 0.75D);
    /**
     * B: .. T: ..
     * B: .. T: x.
     */
    protected static final AxisAlignedBB AABB_OCT_TOP1_SW = new AxisAlignedBB(0.0D, 0.75D, 0.75D, 0.25D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_OCT_TOP2_SW = new AxisAlignedBB(0.0D, 0.5D,  0.5D, 0.5D, 0.75D, 1.0D);
    protected static final AxisAlignedBB AABB_OCT_TOP3_SW = new AxisAlignedBB(0.0D, 0.25D, 0.25D, 0.75D, 0.5D, 1.0D);
    /**
     * B: .. T: ..
     * B: .. T: .x
     */
    protected static final AxisAlignedBB AABB_OCT_TOP1_SE = new AxisAlignedBB(0.75D, 0.75D, 0.75D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_OCT_TOP2_SE = new AxisAlignedBB(0.5D, 0.5D, 0.5D, 1.0D, 0.75D, 1.0D);
    protected static final AxisAlignedBB AABB_OCT_TOP3_SE = new AxisAlignedBB(0.25D, 0.25D, 0.25D, 1.0D, 0.50D, 1.0D);
    /**
     * B: xx T: ..
     * B: xx T: ..
     */
    protected static final AxisAlignedBB AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
    /**
     * B: x. T: ..
     * B: x. T: ..
     */
    protected static final AxisAlignedBB AABB_QTR_BOT1_WEST = new AxisAlignedBB(0.0D, 0.25D, 0.0D, 0.75D, 0.50D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_BOT2_WEST = new AxisAlignedBB(0.0D, 0.50D, 0.0D, 0.5D, 0.75D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_BOT3_WEST = new AxisAlignedBB(0.0D, 0.75D, 0.0D, 0.25D, 1.0D, 1.0D);
    /**
     * B: .x T: ..
     * B: .x T: ..
     */
    protected static final AxisAlignedBB AABB_QTR_BOT1_EAST = new AxisAlignedBB(0.25D, 0.25D, 0.0D, 1.0D, 0.50D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_BOT2_EAST = new AxisAlignedBB(0.5D, 0.50D, 0.0D, 1.0D, 0.75D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_BOT3_EAST = new AxisAlignedBB(0.75D, 0.75D, 0.0D, 1.0D, 1.00D, 1.0D);
    /**
     * B: xx T: ..
     * B: .. T: ..
     */
    protected static final AxisAlignedBB AABB_QTR_BOT1_NORTH = new AxisAlignedBB(0.0D, 0.25D, 0.0D, 1.0D, 0.50D, 0.75D);
    protected static final AxisAlignedBB AABB_QTR_BOT2_NORTH = new AxisAlignedBB(0.0D, 0.50D, 0.0D, 1.0D, 0.75D, 0.5D);
    protected static final AxisAlignedBB AABB_QTR_BOT3_NORTH = new AxisAlignedBB(0.0D, 0.75D, 0.0D, 1.0D, 1.00D, 0.25D);
    /**
     * B: .. T: ..
     * B: xx T: ..
     */
    protected static final AxisAlignedBB AABB_QTR_BOT1_SOUTH = new AxisAlignedBB(0.0D, 0.25D, 0.25D, 1.0D, 0.50D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_BOT2_SOUTH = new AxisAlignedBB(0.0D, 0.50D, 0.5D, 1.0D, 0.75D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_BOT3_SOUTH = new AxisAlignedBB(0.0D, 0.75D, 0.75D, 1.0D, 1.00D, 1.0D);
    /**
     * B: x. T: ..
     * B: .. T: ..
     */
    protected static final AxisAlignedBB AABB_OCT_BOT1_NW = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.25D, 0.25D, 0.25D);
    protected static final AxisAlignedBB AABB_OCT_BOT2_NW = new AxisAlignedBB(0.0D, 0.25D, 0.0D, 0.5D, 0.5D, 0.5D);
    protected static final AxisAlignedBB AABB_OCT_BOT3_NW = new AxisAlignedBB(0.0D, 0.50D, 0.0D, 0.75D, 0.75D, 0.75D);
    /**
     * B: .x T: ..
     * B: .. T: ..
     */
    protected static final AxisAlignedBB AABB_OCT_BOT1_NE = new AxisAlignedBB(0.75D, 0.0D, 0.0D, 1.0D, 0.25D, 0.25D);
    protected static final AxisAlignedBB AABB_OCT_BOT2_NE = new AxisAlignedBB(0.5D, 0.25D, 0.0D, 1.0D, 0.5D, 0.5D);
    protected static final AxisAlignedBB AABB_OCT_BOT3_NE = new AxisAlignedBB(0.25D, 0.50D, 0.0D, 1.0D, 0.75D, 0.75D);
    /**
     * B: .. T: ..
     * B: x. T: ..
     */
    protected static final AxisAlignedBB AABB_OCT_BOT1_SW = new AxisAlignedBB(0.0D, 0.0D, 0.75D, 0.25D, 0.25D, 1.0D);
    protected static final AxisAlignedBB AABB_OCT_BOT2_SW = new AxisAlignedBB(0.0D, 0.25D, 0.5D, 0.5D, 0.5D, 1.0D);
    protected static final AxisAlignedBB AABB_OCT_BOT3_SW = new AxisAlignedBB(0.0D, 0.50D, 0.25D, 0.75D, 0.75D, 1.0D);
    /**
     * B: .. T: ..
     * B: .x T: ..
     */
    protected static final AxisAlignedBB AABB_OCT_BOT1_SE = new AxisAlignedBB(0.75D, 0.0D, 0.75D, 1.0D, 0.25D, 1.0D);
    protected static final AxisAlignedBB AABB_OCT_BOT2_SE = new AxisAlignedBB(0.5D, 0.25D, 0.5D, 1.0D, 0.5D, 1.0D);
    protected static final AxisAlignedBB AABB_OCT_BOT3_SE = new AxisAlignedBB(0.25D, 0.50D, 0.25D, 1.0D, 0.75D, 1.0D);
    
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
    {
        state = this.getActualState(state, worldIn, pos);

        for (AxisAlignedBB axisalignedbb : getCollisionBoxList(state))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, axisalignedbb);
        }
    }

    private static List<AxisAlignedBB> getCollisionBoxList(IBlockState bstate)
    {
        List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
        boolean flag = bstate.getValue(HALF) == BlockStairs.EnumHalf.TOP;
        list.add(flag ? AABB_SLAB_TOP : AABB_SLAB_BOTTOM);
        BlockStairs.EnumShape blockstairs$enumshape = (BlockStairs.EnumShape)bstate.getValue(SHAPE);

        if (blockstairs$enumshape == BlockStairs.EnumShape.STRAIGHT || blockstairs$enumshape == BlockStairs.EnumShape.INNER_LEFT || blockstairs$enumshape == BlockStairs.EnumShape.INNER_RIGHT)
        {
            list.add(getCollQuarterBlock1(bstate));
            list.add(getCollQuarterBlock2(bstate));
            list.add(getCollQuarterBlock3(bstate));
        }

        if (blockstairs$enumshape != BlockStairs.EnumShape.STRAIGHT)
        {
            list.add(getCollEighthBlock1(bstate));
            list.add(getCollEighthBlock2(bstate));
            list.add(getCollEighthBlock3(bstate));
        }

        return list;
    }

    /**
     * Returns a bounding box representing a quarter of a block (two eight-size cubes back to back).
     * Used in all stair shapes except OUTER.
     */
    private static AxisAlignedBB getCollQuarterBlock1(IBlockState bstate)
    {
        boolean flag = bstate.getValue(HALF) == BlockStairs.EnumHalf.TOP;

        switch ((EnumFacing)bstate.getValue(FACING))
        {
            case NORTH:
            default:
                return flag ? AABB_QTR_BOT1_NORTH : AABB_QTR_TOP1_NORTH;
            case SOUTH:
                return flag ? AABB_QTR_BOT1_SOUTH : AABB_QTR_TOP1_SOUTH;
            case WEST:
                return flag ? AABB_QTR_BOT1_WEST : AABB_QTR_TOP1_WEST;
            case EAST:
                return flag ? AABB_QTR_BOT1_EAST : AABB_QTR_TOP1_EAST;
        }
    }
    /**
     * Returns a bounding box representing a quarter of a block (two eight-size cubes back to back).
     * Used in all stair shapes except OUTER.
     */
    private static AxisAlignedBB getCollQuarterBlock2(IBlockState bstate)
    {
        boolean flag = bstate.getValue(HALF) == BlockStairs.EnumHalf.TOP;

        switch ((EnumFacing)bstate.getValue(FACING))
        {
            case NORTH:
            default:
                return flag ? AABB_QTR_BOT2_NORTH : AABB_QTR_TOP2_NORTH;
            case SOUTH:
                return flag ? AABB_QTR_BOT2_SOUTH : AABB_QTR_TOP2_SOUTH;
            case WEST:
                return flag ? AABB_QTR_BOT2_WEST : AABB_QTR_TOP2_WEST;
            case EAST:
                return flag ? AABB_QTR_BOT2_EAST : AABB_QTR_TOP2_EAST;
        }
    }
    /**
     * Returns a bounding box representing a quarter of a block (two eight-size cubes back to back).
     * Used in all stair shapes except OUTER.
     */
    private static AxisAlignedBB getCollQuarterBlock3(IBlockState bstate)
    {
        boolean flag = bstate.getValue(HALF) == BlockStairs.EnumHalf.TOP;

        switch ((EnumFacing)bstate.getValue(FACING))
        {
            case NORTH:
            default:
                return flag ? AABB_QTR_BOT3_NORTH : AABB_QTR_TOP3_NORTH;
            case SOUTH:
                return flag ? AABB_QTR_BOT3_SOUTH : AABB_QTR_TOP3_SOUTH;
            case WEST:
                return flag ? AABB_QTR_BOT3_WEST : AABB_QTR_TOP3_WEST;
            case EAST:
                return flag ? AABB_QTR_BOT3_EAST : AABB_QTR_TOP3_EAST;
        }
    }

    /**
     * Returns a bounding box representing an eighth of a block (a block whose three dimensions are halved).
     * Used in all stair shapes except STRAIGHT (gets added alone in the case of OUTER; alone with a quarter block in
     * case of INSIDE).
     */
    private static AxisAlignedBB getCollEighthBlock1(IBlockState bstate)
    {
        EnumFacing enumfacing = (EnumFacing)bstate.getValue(FACING);
        EnumFacing enumfacing1;

        switch ((BlockStairs.EnumShape)bstate.getValue(SHAPE))
        {
            case OUTER_LEFT:
            default:
                enumfacing1 = enumfacing;
                break;
            case OUTER_RIGHT:
                enumfacing1 = enumfacing.rotateY();
                break;
            case INNER_RIGHT:
                enumfacing1 = enumfacing.getOpposite();
                break;
            case INNER_LEFT:
                enumfacing1 = enumfacing.rotateYCCW();
        }

        boolean flag = bstate.getValue(HALF) == BlockStairs.EnumHalf.TOP;

        switch (enumfacing1)
        {
            case NORTH:
            default:
                return flag ? AABB_OCT_BOT1_NW : AABB_OCT_TOP1_NW;
            case SOUTH:
                return flag ? AABB_OCT_BOT1_SE : AABB_OCT_TOP1_SE;
            case WEST:
                return flag ? AABB_OCT_BOT1_SW : AABB_OCT_TOP1_SW;
            case EAST:
                return flag ? AABB_OCT_BOT1_NE : AABB_OCT_TOP1_NE;
        }
    }
    /**
     * Returns a bounding box representing an eighth of a block (a block whose three dimensions are halved).
     * Used in all stair shapes except STRAIGHT (gets added alone in the case of OUTER; alone with a quarter block in
     * case of INSIDE).
     */
    private static AxisAlignedBB getCollEighthBlock2(IBlockState bstate)
    {
        EnumFacing enumfacing = (EnumFacing)bstate.getValue(FACING);
        EnumFacing enumfacing1;

        switch ((BlockStairs.EnumShape)bstate.getValue(SHAPE))
        {
            case OUTER_LEFT:
            default:
                enumfacing1 = enumfacing;
                break;
            case OUTER_RIGHT:
                enumfacing1 = enumfacing.rotateY();
                break;
            case INNER_RIGHT:
                enumfacing1 = enumfacing.getOpposite();
                break;
            case INNER_LEFT:
                enumfacing1 = enumfacing.rotateYCCW();
        }

        boolean flag = bstate.getValue(HALF) == BlockStairs.EnumHalf.TOP;

        switch (enumfacing1)
        {
            case NORTH:
            default:
                return flag ? AABB_OCT_BOT2_NW : AABB_OCT_TOP2_NW;
            case SOUTH:
                return flag ? AABB_OCT_BOT2_SE : AABB_OCT_TOP2_SE;
            case WEST:
                return flag ? AABB_OCT_BOT2_SW : AABB_OCT_TOP2_SW;
            case EAST:
                return flag ? AABB_OCT_BOT2_NE : AABB_OCT_TOP2_NE;
        }
    }
    /**
     * Returns a bounding box representing an eighth of a block (a block whose three dimensions are halved).
     * Used in all stair shapes except STRAIGHT (gets added alone in the case of OUTER; alone with a quarter block in
     * case of INSIDE).
     */
    private static AxisAlignedBB getCollEighthBlock3(IBlockState bstate)
    {
        EnumFacing enumfacing = (EnumFacing)bstate.getValue(FACING);
        EnumFacing enumfacing1;

        switch ((BlockStairs.EnumShape)bstate.getValue(SHAPE))
        {
            case OUTER_LEFT:
            default:
                enumfacing1 = enumfacing;
                break;
            case OUTER_RIGHT:
                enumfacing1 = enumfacing.rotateY();
                break;
            case INNER_RIGHT:
                enumfacing1 = enumfacing.getOpposite();
                break;
            case INNER_LEFT:
                enumfacing1 = enumfacing.rotateYCCW();
        }

        boolean flag = bstate.getValue(HALF) == BlockStairs.EnumHalf.TOP;

        switch (enumfacing1)
        {
            case NORTH:
            default:
                return flag ? AABB_OCT_BOT3_NW : AABB_OCT_TOP3_NW;
            case SOUTH:
                return flag ? AABB_OCT_BOT3_SE : AABB_OCT_TOP3_SE;
            case WEST:
                return flag ? AABB_OCT_BOT3_SW : AABB_OCT_TOP3_SW;
            case EAST:
                return flag ? AABB_OCT_BOT3_NE : AABB_OCT_TOP3_NE;
        }
    }

	

	  // render using a BakedModel (mbe01_block_simple.json --> mbe01_block_simple_model.json)
	  // not strictly required because the default (super method) is 3.
	  @Override
	  public EnumBlockRenderType getRenderType(IBlockState state) {
	    return EnumBlockRenderType.MODEL;
	  }
	  
	    /**
	     * Checks if an IBlockState represents a block that is opaque and a full cube.
	     */
	  @Override
	    public boolean isFullyOpaque(IBlockState state)
	    {
	        return false;
	    }
	  
	    @Override
	    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
	    {
	    	return false;
	    }

	    @SideOnly(Side.CLIENT)
	    public int getBlockColor()
	    {
	    	//System.out.println("getblock color");
	        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
	    }

	    @SideOnly(Side.CLIENT)
	    public int getRenderColor(IBlockState state)
	    {
	    	//System.out.println("getRenderColor");
	        return this.getBlockColor();
	    }

	    @SideOnly(Side.CLIENT)
	    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
	    {
	    	//System.out.println("colorMultiplier");
	        return BiomeColorHelper.getGrassColorAtPos(worldIn, pos);
	    }
	    @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.CUTOUT_MIPPED;
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
