package com.sb205.missing_pieces.Shelf;

import java.awt.Color;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.annotation.Nullable;

import com.sb205.missing_pieces.MissingPieces;
import com.sb205.missing_pieces.Config.MpConfiguration;
import com.sb205.missing_pieces.Config.MpConfiguration.ConfigInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFence;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


/**
 * User: sboy205
 * Date: 06/01/2015
 *
 * BlockInventoryBasic is a simple inventory capable of storing 9 item stacks. The block itself doesn't do much more
 * then any regular block except create a tile entity when placed, open a gui when right clicked and drop tne
 * inventory's contents when harvested. The actual storage is handled by the tile entity.
 */
public class BlockShelf extends BlockContainer implements ITileEntityProvider
{
	public BlockShelf(Material mType, Float matHardness)
	{
		super(mType);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);     // the block will appear on the Blocks tab.
	    this.setHardness(matHardness);

	}

	  // Our block has a property:
	  // 1) PROPERTYFACING for which way the sign points (east, west, north, south).  EnumFacing is as standard used by vanilla for a number of blocks.
	  public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
		public  enum ShelfInfo {
			//		Name					Ingredient					Material		Enable/Disable
			ACACIA("acacia_shelf",		BlockType.BT_PLANK_ACACIA,	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.SHELF_ACACIA.ordinal()]),
			BIRCH("birch_shelf",		BlockType.BT_PLANK_BIRCH, 	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.SHELF_BIRCH.ordinal()]),
			DARK_OAK("dark_oak_shelf", 	BlockType.BT_PLANK_DARK_OAK,Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.SHELF_DARK_OAK.ordinal()]),
			JUNGLE("jungle_shelf", 		BlockType.BT_PLANK_JUNGLE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.SHELF_JUNGLE.ordinal()]),
			OAK("oak_shelf", 			BlockType.BT_PLANK_OAK, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.SHELF_OAK.ordinal()]),
			SPRUCE("spruce_shelf", 		BlockType.BT_PLANK_SPRUCE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.SHELF_SPRUCE.ordinal()]);
			
			String shelfName;
			ItemStack shelfIngredientA;
			Material matType;
			Boolean enabled;
			private  ShelfInfo( String name, BlockType ingredientA, Material mType, Boolean enable){
				shelfName = name;
				shelfIngredientA = BlockInfo.blockType2Stack(ingredientA);
				matType = mType;
				enabled = enable;
			}
			public Material getMaterial() {
				return this.matType;
			}
			public String getName() {
				return shelfName;
			}

		};

	  // getStateFromMeta, getMetaFromState are used to interconvert between the block's property values and
	  //   the stored metadata (which must be an integer in the range 0 - 15 inclusive)
	  // The property is encode as:
	  // - lower two bits = facing direction (i.e. 0, 1, 2, 3)
	  // - upper two bits = colour (i.e. 0, 4, 8, 12)
	  @Override
	  public IBlockState getStateFromMeta(int meta)
	  {
	    EnumFacing facing = EnumFacing.getHorizontal(meta);
	    return this.getDefaultState().withProperty(PROPERTYFACING, facing);
	  }

	  @Override
	  public int getMetaFromState(IBlockState state)
	  {
	    EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);

	    int facingbits = facing.getHorizontalIndex();
	    return facingbits;
	  }
	  public EnumFacing getFacingFromState(IBlockState state)
	  {
	    EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);

	    return facing;
	  }

	  // necessary to define which properties your blocks use
	  // will also affect the variants listed in the blockstates model file
	  @Override
	  protected BlockStateContainer createBlockState()
	  {
	    return new BlockStateContainer(this, new IProperty[] {PROPERTYFACING});
	  }


	// Called when the block is placed or loaded client side to get the tile entity for the block
	// Should return a new instance of the tile entity for the block
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO handle meta
		return new TileEntityShelf();
	}

	  // Called just after the player places a block.  Sets the TileEntity's colour
	  @Override
	  public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	    super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

	    TileEntity tileentity = worldIn.getTileEntity(pos);
	    if (tileentity instanceof TileEntityShelf) { // prevent a crash if not the right type, or is null
	    	TileEntityShelf tileEntityInventoryBasic = (TileEntityShelf)tileentity;
	    	System.out.println("blockshelf placed1");

	    } else {
	    	System.out.println("blockshelf placed2");
	    }
	  }
	  @Override
	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return getAxisAlignedBBFromFacing(getFacingFromState(state));
	    }
/*
	    @Deprecated
	    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
	    {
	        addCollisionBoxToList(pos, entityBox, collidingBoxes, state.getCollisionBoundingBox(worldIn, pos));
	    }

	 
	    protected static void addCollisionBoxToList(BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable AxisAlignedBB blockBox)
	    {
	        if (blockBox != NULL_AABB)
	        {
	            AxisAlignedBB axisalignedbb = blockBox.offset(pos);

	            if (entityBox.intersectsWith(axisalignedbb))
	            {
	                collidingBoxes.add(axisalignedbb);
	            }
	        }
	    }
*/
	  //@Override
	  //	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	  //  {
		//    EnumFacing enumfacing = EnumFacing.getHorizontal(getMetaFromState(state));
		//    return getAxisAlignedBBFromFacing(enumfacing, pos);
		    //return new AxisAlignedBB((double)pos.getX() + this.minX, (double)pos.getY() + this.minY, (double)pos.getZ() + this.minZ, (double)pos.getX() + this.maxX, (double)pos.getY() + this.maxY, (double)pos.getZ() + this.maxZ);
	   // }
/*
	  @Override//
	    @SideOnly(Side.CLIENT)
	    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
	    {
		    EnumFacing enumfacing = EnumFacing.getHorizontal(getMetaFromState(worldIn.getBlockState(pos)));
		    return getAxisAlignedBBFromFacing(enumfacing, pos);
	    }
*/	  
	  private AxisAlignedBB getAxisAlignedBBFromFacing(EnumFacing facing)
	  {
		  	double minX, minY, minZ;
		  	double maxX, maxY, maxZ;

		    switch(facing){
		    default:
		    case NORTH:
		    	minX = minY = minZ = 0.0F;
		    	maxX = maxY = 1.0F;
		    	maxZ = 8/16.0F;
		    	//System.out.println("north");
		    	break;
		    	
		    case EAST:
		    	minX = 8/16.0F;
		    	minY = minZ = 0.0F;
		    	maxX = maxY = 1.0F;
		    	maxZ = 16/16.0F;
		    	//System.out.println("east");
		    	break;
		    	
		    case SOUTH:
		    	minX = minY = 0.0F;
		    	minZ = 8/16.0F;
		    	maxX = maxY = 1.0F;
		    	maxZ = 16/16.0F;
		    	//System.out.println("south");
		    	break;

		    case WEST:
		    	minX = minY = minZ = 0.0F;
		    	maxX = 8/16.0F;
		    	maxY = 1.0F;
		    	maxZ = 16/16.0F;
		    	//System.out.println("west");
		    	break;

	    }

	        return new AxisAlignedBB(minX,  minY,  minZ, 
	        						 maxX,  maxY,  maxZ);
		  
	  }
	  
	  // when the block is placed, set the appropriate facing direction based on which way the player is looking
	  // the colour of block is contained in meta, it corresponds to the values we used for getSubBlocks
	  @Override
	  public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitZ, float hitY, float hitX, int meta, EntityLivingBase placer)
	  {
		    // find the quadrant the player is facing
	    EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

	    return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing);
	  }

	// Called when the block is right clicked
	// In this block it is used to open the blocks gui when right clicked by a player
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float hitZ, float hitY, float hitX) {
		// Uses the gui handler registered to your mod to open the gui for the given gui id
		// open on the server side only  (not sure why you shouldn't open client side too... vanilla doesn't, so we better not either)
		final float SHELF_FRONT = 0.5F; // coordinate of front of shelf... half a block.
		if (worldIn.isRemote) return true;
		ItemStack airStack = new ItemStack(Blocks.AIR,1);
		IInventory inventory = worldIn.getTileEntity(pos) instanceof IInventory ? (IInventory)worldIn.getTileEntity(pos) : null;
		//float eyeHeight = playerIn.getEyeHeight();
	    double actualY, actualZ, actualX, delta;
	    	/* BlockChest
			System.out.println("player eye height is: " + eyeHeight);
			System.out.println("shelf position y: " + pos.getY());
			System.out.println("shelf position x: " + pos.getX());
			System.out.println("shelf position z: " + pos.getZ());
			System.out.println("player position y: " + playerIn.posY);
			System.out.println("player position x: " + playerIn.posX);
			System.out.println("player position z: " + playerIn.posZ);
			System.out.println("player vector:" + playerIn.getLookVec());
			System.out.println("player distance: " + playerIn.getDistance(pos.getX(), pos.getY(), pos.getZ()));
			System.out.println("Hit Shelf at (" + hitX + "," + hitY + "," + hitZ +")");
			*/
			//System.out.println("player has: " + playerIn.getCurrentEquippedItem().toString() + " In his hand" );
		    EnumFacing enumfacing = EnumFacing.getHorizontal(getMetaFromState(state));
		    int selectedSlot = 0;
		    if (worldIn.isRemote)
	        {
	            return true;
	        }
	        
		    switch(enumfacing){
		    default:
		    case NORTH:
		    	//delta = (hitZ-SHELF_FRONT)/playerIn.getLookVec().zCoord;
		    	delta = (hitX-SHELF_FRONT)/playerIn.getLookVec().z;
		    	actualY = hitY-delta*playerIn.getLookVec().y;
		    	actualX = hitZ;//-delta*playerIn.getLookVec().xCoord;
		    	//System.out.println("north: actualY: " + actualY + " actualX:" + actualX);
		    	//System.out.println("north");
		    	break;
		    	
		    case EAST:
		    	delta = (SHELF_FRONT-hitX)/playerIn.getLookVec().x;
		    	actualY = hitY;//-delta*playerIn.getLookVec().yCoord;
		    	actualX = hitX;//-delta*playerIn.getLookVec().zCoord;
		    	//System.out.println("east: actualY: " + actualY + " actualX:" + actualX);

		    	//System.out.println("east");
		    	break;
		    	
		    case SOUTH:
		    	//delta = (hitZ-SHELF_FRONT)/playerIn.getLookVec().zCoord;
		    	delta = (hitX-SHELF_FRONT)/playerIn.getLookVec().z;
		    	actualY = hitY-delta*playerIn.getLookVec().y;
		    	actualX = 1.0F-hitZ;//-delta*playerIn.getLookVec().xCoord;
		    	//System.out.println("south: actualY: " + actualY + " actualX:" + actualX);

		    	//System.out.println("south");
		    	break;

		    case WEST:
		    	delta = (hitX-SHELF_FRONT)/playerIn.getLookVec().x;
		    	actualY = hitY;//-delta*playerIn.getLookVec().yCoord;
		    	actualX = 1.0F-hitX;//-delta*playerIn.getLookVec().zCoord;
		    	//System.out.println("west: actualY: " + actualY + " actualX:" + actualX);
		    	//System.out.println("west");
		    	break;

		    }

		    //System.out.println("selected slot is: " + selectedSlot);
		    //System.out.println("Hit x: " + hitX + "  Hit Y: " + hitY + " hitZ: "+ hitZ);
		    if( actualY > 0.5F) {
		    	if( actualX < 0.5F){
		    		selectedSlot = 0;
		    	} else {
		    		selectedSlot = 1;
		    	}
		    } else {
		    	if( actualX < 0.5F){
		    		selectedSlot = 2;
		    	} else {
		    		selectedSlot = 3;
		    	}
		    }
		    //System.out.println("New selected slot is: " + selectedSlot);
		    if ((inventory == null) || (inventory.getStackInSlot(selectedSlot) == null) ||
		        ((playerIn.getHeldItemMainhand().getItem()==airStack.getItem()) && ( inventory.getStackInSlot(selectedSlot).getItem()==airStack.getItem())) ) 
		    {
		    	
				playerIn.openGui(MissingPieces.instance, GuiHandlerShelf.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
				
			} else if ((playerIn.getHeldItemMainhand().getItem() == airStack.getItem()) && ( !(inventory.getStackInSlot(selectedSlot).getItem() == airStack.getItem()) )) {
				// Take the slot and put in player's hand.
				playerIn.setHeldItem(EnumHand.MAIN_HAND, inventory.getStackInSlot(selectedSlot)); 
				inventory.setInventorySlotContents(selectedSlot, airStack);
				worldIn.notifyBlockUpdate(pos, state, state, 3);  

			} else 
				//System.out.println("Selected slot is:" + selectedSlot) ;
				//Add to inventory.
				if((inventory.getStackInSlot(selectedSlot)!= null) &&(inventory.getStackInSlot(selectedSlot).getItem() == airStack.getItem() )){
					inventory.setInventorySlotContents(selectedSlot,playerIn.getHeldItemMainhand());
					playerIn.setHeldItem(EnumHand.MAIN_HAND, airStack);
					worldIn.notifyBlockUpdate(pos, state, state, 3);  
				} else {
					// just open the gui
					System.out.println("guiID: " + GuiHandlerShelf.getGuiID());
					playerIn.openGui(MissingPieces.instance, GuiHandlerShelf.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());

				}
		
		return true;
	}

	// This is where you can do something when the block is broken. In this case drop the inventory's contents
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		IInventory inventory = worldIn.getTileEntity(pos) instanceof IInventory ? (IInventory)worldIn.getTileEntity(pos) : null;

		if (inventory != null){
			// For each slot in the inventory
			for (int i = 0; i < inventory.getSizeInventory(); i++){
				// If the slot is not empty
				if (inventory.getStackInSlot(i) != null)
				{
					// Create a new entity item with the item stack in the slot
					EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));

					// Apply some random motion to the item
					float multiplier = 0.1f;
					float motionX = worldIn.rand.nextFloat() - 0.5f;
					float motionY = worldIn.rand.nextFloat() - 0.5f;
					float motionZ = worldIn.rand.nextFloat() - 0.5f;

					item.motionX = motionX * multiplier;
					item.motionY = motionY * multiplier;
					item.motionZ = motionZ * multiplier;

					// Spawn the item in the world
					worldIn.spawnEntity(item);
				}
			}

			// Clear the inventory so nothing else (such as another mod) can do anything with the items
			inventory.clear();
		}

		// Super MUST be called last because it removes the tile entity
		super.breakBlock(worldIn, pos, state);
	}
	  public String getOredictName()
	  {
		  	// convert string modid_object_type to objectType
		  	String name = this.getUnlocalizedName().substring(5);
		  	String parts[] = name.split("_");
			String firstLetter = parts[1].substring(0,1);
		  return parts[0]+":"+firstLetter.toUpperCase(Locale.ENGLISH)+":"+parts[1].substring(1);
	  }

	//---------------------------------------------------------

	// the block will render in the SOLID layer.  See http://greyminecraftcoder.blogspot.co.at/2014/12/block-rendering-18.html for more information.
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
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
