package com.sb205.missing_pieces;

import javax.annotation.Nullable;

import com.sb205.missing_pieces.Config.MpConfiguration;
import com.sb205.missing_pieces.Config.MpConfiguration.ConfigInfo;
import com.sb205.missing_pieces.MpBlocks.BlockCandelabra;
import com.sb205.missing_pieces.MpBlocks.BlockChair;
import com.sb205.missing_pieces.MpBlocks.BlockLamp;
import com.sb205.missing_pieces.MpBlocks.BlockPillar;
import com.sb205.missing_pieces.MpBlocks.BlockTable;
import com.sb205.missing_pieces.MpBlocks.BlockWedge;
import com.sb205.missing_pieces.MpBlocks.EnumChairTypes;
import com.sb205.missing_pieces.MpBlocks.MpBlock;
import com.sb205.missing_pieces.MpBlocks.MpBlockSlab;
import com.sb205.missing_pieces.MpBlocks.MpBlockSlab_half;
import com.sb205.missing_pieces.MpBlocks.MpBlockStairs;
import com.sb205.missing_pieces.MpItems.ItemBlockChair;
import com.sb205.missing_pieces.MpItems.ItemBlockSlab;
import com.sb205.missing_pieces.MpBlocks.MpBlockSlab_double;
import com.sb205.missing_pieces.Utilities.BlockInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;
import com.sb205.missing_pieces.Utilities.ModColorManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

// Define and register blocks

public class Blocks {
	
	//Vanilla Candelabras
	public static BlockCandelabra acacia_candelabra;
	public static BlockCandelabra birch_candelabra;
	public static BlockCandelabra dark_oak_candelabra;
	public static BlockCandelabra jungle_candelabra;
	public static BlockCandelabra oak_candelabra;
	public static BlockCandelabra spruce_candelabra;
	public static BlockCandelabra gold_candelabra;
	public static BlockCandelabra iron_candelabra;
// BOP
	//public static BlockCandelabra redwood_candelabra;
	//public static BlockCandelabra willow_candelabra;
	//public static BlockCandelabra pine_candelabra;
	//public static BlockCandelabra hellbark_candelabra;
	//public static BlockCandelabra jacaranda_candelabra;
	//public static BlockCandelabra mahogany_candelabra;
	//public static BlockCandelabra ebony_candelabra;
	//public static BlockCandelabra eucalyptus_candelabra;
	//public static BlockCandelabra sacred_oak_candelabra;
	//public static BlockCandelabra cherry_candelabra;
	//public static BlockCandelabra umbran_candelabra;
	//public static BlockCandelabra fir_candelabra;
	//public static BlockCandelabra ethereal_candelabra;
	//public static BlockCandelabra magic_candelabra;
	//public static BlockCandelabra mangrove_candelabra;
	//public static BlockCandelabra palm_candelabra;

	// BaseMetal Candelabras
	public static BlockCandelabra adamantine_candelabra;
	public static BlockCandelabra aquarium_candelabra;
	public static BlockCandelabra brass_candelabra;
	public static BlockCandelabra bronze_candelabra;
	public static BlockCandelabra cold_iron_candelabra;
	public static BlockCandelabra copper_candelabra;
	public static BlockCandelabra electrum_candelabra;
	public static BlockCandelabra invar_candelabra;
	public static BlockCandelabra lead_candelabra;
	public static BlockCandelabra mithril_candelabra;
	public static BlockCandelabra nickel_candelabra;
	public static BlockCandelabra silver_candelabra;
	public static BlockCandelabra star_steel_candelabra;
	public static BlockCandelabra steel_candelabra;
	public static BlockCandelabra tin_candelabra;
	public static BlockCandelabra zinc_candelabra;
	// Natura Candelabras
	public static BlockCandelabra amaranth_candelabra;
	public static BlockCandelabra darkwood_candelabra;
	public static BlockCandelabra eucalyptus_candelabra;
	public static BlockCandelabra fusewood_candelabra;
	public static BlockCandelabra ghostwood_candelabra;
	public static BlockCandelabra hopseed_candelabra;
	public static BlockCandelabra maple_candelabra;
	public static BlockCandelabra redwood_candelabra;
	public static BlockCandelabra sakura_candelabra;
	public static BlockCandelabra silverbell_candelabra;
	public static BlockCandelabra tiger_candelabra;
	public static BlockCandelabra willow_candelabra;

	// Vanilla Lamps
	public static BlockLamp	 acacia_lamp;
	public static BlockLamp birch_lamp;
	public static BlockLamp dark_oak_lamp;
	public static BlockLamp jungle_lamp;
	public static BlockLamp oak_lamp;
	public static BlockLamp spruce_lamp;
	public static BlockLamp gold_lamp;
	public static BlockLamp iron_lamp;
	// BOP
	//public static BlockLamp redwood_lamp;
	//public static BlockLamp willow_lamp;
	public static BlockLamp pine_lamp;
	public static BlockLamp hellbark_lamp;
	public static BlockLamp jacaranda_lamp;
	public static BlockLamp mahogany_lamp;
	public static BlockLamp ebony_lamp;
	//public static BlockLamp eucalyptus_lamp;
	public static BlockLamp sacred_oak_lamp;
	public static BlockLamp cherry_lamp;
	public static BlockLamp umbran_lamp;
	public static BlockLamp fir_lamp;
	public static BlockLamp ethereal_lamp;
	public static BlockLamp magic_lamp;
	public static BlockLamp mangrove_lamp;
	public static BlockLamp palm_lamp;

	// BaseMetal Lamps
	public static BlockLamp adamantine_lamp;
	public static BlockLamp aquarium_lamp;
	public static BlockLamp brass_lamp;
	public static BlockLamp bronze_lamp;
	public static BlockLamp cold_iron_lamp;
	public static BlockLamp copper_lamp;
	public static BlockLamp electrum_lamp;
	public static BlockLamp invar_lamp;
	public static BlockLamp lead_lamp;
	public static BlockLamp mithril_lamp;
	public static BlockLamp nickel_lamp;
	public static BlockLamp silver_lamp;
	public static BlockLamp star_steel_lamp;
	public static BlockLamp steel_lamp;
	public static BlockLamp tin_lamp;
	public static BlockLamp zinc_lamp;
	// Natura Lamps
	public static BlockLamp amaranth_lamp;
	public static BlockLamp darkwood_lamp;
	public static BlockLamp eucalyptus_lamp;
	public static BlockLamp fusewood_lamp;
	public static BlockLamp ghostwood_lamp;
	public static BlockLamp hopseed_lamp;
	public static BlockLamp maple_lamp;
	public static BlockLamp redwood_lamp;
	public static BlockLamp sakura_lamp;
	public static BlockLamp silverbell_lamp;
	public static BlockLamp tiger_lamp;
	public static BlockLamp willow_lamp;

	// Vanilla Chairs
	public static BlockChair acacia_chair;
	public static BlockChair birch_chair;
	public static BlockChair dark_oak_chair;
	public static BlockChair jungle_chair;
	public static BlockChair oak_chair;
	public static BlockChair spruce_chair;
	// BOP chairs
	//public static BlockChair redwood_chair;
	//public static BlockChair willow_chair;
	public static BlockChair pine_chair;
	public static BlockChair hellbark_chair;
	public static BlockChair jacaranda_chair;
	public static BlockChair mahogany_chair;
	public static BlockChair ebony_chair;
	//public static BlockChair eucalyptus_chair;
	public static BlockChair sacred_oak_chair;
	public static BlockChair cherry_chair;
	public static BlockChair umbran_chair;
	public static BlockChair fir_chair;
	public static BlockChair ethereal_chair;
	public static BlockChair magic_chair;
	public static BlockChair mangrove_chair;
	public static BlockChair palm_chair;
	// Natura Chairs
	public static BlockChair amaranth_chair;
	public static BlockChair darkwood_chair;
	public static BlockChair eucalyptus_chair;
	public static BlockChair fusewood_chair;
	public static BlockChair ghostwood_chair;
	public static BlockChair hopseed_chair;
	public static BlockChair maple_chair;
	public static BlockChair redwood_chair;
	public static BlockChair sakura_chair;
	public static BlockChair silverbell_chair;
	public static BlockChair tiger_chair;
	public static BlockChair willow_chair;

	//Vanilla Pillars
	public static BlockPillar acacia_pillar;
	public static BlockPillar birch_pillar;
	public static BlockPillar dark_oak_pillar;
	public static BlockPillar jungle_pillar;
	public static BlockPillar oak_pillar;
	public static BlockPillar spruce_pillar;
	public static BlockPillar acacia_log;
	public static BlockPillar birch_log;
	public static BlockPillar dark_oak_log;
	public static BlockPillar jungle_log;
	public static BlockPillar oak_log;
	public static BlockPillar spruce_log;
	// Natura Logs
	public static BlockPillar amaranth_log;
	public static BlockPillar darkwood_log;
	public static BlockPillar eucalyptus_log;
	public static BlockPillar fusewood_log;
	public static BlockPillar ghostwood_log;
	public static BlockPillar hopseed_log;
	public static BlockPillar maple_log;
	public static BlockPillar redwood_log;
	public static BlockPillar sakura_log;
	public static BlockPillar silverbell_log;
	public static BlockPillar tiger_log;
	public static BlockPillar willow_log;

	public static BlockPillar obsidian_pillar;
	public static BlockPillar p_granite_pillar;
	public static BlockPillar p_diorite_pillar;
	public static BlockPillar p_andesite_pillar;
	public static BlockPillar granite_pillar;
	public static BlockPillar diorite_pillar;
	public static BlockPillar andesite_pillar;
	public static BlockPillar quartz_pillar;
	public static BlockPillar cobblestone_pillar;
	public static BlockPillar stonebrick_pillar;
	public static BlockPillar sandstone_pillar;
	public static BlockPillar red_sandstone_pillar;
	public static BlockPillar nether_brick_pillar;
	public static BlockPillar stone_pillar;
	public static BlockPillar purpur_pillar;

	public static BlockPillar end_stone_pillar;
	public static BlockPillar black_clay_pillar;
	public static BlockPillar blue_clay_pillar;
	public static BlockPillar brown_clay_pillar;
	public static BlockPillar cyan_clay_pillar;
	public static BlockPillar gray_clay_pillar;
	public static BlockPillar green_clay_pillar;
	public static BlockPillar light_blue_clay_pillar;
	public static BlockPillar light_gray_clay_pillar;
	public static BlockPillar lime_clay_pillar;
	public static BlockPillar magenta_clay_pillar;
	public static BlockPillar orange_clay_pillar;
	public static BlockPillar pink_clay_pillar;
	public static BlockPillar purple_clay_pillar;
	public static BlockPillar red_clay_pillar;
	public static BlockPillar white_clay_pillar;
	public static BlockPillar yellow_clay_pillar;
	public static BlockPillar glass_pillar;
// BOP 
	//public static BlockPillar redwood_pillar;
	//public static BlockPillar willow_pillar;
	public static BlockPillar pine_pillar;
	public static BlockPillar hellbark_pillar;
	public static BlockPillar jacaranda_pillar;
	public static BlockPillar mahogany_pillar;
	public static BlockPillar ebony_pillar;
	//public static BlockPillar eucalyptus_pillar;
	public static BlockPillar sacred_oak_pillar;
	public static BlockPillar cherry_pillar;
	public static BlockPillar umbran_pillar;
	public static BlockPillar fir_pillar;
	public static BlockPillar ethereal_pillar;
	public static BlockPillar magic_pillar;
	public static BlockPillar mangrove_pillar;
	public static BlockPillar palm_pillar;

	// mineralogy Pillars
	public static BlockPillar amphibolite_pillar;
	public static BlockPillar amphibolite_smooth_pillar;
	public static BlockPillar m_andesite_pillar;
	public static BlockPillar m_andesite_smooth_pillar;
	public static BlockPillar basalt_pillar;
	public static BlockPillar basalt_smooth_pillar;
	public static BlockPillar chert_pillar;
	public static BlockPillar conglomerate_pillar;
	public static BlockPillar conglomerate_smooth_pillar;
	public static BlockPillar m_diorite_pillar;
	public static BlockPillar m_diorite_smooth_pillar;
	public static BlockPillar dolomite_pillar;
	public static BlockPillar dolomite_smooth_pillar;
	public static BlockPillar gneiss_pillar;
	public static BlockPillar gneiss_smooth_pillar;
	public static BlockPillar m_granite_pillar;
	public static BlockPillar m_granite_smooth_pillar;
	public static BlockPillar limestone_pillar;
	public static BlockPillar limestone_smooth_pillar;
	public static BlockPillar marble_pillar;
	public static BlockPillar marble_smooth_pillar;
	public static BlockPillar pumice_pillar;
	public static BlockPillar pegmatite_pillar;
	public static BlockPillar pegmatite_smooth_pillar;
	public static BlockPillar phyllite_pillar;
	public static BlockPillar phyllite_smooth_pillar;
	public static BlockPillar rhyolite_pillar;
	public static BlockPillar rhyolite_smooth_pillar;
	public static BlockPillar schist_pillar;
	public static BlockPillar schist_smooth_pillar;
	public static BlockPillar shale_pillar;
	public static BlockPillar shale_smooth_pillar;
	public static BlockPillar slate_pillar;
	public static BlockPillar slate_smooth_pillar;
	// Natura Pillars
	public static BlockPillar amaranth_pillar;
	public static BlockPillar darkwood_pillar;
	public static BlockPillar eucalyptus_pillar;
	public static BlockPillar fusewood_pillar;
	public static BlockPillar ghostwood_pillar;
	public static BlockPillar hopseed_pillar;
	public static BlockPillar maple_pillar;
	public static BlockPillar redwood_pillar;
	public static BlockPillar sakura_pillar;
	public static BlockPillar silverbell_pillar;
	public static BlockPillar tiger_pillar;
	public static BlockPillar willow_pillar;


	// Vanilla Tables
	public static BlockTable acacia_table;
	public static BlockTable birch_table;
	public static BlockTable dark_oak_table;
	public static BlockTable jungle_table;
	public static BlockTable oak_table;
	public static BlockTable spruce_table;
	// BOP
	//public static BlockTable redwood_table;
	//public static BlockTable willow_table;
	public static BlockTable pine_table;
	public static BlockTable hellbark_table;
	public static BlockTable jacaranda_table;
	public static BlockTable mahogany_table;
	public static BlockTable ebony_table;
	//public static BlockTable eucalyptus_table;
	public static BlockTable sacred_oak_table;
	public static BlockTable cherry_table;
	public static BlockTable umbran_table;
	public static BlockTable fir_table;
	public static BlockTable ethereal_table;
	public static BlockTable magic_table;
	public static BlockTable mangrove_table;
	public static BlockTable palm_table;
	// Natura Tables
	public static BlockTable amaranth_table;
	public static BlockTable darkwood_table;
	public static BlockTable eucalyptus_table;
	public static BlockTable fusewood_table;
	public static BlockTable ghostwood_table;
	public static BlockTable hopseed_table;
	public static BlockTable maple_table;
	public static BlockTable redwood_table;
	public static BlockTable sakura_table;
	public static BlockTable silverbell_table;
	public static BlockTable tiger_table;
	public static BlockTable willow_table;

	// Vanilla Wedges
	public static BlockWedge acacia_wedge;
	public static BlockWedge birch_wedge;
	public static BlockWedge dark_oak_wedge;
	public static BlockWedge jungle_wedge;
	public static BlockWedge oak_wedge;
	public static BlockWedge spruce_wedge;
	public static BlockWedge obsidian_wedge;
	public static BlockWedge p_granite_wedge;
	public static BlockWedge p_diorite_wedge;
	public static BlockWedge p_andesite_wedge;
	public static BlockWedge granite_wedge;
	public static BlockWedge diorite_wedge;
	public static BlockWedge andesite_wedge;
	public static BlockWedge quartz_wedge;
	public static BlockWedge cobblestone_wedge;
	public static BlockWedge stone_wedge;
	public static BlockWedge stonebrick_wedge;
	public static BlockWedge purpur_wedge;
	public static BlockWedge sandstone_wedge;
	public static BlockWedge red_sandstone_wedge;
	public static BlockWedge nether_brick_wedge;

	public static BlockWedge end_stone_wedge;
	public static BlockWedge black_clay_wedge;
	public static BlockWedge blue_clay_wedge;
	public static BlockWedge brown_clay_wedge;
	public static BlockWedge cyan_clay_wedge;
	public static BlockWedge gray_clay_wedge;
	public static BlockWedge green_clay_wedge;
	public static BlockWedge light_blue_clay_wedge;
	public static BlockWedge light_gray_clay_wedge;
	public static BlockWedge lime_clay_wedge;
	public static BlockWedge magenta_clay_wedge;
	public static BlockWedge orange_clay_wedge;
	public static BlockWedge pink_clay_wedge;
	public static BlockWedge purple_clay_wedge;
	public static BlockWedge red_clay_wedge;
	public static BlockWedge white_clay_wedge;
	public static BlockWedge yellow_clay_wedge;
	public static BlockWedge hay_wedge;
	public static BlockWedge dirt_wedge;
	public static BlockWedge grass_wedge;
	public static BlockWedge grass_path_wedge;
	public static BlockWedge glass_wedge;
// BOP
	//public static BlockWedge redwood_wedge;
	//public static BlockWedge willow_wedge;
	public static BlockWedge pine_wedge;
	public static BlockWedge hellbark_wedge;
	public static BlockWedge jacaranda_wedge;
	public static BlockWedge mahogany_wedge;
	public static BlockWedge ebony_wedge;
	//public static BlockWedge eucalyptus_wedge;
	public static BlockWedge sacred_oak_wedge;
	public static BlockWedge cherry_wedge;
	public static BlockWedge umbran_wedge;
	public static BlockWedge fir_wedge;
	public static BlockWedge ethereal_wedge;
	public static BlockWedge magic_wedge;
	public static BlockWedge mangrove_wedge;
	public static BlockWedge palm_wedge;

	// mineralogy Wedges
	public static BlockWedge amphibolite_wedge;
	public static BlockWedge amphibolite_smooth_wedge;
	public static BlockWedge m_andesite_wedge;
	public static BlockWedge m_andesite_smooth_wedge;
	public static BlockWedge basalt_wedge;
	public static BlockWedge basalt_smooth_wedge;
	public static BlockWedge chert_wedge;
	public static BlockWedge conglomerate_wedge;
	public static BlockWedge conglomerate_smooth_wedge;
	public static BlockWedge m_diorite_wedge;
	public static BlockWedge m_diorite_smooth_wedge;
	public static BlockWedge dolomite_wedge;
	public static BlockWedge dolomite_smooth_wedge;
	public static BlockWedge gneiss_wedge;
	public static BlockWedge gneiss_smooth_wedge;
	public static BlockWedge m_granite_wedge;
	public static BlockWedge m_granite_smooth_wedge;
	public static BlockWedge limestone_wedge;
	public static BlockWedge limestone_smooth_wedge;
	public static BlockWedge marble_wedge;
	public static BlockWedge marble_smooth_wedge;
	public static BlockWedge pumice_wedge;
	public static BlockWedge pegmatite_wedge;
	public static BlockWedge pegmatite_smooth_wedge;
	public static BlockWedge phyllite_wedge;
	public static BlockWedge phyllite_smooth_wedge;
	public static BlockWedge rhyolite_wedge;
	public static BlockWedge rhyolite_smooth_wedge;
	public static BlockWedge schist_wedge;
	public static BlockWedge schist_smooth_wedge;
	public static BlockWedge shale_wedge;
	public static BlockWedge shale_smooth_wedge;
	public static BlockWedge slate_wedge;
	public static BlockWedge slate_smooth_wedge;
	// Natura Wedges
	public static BlockWedge amaranth_wedge;
	public static BlockWedge darkwood_wedge;
	public static BlockWedge eucalyptus_wedge;
	public static BlockWedge fusewood_wedge;
	public static BlockWedge ghostwood_wedge;
	public static BlockWedge hopseed_wedge;
	public static BlockWedge maple_wedge;
	public static BlockWedge redwood_wedge;
	public static BlockWedge sakura_wedge;
	public static BlockWedge silverbell_wedge;
	public static BlockWedge tiger_wedge;
	public static BlockWedge willow_wedge;

	// Patterned Cobblestone Slabs
	public static MpBlockSlab_half stone_patt1_slab;
	public static MpBlockSlab_double stone_patt1_slab_double;
	public static MpBlockSlab_half stone_patt2_slab;
	public static MpBlockSlab_double stone_patt2_slab_double;
	public static MpBlockSlab_half stone_patt3_slab;
	public static MpBlockSlab_double stone_patt3_slab_double;
	public static MpBlockSlab_half stone_patt4_slab;
	public static MpBlockSlab_double stone_patt4_slab_double;
	public static MpBlockSlab_half stone_patt5_slab;
	public static MpBlockSlab_double stone_patt5_slab_double;
	public static MpBlockSlab_half stone_patt6_slab;
	public static MpBlockSlab_double stone_patt6_slab_double;
	public static MpBlockSlab_half stone_patt7_slab;
	public static MpBlockSlab_double stone_patt7_slab_double;
	public static MpBlockSlab_half stone_patt8_slab;
	public static MpBlockSlab_double stone_patt8_slab_double;
	public static MpBlockSlab_half stone_patt9_slab;
	public static MpBlockSlab_double stone_patt9_slab_double;
	public static MpBlockSlab_half stone_patt10_slab;
	public static MpBlockSlab_double stone_patt10_slab_double;
	public static MpBlockSlab_half stone_patt11_slab;
	public static MpBlockSlab_double stone_patt11_slab_double;
	public static MpBlockSlab_half stone_patt12_slab;
	public static MpBlockSlab_double stone_patt12_slab_double;

	
	/*  Rainbow / test blocks
	public static MpBlockSlab_half rainbow_slab;
	public static MpBlockSlab_double rainbow_slab_double;
	public static MpBlockStairs rainbow_stairs;
	public static BlockWedge rainbow_wedge;
	public static BlockTable rainbow_table;
	public static BlockChair rainbow_chair;
	public static BlockPillar rainbow_pillar;
	public static BlockLamp	rainbow_lamp;
	public static BlockCandelabra rainbow_candelabra;
	*/
	
	public  enum  Slab_type{
		PATT_1,
		PATT_2,
		PATT_3,
		PATT_4,
		PATT_5,
		PATT_6,
		PATT_7,
		PATT_8,
		PATT_9,
		PATT_10,
		PATT_11,
		PATT_12,
		PATT_NORM
	}

	public static void preInitCommon(){
		/*
		rainbow_candelabra = 	createCandelabra("rainbow_candelabra",	BlockType.BT_PLANK_ACACIA,	Material.wood,	true);
		rainbow_lamp = 			createLamp("rainbow_lamp",				BlockType.BT_PLANK_ACACIA,	Material.wood,	true);
		rainbow_chair = 		createChair("rainbow_chair",			BlockType.BT_PLANK_ACACIA,	Material.wood,	true);
		rainbow_pillar =		createPillar("rainbow_pillar",			BlockType.BT_PLANK_ACACIA,	Material.wood,	0.5F,	true, "axe", 1);
		rainbow_table = 		createTable("rainbow_table",			BlockType.BT_PLANK_ACACIA,	Material.wood,	true);
		rainbow_wedge =			createWedge("rainbow_wedge",			BlockType.BT_PLANK_ACACIA,	Material.wood,	0.5F,	true, "axe", 1);
	    rainbow_slab = 			createHalfSlab("rainbow_slab", 			Material.rock, 2.0F, true, "pickaxe", 3);
	    rainbow_slab_double = 	createDoubleSlab("rainbow_slab_double",	Material.rock, 2.0F, true, "pickaxe", 3);
		registerSlab(rainbow_slab, "rainbow_slab", rainbow_slab_double, "rainbow_slab_double", BlockType.BT_POLISHED_GRANITE, true);
	    rainbow_stairs = 		createStairs("rainbow_stairs", 			BlockType.BT_RED_SANDSTONE, 1.5F, true, "pickxe", 1);
		 */
		acacia_candelabra = 	createCandelabra("acacia_candelabra",		BlockType.BT_PLANK_ACACIA,	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_ACACIA.ordinal()]);
		birch_candelabra = 		createCandelabra("birch_candelabra",		BlockType.BT_PLANK_BIRCH, 	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_BIRCH.ordinal()]);
		dark_oak_candelabra = 	createCandelabra("dark_oak_candelabra", 	BlockType.BT_PLANK_DARK_OAK, Material.WOOD, MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_DARK_OAK.ordinal()]);
		jungle_candelabra = 	createCandelabra("jungle_candelabra", 		BlockType.BT_PLANK_JUNGLE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_JUNGLE.ordinal()]);
		oak_candelabra = 		createCandelabra("oak_candelabra", 			BlockType.BT_PLANK_OAK, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_OAK.ordinal()]);
		spruce_candelabra = 	createCandelabra("spruce_candelabra", 		BlockType.BT_PLANK_SPRUCE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_SPRUCE.ordinal()]);

		gold_candelabra = 		createCandelabra("gold_candelabra", 		BlockType.BT_INGOT_GOLD, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_GOLD.ordinal()]);
		iron_candelabra =	 	createCandelabra("iron_candelabra", 		BlockType.BT_INGOT_IRON, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_IRON.ordinal()]);

		// BaseMetal Lamps
		if (Loader.isModLoaded("basemetals")) {
			try {
				//do stuff

				adamantine_candelabra =	createCandelabra("adamantine_candelabra", 	BlockType.BT_INGOT_ADAMANTINE, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_ACACIA.ordinal()]);
				aquarium_candelabra =	createCandelabra("aquarium_candelabra", 	BlockType.BT_INGOT_AQUARIUM, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_AQUARIUM.ordinal()]);
				brass_candelabra =	 	createCandelabra("brass_candelabra", 		BlockType.BT_INGOT_BRASS, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_BRASS.ordinal()]);
				bronze_candelabra =	 	createCandelabra("bronze_candelabra", 		BlockType.BT_INGOT_BRONZE, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_BRONZE.ordinal()]);
				cold_iron_candelabra =	createCandelabra("cold_iron_candelabra", 	BlockType.BT_INGOT_COLD_IRON, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_COLD_IRON.ordinal()]);
				copper_candelabra =	 	createCandelabra("copper_candelabra",  		BlockType.BT_INGOT_COPPER, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_COPPER.ordinal()]);
				electrum_candelabra =	createCandelabra("electrum_candelabra", 	BlockType.BT_INGOT_ELECTRUM, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_ELECTRUM.ordinal()]);
				invar_candelabra =	 	createCandelabra("invar_candelabra", 		BlockType.BT_INGOT_INVAR, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_INVAR.ordinal()]);
				lead_candelabra =	 	createCandelabra("lead_candelabra", 		BlockType.BT_INGOT_LEAD, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_LEAD.ordinal()]);
				mithril_candelabra =	createCandelabra("mithril_candelabra", 		BlockType.BT_INGOT_MITHRIL, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_MITHRIL.ordinal()]);
				nickel_candelabra =	 	createCandelabra("nickel_candelabra", 		BlockType.BT_INGOT_NICKEL, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_NICKEL.ordinal()]);
				silver_candelabra =	 	createCandelabra("silver_candelabra", 		BlockType.BT_INGOT_SILVER, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_SILVER.ordinal()]);
				star_steel_candelabra =	createCandelabra("star_steel_candelabra", 	BlockType.BT_INGOT_STAR_STEEL, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_STAR_STEEL.ordinal()]);
				steel_candelabra =	 	createCandelabra("steel_candelabra", 		BlockType.BT_INGOT_STEEL, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_STEEL.ordinal()]);
				tin_candelabra =	 	createCandelabra("tin_candelabra", 			BlockType.BT_INGOT_TIN, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_TIN.ordinal()]);
				zinc_candelabra =	 	createCandelabra("zinc_candelabra", 		BlockType.BT_INGOT_ZINC, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_ZINC.ordinal()]);
				System.out.println("\nLoaded base metals\n");
			}
			catch (Exception e) {
				System.out.println("Could not load base metals");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Base metals\n");
		}
		
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura Candelabras
				amaranth_candelabra =	createCandelabra("amaranth_candelabra", 	BlockType.BT_PLANK_AMARANTH,	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_AMARANTH.ordinal()]);
				darkwood_candelabra =	createCandelabra("darkwood_candelabra", 	BlockType.BT_PLANK_DARKWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_DARKWOOD.ordinal()]);
				eucalyptus_candelabra =	createCandelabra("eucalyptus_candelabra", 	BlockType.BT_PLANK_EUCALYPTUS, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_EUCALYPTUS.ordinal()]);
				fusewood_candelabra =	createCandelabra("fusewood_candelabra", 	BlockType.BT_PLANK_FUSEWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_FUSEWOOD.ordinal()]);
				ghostwood_candelabra =	createCandelabra("ghostwood_candelabra", 	BlockType.BT_PLANK_GHOSTWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_GHOSTWOOD.ordinal()]);
				hopseed_candelabra =	createCandelabra("hopseed_candelabra", 		BlockType.BT_PLANK_HOPSEED, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_HOPSEED.ordinal()]);
				maple_candelabra =	 	createCandelabra("maple_candelabra", 		BlockType.BT_PLANK_MAPLE, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_MAPLE.ordinal()]);
				redwood_candelabra =	createCandelabra("redwood_candelabra", 		BlockType.BT_PLANK_REDWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_REDWOOD.ordinal()]);
				sakura_candelabra =	 	createCandelabra("sakura_candelabra", 		BlockType.BT_PLANK_SAKURA, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_SAKURA.ordinal()]);
				silverbell_candelabra =	createCandelabra("silverbell_candelabra", 	BlockType.BT_PLANK_SILVERBELL, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_SILVERBELL.ordinal()]);
				tiger_candelabra =	 	createCandelabra("tiger_candelabra", 		BlockType.BT_PLANK_TIGER, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_TIGER.ordinal()]);
				willow_candelabra =	 	createCandelabra("willow_candelabra", 		BlockType.BT_PLANK_WILLOW, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_WILLOW.ordinal()]);


				System.out.println("\nLoaded natura candelabras\n");
			}
			catch (Exception e) {
				System.out.println("Could not load natura candelabras");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		/*
		// Generic Candelabra
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(oak_candelabra, 2),
				"G G",
				"TWT",
				"SSS",
				'W', "plankWood",
				'G', "paneGlass",
				'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE),
				'T', BlockInfo.blockType2Stack(BlockType.BT_TORCH)
				));
		*/
		acacia_lamp = 	createLamp("acacia_lamp",	BlockType.BT_PLANK_ACACIA,	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.LAMP_ACACIA.ordinal()]);
		birch_lamp = 	createLamp("birch_lamp",	BlockType.BT_PLANK_BIRCH, 	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.LAMP_BIRCH.ordinal()]);
		dark_oak_lamp = createLamp("dark_oak_lamp", BlockType.BT_PLANK_DARK_OAK, Material.WOOD, MpConfiguration.BlockEnable[ConfigInfo.LAMP_DARK_OAK.ordinal()]);
		jungle_lamp = 	createLamp("jungle_lamp", 	BlockType.BT_PLANK_JUNGLE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_JUNGLE.ordinal()]);
		oak_lamp = 		createLamp("oak_lamp", 		BlockType.BT_PLANK_OAK, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_OAK.ordinal()]);
		spruce_lamp = 	createLamp("spruce_lamp", 	BlockType.BT_PLANK_SPRUCE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_SPRUCE.ordinal()]);
		gold_lamp = 	createLamp("gold_lamp", 	BlockType.BT_INGOT_GOLD, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_GOLD.ordinal()]);
		iron_lamp =	 	createLamp("iron_lamp", 	BlockType.BT_INGOT_IRON, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_IRON.ordinal()]);
		
		// BaseMetal Lamps
		if (Loader.isModLoaded("basemetals")) {
			try {
				//do stuff

				adamantine_lamp =	createLamp("adamantine_lamp", 	BlockType.BT_INGOT_ADAMANTINE, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_ADAMANTINE.ordinal()]);
				aquarium_lamp =	 	createLamp("aquarium_lamp", 	BlockType.BT_INGOT_AQUARIUM, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_AQUARIUM.ordinal()]);
				brass_lamp =	 	createLamp("brass_lamp", 		BlockType.BT_INGOT_BRASS, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_BRASS.ordinal()]);
				bronze_lamp =	 	createLamp("bronze_lamp", 		BlockType.BT_INGOT_BRONZE, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_BRONZE.ordinal()]);
				cold_iron_lamp =	createLamp("cold_iron_lamp", 	BlockType.BT_INGOT_COLD_IRON, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_COLD_IRON.ordinal()]);
				copper_lamp =	 	createLamp("copper_lamp", 		BlockType.BT_INGOT_COPPER, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_COPPER.ordinal()]);
				electrum_lamp =	 	createLamp("electrum_lamp", 	BlockType.BT_INGOT_ELECTRUM, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_ELECTRUM.ordinal()]);
				invar_lamp =	 	createLamp("invar_lamp", 		BlockType.BT_INGOT_INVAR, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_INVAR.ordinal()]);
				lead_lamp =	 		createLamp("lead_lamp", 		BlockType.BT_INGOT_LEAD, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_LEAD.ordinal()]);
				mithril_lamp =	 	createLamp("mithril_lamp", 		BlockType.BT_INGOT_MITHRIL, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_MITHRIL.ordinal()]);
				nickel_lamp =	 	createLamp("nickel_lamp", 		BlockType.BT_INGOT_NICKEL, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_NICKEL.ordinal()]);
				silver_lamp =	 	createLamp("silver_lamp", 		BlockType.BT_INGOT_SILVER, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_SILVER.ordinal()]);
				star_steel_lamp =	createLamp("star_steel_lamp", 	BlockType.BT_INGOT_STAR_STEEL, 	Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_STAR_STEEL.ordinal()]);
				steel_lamp =	 	createLamp("steel_lamp", 		BlockType.BT_INGOT_STEEL, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_STEEL.ordinal()]);
				tin_lamp =	 		createLamp("tin_lamp", 			BlockType.BT_INGOT_TIN, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_TIN.ordinal()]);
				zinc_lamp =	 		createLamp("zinc_lamp", 		BlockType.BT_INGOT_ZINC, 		Material.IRON, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_ZINC.ordinal()]);
				
				System.out.println("\nLoaded base metals\n");
			}
			catch (Exception e) {
				System.out.println("Could not load base metals");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Base metals\n");
		}
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura Lamps
				amaranth_lamp =		createLamp("amaranth_lamp", 	BlockType.BT_PLANK_AMARANTH,	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_AMARANTH.ordinal()]);
				darkwood_lamp =		createLamp("darkwood_lamp", 	BlockType.BT_PLANK_DARKWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_DARKWOOD.ordinal()]);
				eucalyptus_lamp =	createLamp("eucalyptus_lamp", 	BlockType.BT_PLANK_EUCALYPTUS, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_EUCALYPTUS.ordinal()]);
				fusewood_lamp =		createLamp("fusewood_lamp", 	BlockType.BT_PLANK_FUSEWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_FUSEWOOD.ordinal()]);
				ghostwood_lamp =	createLamp("ghostwood_lamp", 	BlockType.BT_PLANK_GHOSTWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_GHOSTWOOD.ordinal()]);
				hopseed_lamp =		createLamp("hopseed_lamp", 		BlockType.BT_PLANK_HOPSEED, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_HOPSEED.ordinal()]);
				maple_lamp =	 	createLamp("maple_lamp", 		BlockType.BT_PLANK_MAPLE, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_MAPLE.ordinal()]);
				redwood_lamp =		createLamp("redwood_lamp", 		BlockType.BT_PLANK_REDWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_REDWOOD.ordinal()]);
				sakura_lamp =	 	createLamp("sakura_lamp", 		BlockType.BT_PLANK_SAKURA, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_SAKURA.ordinal()]);
				silverbell_lamp =	createLamp("silverbell_lamp", 	BlockType.BT_PLANK_SILVERBELL, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_SILVERBELL.ordinal()]);
				tiger_lamp =	 	createLamp("tiger_lamp", 		BlockType.BT_PLANK_TIGER, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_TIGER.ordinal()]);
				willow_lamp =	 	createLamp("willow_lamp", 		BlockType.BT_PLANK_WILLOW, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_WILLOW.ordinal()]);


				System.out.println("\nLoaded natura lamps\n");
			}
			catch (Exception e) {
				System.out.println("Could not load natura lamps");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}
		/*
		// Generic Lamp
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(oak_lamp, 2),
				"GTG",
				" S ",
				" W ",
				'W', "plankWood",
				'G', "paneGlass",
				'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE),
				'T', BlockInfo.blockType2Stack(BlockType.BT_TORCH)
				));
		 */
		acacia_chair = 	createChair("acacia_chair",		BlockType.BT_PLANK_ACACIA,	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_ACACIA.ordinal()]);
		birch_chair = 	createChair("birch_chair",		BlockType.BT_PLANK_BIRCH, 	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_BIRCH.ordinal()]);
		dark_oak_chair = createChair("dark_oak_chair", 	BlockType.BT_PLANK_DARK_OAK, Material.WOOD, MpConfiguration.BlockEnable[ConfigInfo.CHAIR_DARK_OAK.ordinal()]);
		jungle_chair = 	createChair("jungle_chair", 	BlockType.BT_PLANK_JUNGLE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_JUNGLE.ordinal()]);
		oak_chair = 	createChair("oak_chair", 		BlockType.BT_PLANK_OAK, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_OAK.ordinal()]);
		spruce_chair = 	createChair("spruce_chair", 	BlockType.BT_PLANK_SPRUCE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_SPRUCE.ordinal()]);
		/*
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(oak_chair,2),
				"  S",
				" AA",
				" SS",
				'A', "plankWood",
				'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE )));
		 */
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura Chairs
				amaranth_chair =	createChair("amaranth_chair", 	BlockType.BT_PLANK_AMARANTH,	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_AMARANTH.ordinal()]);
				darkwood_chair =	createChair("darkwood_chair", 	BlockType.BT_PLANK_DARKWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_DARKWOOD.ordinal()]);
				eucalyptus_chair =	createChair("eucalyptus_chair", BlockType.BT_PLANK_EUCALYPTUS, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_EUCALYPTUS.ordinal()]);
				fusewood_chair =	createChair("fusewood_chair", 	BlockType.BT_PLANK_FUSEWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_FUSEWOOD.ordinal()]);
				ghostwood_chair =	createChair("ghostwood_chair", 	BlockType.BT_PLANK_GHOSTWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_GHOSTWOOD.ordinal()]);
				hopseed_chair =		createChair("hopseed_chair", 	BlockType.BT_PLANK_HOPSEED, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_HOPSEED.ordinal()]);
				maple_chair =	 	createChair("maple_chair", 		BlockType.BT_PLANK_MAPLE, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_MAPLE.ordinal()]);
				redwood_chair =		createChair("redwood_chair", 	BlockType.BT_PLANK_REDWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_REDWOOD.ordinal()]);
				sakura_chair =	 	createChair("sakura_chair", 	BlockType.BT_PLANK_SAKURA, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_SAKURA.ordinal()]);
				silverbell_chair =	createChair("silverbell_chair", BlockType.BT_PLANK_SILVERBELL, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_SILVERBELL.ordinal()]);
				tiger_chair =	 	createChair("tiger_chair", 		BlockType.BT_PLANK_TIGER, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_TIGER.ordinal()]);
				willow_chair =	 	createChair("willow_chair", 	BlockType.BT_PLANK_WILLOW, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_WILLOW.ordinal()]);


				System.out.println("\nLoaded natura chairs\n");
			}
			catch (Exception e) {
				System.out.println("Could not load natura chairs");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		//		Name					    Ingredient						Material		Hard	Enable/Disable
		acacia_pillar =			createPillar("acacia_pillar",		BlockType.BT_PLANK_ACACIA,		Material.WOOD,	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_ACACIA.ordinal()], "axe", 1);
		birch_pillar = 			createPillar("birch_pillar",		BlockType.BT_PLANK_BIRCH, 		Material.WOOD,	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BIRCH.ordinal()], "axe", 1);
		dark_oak_pillar = 		createPillar("dark_oak_pillar", 	BlockType.BT_PLANK_DARK_OAK, 	Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DARK_OAK.ordinal()], "axe", 1);
		jungle_pillar = 		createPillar("jungle_pillar", 		BlockType.BT_PLANK_JUNGLE, 		Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_JUNGLE.ordinal()], "axe", 1);
		oak_pillar = 			createPillar("oak_pillar", 			BlockType.BT_PLANK_OAK, 		Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_OAK.ordinal()], "axe", 1);
		spruce_pillar = 		createPillar("spruce_pillar", 		BlockType.BT_PLANK_SPRUCE, 		Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SPRUCE.ordinal()], "axe", 1);
		acacia_log =			createPillar("acacia_log",			BlockType.BT_WOOD_ACACIA,		Material.WOOD,	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.LOG_ACACIA.ordinal()], "axe", 1);
		birch_log = 			createPillar("birch_log",			BlockType.BT_WOOD_BIRCH, 		Material.WOOD,	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.LOG_BIRCH.ordinal()], "axe", 1);
		dark_oak_log = 			createPillar("dark_oak_log", 		BlockType.BT_WOOD_DARK_OAK, 	Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.LOG_DARK_OAK.ordinal()], "axe", 1);
		jungle_log = 			createPillar("jungle_log", 			BlockType.BT_WOOD_JUNGLE, 		Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.LOG_JUNGLE.ordinal()], "axe", 1);
		oak_log = 				createPillar("oak_log", 			BlockType.BT_WOOD_OAK, 			Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.LOG_OAK.ordinal()], "axe", 1);
		spruce_log = 			createPillar("spruce_log", 			BlockType.BT_WOOD_SPRUCE, 		Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.LOG_SPRUCE.ordinal()], "axe", 1);
		p_granite_pillar = 		createPillar("p_granite_pillar", 	BlockType.BT_POLISHED_GRANITE, 	Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_P_GRANITE.ordinal()], "pickaxe", 1);
		p_andesite_pillar = 	createPillar("p_andesite_pillar", 	BlockType.BT_POLISHED_ANDESITE, Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_P_ANDESITE.ordinal()], "pickaxe", 1);
		p_diorite_pillar = 		createPillar("p_diorite_pillar", 	BlockType.BT_POLISHED_DIORITE, 	Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_P_DIORITE.ordinal()], "pickaxe", 1);
		granite_pillar = 		createPillar("granite_pillar", 		BlockType.BT_GRANITE, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GRANITE.ordinal()], "pickaxe", 1);
		andesite_pillar = 		createPillar("andesite_pillar", 	BlockType.BT_ANDESITE, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_ANDESITE.ordinal()], "pickaxe", 1);
		diorite_pillar = 		createPillar("diorite_pillar", 		BlockType.BT_DIORITE, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DIORITE.ordinal()], "pickaxe", 1);
		stone_pillar = 			createPillar("stone_pillar", 		BlockType.BT_STONE, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_STONE.ordinal()], "pickaxe", 1);
		stonebrick_pillar = 	createPillar("stonebrick_pillar", 	BlockType.BT_STONEBRICK, 		Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_STONEBRICK.ordinal()], "pickaxe", 1);
		purpur_pillar = 		createPillar("purpur_pillar", 		BlockType.BT_PURPUR, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PURPUR.ordinal()], "pickaxe", 1);
		cobblestone_pillar = 	createPillar("cobblestone_pillar", 	BlockType.BT_COBBLESTONE, 		Material.ROCK, 	2.0F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_COBBLESTONE.ordinal()], "pickaxe", 1);
		obsidian_pillar = 		createPillar("obsidian_pillar", 	BlockType.BT_OBSIDIAN, 			Material.ROCK, 	50.0F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_OBSIDIAN.ordinal()], "pickaxe", 3);
		quartz_pillar = 		createPillar("quartz_pillar", 		BlockType.BT_QUARTZ_BLOCK, 		Material.ROCK, 	0.8F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_QUARTZ.ordinal()], "pickaxe", 1);
		sandstone_pillar = 		createPillar("sandstone_pillar", 	BlockType.BT_SANDSTONE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SANDSTONE.ordinal()], "pickaxe", 1);
		red_sandstone_pillar = 	createPillar("red_sandstone_pillar", BlockType.BT_RED_SANDSTONE, 	Material.ROCK, 	0.8F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_RED_SANDSTONE.ordinal()], "pickaxe", 1);
		nether_brick_pillar = 	createPillar("nether_brick_pillar", BlockType.BT_NETHER_BRICK, 		Material.ROCK, 	0.8F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_NETHER_BRICK.ordinal()], "pickaxe", 1);

		end_stone_pillar = 		createPillar("end_stone_pillar", 		BlockType.BT_END_STONE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_END_STONE.ordinal()], "pickaxe", 1);
		black_clay_pillar = 	createPillar("black_clay_pillar", 		BlockType.BT_CLAY_BLACK, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BLACK_CLAY.ordinal()], "pickaxe", 1);
		blue_clay_pillar = 		createPillar("blue_clay_pillar", 		BlockType.BT_CLAY_BLUE, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BLUE_CLAY.ordinal()], "pickaxe", 1);
		brown_clay_pillar = 	createPillar("brown_clay_pillar", 		BlockType.BT_CLAY_BROWN, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BROWN_CLAY.ordinal()], "pickaxe", 1);
		cyan_clay_pillar = 		createPillar("cyan_clay_pillar", 		BlockType.BT_CLAY_CYAN, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_CYAN_CLAY.ordinal()], "pickaxe", 1);
		gray_clay_pillar = 		createPillar("gray_clay_pillar", 		BlockType.BT_CLAY_GRAY, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GRAY_CLAY.ordinal()], "pickaxe", 1);
		green_clay_pillar = 	createPillar("green_clay_pillar", 		BlockType.BT_CLAY_GREEN, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GREEN_CLAY.ordinal()], "pickaxe", 1);
		light_blue_clay_pillar = createPillar("light_blue_clay_pillar", BlockType.BT_CLAY_LIGHT_BLUE, 	Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIGHT_BLUE_CLAY.ordinal()], "pickaxe", 1);
		light_gray_clay_pillar = createPillar("light_gray_clay_pillar", BlockType.BT_CLAY_LIGHT_GRAY, 	Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIGHT_GRAY_CLAY.ordinal()], "pickaxe", 1);
		lime_clay_pillar = 		createPillar("lime_clay_pillar", 		BlockType.BT_CLAY_LIME, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIME_CLAY.ordinal()], "pickaxe", 1);
		magenta_clay_pillar = 	createPillar("magenta_clay_pillar", 	BlockType.BT_CLAY_MAGENTA, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_MAGENTA_CLAY.ordinal()], "pickaxe", 1);
		orange_clay_pillar = 	createPillar("orange_clay_pillar", 		BlockType.BT_CLAY_ORANGE, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_ORANGE_CLAY.ordinal()], "pickaxe", 1);
		pink_clay_pillar = 		createPillar("pink_clay_pillar", 		BlockType.BT_CLAY_PINK, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PINK_CLAY.ordinal()], "pickaxe", 1);
		purple_clay_pillar = 	createPillar("purple_clay_pillar", 		BlockType.BT_CLAY_PURPLE, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PURPLE_CLAY.ordinal()], "pickaxe", 1);
		red_clay_pillar = 		createPillar("red_clay_pillar", 		BlockType.BT_CLAY_RED, 			Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_RED_CLAY.ordinal()], "pickaxe", 1);
		white_clay_pillar = 	createPillar("white_clay_pillar", 		BlockType.BT_CLAY_WHITE, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_WHITE_CLAY.ordinal()], "pickaxe", 1);
		yellow_clay_pillar = 	createPillar("yellow_clay_pillar", 		BlockType.BT_CLAY_YELLOW, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_YELLOW_CLAY.ordinal()], "pickaxe", 1);
		glass_pillar = 			createPillar("glass_pillar", 			BlockType.BT_GLASS_BLOCK, 		Material.GLASS,	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GLASS.ordinal()], "pickaxe", 1);

		// mineralogy Pillars
		if (Loader.isModLoaded("mineralogy")) {
			try {
				//System.out.println("\nLoaded mineralogy\n");

				amphibolite_pillar = 		createPillar("amphibolite_pillar", 		BlockType.BT_AMPHIBOLITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_AMPHIBOLITE.ordinal()], 		"pickaxe", 1);
				amphibolite_smooth_pillar = createPillar("amphibolite_smooth_pillar", BlockType.BT_AMPHIBOLITE_SMOOTH, Material.ROCK, 0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_AMPHIBOLITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				m_andesite_pillar = 		createPillar("m_andesite_pillar", 		BlockType.BT_M_ANDESITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_ANDESITE.ordinal()], 		"pickaxe", 1);
				m_andesite_smooth_pillar = 	createPillar("m_andesite_smooth_pillar", BlockType.BT_M_ANDESITE_SMOOTH, Material.ROCK, 0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_ANDESITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				basalt_pillar = 			createPillar("basalt_pillar", 			BlockType.BT_BASALT, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BASALT.ordinal()], 			"pickaxe", 1);
				basalt_smooth_pillar = 		createPillar("basalt_smooth_pillar", 	BlockType.BT_BASALT_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BASALT_SMOOTH.ordinal()], 	"pickaxe", 1);
				chert_pillar = 				createPillar("chert_pillar", 			BlockType.BT_CHERT, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_CHERT.ordinal()], 			"pickaxe", 1);
				conglomerate_pillar = 		createPillar("conglomerate_pillar", 	BlockType.BT_CONGLOMERATE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_CONGLOMERATE.ordinal()], 	"pickaxe", 1);
				conglomerate_smooth_pillar = createPillar("conglomerate_smooth_pillar", BlockType.BT_CONGLOMERATE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_CONGLOMERATE_SMOOTH.ordinal()], "pickaxe", 1);
				m_diorite_pillar = 			createPillar("m_diorite_pillar", 		BlockType.BT_M_DIORITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_DIORITE.ordinal()], 		"pickaxe", 1);
				m_diorite_smooth_pillar = 	createPillar("m_diorite_smooth_pillar", BlockType.BT_M_DIORITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_DIORITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				dolomite_pillar = 			createPillar("dolomite_pillar", 		BlockType.BT_DOLOMITE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DOLOMITE.ordinal()], 		"pickaxe", 1);
				dolomite_smooth_pillar = 	createPillar("dolomite_smooth_pillar", 	BlockType.BT_DOLOMITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DOLOMITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				gneiss_pillar = 			createPillar("gneiss_pillar", 			BlockType.BT_GNEISS, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GNEISS.ordinal()], 			"pickaxe", 1);
				gneiss_smooth_pillar = 		createPillar("gneiss_smooth_pillar", 	BlockType.BT_GNEISS_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GNEISS_SMOOTH.ordinal()], 	"pickaxe", 1);
				m_granite_pillar = 			createPillar("m_granite_pillar", 		BlockType.BT_M_GRANITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_GRANITE.ordinal()], 		"pickaxe", 1);
				m_granite_smooth_pillar = 	createPillar("m_granite_smooth_pillar", BlockType.BT_M_GRANITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_GRANITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				limestone_pillar = 			createPillar("limestone_pillar", 		BlockType.BT_LIMESTONE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIMESTONE.ordinal()], 		"pickaxe", 1);
				limestone_smooth_pillar = 	createPillar("limestone_smooth_pillar", BlockType.BT_LIMESTONE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIMESTONE_SMOOTH.ordinal()], 	"pickaxe", 1);
				marble_pillar = 			createPillar("marble_pillar", 			BlockType.BT_MARBLE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_MARBLE.ordinal()], 			"pickaxe", 1);
				marble_smooth_pillar = 		createPillar("marble_smooth_pillar", 	BlockType.BT_MARBLE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_MARBLE_SMOOTH.ordinal()], 	"pickaxe", 1);
				pumice_pillar = 			createPillar("pumice_pillar", 			BlockType.BT_PUMICE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PUMICE.ordinal()], 			"pickaxe", 1);
				pegmatite_pillar = 			createPillar("pegmatite_pillar", 		BlockType.BT_PEGMATITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PEGMATITE.ordinal()], 		"pickaxe", 1);
				pegmatite_smooth_pillar = 	createPillar("pegmatite_smooth_pillar", BlockType.BT_PEGMATITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PEGMATITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				phyllite_pillar = 			createPillar("phyllite_pillar", 		BlockType.BT_PHYLLITE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PHYLLITE.ordinal()], 		"pickaxe", 1);
				phyllite_smooth_pillar = 	createPillar("phyllite_smooth_pillar", BlockType.BT_PHYLLITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PHYLLITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				rhyolite_pillar = 			createPillar("rhyolite_pillar", 		BlockType.BT_RHYOLITE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_RHYOLITE.ordinal()], 		"pickaxe", 1);
				rhyolite_smooth_pillar = 	createPillar("rhyolite_smooth_pillar", 	BlockType.BT_RHYOLITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_RHYOLITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				schist_pillar = 			createPillar("schist_pillar", 			BlockType.BT_SCHIST, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SCHIST.ordinal()], 			"pickaxe", 1);
				schist_smooth_pillar = 		createPillar("schist_smooth_pillar", 	BlockType.BT_SCHIST_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SCHIST_SMOOTH.ordinal()], 	"pickaxe", 1);
				shale_pillar = 				createPillar("shale_pillar", 			BlockType.BT_SHALE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SHALE.ordinal()], 			"pickaxe", 1);
				shale_smooth_pillar = 		createPillar("shale_smooth_pillar", 	BlockType.BT_SHALE_SMOOTH, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SHALE_SMOOTH.ordinal()], 		"pickaxe", 1);
				slate_pillar = 				createPillar("slate_pillar", 			BlockType.BT_SLATE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SLATE.ordinal()], 			"pickaxe", 1);
				slate_smooth_pillar = 		createPillar("slate_smooth_pillar", 	BlockType.BT_SLATE_SMOOTH, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SLATE_SMOOTH.ordinal()], 		"pickaxe", 1);
			}
			catch (Exception e) {
				System.out.println("Could not load mineralogy");
				e.printStackTrace(System.err);
			}
		} 
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura Pillars
				amaranth_pillar =	createPillar("amaranth_pillar", 	BlockType.BT_PLANK_AMARANTH,	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_AMARANTH.ordinal()],	"axe", 1);
				darkwood_pillar =	createPillar("darkwood_pillar", 	BlockType.BT_PLANK_DARKWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DARKWOOD.ordinal()],	"axe", 1);
				eucalyptus_pillar =	createPillar("eucalyptus_pillar", 	BlockType.BT_PLANK_EUCALYPTUS, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_EUCALYPTUS.ordinal()],"axe", 1);
				fusewood_pillar =	createPillar("fusewood_pillar", 	BlockType.BT_PLANK_FUSEWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_FUSEWOOD.ordinal()],	"axe", 1);
				ghostwood_pillar =	createPillar("ghostwood_pillar", 	BlockType.BT_PLANK_GHOSTWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GHOSTWOOD.ordinal()],	"axe", 1);
				hopseed_pillar =	createPillar("hopseed_pillar", 		BlockType.BT_PLANK_HOPSEED, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_HOPSEED.ordinal()],	"axe", 1);
				maple_pillar =	 	createPillar("maple_pillar", 		BlockType.BT_PLANK_MAPLE, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_MAPLE.ordinal()],		"axe", 1);
				redwood_pillar =	createPillar("redwood_pillar", 		BlockType.BT_PLANK_REDWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_REDWOOD.ordinal()],	"axe", 1);
				sakura_pillar =	 	createPillar("sakura_pillar", 		BlockType.BT_PLANK_SAKURA, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SAKURA.ordinal()],	"axe", 1);
				silverbell_pillar =	createPillar("silverbell_pillar", 	BlockType.BT_PLANK_SILVERBELL, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SILVERBELL.ordinal()],"axe", 1);
				tiger_pillar =	 	createPillar("tiger_pillar", 		BlockType.BT_PLANK_TIGER, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_TIGER.ordinal()],		"axe", 1);
				willow_pillar =	 	createPillar("willow_pillar", 		BlockType.BT_PLANK_WILLOW, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_WILLOW.ordinal()],	"axe", 1);
				//Natura Logs
				amaranth_log =		createPillar("amaranth_log", 	BlockType.BT_WOOD_AMARANTH,	    Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_AMARANTH.ordinal()],	"axe", 1);
				darkwood_log =		createPillar("darkwood_log", 	BlockType.BT_WOOD_DARKWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_DARKWOOD.ordinal()],	"axe", 1);
				eucalyptus_log =	createPillar("eucalyptus_log", 	BlockType.BT_WOOD_EUCALYPTUS, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_EUCALYPTUS.ordinal()],"axe", 1);
				fusewood_log =		createPillar("fusewood_log", 	BlockType.BT_WOOD_FUSEWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_FUSEWOOD.ordinal()],	"axe", 1);
				ghostwood_log =		createPillar("ghostwood_log", 	BlockType.BT_WOOD_GHOSTWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_GHOSTWOOD.ordinal()],	"axe", 1);
				hopseed_log =		createPillar("hopseed_log", 	BlockType.BT_WOOD_HOPSEED, 	    Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_HOPSEED.ordinal()],	"axe", 1);
				maple_log =	 		createPillar("maple_log", 		BlockType.BT_WOOD_MAPLE, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_MAPLE.ordinal()],		"axe", 1);
				redwood_log =		createPillar("redwood_log", 	BlockType.BT_WOOD_REDWOOD, 	    Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_REDWOOD.ordinal()],	"axe", 1);
				sakura_log =	 	createPillar("sakura_log", 		BlockType.BT_WOOD_SAKURA, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_SAKURA.ordinal()],	"axe", 1);
				silverbell_log =	createPillar("silverbell_log", 	BlockType.BT_WOOD_SILVERBELL, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_SILVERBELL.ordinal()],"axe", 1);
				tiger_log =	 		createPillar("tiger_log", 		BlockType.BT_WOOD_TIGER, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_TIGER.ordinal()],		"axe", 1);
				willow_log =	 	createPillar("willow_log", 		BlockType.BT_WOOD_WILLOW, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_WILLOW.ordinal()],	"axe", 1);


				System.out.println("\nLoaded natura pillars\n");
			}
			catch (Exception e) {
				System.out.println("Could not load natura pillars");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		// generic pillar
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cobblestone_pillar, 3),
				" A ",
				" A ",
				" A ",
				'A', "cobblestone"
				));

		// Create Tables
		//		Name					Ingredient					Material		Enable/Disable
		acacia_table = 	createTable("acacia_table",		BlockType.BT_PLANK_ACACIA,	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.TABLE_ACACIA.ordinal()]);
		birch_table = 	createTable("birch_table",		BlockType.BT_PLANK_BIRCH, 	Material.WOOD,	MpConfiguration.BlockEnable[ConfigInfo.TABLE_BIRCH.ordinal()]);
		dark_oak_table = createTable("dark_oak_table", 	BlockType.BT_PLANK_DARK_OAK, Material.WOOD, MpConfiguration.BlockEnable[ConfigInfo.TABLE_DARK_OAK.ordinal()]);
		jungle_table = 	createTable("jungle_table", 	BlockType.BT_PLANK_JUNGLE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_JUNGLE.ordinal()]);
		oak_table = 	createTable("oak_table", 		BlockType.BT_PLANK_OAK, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_OAK.ordinal()]);
		spruce_table = 	createTable("spruce_table", 	BlockType.BT_PLANK_SPRUCE, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_SPRUCE.ordinal()]);
		//Generic Table
		/*
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(oak_table,2),
				"AAA",
				"S S",
				"S S",
				'A', "plankWood",
				'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE)));
		*/
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura Tables
				amaranth_table =	createTable("amaranth_table", 	BlockType.BT_PLANK_AMARANTH,	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_AMARANTH.ordinal()]);
				darkwood_table =	createTable("darkwood_table", 	BlockType.BT_PLANK_DARKWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_DARKWOOD.ordinal()]);
				eucalyptus_table =	createTable("eucalyptus_table", BlockType.BT_PLANK_EUCALYPTUS, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_EUCALYPTUS.ordinal()]);
				fusewood_table =	createTable("fusewood_table", 	BlockType.BT_PLANK_FUSEWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_FUSEWOOD.ordinal()]);
				ghostwood_table =	createTable("ghostwood_table", 	BlockType.BT_PLANK_GHOSTWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_GHOSTWOOD.ordinal()]);
				hopseed_table =		createTable("hopseed_table", 	BlockType.BT_PLANK_HOPSEED, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_HOPSEED.ordinal()]);
				maple_table =	 	createTable("maple_table", 		BlockType.BT_PLANK_MAPLE, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_MAPLE.ordinal()]);
				redwood_table =		createTable("redwood_table", 	BlockType.BT_PLANK_REDWOOD, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_REDWOOD.ordinal()]);
				sakura_table =	 	createTable("sakura_table", 	BlockType.BT_PLANK_SAKURA, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_SAKURA.ordinal()]);
				silverbell_table =	createTable("silverbell_table", BlockType.BT_PLANK_SILVERBELL, 	Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_SILVERBELL.ordinal()]);
				tiger_table =	 	createTable("tiger_table", 		BlockType.BT_PLANK_TIGER, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_TIGER.ordinal()]);
				willow_table =	 	createTable("willow_table", 	BlockType.BT_PLANK_WILLOW, 		Material.WOOD, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_WILLOW.ordinal()]);


				System.out.println("\nLoaded natura tables\n");
			}
			catch (Exception e) {
				System.out.println("Could not load natura tables");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		//		Name					    Ingredient						Material		Hard	Enable/Disable
		acacia_wedge =		createWedge("acacia_wedge",		BlockType.BT_PLANK_ACACIA,		Material.WOOD,	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_ACACIA.ordinal()], 	"axe", 1);
		birch_wedge = 		createWedge("birch_wedge",		BlockType.BT_PLANK_BIRCH, 		Material.WOOD,	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BIRCH.ordinal()], 	"axe", 1);
		dark_oak_wedge = 	createWedge("dark_oak_wedge", 	BlockType.BT_PLANK_DARK_OAK, 	Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DARK_OAK.ordinal()], 	"axe", 1);
		jungle_wedge = 		createWedge("jungle_wedge", 	BlockType.BT_PLANK_JUNGLE, 		Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_JUNGLE.ordinal()], 	"axe", 1);
		oak_wedge = 		createWedge("oak_wedge", 		BlockType.BT_PLANK_OAK, 		Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_OAK.ordinal()], 		"axe", 1);
		spruce_wedge = 		createWedge("spruce_wedge", 	BlockType.BT_PLANK_SPRUCE, 		Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SPRUCE.ordinal()], 	"axe", 1);
		p_granite_wedge = 	createWedge("p_granite_wedge", 	BlockType.BT_POLISHED_GRANITE, 	Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_P_GRANITE.ordinal()], 		"pickaxe", 1);
		p_andesite_wedge = 	createWedge("p_andesite_wedge", BlockType.BT_POLISHED_ANDESITE, Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_P_ANDESITE.ordinal()], 		"pickaxe", 1);
		p_diorite_wedge = 	createWedge("p_diorite_wedge", 	BlockType.BT_POLISHED_DIORITE, 	Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_P_DIORITE.ordinal()], 		"pickaxe", 1);
		diorite_wedge = 	createWedge("diorite_wedge", 	BlockType.BT_DIORITE, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DIORITE.ordinal()], 		"pickaxe", 1);
		granite_wedge = 	createWedge("granite_wedge", 	BlockType.BT_GRANITE, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GRANITE.ordinal()], 		"pickaxe", 1);
		andesite_wedge = 	createWedge("andesite_wedge", 	BlockType.BT_ANDESITE, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_ANDESITE.ordinal()], 		"pickaxe", 1);
		stone_wedge = 		createWedge("stone_wedge", 		BlockType.BT_STONE, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_STONE.ordinal()], 		"pickaxe", 1);
		stonebrick_wedge = 	createWedge("stonebrick_wedge",	BlockType.BT_STONEBRICK, 		Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_STONEBRICK.ordinal()], 	"pickaxe", 1);
		purpur_wedge = 		createWedge("purpur_wedge", 	BlockType.BT_PURPUR, 			Material.ROCK, 	1.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PURPUR.ordinal()], 		"pickaxe", 1);
		cobblestone_wedge = createWedge("cobblestone_wedge",BlockType.BT_COBBLESTONE, 		Material.ROCK, 	2.0F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_COBBLESTONE.ordinal()], 	"pickaxe", 1);
		obsidian_wedge = 	createWedge("obsidian_wedge", 	BlockType.BT_OBSIDIAN, 			Material.ROCK, 	50.0F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_OBSIDIAN.ordinal()], 		"pickaxe", 3);
		quartz_wedge = 		createWedge("quartz_wedge", 	BlockType.BT_QUARTZ_BLOCK, 		Material.ROCK, 	0.8F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_QUARTZ.ordinal()], 		"pickaxe", 1);
		sandstone_wedge = 	createWedge("sandstone_wedge", 	BlockType.BT_SANDSTONE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SANDSTONE.ordinal()], 	"pickaxe", 1);
		red_sandstone_wedge = createWedge("red_sandstone_wedge", BlockType.BT_RED_SANDSTONE, Material.ROCK, 0.8F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_RED_SANDSTONE.ordinal()], 	"pickaxe", 1);
		nether_brick_wedge= createWedge("nether_brick_wedge", BlockType.BT_NETHER_BRICK, 	Material.ROCK, 	0.8F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_NETHER_BRICK.ordinal()], 	"pickaxe", 1);


		end_stone_wedge = 		createWedge("end_stone_wedge", 		BlockType.BT_END_STONE, 		Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_END_STONE.ordinal()], 		"pickaxe", 1);
		black_clay_wedge = 		createWedge("black_clay_wedge", 	BlockType.BT_CLAY_BLACK, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BLACK_CLAY.ordinal()], 	"pickaxe", 1);
		blue_clay_wedge = 		createWedge("blue_clay_wedge", 		BlockType.BT_CLAY_BLUE, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BLUE_CLAY.ordinal()], 		"pickaxe", 1);
		brown_clay_wedge = 		createWedge("brown_clay_wedge", 	BlockType.BT_CLAY_BROWN, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BROWN_CLAY.ordinal()], 	"pickaxe", 1);
		cyan_clay_wedge = 		createWedge("cyan_clay_wedge", 		BlockType.BT_CLAY_CYAN, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_CYAN_CLAY.ordinal()], 		"pickaxe", 1);
		gray_clay_wedge = 		createWedge("gray_clay_wedge", 		BlockType.BT_CLAY_GRAY, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GRAY_CLAY.ordinal()], 		"pickaxe", 1);
		green_clay_wedge = 		createWedge("green_clay_wedge", 	BlockType.BT_CLAY_GREEN, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GREEN_CLAY.ordinal()], 	"pickaxe", 1);
		light_blue_clay_wedge =	createWedge("light_blue_clay_wedge", BlockType.BT_CLAY_LIGHT_BLUE, 	Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIGHT_BLUE_CLAY.ordinal()], "pickaxe", 1);
		light_gray_clay_wedge = createWedge("light_gray_clay_wedge", BlockType.BT_CLAY_LIGHT_GRAY, 	Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIGHT_GRAY_CLAY.ordinal()], "pickaxe", 1);
		lime_clay_wedge = 		createWedge("lime_clay_wedge", 		BlockType.BT_CLAY_LIME, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIME_CLAY.ordinal()], 		"pickaxe", 1);
		magenta_clay_wedge = 	createWedge("magenta_clay_wedge", 	BlockType.BT_CLAY_MAGENTA, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_MAGENTA_CLAY.ordinal()], 	"pickaxe", 1);
		orange_clay_wedge = 	createWedge("orange_clay_wedge", 	BlockType.BT_CLAY_ORANGE, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_ORANGE_CLAY.ordinal()], 	"pickaxe", 1);
		pink_clay_wedge = 		createWedge("pink_clay_wedge", 		BlockType.BT_CLAY_PINK, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PINK_CLAY.ordinal()], 		"pickaxe", 1);
		purple_clay_wedge = 	createWedge("purple_clay_wedge", 	BlockType.BT_CLAY_PURPLE, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PURPLE_CLAY.ordinal()], 	"pickaxe", 1);
		red_clay_wedge = 		createWedge("red_clay_wedge", 		BlockType.BT_CLAY_RED, 			Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_RED_CLAY.ordinal()], 		"pickaxe", 1);
		white_clay_wedge = 		createWedge("white_clay_wedge", 	BlockType.BT_CLAY_WHITE, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_WHITE_CLAY.ordinal()], 	"pickaxe", 1);
		yellow_clay_wedge = 	createWedge("yellow_clay_wedge", 	BlockType.BT_CLAY_YELLOW, 		Material.CLAY, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_YELLOW_CLAY.ordinal()], 	"pickaxe", 1);
		dirt_wedge = 			createWedge("dirt_wedge", 			BlockType.BT_DIRT, 				Material.GROUND,0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DIRT.ordinal()], 			"shovel", 0);
		grass_wedge = 			createWedge("grass_wedge", 			BlockType.BT_GRASS, 			Material.GROUND, 0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GRASS.ordinal()], 			"shovel", 0);
		grass_path_wedge = 		createWedge("grass_path_wedge", 	BlockType.BT_GRASS_PATH, 		Material.GROUND, 0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GRASS_PATH.ordinal()], 	"shovel", 0);
		glass_wedge = 			createWedge("glass_wedge", 			BlockType.BT_GLASS_BLOCK, 		Material.GLASS, 0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GLASS.ordinal()], 			"pickaxe", 1);
		hay_wedge = 			createWedge("hay_wedge", 			BlockType.BT_HAY_BALE, 			Material.WOOD, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_HAY.ordinal()], 			"pickaxe", 0);

		// mineralogy Wedges
		if (Loader.isModLoaded("mineralogy")) {
			try {
				//System.out.println("\nLoaded mineralogy\n");

				amphibolite_wedge = 		createWedge("amphibolite_wedge", 		BlockType.BT_AMPHIBOLITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_AMPHIBOLITE.ordinal()], 		"pickaxe", 1);
				amphibolite_smooth_wedge = 	createWedge("amphibolite_smooth_wedge",	BlockType.BT_AMPHIBOLITE_SMOOTH, Material.ROCK, 0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_AMPHIBOLITE_SMOOTH.ordinal()], 		"pickaxe", 1);
				m_andesite_wedge = 			createWedge("m_andesite_wedge", 		BlockType.BT_M_ANDESITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_ANDESITE.ordinal()], 		"pickaxe", 1);
				m_andesite_smooth_wedge = 	createWedge("m_andesite_smooth_wedge", 	BlockType.BT_M_ANDESITE_SMOOTH, Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_ANDESITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				basalt_wedge = 				createWedge("basalt_wedge", 			BlockType.BT_BASALT, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BASALT.ordinal()], 			"pickaxe", 1);
				basalt_smooth_wedge = 		createWedge("basalt_smooth_wedge", 		BlockType.BT_BASALT_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BASALT_SMOOTH.ordinal()], 		"pickaxe", 1);
				chert_wedge = 				createWedge("chert_wedge", 				BlockType.BT_CHERT, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_CHERT.ordinal()], 			"pickaxe", 1);
				conglomerate_wedge = 		createWedge("conglomerate_wedge", 		BlockType.BT_CONGLOMERATE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_CONGLOMERATE.ordinal()], 		"pickaxe", 1);
				conglomerate_smooth_wedge = createWedge("conglomerate_smooth_wedge", BlockType.BT_CONGLOMERATE_SMOOTH, 	Material.ROCK, 0.5F,MpConfiguration.BlockEnable[ConfigInfo.WEDGE_CONGLOMERATE_SMOOTH.ordinal()], "pickaxe", 1);
				m_diorite_wedge = 			createWedge("m_diorite_wedge", 			BlockType.BT_M_DIORITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_DIORITE.ordinal()], 			"pickaxe", 1);
				m_diorite_smooth_wedge = 	createWedge("m_diorite_smooth_wedge", 	BlockType.BT_M_DIORITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_DIORITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				dolomite_wedge = 			createWedge("dolomite_wedge", 			BlockType.BT_DOLOMITE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DOLOMITE.ordinal()], 			"pickaxe", 1);
				dolomite_smooth_wedge = 	createWedge("dolomite_smooth_wedge", 	BlockType.BT_DOLOMITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DOLOMITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				gneiss_wedge = 				createWedge("gneiss_wedge", 			BlockType.BT_GNEISS, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GNEISS.ordinal()], 			"pickaxe", 1);
				gneiss_smooth_wedge = 		createWedge("gneiss_smooth_wedge", 		BlockType.BT_GNEISS_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GNEISS_SMOOTH.ordinal()], 		"pickaxe", 1);
				m_granite_wedge = 			createWedge("m_granite_wedge", 			BlockType.BT_M_GRANITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_GRANITE.ordinal()], 			"pickaxe", 1);
				m_granite_smooth_wedge = 	createWedge("m_granite_smooth_wedge", 	BlockType.BT_M_GRANITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_GRANITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				limestone_wedge = 			createWedge("limestone_wedge", 			BlockType.BT_LIMESTONE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIMESTONE.ordinal()], 		"pickaxe", 1);
				limestone_smooth_wedge = 	createWedge("limestone_smooth_wedge", 	BlockType.BT_LIMESTONE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIMESTONE_SMOOTH.ordinal()], 	"pickaxe", 1);
				marble_wedge = 				createWedge("marble_wedge", 			BlockType.BT_MARBLE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_MARBLE.ordinal()], 			"pickaxe", 1);
				marble_smooth_wedge = 		createWedge("marble_smooth_wedge", 		BlockType.BT_MARBLE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_MARBLE_SMOOTH.ordinal()], 		"pickaxe", 1);
				pumice_wedge = 				createWedge("pumice_wedge", 			BlockType.BT_PUMICE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PUMICE.ordinal()], 			"pickaxe", 1);
				pegmatite_wedge = 			createWedge("pegmatite_wedge", 			BlockType.BT_PEGMATITE, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PEGMATITE.ordinal()], 		"pickaxe", 1);
				pegmatite_smooth_wedge = 	createWedge("pegmatite_smooth_wedge", 	BlockType.BT_PEGMATITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PEGMATITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				phyllite_wedge = 			createWedge("phyllite_wedge", 			BlockType.BT_PHYLLITE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PHYLLITE.ordinal()], 			"pickaxe", 1);
				phyllite_smooth_wedge = 	createWedge("phyllite_smooth_wedge", 	BlockType.BT_PHYLLITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PHYLLITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				rhyolite_wedge = 			createWedge("rhyolite_wedge", 			BlockType.BT_RHYOLITE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_RHYOLITE.ordinal()], 			"pickaxe", 1);
				rhyolite_smooth_wedge = 	createWedge("rhyolite_smooth_wedge", 	BlockType.BT_RHYOLITE_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_RHYOLITE_SMOOTH.ordinal()], 	"pickaxe", 1);
				schist_wedge = 				createWedge("schist_wedge", 			BlockType.BT_SCHIST, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SCHIST.ordinal()], 			"pickaxe", 1);
				schist_smooth_wedge = 		createWedge("schist_smooth_wedge", 		BlockType.BT_SCHIST_SMOOTH, 	Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SCHIST_SMOOTH.ordinal()], 		"pickaxe", 1);
				shale_wedge = 				createWedge("shale_wedge", 				BlockType.BT_SHALE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SHALE.ordinal()], 			"pickaxe", 1);
				shale_smooth_wedge = 		createWedge("shale_smooth_wedge", 		BlockType.BT_SHALE_SMOOTH, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SHALE_SMOOTH.ordinal()], 		"pickaxe", 1);
				slate_wedge = 				createWedge("slate_wedge", 				BlockType.BT_SLATE, 			Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SLATE.ordinal()], 			"pickaxe", 1);
				slate_smooth_wedge = 		createWedge("slate_smooth_wedge", 		BlockType.BT_SLATE_SMOOTH, 		Material.ROCK, 	0.5F,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SLATE_SMOOTH.ordinal()], 		"pickaxe", 1);
			}
			catch (Exception e) {
				System.out.println("Could not load mineralogy");
				e.printStackTrace(System.err);
			}
		} 
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura Wedge
				amaranth_wedge =	createWedge("amaranth_wedge", 	BlockType.BT_PLANK_AMARANTH,	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_AMARANTH.ordinal()], "axe", 1);
				darkwood_wedge =	createWedge("darkwood_wedge", 	BlockType.BT_PLANK_DARKWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DARKWOOD.ordinal()], "axe", 1);
				eucalyptus_wedge =	createWedge("eucalyptus_wedge", BlockType.BT_PLANK_EUCALYPTUS, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_EUCALYPTUS.ordinal()], "axe", 1);
				fusewood_wedge =	createWedge("fusewood_wedge", 	BlockType.BT_PLANK_FUSEWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_FUSEWOOD.ordinal()], "axe", 1);
				ghostwood_wedge =	createWedge("ghostwood_wedge", 	BlockType.BT_PLANK_GHOSTWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GHOSTWOOD.ordinal()], "axe", 1);
				hopseed_wedge =		createWedge("hopseed_wedge", 	BlockType.BT_PLANK_HOPSEED, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_HOPSEED.ordinal()], "axe", 1);
				maple_wedge =	 	createWedge("maple_wedge", 		BlockType.BT_PLANK_MAPLE, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_MAPLE.ordinal()], "axe", 1);
				redwood_wedge =		createWedge("redwood_wedge", 	BlockType.BT_PLANK_REDWOOD, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_REDWOOD.ordinal()], "axe", 1);
				sakura_wedge =	 	createWedge("sakura_wedge", 	BlockType.BT_PLANK_SAKURA, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SAKURA.ordinal()], "axe", 1);
				silverbell_wedge =	createWedge("silverbell_wedge", BlockType.BT_PLANK_SILVERBELL, 	Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SILVERBELL.ordinal()], "axe", 1);
				tiger_wedge =	 	createWedge("tiger_wedge", 		BlockType.BT_PLANK_TIGER, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_TIGER.ordinal()], "axe", 1);
				willow_wedge =	 	createWedge("willow_wedge", 	BlockType.BT_PLANK_WILLOW, 		Material.WOOD, 	0.5F, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_WILLOW.ordinal()], "axe", 1);


				System.out.println("\nLoaded natura wedges\n");
			}
			catch (Exception e) {
				System.out.println("Could not load natura wedges");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		// Generic Wedge from Ore dictionary
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cobblestone_wedge, 3),
				"   ",
				"A  ",
				"AA ",
				'A', "cobblestone" 
				));

		//rainbow_slab = createHalfSlab("rainbow_slab", Material.rock, 2.0F, true, "pickaxe", 3);
		//rainbow_slab_double = createDoubleSlab("rainbow_slab_double",  Material.rock, 2.0F, true, "pickaxe", 3);
		//registerSlab(rainbow_slab, "rainbow_slab", rainbow_slab_double, "rainbow_slab_double", BlockType.BT_POLISHED_GRANITE, Slab_type.PATT_NORM, true);

		stone_patt1_slab = createHalfSlab("stone_patt1_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT1.ordinal()], "pickaxe", 1);
		stone_patt1_slab_double = createDoubleSlab("stone_patt1_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT1.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt1_slab, "stone_patt1_slab", stone_patt1_slab_double, "stone_patt1_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_1, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT1.ordinal()]);
		stone_patt2_slab = createHalfSlab("stone_patt2_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT2.ordinal()], "pickaxe", 1);
		stone_patt2_slab_double = createDoubleSlab("stone_patt2_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT2.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt2_slab, "stone_patt2_slab", stone_patt2_slab_double, "stone_patt2_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_2, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT2.ordinal()]);
		stone_patt3_slab = createHalfSlab("stone_patt3_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT3.ordinal()], "pickaxe", 1);
		stone_patt3_slab_double = createDoubleSlab("stone_patt3_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT3.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt3_slab, "stone_patt3_slab", stone_patt3_slab_double, "stone_patt3_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_3, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT3.ordinal()]);
		stone_patt4_slab = createHalfSlab("stone_patt4_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT4.ordinal()], "pickaxe", 1);
		stone_patt4_slab_double = createDoubleSlab("stone_patt4_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT4.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt4_slab, "stone_patt4_slab", stone_patt4_slab_double, "stone_patt4_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_4, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT4.ordinal()]);
		stone_patt5_slab = createHalfSlab("stone_patt5_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT5.ordinal()], "pickaxe", 1);
		stone_patt5_slab_double = createDoubleSlab("stone_patt5_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT5.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt5_slab, "stone_patt5_slab", stone_patt5_slab_double, "stone_patt5_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_5, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT5.ordinal()]);
		stone_patt6_slab = createHalfSlab("stone_patt6_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT6.ordinal()], "pickaxe", 1);
		stone_patt6_slab_double = createDoubleSlab("stone_patt6_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT6.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt6_slab, "stone_patt6_slab", stone_patt6_slab_double, "stone_patt6_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_6, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT6.ordinal()]);
		stone_patt7_slab = createHalfSlab("stone_patt7_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT7.ordinal()], "pickaxe", 1);
		stone_patt7_slab_double = createDoubleSlab("stone_patt7_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT7.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt7_slab, "stone_patt7_slab", stone_patt7_slab_double, "stone_patt7_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_7, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT7.ordinal()]);
		stone_patt8_slab = createHalfSlab("stone_patt8_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT8.ordinal()], "pickaxe", 1);
		stone_patt8_slab_double = createDoubleSlab("stone_patt8_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT8.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt8_slab, "stone_patt8_slab", stone_patt8_slab_double, "stone_patt8_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_8, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT8.ordinal()]);
		stone_patt9_slab = createHalfSlab("stone_patt9_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT9.ordinal()], "pickaxe", 1);
		stone_patt9_slab_double = createDoubleSlab("stone_patt9_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT9.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt9_slab, "stone_patt9_slab", stone_patt9_slab_double, "stone_patt9_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_9, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT9.ordinal()]);
		stone_patt10_slab = createHalfSlab("stone_patt10_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT10.ordinal()], "pickaxe", 1);
		stone_patt10_slab_double = createDoubleSlab("stone_patt10_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT10.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt10_slab, "stone_patt10_slab", stone_patt10_slab_double, "stone_patt10_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_10, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT10.ordinal()]);
		stone_patt11_slab = createHalfSlab("stone_patt11_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT11.ordinal()], "pickaxe", 1);
		stone_patt11_slab_double = createDoubleSlab("stone_patt11_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT11.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt11_slab, "stone_patt11_slab", stone_patt11_slab_double, "stone_patt11_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_11, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT11.ordinal()]);
		stone_patt12_slab = createHalfSlab("stone_patt12_slab", Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT12.ordinal()], "pickaxe", 1);
		stone_patt12_slab_double = createDoubleSlab("stone_patt12_slab_double",  Material.ROCK, 2.0F, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT12.ordinal()], "pickaxe", 1);
		registerSlab(stone_patt12_slab, "stone_patt12_slab", stone_patt12_slab_double, "stone_patt12_slab_double", BlockType.BT_COBBLESTONE_SLAB, Slab_type.PATT_12, MpConfiguration.BlockEnable[ConfigInfo.SLABPATT12.ordinal()]);

	};
	public static void initClientOnly(){

		registerItem(acacia_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_ACACIA.ordinal()]);
		registerItem(birch_candelabra,		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_BIRCH.ordinal()]);
		registerItem(dark_oak_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_DARK_OAK.ordinal()]);
		registerItem(jungle_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_JUNGLE.ordinal()]);
		registerItem(oak_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_OAK.ordinal()]);
		registerItem(spruce_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_SPRUCE.ordinal()]);
		registerItem(gold_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_GOLD.ordinal()]);
		registerItem(iron_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_IRON.ordinal()]);
		// BaseMetal Candelabras
		if (Loader.isModLoaded("basemetals")) {
			try {
				//do stuff

				registerItem(adamantine_candelabra, MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_ADAMANTINE.ordinal()]);
				registerItem(aquarium_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_AQUARIUM.ordinal()]);
				registerItem(brass_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_BRASS.ordinal()]);
				registerItem(bronze_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_BRONZE.ordinal()]);
				registerItem(cold_iron_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_COLD_IRON.ordinal()]);
				registerItem(copper_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_COPPER.ordinal()]);
				registerItem(electrum_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_ELECTRUM.ordinal()]);
				registerItem(invar_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_INVAR.ordinal()]);
				registerItem(lead_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_LEAD.ordinal()]);
				registerItem(mithril_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_MITHRIL.ordinal()]);
				registerItem(nickel_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_NICKEL.ordinal()]);
				registerItem(silver_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_SILVER.ordinal()]);
				registerItem(star_steel_candelabra, MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_STAR_STEEL.ordinal()]);
				registerItem(steel_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_STEEL.ordinal()]);
				registerItem(tin_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_TIN.ordinal()]);
				registerItem(zinc_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_ZINC.ordinal()]);
				System.out.println("\nLoaded base metals\n");
			}
			catch (Exception e) {
				System.out.println("Could not load base metals");
				e.printStackTrace(System.err);
			}
		} 
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura candelabra
				registerItem(amaranth_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_AMARANTH.ordinal()]);
				registerItem(darkwood_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_DARKWOOD.ordinal()]);
				registerItem(eucalyptus_candelabra, MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_EUCALYPTUS.ordinal()]);
				registerItem(fusewood_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_FUSEWOOD.ordinal()]);
				registerItem(ghostwood_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_GHOSTWOOD.ordinal()]);
				registerItem(hopseed_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_HOPSEED.ordinal()]);
				registerItem(maple_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_MAPLE.ordinal()]);
				registerItem(redwood_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_REDWOOD.ordinal()]);
				registerItem(sakura_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_SAKURA.ordinal()]);
				registerItem(silverbell_candelabra, MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_SILVERBELL.ordinal()]);
				registerItem(tiger_candelabra, 		MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_TIGER.ordinal()]);
				registerItem(willow_candelabra, 	MpConfiguration.BlockEnable[ConfigInfo.CANDELABRA_WILLOW.ordinal()]);

				System.out.println("\nRegistered natura candelabras\n");
			}
			catch (Exception e) {
				System.out.println("Could not register natura candelabras");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		registerItem(acacia_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_ACACIA.ordinal()]);
		registerItem(birch_lamp,	MpConfiguration.BlockEnable[ConfigInfo.LAMP_BIRCH.ordinal()]);
		registerItem(dark_oak_lamp, MpConfiguration.BlockEnable[ConfigInfo.LAMP_DARK_OAK.ordinal()]);
		registerItem(jungle_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_JUNGLE.ordinal()]);
		registerItem(oak_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_OAK.ordinal()]);
		registerItem(spruce_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_SPRUCE.ordinal()]);
		registerItem(gold_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_GOLD.ordinal()]);
		registerItem(iron_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_IRON.ordinal()]);

		// BaseMetal Lamps
		if (Loader.isModLoaded("basemetals")) {
			try {
				//do stuff

				registerItem(adamantine_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_ADAMANTINE.ordinal()]);
				registerItem(aquarium_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_AQUARIUM.ordinal()]);
				registerItem(brass_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_BRASS.ordinal()]);
				registerItem(bronze_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_BRONZE.ordinal()]);
				registerItem(cold_iron_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_COLD_IRON.ordinal()]);
				registerItem(copper_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_COPPER.ordinal()]);
				registerItem(electrum_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_ELECTRUM.ordinal()]);
				registerItem(invar_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_INVAR.ordinal()]);
				registerItem(lead_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_LEAD.ordinal()]);
				registerItem(mithril_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_MITHRIL.ordinal()]);
				registerItem(nickel_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_NICKEL.ordinal()]);
				registerItem(silver_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_SILVER.ordinal()]);
				registerItem(star_steel_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_STAR_STEEL.ordinal()]);
				registerItem(steel_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_STEEL.ordinal()]);
				registerItem(tin_lamp, 			MpConfiguration.BlockEnable[ConfigInfo.LAMP_TIN.ordinal()]);
				registerItem(zinc_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_ZINC.ordinal()]);
				System.out.println("\nLoaded base metals\n");
			}
			catch (Exception e) {
				System.out.println("Could not load base metals");
				e.printStackTrace(System.err);
			}
		} 
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura candelabra
				registerItem(amaranth_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_AMARANTH.ordinal()]);
				registerItem(darkwood_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_DARKWOOD.ordinal()]);
				registerItem(eucalyptus_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_EUCALYPTUS.ordinal()]);
				registerItem(fusewood_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_FUSEWOOD.ordinal()]);
				registerItem(ghostwood_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_GHOSTWOOD.ordinal()]);
				registerItem(hopseed_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_HOPSEED.ordinal()]);
				registerItem(maple_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_MAPLE.ordinal()]);
				registerItem(redwood_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_REDWOOD.ordinal()]);
				registerItem(sakura_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_SAKURA.ordinal()]);
				registerItem(silverbell_lamp, 	MpConfiguration.BlockEnable[ConfigInfo.LAMP_SILVERBELL.ordinal()]);
				registerItem(tiger_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_TIGER.ordinal()]);
				registerItem(willow_lamp, 		MpConfiguration.BlockEnable[ConfigInfo.LAMP_WILLOW.ordinal()]);

				System.out.println("\nRegistered natura lamps\n");
			}
			catch (Exception e) {
				System.out.println("Could not register natura lamps");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		registerChair(acacia_chair, 		MpConfiguration.BlockEnable[ConfigInfo.CHAIR_ACACIA.ordinal()]);
		registerChair(birch_chair,		MpConfiguration.BlockEnable[ConfigInfo.CHAIR_BIRCH.ordinal()]);
		registerChair(dark_oak_chair, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_DARK_OAK.ordinal()]);
		registerChair(jungle_chair, 		MpConfiguration.BlockEnable[ConfigInfo.CHAIR_JUNGLE.ordinal()]);
		registerChair(oak_chair,		MpConfiguration.BlockEnable[ConfigInfo.CHAIR_OAK.ordinal()]);
		registerChair(spruce_chair,		MpConfiguration.BlockEnable[ConfigInfo.CHAIR_SPRUCE.ordinal()]);

		if (Loader.isModLoaded("natura")) {
			try {
				// Natura chair
				registerChair(amaranth_chair, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_AMARANTH.ordinal()]);
				registerChair(darkwood_chair, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_DARKWOOD.ordinal()]);
				registerChair(eucalyptus_chair, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_EUCALYPTUS.ordinal()]);
				registerChair(fusewood_chair, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_FUSEWOOD.ordinal()]);
				registerChair(ghostwood_chair, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_GHOSTWOOD.ordinal()]);
				registerChair(hopseed_chair, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_HOPSEED.ordinal()]);
				registerChair(maple_chair, 		MpConfiguration.BlockEnable[ConfigInfo.CHAIR_MAPLE.ordinal()]);
				registerChair(redwood_chair, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_REDWOOD.ordinal()]);
				registerChair(sakura_chair, 		MpConfiguration.BlockEnable[ConfigInfo.CHAIR_SAKURA.ordinal()]);
				registerChair(silverbell_chair, 	MpConfiguration.BlockEnable[ConfigInfo.CHAIR_SILVERBELL.ordinal()]);
				registerChair(tiger_chair, 		MpConfiguration.BlockEnable[ConfigInfo.CHAIR_TIGER.ordinal()]);
				registerChair(willow_chair, 		MpConfiguration.BlockEnable[ConfigInfo.CHAIR_WILLOW.ordinal()]);

				System.out.println("\nRegistered natura chairs\n");
			}
			catch (Exception e) {
				System.out.println("Could not register natura chairs");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		registerItem(acacia_table, 		MpConfiguration.BlockEnable[ConfigInfo.TABLE_ACACIA.ordinal()]);
		registerItem(birch_table,		MpConfiguration.BlockEnable[ConfigInfo.TABLE_BIRCH.ordinal()]);
		registerItem(dark_oak_table, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_DARK_OAK.ordinal()]);
		registerItem(jungle_table, 		MpConfiguration.BlockEnable[ConfigInfo.TABLE_JUNGLE.ordinal()]);
		registerItem(oak_table, 		MpConfiguration.BlockEnable[ConfigInfo.TABLE_OAK.ordinal()]);
		registerItem(spruce_table, 		MpConfiguration.BlockEnable[ConfigInfo.TABLE_SPRUCE.ordinal()]);
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura table
				registerItem(amaranth_table, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_AMARANTH.ordinal()]);
				registerItem(darkwood_table, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_DARKWOOD.ordinal()]);
				registerItem(eucalyptus_table, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_EUCALYPTUS.ordinal()]);
				registerItem(fusewood_table, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_FUSEWOOD.ordinal()]);
				registerItem(ghostwood_table, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_GHOSTWOOD.ordinal()]);
				registerItem(hopseed_table, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_HOPSEED.ordinal()]);
				registerItem(maple_table, 		MpConfiguration.BlockEnable[ConfigInfo.TABLE_MAPLE.ordinal()]);
				registerItem(redwood_table, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_REDWOOD.ordinal()]);
				registerItem(sakura_table, 		MpConfiguration.BlockEnable[ConfigInfo.TABLE_SAKURA.ordinal()]);
				registerItem(silverbell_table, 	MpConfiguration.BlockEnable[ConfigInfo.TABLE_SILVERBELL.ordinal()]);
				registerItem(tiger_table, 		MpConfiguration.BlockEnable[ConfigInfo.TABLE_TIGER.ordinal()]);
				registerItem(willow_table, 		MpConfiguration.BlockEnable[ConfigInfo.TABLE_WILLOW.ordinal()]);

				System.out.println("\nRegistered natura tables\n");
			}
			catch (Exception e) {
				System.out.println("Could not register natura tables");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		registerWedge(acacia_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_ACACIA.ordinal()]);
		registerWedge(birch_wedge,		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BIRCH.ordinal()]);
		registerWedge(dark_oak_wedge,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DARK_OAK.ordinal()]);
		registerWedge(jungle_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_JUNGLE.ordinal()]);
		registerWedge(oak_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_OAK.ordinal()]);
		registerWedge(spruce_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SPRUCE.ordinal()]);
		registerWedge(obsidian_wedge,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_OBSIDIAN.ordinal()]);
		registerWedge(quartz_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_QUARTZ.ordinal()]);
		registerWedge(stone_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_STONE.ordinal()]);
		registerWedge(stonebrick_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_STONEBRICK.ordinal()]);
		registerWedge(purpur_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PURPUR.ordinal()]);
		registerWedge(cobblestone_wedge, MpConfiguration.BlockEnable[ConfigInfo.WEDGE_COBBLESTONE.ordinal()]);
		registerWedge(p_granite_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_P_GRANITE.ordinal()]);
		registerWedge(p_andesite_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_P_ANDESITE.ordinal()]);
		registerWedge(p_diorite_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_P_DIORITE.ordinal()]);
		registerWedge(granite_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GRANITE.ordinal()]);
		registerWedge(andesite_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_ANDESITE.ordinal()]);
		registerWedge(diorite_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DIORITE.ordinal()]);
		registerWedge(sandstone_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SANDSTONE.ordinal()]);
		registerWedge(red_sandstone_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_RED_SANDSTONE.ordinal()]);
		registerWedge(nether_brick_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_NETHER_BRICK.ordinal()]);

		registerWedge(end_stone_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_END_STONE.ordinal()]);
		registerWedge(black_clay_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BLACK_CLAY.ordinal()]);
		registerWedge(blue_clay_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BLUE_CLAY.ordinal()]);
		registerWedge(brown_clay_wedge,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BROWN_CLAY.ordinal()]);
		registerWedge(cyan_clay_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_CYAN_CLAY.ordinal()]);
		registerWedge(gray_clay_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GRAY_CLAY.ordinal()]);
		registerWedge(green_clay_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GREEN_CLAY.ordinal()]);
		registerWedge(light_blue_clay_wedge, MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIGHT_BLUE_CLAY.ordinal()]);
		registerWedge(light_gray_clay_wedge, MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIGHT_GRAY_CLAY.ordinal()]);
		registerWedge(lime_clay_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIME_CLAY.ordinal()]);
		registerWedge(magenta_clay_wedge, MpConfiguration.BlockEnable[ConfigInfo.WEDGE_MAGENTA_CLAY.ordinal()]);
		registerWedge(orange_clay_wedge, MpConfiguration.BlockEnable[ConfigInfo.WEDGE_ORANGE_CLAY.ordinal()]);
		registerWedge(pink_clay_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PINK_CLAY.ordinal()]);
		registerWedge(purple_clay_wedge, MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PURPLE_CLAY.ordinal()]);
		registerWedge(red_clay_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_RED_CLAY.ordinal()]);
		registerWedge(white_clay_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_WHITE_CLAY.ordinal()]);
		registerWedge(yellow_clay_wedge, MpConfiguration.BlockEnable[ConfigInfo.WEDGE_YELLOW_CLAY.ordinal()]);
		registerWedge(dirt_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DIRT.ordinal()]);
		registerWedge(grass_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GRASS.ordinal()]);
		registerWedge(grass_path_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GRASS_PATH.ordinal()]);
		registerWedge(glass_wedge,	 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GLASS.ordinal()]);
		registerWedge(hay_wedge,		 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_HAY.ordinal()]);
		
		// mineralogy Pillars
		if (Loader.isModLoaded("mineralogy")) {
			try {
				//System.out.println("\nLoaded mineralogy\n");


				registerWedge(amphibolite_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_AMPHIBOLITE.ordinal()]);
				registerWedge(amphibolite_smooth_wedge,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_AMPHIBOLITE_SMOOTH.ordinal()]);
				registerWedge(m_andesite_wedge, 			MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_ANDESITE.ordinal()]);
				registerWedge(m_andesite_smooth_wedge,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_ANDESITE_SMOOTH.ordinal()]);
				registerWedge(basalt_wedge,			 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BASALT.ordinal()]);
				registerWedge(basalt_smooth_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_BASALT_SMOOTH.ordinal()]);
				registerWedge(chert_wedge, 				MpConfiguration.BlockEnable[ConfigInfo.WEDGE_CHERT.ordinal()]);
				registerWedge(conglomerate_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_CONGLOMERATE.ordinal()]);
				registerWedge(conglomerate_smooth_wedge, MpConfiguration.BlockEnable[ConfigInfo.WEDGE_CONGLOMERATE_SMOOTH.ordinal()]);
				registerWedge(m_diorite_wedge, 			MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_DIORITE.ordinal()]);
				registerWedge(m_diorite_smooth_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_DIORITE_SMOOTH.ordinal()]);
				registerWedge(dolomite_wedge, 			MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DOLOMITE.ordinal()]);
				registerWedge(dolomite_smooth_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DOLOMITE_SMOOTH.ordinal()]);
				registerWedge(gneiss_wedge, 				MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GNEISS.ordinal()]);
				registerWedge(gneiss_smooth_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GNEISS_SMOOTH.ordinal()]);
				registerWedge(m_granite_wedge, 			MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_GRANITE.ordinal()]);
				registerWedge(m_granite_smooth_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_M_GRANITE_SMOOTH.ordinal()]);
				registerWedge(limestone_wedge, 			MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIMESTONE.ordinal()]);
				registerWedge(limestone_smooth_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_LIMESTONE_SMOOTH.ordinal()]);
				registerWedge(pumice_wedge, 				MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PUMICE.ordinal()]);
				registerWedge(marble_wedge, 				MpConfiguration.BlockEnable[ConfigInfo.WEDGE_MARBLE.ordinal()]);
				registerWedge(marble_smooth_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_MARBLE_SMOOTH.ordinal()]);
				registerWedge(pegmatite_wedge, 			MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PEGMATITE.ordinal()]);
				registerWedge(pegmatite_smooth_wedge,	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PEGMATITE_SMOOTH.ordinal()]);
				registerWedge(phyllite_wedge, 			MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PHYLLITE.ordinal()]);
				registerWedge(phyllite_smooth_wedge,		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_PHYLLITE_SMOOTH.ordinal()]);
				registerWedge(rhyolite_wedge, 			MpConfiguration.BlockEnable[ConfigInfo.WEDGE_RHYOLITE.ordinal()]);
				registerWedge(rhyolite_smooth_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_RHYOLITE_SMOOTH.ordinal()]);
				registerWedge(schist_wedge, 				MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SCHIST.ordinal()]);
				registerWedge(schist_smooth_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SCHIST_SMOOTH.ordinal()]);
				registerWedge(shale_wedge, 				MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SHALE.ordinal()]);
				registerWedge(shale_smooth_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SHALE_SMOOTH.ordinal()]);
				registerWedge(slate_wedge, 				MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SLATE.ordinal()]);
				registerWedge(slate_smooth_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SLATE_SMOOTH.ordinal()]);
			}
			catch (Exception e) {
				System.out.println("Could not load mineralogy");
				e.printStackTrace(System.err);
			}
		}
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura wedge
				registerWedge(amaranth_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_AMARANTH.ordinal()]);
				registerWedge(darkwood_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_DARKWOOD.ordinal()]);
				registerWedge(eucalyptus_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_EUCALYPTUS.ordinal()]);
				registerWedge(fusewood_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_FUSEWOOD.ordinal()]);
				registerWedge(ghostwood_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GHOSTWOOD.ordinal()]);
				registerWedge(hopseed_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_HOPSEED.ordinal()]);
				registerWedge(maple_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_MAPLE.ordinal()]);
				registerWedge(redwood_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_REDWOOD.ordinal()]);
				registerWedge(sakura_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SAKURA.ordinal()]);
				registerWedge(silverbell_wedge, 	MpConfiguration.BlockEnable[ConfigInfo.WEDGE_SILVERBELL.ordinal()]);
				registerWedge(tiger_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_TIGER.ordinal()]);
				registerWedge(willow_wedge, 		MpConfiguration.BlockEnable[ConfigInfo.WEDGE_WILLOW.ordinal()]);

				System.out.println("\nRegistered natura wedges\n");
			}
			catch (Exception e) {
				System.out.println("Could not register natura wedges");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		registerItem(acacia_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_ACACIA.ordinal()]);
		registerItem(birch_pillar,		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BIRCH.ordinal()]);
		registerItem(dark_oak_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DARK_OAK.ordinal()]);
		registerItem(jungle_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_JUNGLE.ordinal()]);
		registerItem(oak_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_OAK.ordinal()]);
		registerItem(spruce_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SPRUCE.ordinal()]);
		registerItem(acacia_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_ACACIA.ordinal()]);
		registerItem(birch_log,			MpConfiguration.BlockEnable[ConfigInfo.LOG_BIRCH.ordinal()]);
		registerItem(dark_oak_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_DARK_OAK.ordinal()]);
		registerItem(jungle_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_JUNGLE.ordinal()]);
		registerItem(oak_log, 			MpConfiguration.BlockEnable[ConfigInfo.LOG_OAK.ordinal()]);
		registerItem(spruce_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_SPRUCE.ordinal()]);
		registerItem(obsidian_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_OBSIDIAN.ordinal()]);
		registerItem(quartz_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_QUARTZ.ordinal()]);
		registerItem(stone_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_STONE.ordinal()]);
		registerItem(stonebrick_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_STONEBRICK.ordinal()]);
		registerItem(purpur_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PURPUR.ordinal()]);
		registerItem(cobblestone_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_COBBLESTONE.ordinal()]);
		registerItem(p_granite_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_P_GRANITE.ordinal()]);
		registerItem(p_andesite_pillar,	 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_P_ANDESITE.ordinal()]);
		registerItem(p_diorite_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_P_DIORITE.ordinal()]);
		registerItem(granite_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GRANITE.ordinal()]);
		registerItem(andesite_pillar,	 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_ANDESITE.ordinal()]);
		registerItem(diorite_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DIORITE.ordinal()]);
		registerItem(sandstone_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SANDSTONE.ordinal()]);
		registerItem(red_sandstone_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_RED_SANDSTONE.ordinal()]);
		registerItem(nether_brick_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_NETHER_BRICK.ordinal()]);

		registerItem(end_stone_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_END_STONE.ordinal()]);
		registerItem(black_clay_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BLACK_CLAY.ordinal()]);
		registerItem(blue_clay_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BLUE_CLAY.ordinal()]);
		registerItem(brown_clay_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BROWN_CLAY.ordinal()]);
		registerItem(cyan_clay_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_CYAN_CLAY.ordinal()]);
		registerItem(gray_clay_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GRAY_CLAY.ordinal()]);
		registerItem(green_clay_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GREEN_CLAY.ordinal()]);
		registerItem(light_blue_clay_pillar, MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIGHT_BLUE_CLAY.ordinal()]);
		registerItem(light_gray_clay_pillar, MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIGHT_GRAY_CLAY.ordinal()]);
		registerItem(lime_clay_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIME_CLAY.ordinal()]);
		registerItem(magenta_clay_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_MAGENTA_CLAY.ordinal()]);
		registerItem(orange_clay_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_ORANGE_CLAY.ordinal()]);
		registerItem(pink_clay_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PINK_CLAY.ordinal()]);
		registerItem(purple_clay_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PURPLE_CLAY.ordinal()]);
		registerItem(red_clay_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_RED_CLAY.ordinal()]);
		registerItem(white_clay_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_WHITE_CLAY.ordinal()]);
		registerItem(yellow_clay_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_YELLOW_CLAY.ordinal()]);
		registerItem(glass_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GLASS.ordinal()]);

		// mineralogy Pillars
		if (Loader.isModLoaded("mineralogy")) {
			try {
				//System.out.println("\nLoaded mineralogy\n");


				registerItem(amphibolite_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_AMPHIBOLITE.ordinal()]);
				registerItem(amphibolite_smooth_pillar, MpConfiguration.BlockEnable[ConfigInfo.PILLAR_AMPHIBOLITE_SMOOTH.ordinal()]);
				registerItem(m_andesite_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_ANDESITE.ordinal()]);
				registerItem(m_andesite_smooth_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_ANDESITE_SMOOTH.ordinal()]);
				registerItem(basalt_pillar,				MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BASALT.ordinal()]);
				registerItem(basalt_smooth_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_BASALT_SMOOTH.ordinal()]);
				registerItem(chert_pillar, 				MpConfiguration.BlockEnable[ConfigInfo.PILLAR_CHERT.ordinal()]);
				registerItem(conglomerate_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_CONGLOMERATE.ordinal()]);
				registerItem(conglomerate_smooth_pillar, MpConfiguration.BlockEnable[ConfigInfo.PILLAR_CONGLOMERATE_SMOOTH.ordinal()]);
				registerItem(m_diorite_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_DIORITE.ordinal()]);
				registerItem(m_diorite_smooth_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_DIORITE_SMOOTH.ordinal()]);
				registerItem(dolomite_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DOLOMITE.ordinal()]);
				registerItem(dolomite_smooth_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DOLOMITE_SMOOTH.ordinal()]);
				registerItem(gneiss_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GNEISS.ordinal()]);
				registerItem(gneiss_smooth_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GNEISS_SMOOTH.ordinal()]);
				registerItem(m_granite_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_GRANITE.ordinal()]);
				registerItem(m_granite_smooth_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_M_GRANITE_SMOOTH.ordinal()]);
				registerItem(limestone_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIMESTONE.ordinal()]);
				registerItem(limestone_smooth_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_LIMESTONE_SMOOTH.ordinal()]);
				registerItem(marble_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_MARBLE.ordinal()]);
				registerItem(marble_smooth_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_MARBLE_SMOOTH.ordinal()]);
				registerItem(pumice_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PUMICE.ordinal()]);
				registerItem(pegmatite_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PEGMATITE.ordinal()]);
				registerItem(pegmatite_smooth_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PEGMATITE_SMOOTH.ordinal()]);
				registerItem(phyllite_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PHYLLITE.ordinal()]);
				registerItem(phyllite_smooth_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_PHYLLITE_SMOOTH.ordinal()]);
				registerItem(rhyolite_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_RHYOLITE.ordinal()]);
				registerItem(rhyolite_smooth_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_RHYOLITE_SMOOTH.ordinal()]);
				registerItem(schist_pillar, 			MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SCHIST.ordinal()]);
				registerItem(schist_smooth_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SCHIST_SMOOTH.ordinal()]);
				registerItem(shale_pillar, 				MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SHALE.ordinal()]);
				registerItem(shale_smooth_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SHALE_SMOOTH.ordinal()]);
				registerItem(slate_pillar, 				MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SLATE.ordinal()]);
				registerItem(slate_smooth_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SLATE_SMOOTH.ordinal()]);
			}
			catch (Exception e) {
				System.out.println("Could not load mineralogy");
				e.printStackTrace(System.err);
			}
		} 
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura pillar
				registerItem(amaranth_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_AMARANTH.ordinal()]);
				registerItem(darkwood_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_DARKWOOD.ordinal()]);
				registerItem(eucalyptus_pillar, MpConfiguration.BlockEnable[ConfigInfo.PILLAR_EUCALYPTUS.ordinal()]);
				registerItem(fusewood_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_FUSEWOOD.ordinal()]);
				registerItem(ghostwood_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_GHOSTWOOD.ordinal()]);
				registerItem(hopseed_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_HOPSEED.ordinal()]);
				registerItem(maple_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_MAPLE.ordinal()]);
				registerItem(redwood_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_REDWOOD.ordinal()]);
				registerItem(sakura_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SAKURA.ordinal()]);
				registerItem(silverbell_pillar, MpConfiguration.BlockEnable[ConfigInfo.PILLAR_SILVERBELL.ordinal()]);
				registerItem(tiger_pillar, 		MpConfiguration.BlockEnable[ConfigInfo.PILLAR_TIGER.ordinal()]);
				registerItem(willow_pillar, 	MpConfiguration.BlockEnable[ConfigInfo.PILLAR_WILLOW.ordinal()]);
				// Natura logs
				registerItem(amaranth_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_AMARANTH.ordinal()]);
				registerItem(darkwood_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_DARKWOOD.ordinal()]);
				registerItem(eucalyptus_log,	MpConfiguration.BlockEnable[ConfigInfo.LOG_EUCALYPTUS.ordinal()]);
				registerItem(fusewood_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_FUSEWOOD.ordinal()]);
				registerItem(ghostwood_log, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_GHOSTWOOD.ordinal()]);
				registerItem(hopseed_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_HOPSEED.ordinal()]);
				registerItem(maple_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_MAPLE.ordinal()]);
				registerItem(redwood_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_REDWOOD.ordinal()]);
				registerItem(sakura_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_SAKURA.ordinal()]);
				registerItem(silverbell_log, 	MpConfiguration.BlockEnable[ConfigInfo.LOG_SILVERBELL.ordinal()]);
				registerItem(tiger_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_TIGER.ordinal()]);
				registerItem(willow_log, 		MpConfiguration.BlockEnable[ConfigInfo.LOG_WILLOW.ordinal()]);

				System.out.println("\nRegistered natura pillars\n");
			}
			catch (Exception e) {
				System.out.println("Could not register natura pillars");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}

		//registerItem(rainbow_slab, true);
		//registerItem(rainbow_slab_double, true);
		registerSlab(stone_patt1_slab, 			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT1.ordinal()]);
		registerSlab(stone_patt1_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT1.ordinal()]);
		registerSlab(stone_patt2_slab, 			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT2.ordinal()]);
		registerSlab(stone_patt2_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT2.ordinal()]);
		registerSlab(stone_patt3_slab, 			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT3.ordinal()]);
		registerSlab(stone_patt3_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT3.ordinal()]);
		registerSlab(stone_patt4_slab, 			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT4.ordinal()]);
		registerSlab(stone_patt4_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT4.ordinal()]);
		registerSlab(stone_patt5_slab, 			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT5.ordinal()]);
		registerSlab(stone_patt5_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT5.ordinal()]);
		registerSlab(stone_patt6_slab, 			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT6.ordinal()]);
		registerSlab(stone_patt6_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT6.ordinal()]);
		registerSlab(stone_patt7_slab, 			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT7.ordinal()]);
		registerSlab(stone_patt7_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT7.ordinal()]);
		registerSlab(stone_patt8_slab, 			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT8.ordinal()]);
		registerSlab(stone_patt8_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT8.ordinal()]);
		registerSlab(stone_patt9_slab, 			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT9.ordinal()]);
		registerSlab(stone_patt9_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT9.ordinal()]);
		registerSlab(stone_patt10_slab, 		MpConfiguration.BlockEnable[ConfigInfo.SLABPATT10.ordinal()]);
		registerSlab(stone_patt10_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT10.ordinal()]);
		registerSlab(stone_patt11_slab,			MpConfiguration.BlockEnable[ConfigInfo.SLABPATT11.ordinal()]);
		registerSlab(stone_patt11_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT11.ordinal()]);
		registerSlab(stone_patt12_slab, 		MpConfiguration.BlockEnable[ConfigInfo.SLABPATT12.ordinal()]);
		registerSlab(stone_patt12_slab_double, 	MpConfiguration.BlockEnable[ConfigInfo.SLABPATT12.ordinal()]);

		/*
		registerItem(rainbow_stairs, true);
		registerItem(rainbow_candelabra, true);
		registerItem(rainbow_lamp, true);
		registerItem(rainbow_chair, true);
		registerItem(rainbow_pillar, true);
		registerItem(rainbow_table, true);
		registerItem(rainbow_wedge, true);
		registerItem(rainbow_stairs, true);
		 */
		if( MpConfiguration.BlockEnable[ConfigInfo.WEDGE_GRASS.ordinal()] == true){
			// only register color handler if grass wedge is in use
			ModColorManager.registerColourHandlers();
		}

	}

	public static BlockCandelabra createCandelabra(String name, BlockType ingredientA, Material mType, Boolean enabled){

		BlockCandelabra candelabra = null;
		if(enabled) {
			candelabra = (BlockCandelabra)(new BlockCandelabra(mType).setUnlocalizedName(name));
			GameRegistry.register(candelabra.setRegistryName(name));
			//GameRegistry.registerBlock(candelabra, name);
			GameRegistry.register(new ItemBlock(candelabra).setRegistryName(candelabra.getRegistryName()));

			//OreDictionary.registerOre(candelabra.getOredictName(),candelabra);
			//OreDictionary.registerOre("candelabra",candelabra); //generic
			if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) { // can't enable recipe if no spindle

				GameRegistry.addRecipe(new ItemStack(candelabra, 2),
						"G G",
						"TWT",
						"SSS",
						'W', BlockInfo.blockType2Stack(ingredientA),
						'G', BlockInfo.blockType2Stack(BlockType.BT_GLASS_PANE),
						'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE),
						'T', BlockInfo.blockType2Stack(BlockType.BT_TORCH)
						);
			}
		}
		return candelabra;
	};
	public static BlockLamp createLamp(String name, BlockType ingredientA, Material mType, Boolean enabled){

		BlockLamp lamp = null;
		if(enabled) {
			lamp = (BlockLamp)(new BlockLamp(mType).setUnlocalizedName(name));
			GameRegistry.register(lamp.setRegistryName(name));
			GameRegistry.register(new ItemBlock(lamp).setRegistryName(lamp.getRegistryName()));


			if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) { // can't enable recipe if no spindle

				GameRegistry.addRecipe(new ItemStack(lamp, 2),
						"GTG",
						" S ",
						" W ",
						'W', BlockInfo.blockType2Stack(ingredientA),
						'G', BlockInfo.blockType2Stack(BlockType.BT_GLASS_PANE),
						'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE),
						'T', BlockInfo.blockType2Stack(BlockType.BT_TORCH)
						);
			}
		}
		return lamp;
	};

	public static BlockPillar createPillar(String name, BlockType ingredientA, Material mType, Float mHardness, Boolean enabled, String mHarvest, int harvestLevel){

		BlockPillar pillar = null;
		if(enabled) {


			pillar = (BlockPillar)new BlockPillar(mType, mHardness, mHarvest, harvestLevel).setUnlocalizedName(name);
			GameRegistry.register(pillar.setRegistryName(name));
			GameRegistry.register(new ItemBlock(pillar).setRegistryName(pillar.getRegistryName()));

			GameRegistry.addRecipe(new ItemStack(pillar, 3),
					" A ",
					" A ",
					" A ",
					'A', BlockInfo.blockType2Stack(ingredientA)
					);
		}
		return pillar;
	}
	public static MpBlockStairs createStairs(String name, BlockType ingredientA, Float mHardness, Boolean enabled, String mHarvest, int harvestLevel){

		MpBlockStairs stairs = null;
		if(enabled) {


			stairs = (MpBlockStairs)(new MpBlockStairs(mHardness, mHarvest, harvestLevel).setUnlocalizedName(name));
			GameRegistry.register(stairs.setRegistryName(name));
			GameRegistry.register(new ItemBlock(stairs).setRegistryName(stairs.getRegistryName()));

			GameRegistry.addRecipe(new ItemStack(stairs, 3),
					"A  ",
					"AA ",
					"AAA",
					'A', BlockInfo.blockType2Stack(ingredientA)
					);
		}
		return stairs;
	}


	public static BlockChair createChair(String name, BlockType ingredientA, Material mType, Boolean enabled){
		
		BlockChair chair = null;
		chair = (BlockChair) new BlockChair(mType, EnumChairTypes.SPINDLE).setUnlocalizedName(name);
		chair.setRegistryName(name);
		GameRegistry.register(chair);
		
		System.out.println("creating chair: " + name);
		
		ItemBlockChair itemChair = (ItemBlockChair) new ItemBlockChair((Block) chair);
		itemChair.setRegistryName(chair.getRegistryName());
		
		GameRegistry.register(itemChair);

		
		if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) {
			GameRegistry.addRecipe(new ItemStack(chair, 2, 0),
					"  S",
					" AA",
					" SS",
					'A', BlockInfo.blockType2Stack(ingredientA),
					'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE)
					);
		}
		if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) {
			GameRegistry.addRecipe(new ItemStack(chair, 2, EnumChairTypes.STRAIGHT.getMeta()),
					"  S",
					" AA",
					" SS",
					'A', BlockInfo.blockType2Stack(ingredientA),
					'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_FLAT_SPINDLE)
					);
		}
		if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) {
			GameRegistry.addRecipe(new ItemStack(chair, 2, EnumChairTypes.TALL.getMeta()),
					"  S",
					" AA",
					" SS",
					'A', BlockInfo.blockType2Stack(ingredientA),
					'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_TALL_SPINDLE)
					);
		}
		if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) {
			GameRegistry.addRecipe(new ItemStack(chair, 2, EnumChairTypes.ADIRONDACK.getMeta()),
					"  S",
					" AA",
					" SS",
					'A', BlockInfo.blockType2Stack(ingredientA),
					'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_BENT_SPINDLE)
					);
		}
		return chair;
	}


	public static BlockTable createTable(String name, BlockType ingredientA, Material mType, Boolean enabled){

		BlockTable table = null;
		if(enabled) {
			if(enabled) {

				table = (BlockTable)(new BlockTable(mType).setUnlocalizedName(name));
				table = (BlockTable)(new BlockTable(mType).setUnlocalizedName(name));
				GameRegistry.register(table.setRegistryName(name));
				GameRegistry.register(new ItemBlock(table).setRegistryName(table.getRegistryName()));

				if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) {
					GameRegistry.addRecipe(new ItemStack(table, 2),
							"AAA",
							"S S",
							"S S",
							'A', BlockInfo.blockType2Stack(ingredientA),
							'S', BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE)
							);

				}
			}

		}
		return table;
	};
	public static BlockWedge createWedge(String name, BlockType ingredientA, Material mType, Float mHardness, Boolean enabled, String mHarvest, int harvestLevel){

		BlockWedge wedge = null;
		if(enabled) {


			// each instance of your block should have a name that is unique within your mod.  use lower case.
			wedge = (BlockWedge)(new BlockWedge(mType, mHardness, mHarvest, harvestLevel).setUnlocalizedName(name));
			GameRegistry.register(wedge.setRegistryName(name));
			GameRegistry.register(new ItemBlock(wedge).setRegistryName(wedge.getRegistryName()));

			GameRegistry.addRecipe(new ItemStack(wedge, MpConfiguration.ConfigValue[ConfigInfo.WEDGE_QTY.ordinal()]),
					"   ",
					"A  ",
					"AA ",
					'A', BlockInfo.blockType2Stack(ingredientA)
					);
		}
		return wedge;
	}

	public static MpBlockSlab_half createHalfSlab(String name, Material mType, Float mHardness, Boolean enabled, String mHarvest, int harvestLevel){

		MpBlockSlab_half slab = null;

		if(enabled) {
			slab = (MpBlockSlab_half)(new MpBlockSlab_half(mType, mHardness, mHarvest, harvestLevel).setUnlocalizedName(name));
			// Slab is registered with double slab in separate function.
		}
		return slab;
	}
	public static MpBlockSlab_double createDoubleSlab(String name, Material mType, Float mHardness, Boolean enabled, String mHarvest, int harvestLevel){

		MpBlockSlab_double slab = null;

		if(enabled) {
			slab = (MpBlockSlab_double)(new MpBlockSlab_double(mType, mHardness, mHarvest, harvestLevel).setUnlocalizedName(name));
			// Slab is registered with half slab in separate function.

		}
		return slab;
	};	
	public static void registerSlab(MpBlockSlab_half slab_half, String name_half, MpBlockSlab_double slab_double, String name_double, BlockType ingredientA, Slab_type sType, boolean enabled){

		if(enabled) {
			//System.out.println("register slab:" + name_half + " : " + name_double);;

			GameRegistry.register(slab_half.setRegistryName(name_half));
			//GameRegistry.registerBlock(slab_half, ItemBlockSlab.class, name_half, slab_half, slab_double,false);

			GameRegistry.register(new ItemSlab(slab_half, slab_half, slab_double).setRegistryName(name_half));
			//GameRegistry.registerBlock(slab_double, ItemBlockSlab.class , name_double, slab_half, slab_double,true);
			GameRegistry.register(slab_double.setRegistryName(name_double));
			
			OreDictionary.registerOre(slab_half.getOredictName(),slab_half);
			switch(sType){
			case PATT_1:
				GameRegistry.addRecipe(new ItemStack(slab_half, 4),
						"AA ",
						"AA ",
						"   ",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);

				break;
			case PATT_10:
				GameRegistry.addRecipe(new ItemStack(slab_half, 4),
						"A A",
						"A A",
						"   ",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_11:
				GameRegistry.addRecipe(new ItemStack(slab_half, 6),
						"A A",
						"A A",
						"A A",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_12:
				GameRegistry.addRecipe(new ItemStack(slab_half, 4),
						"AA ",
						"   ",
						"AA ",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_2:
				GameRegistry.addRecipe(new ItemStack(slab_half, 6),
						"A A",
						"AAA",
						" A ",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_3:
				GameRegistry.addRecipe(new ItemStack(slab_half, 5),
						" A ",
						"AAA",
						" A ",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_4:
				GameRegistry.addRecipe(new ItemStack(slab_half, 5),
						"A A",
						" A ",
						"A A",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_5:
				GameRegistry.addRecipe(new ItemStack(slab_half, 4),
						"A A",
						"   ",
						"A A",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_6:
				GameRegistry.addRecipe(new ItemStack(slab_half, 8),
						"AAA",
						"A A",
						"AAA",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_7:
				GameRegistry.addRecipe(new ItemStack(slab_half, 6),
						"AAA",
						"   ",
						"AAA",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_8:
				GameRegistry.addRecipe(new ItemStack(slab_half, 6),
						"AA ",
						" AA",
						"AA ",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_9:
				GameRegistry.addRecipe(new ItemStack(slab_half, 6),
						"   ",
						"AAA",
						"A A",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			case PATT_NORM:
			default:
				GameRegistry.addRecipe(new ItemStack(slab_half, 6),
						"   ",
						"   ",
						"AAA",
						'A', BlockInfo.blockType2Stack(ingredientA)
						);
				break;
			}
			;

		}

	}

	public static MpBlockSlab_double createSlabDouble(String name, BlockType ingredientA, Material mType, Float mHardness, Boolean enabled, String mHarvest, int harvestLevel){

		MpBlockSlab_double slab = null;
		if(enabled) {

			//System.out.println("register double item" + name);;

			slab = (MpBlockSlab_double)(new MpBlockSlab_double(mType, mHardness, mHarvest, harvestLevel).setUnlocalizedName(name));
			
		}
		return slab;
	}


	public static void registerItem(MpBlock block, Boolean enabled){
		final int DEFAULT_ITEM_SUBTYPE = 0;
		if(enabled) { 
			String name = block.getUnlocalizedName().substring(5);
			//System.out.println("register item " + name);
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("missing_pieces:"+name, "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

			ItemStack stack = new ItemStack(block,1,0);
			OreDictionary.registerOre(block.getOredictName(), stack);

		}
	}

	public static void registerChair(BlockChair chair_block, Boolean enabled){
		final int DEFAULT_ITEM_SUBTYPE = 0;
		String name = chair_block.getUnlocalizedName().substring(5);

		System.out.println("register item " + name);

		ItemStack itemStack = null;
		Boolean spindleEnabled = false;
		String chairName = name;
		
		for( EnumChairTypes chairType: EnumChairTypes.values()){
			chairName = name;

			if(enabled) {

				switch( chairType){
				default:
				case SPINDLE:
					if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) {
						spindleEnabled = true;
						itemStack = BlockInfo.blockType2Stack(BlockType.BT_ITEM_SPINDLE);
						//name += "." + EnumChairTypes.SPINDLE.getName();  // don't use name for this one for backward compatibility with non-variant chairs.
					}
					break;
				case ADIRONDACK:
					if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) {
						spindleEnabled = true;
						itemStack = BlockInfo.blockType2Stack(BlockType.BT_ITEM_BENT_SPINDLE);
						chairName = name + "_" + EnumChairTypes.ADIRONDACK.getName();
					}
					break;
				case TALL:
					if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) {
						spindleEnabled = true;
						itemStack = BlockInfo.blockType2Stack(BlockType.BT_ITEM_TALL_SPINDLE);
						chairName = name + "_" +  EnumChairTypes.TALL.getName();
					}
					break;
				case STRAIGHT:
					if( MpConfiguration.BlockEnable[ConfigInfo.MISC_SPINDLE.ordinal()] ==true) {
						spindleEnabled = true;
						itemStack = BlockInfo.blockType2Stack(BlockType.BT_ITEM_FLAT_SPINDLE);
						chairName = name + "_" + EnumChairTypes.STRAIGHT.getName();
					}
					break;
				}
				if( spindleEnabled == true){
					ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("missing_pieces:"+name, "facing=north,type="+chairType.getName()); 
					System.out.println("item location:" + itemModelResourceLocation.toString());
					//System.out.println("ID:" + Item.getIdFromItem(Item.getItemFromBlock(blockChair)));
					Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(chair_block), chairType.getMeta(), itemModelResourceLocation);

				}
			}
		}
	}

	public static void registerWedge(BlockWedge block, Boolean enabled){
		final int DEFAULT_ITEM_SUBTYPE = 0;
		if(enabled) { 
			String name = block.getUnlocalizedName().substring(5);
			//System.out.println("register item " + name);

			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("missing_pieces:"+name, "inventory");
			//GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

			ItemStack stack = new ItemStack(block,1,0);
			OreDictionary.registerOre(block.getOredictName(), stack);

		}
	}

	public static void registerSlab(MpBlockSlab block, Boolean enabled){
		final int DEFAULT_ITEM_SUBTYPE = 0;
		if(enabled) { 
			String name = block.getUnlocalizedName().substring(5);
			//System.out.println("register item " + name);

			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("missing_pieces:"+name, "inventory");
			//GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

			//ItemStack stack = new ItemStack(block,1,2);
			//OreDictionary.registerOre(block.getOredictName(), stack);

		}
	}

}
