package com.sb205.missing_pieces.Utilities;

import com.sb205.missing_pieces.Config.MpConfiguration;
import com.sb205.missing_pieces.Config.MpConfiguration.ConfigInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.main.GameConfiguration.GameInformation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */

public class BlockInfo {
	
	String myName; // Name of block
	char   myRecipeA[], myRecipeB[], myRecipeC[];  // three Parts of the recipe
	BlockType  myBlockTypeA = BlockType.BT_NONE;  // Type of block needed for recipe
	BlockType  myBlockTypeB = BlockType.BT_NONE;	// Second type of block needed for recipe
	int		myRecipeCount = 1; // Number of resulting block made by recipe

	
	// For the block type stone, these are the sub types or meta values for different types
	public static final int STONEBRICK_TYPE_STONE = 0;
	public static final int STONE_TYPE_STONE = 0;
	public static final int STONE_TYPE_GRANITE = 1;
	public static final int STONE_TYPE_P_GRANITE = 2;
	public static final int STONE_TYPE_DIORITE = 3;
	public static final int STONE_TYPE_P_DIORITE = 4;
	public static final int STONE_TYPE_ANDESITE = 5;
	public static final int STONE_TYPE_P_ANDESITE = 6;
	public static final int WOOD_TYPE_OAK = 0;
	public static final int WOOD_TYPE_SPRUCE = 1;
	public static final int WOOD_TYPE_BIRCH = 2;
	public static final int WOOD_TYPE_JUNGLE = 3;
	public static final int WOOD_TYPE_ACACIA = 0;
	public static final int WOOD_TYPE_DARK_OAK = 1;
	public static final int PLANK_TYPE_OAK = 0;
	public static final int PLANK_TYPE_SPRUCE = 1;
	public static final int PLANK_TYPE_BIRCH = 2;
	public static final int PLANK_TYPE_JUNGLE = 3;
	public static final int PLANK_TYPE_ACACIA = 4;
	public static final int PLANK_TYPE_DARK_OAK = 5;
	public static final int SLAB_TYPE_STONE = 0;
	public static final int SLAB_TYPE_SANDSTONE = 1;
	public static final int SLAB_TYPE_WOODEN = 2;
	public static final int SLAB_TYPE_COBBLESTONE = 3;
	public static final int SLAB_TYPE_BRICK = 4;
	public static final int SLAB_TYPE_STONE_BRICK = 5;
	public static final int SLAB_TYPE_NETHER_BRICK = 6;
	public static final int SLAB_TYPE_QUARTZ = 7;
	public static final int CLAY_WHITE = 0;
	public static final int CLAY_ORANGE = 1;
	public static final int CLAY_MAGENTA = 2;
	public static final int CLAY_LIGHT_BLUE = 3;
	public static final int CLAY_YELLOW = 4;
	public static final int CLAY_LIME = 5;
	public static final int CLAY_PINK = 6;
	public static final int CLAY_GRAY = 7;
	public static final int CLAY_LIGHT_GRAY = 8;
	public static final int CLAY_CYAN = 9;
	public static final int CLAY_PURPLE = 10;
	public static final int CLAY_BLUE = 11;
	public static final int CLAY_BROWN = 12;
	public static final int CLAY_GREEN = 13;
	public static final int CLAY_RED = 14;
	public static final int CLAY_BLACK = 15;
	public static final int NATURA_TYPE_MAPLE = 0;
	public static final int NATURA_TYPE_SILVERBELL = 1;
	public static final int NATURA_TYPE_AMARANTH = 2;
	public static final int NATURA_TYPE_TIGER = 3;
	public static final int NATURA_TYPE_WILLOW = 4;
	public static final int NATURA_TYPE_EUCALYPTUS = 5;
	public static final int NATURA_TYPE_HOPSEED = 6; 
	public static final int NATURA_TYPE_SAKURA = 7;
	public static final int NATURA_TYPE_REDWOOD = 8;
	public static final int NATURA_TYPE_GHOSTWOOD = 0;
	public static final int NATURA_TYPE_BLOODWOOD = 1;
	public static final int NATURA_TYPE_DARKWOOD = 2;
	public static final int NATURA_TYPE_FUSEWOOD = 3;
	public static final int NATURA_TYPE_MAPLE_LOG = 0;
	public static final int NATURA_TYPE_SILVERBELL_LOG = 1;
	public static final int NATURA_TYPE_AMARANTH_LOG = 2;
	public static final int NATURA_TYPE_TIGER_LOG = 3;
	public static final int NATURA_TYPE_WILLOW_LOG = 0;
	public static final int NATURA_TYPE_EUCALYPTUS_LOG = 1;
	public static final int NATURA_TYPE_HOPSEED_LOG = 2; 
	public static final int NATURA_TYPE_SAKURA_LOG = 3;
	public static final int NATURA_TYPE_REDWOOD_LOG = 1;
	public static final int NATURA_TYPE_GHOSTWOOD_LOG = 0;
	public static final int NATURA_TYPE_DARKWOOD_LOG = 1;
	public static final int NATURA_TYPE_FUSEWOOD_LOG = 2;
	public static final int NATURA_TYPE_BLOODWOOD_LOG = 1;
	// used to interface from my mod to this class.
	// identifies alll the needed blocks for recipies.
	public enum BlockType {
		BT_NONE,
		BT_STONE,
		BT_STONEBRICK,
		BT_GRANITE,
		BT_POLISHED_GRANITE,
		BT_DIORITE,
		BT_POLISHED_DIORITE,
		BT_ANDESITE,
		BT_POLISHED_ANDESITE,
		BT_WOOD_ACACIA,
		BT_WOOD_BIRCH,
		BT_WOOD_DARK_OAK,
		BT_WOOD_JUNGLE,
		BT_WOOD_OAK,
		BT_WOOD_SPRUCE,
		BT_PLANK_ACACIA,
		BT_PLANK_BIRCH,
		BT_PLANK_DARK_OAK,
		BT_PLANK_JUNGLE,
		BT_PLANK_OAK,
		BT_PLANK_SPRUCE,
		BT_OBSIDIAN,
		BT_QUARTZ_BLOCK,
		BT_QUARTZ_ORE,
		BT_COBBLESTONE, 
		BT_INGOT_GOLD,
		BT_INGOT_IRON,
		BT_ITEM_SPINDLE,
		BT_ITEM_FLAT_SPINDLE,
		BT_ITEM_TALL_SPINDLE,
		BT_ITEM_BENT_SPINDLE,
		BT_GLASS_PANE,
		BT_GLASS_BLOCK,
		BT_TORCH, 
		BT_SANDSTONE,
		BT_RED_SANDSTONE,
		BT_NETHER_BRICK,
		BT_COBBLESTONE_SLAB,
		BT_CHEST,
		BT_END_STONE,
		BT_INGOT_ADAMANTINE,
		BT_INGOT_AQUARIUM,
		BT_INGOT_BRASS,
		BT_INGOT_BRONZE,
		BT_INGOT_COLD_IRON,
		BT_INGOT_COPPER,
		BT_INGOT_ELECTRUM,
		BT_INGOT_INVAR,
		BT_INGOT_LEAD,
		BT_INGOT_NICKEL,
		BT_INGOT_MITHRIL,
		BT_INGOT_SILVER,
		BT_INGOT_STAR_STEEL,
		BT_INGOT_STEEL,
		BT_INGOT_TIN,
		BT_INGOT_ZINC,
		BT_CLAY_BLACK,
		BT_CLAY_BLUE,
		BT_CLAY_BROWN,
		BT_CLAY_CYAN,
		BT_CLAY_GREEN,
		BT_CLAY_GRAY,
		BT_CLAY_LIGHT_BLUE,
		BT_CLAY_LIGHT_GRAY,
		BT_CLAY_LIME,
		BT_CLAY_MAGENTA,
		BT_CLAY_ORANGE,
		BT_CLAY_PINK,
		BT_CLAY_PURPLE,
		BT_CLAY_RED,
		BT_CLAY_WHITE,
		BT_CLAY_YELLOW,
		BT_DIRT,
		BT_HAY_BALE,
		BT_GRASS,
		BT_GRASS_PATH,
		BT_AMPHIBOLITE,
		BT_AMPHIBOLITE_SMOOTH,
		BT_M_ANDESITE,
		BT_M_ANDESITE_SMOOTH,
		BT_BASALT,
		BT_BASALT_SMOOTH,
		BT_CHERT,
		BT_CONGLOMERATE,
		BT_CONGLOMERATE_SMOOTH,
		BT_DOLOMITE,
		BT_DOLOMITE_SMOOTH,
		BT_M_DIORITE,
		BT_M_DIORITE_SMOOTH,
		BT_GNEISS,
		BT_GNEISS_SMOOTH,
		BT_M_GRANITE,
		BT_M_GRANITE_SMOOTH,
		BT_LIMESTONE,
		BT_LIMESTONE_SMOOTH,
		BT_MARBLE,
		BT_MARBLE_SMOOTH,
		BT_PUMICE,
		BT_PUMICE_SMOOTH,
		BT_PEGMATITE,
		BT_PEGMATITE_SMOOTH,
		BT_PHYLLITE,
		BT_PHYLLITE_SMOOTH,
		BT_RHYOLITE,
		BT_RHYOLITE_SMOOTH,
		BT_SCHIST,
		BT_SCHIST_SMOOTH,
		BT_SHALE,
		BT_SHALE_SMOOTH,
		BT_SLATE,
		BT_SLATE_SMOOTH,
		BT_PURPUR,
		BT_PLANK_AMARANTH,
		BT_PLANK_DARKWOOD,
		BT_PLANK_EUCALYPTUS,
		BT_PLANK_FUSEWOOD,
		BT_PLANK_GHOSTWOOD,
		BT_PLANK_HOPSEED,		
		BT_PLANK_BLOODWOOD,
		BT_PLANK_MAPLE,
		BT_PLANK_REDWOOD,
		BT_PLANK_SAKURA,
		BT_PLANK_SILVERBELL,
		BT_PLANK_TIGER,
		BT_PLANK_WILLOW,
		BT_WOOD_AMARANTH,
		BT_WOOD_DARKWOOD,
		BT_WOOD_EUCALYPTUS,
		BT_WOOD_FUSEWOOD,
		BT_WOOD_GHOSTWOOD,
		BT_WOOD_HOPSEED,		
		BT_WOOD_BLOODWOOD,
		BT_WOOD_MAPLE,
		BT_WOOD_REDWOOD,
		BT_WOOD_SAKURA,
		BT_WOOD_SILVERBELL,
		BT_WOOD_TIGER,
		BT_WOOD_WILLOW;	
		
	}

	public BlockInfo(String blockName, BlockType blockTypeA, BlockType blockTypeB, char recipeA[], char recipeB[], char recipeC[], int count){
		myName = blockName;
		myBlockTypeA = blockTypeA;
		myBlockTypeB = blockTypeB;
		myRecipeA = recipeA;
		myRecipeB = recipeB;
		myRecipeC = recipeC;
		myRecipeCount = count;
		

	}
	public BlockInfo( String blockName, BlockType blockTypeA, BlockType blockTypeB) {
		myName = blockName;
		myBlockTypeA = blockTypeA;
		myBlockTypeB = blockTypeB;
		
	};
	public BlockInfo( String blockName, BlockType blockTypeA) {
		myName = blockName;
		myBlockTypeA = blockTypeA;
		myBlockTypeB = BlockType.BT_NONE;
		
	};
	public BlockInfo( String blockName) {
		myName = blockName;
		myBlockTypeA = BlockType.BT_NONE;
		myBlockTypeB = BlockType.BT_NONE;
		
	};
	
	public BlockType getBlockTypeA(){
		return myBlockTypeA;
	}
	
	public BlockType getBlockTypeB(){
		return myBlockTypeB;
	}
	
	public String getName(){
		return myName;
	};
	
	public ItemStack getStackA(){
		return blockType2Stack(myBlockTypeA);
	}
	public ItemStack getStackB(){
		return blockType2Stack(myBlockTypeB);
	}
	
	public static ItemStack blockType2Stack(BlockType bType){
		ItemStack myStack;
		
		switch( bType){
		case BT_COBBLESTONE:
			myStack = new ItemStack(Blocks.COBBLESTONE,1,0);
			break;
		case BT_STONE:
			myStack = new ItemStack(Blocks.STONE,1,STONE_TYPE_STONE);
			break;
		case BT_STONEBRICK:
			myStack = new ItemStack(Blocks.STONEBRICK,1,STONEBRICK_TYPE_STONE);
			break;
		case BT_GRANITE:
			myStack = new ItemStack(Blocks.STONE,1,STONE_TYPE_GRANITE);
			break;
		case BT_POLISHED_GRANITE:
			myStack = new ItemStack(Blocks.STONE,1,STONE_TYPE_P_GRANITE);
			break;
		case BT_DIORITE:
			myStack = new ItemStack(Blocks.STONE,1,STONE_TYPE_DIORITE);
			break;
		case BT_POLISHED_DIORITE:
			myStack = new ItemStack(Blocks.STONE,1,STONE_TYPE_P_DIORITE);
			break;
		case BT_ANDESITE:
			myStack = new ItemStack(Blocks.STONE,1,STONE_TYPE_ANDESITE);
			break;
		case BT_POLISHED_ANDESITE:
			myStack = new ItemStack(Blocks.STONE,1,STONE_TYPE_P_ANDESITE);
			break;
		case BT_PURPUR:
			myStack = new ItemStack(Blocks.PURPUR_BLOCK,1);
			break;
		case BT_WOOD_ACACIA: // defined as part of log 2
			myStack = new ItemStack(Blocks.LOG2, 1, WOOD_TYPE_ACACIA);
			break;
		case BT_WOOD_BIRCH:
			myStack = new ItemStack(Blocks.LOG, 1, WOOD_TYPE_BIRCH);
			break;
		case BT_WOOD_DARK_OAK: // defined as part of log 2
			myStack = new ItemStack(Blocks.LOG2, 1, WOOD_TYPE_DARK_OAK);
			break;
		case BT_WOOD_JUNGLE:
			myStack = new ItemStack(Blocks.LOG, 1, WOOD_TYPE_JUNGLE);
			break;
		case BT_WOOD_OAK:
			myStack = new ItemStack(Blocks.LOG, 1, WOOD_TYPE_OAK);
			break;
    	case BT_WOOD_SPRUCE:
    		myStack = new ItemStack(Blocks.LOG, 1, WOOD_TYPE_SPRUCE);
    		break;
		case BT_PLANK_ACACIA: 
			myStack = new ItemStack(Blocks.PLANKS, 1, PLANK_TYPE_ACACIA);
			break;
		case BT_PLANK_BIRCH:
			myStack = new ItemStack(Blocks.PLANKS, 1, PLANK_TYPE_BIRCH);
			break;
		case BT_PLANK_DARK_OAK: 
			myStack = new ItemStack(Blocks.PLANKS, 1, PLANK_TYPE_DARK_OAK);
			break;
		case BT_PLANK_JUNGLE:
			myStack = new ItemStack(Blocks.PLANKS, 1, PLANK_TYPE_JUNGLE);
			break;
		case BT_PLANK_OAK:
			myStack = new ItemStack(Blocks.PLANKS, 1, PLANK_TYPE_OAK);
			break;
    	case BT_PLANK_SPRUCE:
    		myStack = new ItemStack(Blocks.PLANKS, 1, PLANK_TYPE_SPRUCE);
    		break;
    	case BT_OBSIDIAN:
    		myStack = new ItemStack(Blocks.OBSIDIAN,1);
    		break;
    	case BT_QUARTZ_BLOCK:
    		myStack = new ItemStack(Blocks.QUARTZ_BLOCK, 1);
    		break;
    	case BT_INGOT_IRON:
    		myStack = new ItemStack(Items.IRON_INGOT,1);
    		break;
    	case BT_INGOT_GOLD:
    		myStack = new ItemStack(Items.GOLD_INGOT,1);
    		break;
    	case BT_ITEM_SPINDLE:
    		myStack = new ItemStack(com.sb205.missing_pieces.Items.item_spindle,1);
    		break;
    	case BT_ITEM_FLAT_SPINDLE:
    		myStack = new ItemStack(com.sb205.missing_pieces.Items.item_flat_spindle,1);
    		break;
    	case BT_ITEM_TALL_SPINDLE:
    		myStack = new ItemStack(com.sb205.missing_pieces.Items.item_tall_spindle,1);
    		break;
    	case BT_ITEM_BENT_SPINDLE:
    		myStack = new ItemStack(com.sb205.missing_pieces.Items.item_bent_spindle,1);
    		break;
    	case BT_GLASS_PANE:
    		myStack = new ItemStack(Blocks.GLASS_PANE,1);
    		break;
    	case BT_GLASS_BLOCK:
    		myStack = new ItemStack(Blocks.GLASS,1);
    		break;
    	case BT_HAY_BALE:
    		myStack = new ItemStack(Blocks.HAY_BLOCK,1);
    		break;
    	case BT_TORCH:
    		myStack = new ItemStack(Blocks.TORCH,1);
    		break;
    	case BT_SANDSTONE:
    		myStack = new ItemStack(Blocks.SANDSTONE,1);
    		break;
    	case BT_RED_SANDSTONE:
    		myStack = new ItemStack(Blocks.RED_SANDSTONE,1);
    		break;
    	case BT_NETHER_BRICK:
    		myStack = new ItemStack(Blocks.NETHER_BRICK,1);
    		break;
    	case BT_COBBLESTONE_SLAB:
    		myStack = new ItemStack(Blocks.STONE_SLAB,1, SLAB_TYPE_COBBLESTONE);
    		break;
    	case BT_CHEST:
    		myStack = new ItemStack(Blocks.CHEST,1);
    		break;

    	case BT_END_STONE:
    		myStack = new ItemStack(Blocks.END_STONE,1);
    		break;
    	case BT_DIRT:
    		myStack = new ItemStack(Blocks.DIRT,1);
    		break;
    	case BT_GRASS:
    		myStack = new ItemStack(Blocks.GRASS,1);
    		break;
    	case BT_GRASS_PATH:
    		myStack = new ItemStack(Blocks.GRASS_PATH,1);
    		break;
    		
    	case BT_INGOT_ADAMANTINE:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:adamantine_ingot"),1);
    		break;
    	case BT_INGOT_AQUARIUM:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:aquarium_ingot"),1);
    		break;
    	case BT_INGOT_BRASS:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:brass_ingot"),1);
    		break;
    	case BT_INGOT_BRONZE:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:bronze_ingot"),1);
    		break;
    	case BT_INGOT_COLD_IRON:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:coldiron_ingot"),1);
    		break;
    	case BT_INGOT_COPPER:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:copper_ingot"),1);
    		break;
    	case BT_INGOT_ELECTRUM:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:electrum_ingot"),1);
    		break;
    	case BT_INGOT_INVAR:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:invar_ingot"),1);
    		break;
    	case BT_INGOT_LEAD:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:lead_ingot"),1);
    		break;
    	case BT_INGOT_MITHRIL:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:mithril_ingot"),1);
    		break;
    	case BT_INGOT_NICKEL:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:nickel_ingot"),1);
    		break;
    	case BT_INGOT_SILVER:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:silver_ingot"),1);
    		break;
    	case BT_INGOT_STAR_STEEL:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:starsteel_ingot"),1);
    		break;
    	case BT_INGOT_STEEL:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:steel_ingot"),1);
    		break;
    	case BT_INGOT_TIN:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:tin_ingot"),1);
    		break;
    	case BT_INGOT_ZINC:
    		myStack = new ItemStack(Item.getByNameOrId("basemetals:zinc_ingot"),1);
    		break;
    		
    	case BT_CLAY_BLACK:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_BLACK);
    		break;
    		
    	case BT_CLAY_BLUE:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_BLUE);
    		break;
    		
    	case BT_CLAY_BROWN:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_BROWN);
    		break;
    		
    	case BT_CLAY_CYAN:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_CYAN);
    		break;
    		
    	case BT_CLAY_GREEN:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_GREEN);
    		break;
    		
    	case BT_CLAY_GRAY:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_GRAY);
    		break;
    		
    	case BT_CLAY_LIGHT_BLUE:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_LIGHT_BLUE);
    		break;
    		
    	case BT_CLAY_LIGHT_GRAY:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_LIGHT_GRAY);
    		break;
    		
    	case BT_CLAY_LIME:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_LIME);
    		break;
    		
    	case BT_CLAY_MAGENTA:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_MAGENTA);
    		break;
    		
    	case BT_CLAY_ORANGE:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_ORANGE);
    		break;
    		
    	case BT_CLAY_PINK:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_PINK);
    		break;
    		
    	case BT_CLAY_PURPLE:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_PURPLE);
    		break;
    		
    	case BT_CLAY_RED:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_RED);
    		break;
    		
    	case BT_CLAY_WHITE:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_WHITE);
    		break;
    		
    	case BT_CLAY_YELLOW:
    		myStack = new ItemStack(Blocks.STAINED_HARDENED_CLAY,1,CLAY_YELLOW);
    		break;

    	case BT_M_ANDESITE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:andesite"),1);
    		break;
    	case BT_M_ANDESITE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:andesite_smooth"),1);
    		break;
    	case BT_AMPHIBOLITE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:amphibolite"),1);
    		break;
    	case BT_AMPHIBOLITE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:amphibolite_smooth"),1);
    		break;
    	case BT_BASALT:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:basalt"),1);
    		break;
    	case BT_BASALT_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:basalt_smooth"),1);
    		break;
    	case BT_CHERT:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:chert"),1);
    		break;
    	case BT_CONGLOMERATE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:conglomerate"),1);
    		break;
    	case BT_CONGLOMERATE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:conglomerate_smooth"),1);
    		break;
    	case BT_M_DIORITE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:diorite"),1);
    		break;
    	case BT_M_DIORITE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:diorite_smooth"),1);
    		break;
    	case BT_DOLOMITE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:dolomite"),1);
    		break;
    	case BT_DOLOMITE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:dolomite_smooth"),1);
    		break;
    	case BT_GNEISS:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:gneiss"),1);
    		break;
    	case BT_GNEISS_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:gneiss_smooth"),1);
    		break;
    	case BT_M_GRANITE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:granite"),1);
    		break;
    	case BT_M_GRANITE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:granite_smooth"),1);
    		break;
    	case BT_LIMESTONE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:limestone"),1);
    		break;
    	case BT_LIMESTONE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:limestone_smooth"),1);
    		break;
    	case BT_MARBLE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:marble"),1);
    		break;
    	case BT_MARBLE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:marble_smooth"),1);
    		break;
    	case BT_PEGMATITE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:pegmatite"),1);
    		break;
    	case BT_PEGMATITE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:pegmatite_smooth"),1);
    		break;
    	case BT_PHYLLITE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:phyllite"),1);
    		break;
    	case BT_PHYLLITE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:phyllite_smooth"),1);
    		break;
    	case BT_PUMICE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:pumice"),1);
    		break;
    	case BT_RHYOLITE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:rhyolite"),1);
    		break;
    	case BT_RHYOLITE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:rhyolite_smooth"),1);
    		break;
    	case BT_SCHIST:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:schist"),1);
    		break;
    	case BT_SCHIST_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:schist_smooth"),1);
    		break;
    	case BT_SHALE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:shale"),1);
    		break;
    	case BT_SHALE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:shale_smooth"),1);
    		break;
    	case BT_SLATE:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:slate"),1);
    		break;
    	case BT_SLATE_SMOOTH:
    		myStack = new ItemStack(Block.getBlockFromName("mineralogy:slate_smooth"),1);
    		break;
    	case BT_PLANK_AMARANTH:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_planks"),1,NATURA_TYPE_AMARANTH);
    		break;

    	case BT_PLANK_DARKWOOD:
    		myStack = new ItemStack(Block.getBlockFromName("natura:nether_planks"),1,NATURA_TYPE_DARKWOOD);
    		break;

    	case BT_PLANK_EUCALYPTUS:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_planks"),1,NATURA_TYPE_EUCALYPTUS);
    		break;
    	case BT_PLANK_FUSEWOOD:
    		myStack = new ItemStack(Block.getBlockFromName("natura:nether_planks"),1,NATURA_TYPE_FUSEWOOD);
    		break;
    	case BT_PLANK_GHOSTWOOD:
    		myStack = new ItemStack(Block.getBlockFromName("natura:nether_planks"),1, NATURA_TYPE_GHOSTWOOD);
    		break;
    	case BT_PLANK_BLOODWOOD:
    		myStack = new ItemStack(Block.getBlockFromName("natura:nether_planks"),1, NATURA_TYPE_BLOODWOOD);
    		break;
    	case BT_PLANK_HOPSEED:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_planks"),1, NATURA_TYPE_HOPSEED);
    		break;
    	case BT_PLANK_MAPLE:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_planks"),1, NATURA_TYPE_MAPLE);
    		break;
    	case BT_PLANK_REDWOOD:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_planks"),1, NATURA_TYPE_REDWOOD);
    		break;
    	case BT_PLANK_SAKURA:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_planks"),1, NATURA_TYPE_SAKURA);
    		break;
    	case BT_PLANK_SILVERBELL:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_planks"),1, NATURA_TYPE_SILVERBELL);
    		break;
    	case BT_PLANK_TIGER:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_planks"),1, NATURA_TYPE_TIGER);
    		break;
    	case BT_PLANK_WILLOW:	
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_planks"),1, NATURA_TYPE_WILLOW);
    		break;
        case BT_WOOD_AMARANTH:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_logs"),1,NATURA_TYPE_AMARANTH_LOG);
    		break;

    	case BT_WOOD_DARKWOOD:
    		myStack = new ItemStack(Block.getBlockFromName("natura:nether_logs"),1,NATURA_TYPE_DARKWOOD_LOG);
    		break;

    	case BT_WOOD_EUCALYPTUS:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_logs2"),1,NATURA_TYPE_EUCALYPTUS_LOG);
    		break;
    	case BT_WOOD_FUSEWOOD:
    		myStack = new ItemStack(Block.getBlockFromName("natura:nether_logs"),1,NATURA_TYPE_FUSEWOOD_LOG);
    		break;
    	case BT_WOOD_GHOSTWOOD:
    		myStack = new ItemStack(Block.getBlockFromName("natura:nether_logs"),1, NATURA_TYPE_GHOSTWOOD_LOG);
    		break;
    	case BT_WOOD_HOPSEED:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_logs2"),1, NATURA_TYPE_HOPSEED_LOG);
    		break;
    	case BT_WOOD_MAPLE:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_logs"),1, NATURA_TYPE_MAPLE_LOG);
    		break;
    	case BT_WOOD_REDWOOD:
    		myStack = new ItemStack(Block.getBlockFromName("natura:redwood_logs"),1, NATURA_TYPE_REDWOOD_LOG);
    		break;
    	case BT_WOOD_SAKURA:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_logs2"),1, NATURA_TYPE_SAKURA_LOG);
    		break;
    	case BT_WOOD_SILVERBELL:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_logs"),1, NATURA_TYPE_SILVERBELL_LOG);
    		break;
    	case BT_WOOD_TIGER:
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_logs"),1, NATURA_TYPE_TIGER_LOG);
    		break;
    	case BT_WOOD_WILLOW:	
    		myStack = new ItemStack(Block.getBlockFromName("natura:overworld_logs2"),1, NATURA_TYPE_WILLOW_LOG);
    		break;

    	case BT_NONE:
		default:
			myStack = new ItemStack(Blocks.AIR);
		}
		return myStack;
	};

}
