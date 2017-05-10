package com.sb205.missing_pieces.Shelf;

import java.awt.Color;
import java.util.Locale;
import java.util.Random;

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
import net.minecraft.inventory.InventoryHelper;
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
 * Date: 5/9/2017
 *
 */

public class BlockShelf extends BlockContainer implements ITileEntityProvider
{
	public BlockShelf(Material mType, Float matHardness)
	{
		super(mType);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);     // the block will appear on the Blocks tab.
	    this.setHardness(matHardness);
	    //System.out.println("new shelf");
	}
	
	  // Our block has a property:
	  // 1) PROPERTYFACING for which way the sign points (east, west, north, south).  EnumFacing is as standard used by vanilla for a number of blocks.
	  public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
		public  enum ShelfInfo {
			//		Name					Ingredient					Material		Enable/Disable
			ACACIA("acacia_shelf",		BlockType.BT_PLANK_ACACIA,	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.SHELF_ACACIA.ordinal()]),
			BIRCH("birch_shelf",		BlockType.BT_PLANK_BIRCH, 	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.SHELF_BIRCH.ordinal()]),
			DARK_OAK("dark_oak_shelf", 	BlockType.BT_PLANK_DARK_OAK, Material.WOOD, MpConfiguration.BlockEnable[ConfigInfo.SHELF_DARK_OAK.ordinal()]),
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
	  
	  @Override
	  protected BlockStateContainer createBlockState()
	  {
	    return new BlockStateContainer(this, new IProperty[] {PROPERTYFACING});
	  }


	// Called when the block is placed or loaded client side to get the tile entity for the block
	// Should return a new instance of the tile entity for the block
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		//System.out.println("Created New tile Entity");
		return new TileEntityShelf();
	}

	  // Called just after the player places a block.  Sets the TileEntity's colour
	  @Override
	  public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	    super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	    
	    //System.out.println("block placedBy");
	    TileEntity tileentity = worldIn.getTileEntity(pos);
	    if (tileentity instanceof TileEntityShelf) { // prevent a crash if not the right type, or is null
	    	TileEntityShelf tileEntityInventoryBasic = (TileEntityShelf)tileentity;

	    }
	  }
	  
	  @Override
	  	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	    {
		    EnumFacing enumfacing = EnumFacing.getHorizontal(getMetaFromState(state));
		    return getAxisAlignedBBFromFacing(enumfacing);
	    }

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
	  
	  @Override
	  public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	  {
		    // find the quadrant the player is facing
		//System.out.println("block placed");

	    EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

	    return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing);
	  }

	// Called when the block is right clicked
	// In this block it is used to open the blocks gui when right clicked by a player
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)  {
	    //System.out.println("block Activated");

		// Uses the gui handler registered to your mod to open the gui for the given gui id
		// open on the server side only  (not sure why you shouldn't open client side too... vanilla doesn't, so we better not either)
		final float SHELF_FRONT = 0.5F; // coordinate of front of shelf... half a block.
		if (worldIn.isRemote) return true;
		IInventory inventory = worldIn.getTileEntity(pos) instanceof IInventory ? (IInventory)worldIn.getTileEntity(pos) : null;
		float eyeHeight = playerIn.getEyeHeight();
	    	double actualY, actualZ, actualX, delta;
	    	/*
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
		    switch(enumfacing){
		    default:
		    case NORTH:
		    	delta = (hitZ-SHELF_FRONT)/playerIn.getLookVec().zCoord;
		    	actualY = hitY-delta*playerIn.getLookVec().yCoord;
		    	actualX = hitX-delta*playerIn.getLookVec().xCoord;
		    	//System.out.println("north: actualY: " + actualY + " actualX:" + actualX);

		    	if(actualY > 0.5F) {
		    		if (actualX > 0.5F) {
		    			selectedSlot = 1;
		    		} else {
		    			selectedSlot = 0;
		    		}	
		    	} else {
		    		if (actualX > 0.5F) {
		    			selectedSlot = 3;
		    		} else {
		    			selectedSlot = 2;
		    		}
		    	}
		    	//System.out.println("north");
		    	break;
		    	
		    case EAST:
		    	delta = (SHELF_FRONT-hitX)/playerIn.getLookVec().xCoord;
		    	actualY = hitY;
		    	actualZ = hitZ;
		    	//System.out.println("east: actualY: " + actualY + " actualZ:" + actualZ);

		    	if(actualY > 0.5F) {
		    		if (actualZ > 0.5F) {
		    			selectedSlot = 1;
		    		} else {
		    			selectedSlot = 0;
		    		}	
		    	} else {
		    		if (actualZ > 0.5F) {
		    			selectedSlot = 3;
		    		} else {
		    			selectedSlot = 2;
		    		}
		    	}
		    	//System.out.println("east");
		    	break;
		    	
		    case SOUTH:
		    	delta = (hitZ-SHELF_FRONT)/playerIn.getLookVec().zCoord;
		    	actualY = hitY-delta*playerIn.getLookVec().yCoord;
		    	actualX = hitX-delta*playerIn.getLookVec().xCoord;
		    	//System.out.println("south: actualY: " + actualY + " actualX:" + actualX);

		    	if(actualY > 0.5F) {
		    		if (actualX < 0.5F) {
		    			selectedSlot = 1;
		    		} else {
		    			selectedSlot = 0;
		    		}	
		    	} else {
		    		if (actualX < 0.5F) {
		    			selectedSlot = 3;
		    		} else {
		    			selectedSlot = 2;
		    		}
		    	}
		    	//System.out.println("south");
		    	break;

		    case WEST:
		    	delta = (hitX-SHELF_FRONT)/playerIn.getLookVec().xCoord;
		    	actualY = hitY;
		    	actualZ = hitZ;
		    	//System.out.println("west: actualY: " + actualY + " actualZ:" + actualZ);
		    	if(actualY > 0.5F) {
		    		if (actualZ < 0.5F) {
		    			selectedSlot = 1;
		    		} else {
		    			selectedSlot = 0;
		    		}	
		    	} else {
		    		if (actualZ < 0.5F) {
		    			selectedSlot = 3;
		    		} else {
		    			selectedSlot = 2;
		    		}
		    	}
		    	//System.out.println("west");
		    	break;

		    }
			if (((playerIn.getHeldItemMainhand() == null) && ( inventory.getStackInSlot(selectedSlot) == null)) || (inventory == null)) {
				playerIn.openGui(MissingPieces.instance, GuiHandlerShelf.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
			} else if ((playerIn.getHeldItemMainhand() == null) && ( inventory.getStackInSlot(selectedSlot) != null)) {
				// Take the slot and put in player's hand.
				playerIn.setHeldItem(EnumHand.MAIN_HAND, inventory.getStackInSlot(selectedSlot)); 
				inventory.setInventorySlotContents(selectedSlot, null);
				worldIn.notifyBlockUpdate(pos, state, state, 3);  

			} else 
				//System.out.println("Selected slot is:" + selectedSlot) ;
				//Add to inventory.
				if(inventory.getStackInSlot(selectedSlot) == null){
					inventory.setInventorySlotContents(selectedSlot,playerIn.getHeldItemMainhand());
					playerIn.setHeldItem(EnumHand.MAIN_HAND, null);
					worldIn.notifyBlockUpdate(pos, state, state, 3);  
				} else {
					// just open the gui
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
					worldIn.spawnEntityInWorld(item);
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
	  @Override
	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return getAxisAlignedBBFromFacing(getFacingFromState(state));
	    }
	  public EnumFacing getFacingFromState(IBlockState state)
	  {
	    EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);

	    return facing;
	  }
  
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

    public IBlockState correctFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        EnumFacing enumfacing = null;
//System.out.println("correcting facing");
        for (EnumFacing enumfacing1 : EnumFacing.Plane.HORIZONTAL)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.offset(enumfacing1));

            if (iblockstate.getBlock() == this)
            {
                return state;
            }

            if (iblockstate.isFullBlock())
            {
                if (enumfacing != null)
                {
                    enumfacing = null;
                    break;
                }

                enumfacing = enumfacing1;
            }
        }

        if (enumfacing != null)
        {
            return state.withProperty(PROPERTYFACING, enumfacing.getOpposite());
        }
        else
        {
            EnumFacing enumfacing2 = (EnumFacing)state.getValue(PROPERTYFACING);

            if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock())
            {
                enumfacing2 = enumfacing2.getOpposite();
            }

            if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock())
            {
                enumfacing2 = enumfacing2.rotateY();
            }

            if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock())
            {
                enumfacing2 = enumfacing2.getOpposite();
            }

            return state.withProperty(PROPERTYFACING, enumfacing2);
        }
    }
}
