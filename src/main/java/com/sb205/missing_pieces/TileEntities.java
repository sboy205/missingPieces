package com.sb205.missing_pieces;

import com.sb205.missing_pieces.Config.MpConfiguration;
import com.sb205.missing_pieces.Config.MpConfiguration.ConfigInfo;
import com.sb205.missing_pieces.Shelf.GuiHandlerShelf;
import com.sb205.missing_pieces.Shelf.TileEntityShelf;
import com.sb205.missing_pieces.Shelf.TileEntitySpecialRendererShelf;
import com.sb205.missing_pieces.Shelf.BlockShelf;
import com.sb205.missing_pieces.Utilities.BlockInfo;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class TileEntities {
	public static BlockShelf acaciaShelf;
	public static BlockShelf birchShelf;
	public static BlockShelf darkOakShelf;
	public static BlockShelf jungleShelf;
	public static BlockShelf oakShelf;  // this holds the unique instance of your block
	public static BlockShelf spruceShelf;
	
	public static BlockShelf amaranthShelf;
	public static BlockShelf darkwoodShelf;
	public static BlockShelf eucalyptusShelf;
	public static BlockShelf fusewoodShelf;
	public static BlockShelf ghostwoodShelf;
	public static BlockShelf hopseedShelf;
	public static BlockShelf mapleShelf;
	public static BlockShelf redwoodShelf;
	public static BlockShelf sakuraShelf;
	public static BlockShelf silverbellShelf;
	public static BlockShelf tigerShelf;
	public static BlockShelf willowShelf;

	
	public static void preInitCommon()
	{
		acaciaShelf = 	createShelf("acacia_shelf", 	BlockType.BT_PLANK_ACACIA, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_ACACIA.ordinal()]);
		birchShelf = 	createShelf("birch_shelf", 		BlockType.BT_PLANK_BIRCH, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_BIRCH.ordinal()]);
		darkOakShelf = 	createShelf("dark_oak_shelf", 	BlockType.BT_PLANK_DARK_OAK, Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_DARK_OAK.ordinal()]);
		jungleShelf = 	createShelf("jungle_shelf", 	BlockType.BT_PLANK_JUNGLE, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_JUNGLE.ordinal()]);
		oakShelf = 		createShelf("oak_shelf", 		BlockType.BT_PLANK_OAK, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_OAK.ordinal()]);
		spruceShelf = 	createShelf("spruce_shelf",		BlockType.BT_PLANK_SPRUCE, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_SPRUCE.ordinal()]);
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura shelves
				amaranthShelf = 	createShelf("amaranth_shelf",	BlockType.BT_PLANK_AMARANTH, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_AMARANTH.ordinal()]);
				darkwoodShelf = 	createShelf("darkwood_shelf",	BlockType.BT_PLANK_DARKWOOD, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_DARKWOOD.ordinal()]);
				eucalyptusShelf = 	createShelf("eucalyptus_shelf",	BlockType.BT_PLANK_EUCALYPTUS, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_EUCALYPTUS.ordinal()]);
				fusewoodShelf = 	createShelf("fusewood_shelf",	BlockType.BT_PLANK_FUSEWOOD, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_FUSEWOOD.ordinal()]);
				ghostwoodShelf = 	createShelf("ghostwood_shelf",	BlockType.BT_PLANK_GHOSTWOOD, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_GHOSTWOOD.ordinal()]);
				hopseedShelf = 	createShelf("hopseed_shelf",		BlockType.BT_PLANK_HOPSEED, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_HOPSEED.ordinal()]);
				mapleShelf = 	createShelf("maple_shelf",			BlockType.BT_PLANK_MAPLE, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_MAPLE.ordinal()]);
				redwoodShelf = 	createShelf("redwood_shelf",		BlockType.BT_PLANK_REDWOOD, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_REDWOOD.ordinal()]);
				sakuraShelf = 	createShelf("sakura_shelf",			BlockType.BT_PLANK_SAKURA, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_SAKURA.ordinal()]);
				silverbellShelf = 	createShelf("silverbell_shelf",	BlockType.BT_PLANK_SILVERBELL, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_SILVERBELL.ordinal()]);
				tigerShelf = 	createShelf("tiger_shelf",			BlockType.BT_PLANK_TIGER, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_TIGER.ordinal()]);
				willowShelf = 	createShelf("willow_shelf",			BlockType.BT_PLANK_WILLOW, 	Material.WOOD, 0.8F, MpConfiguration.BlockEnable[ConfigInfo.SHELF_WILLOW.ordinal()]);

				System.out.println("\nLoaded natura shelves\n");
			}
			catch (Exception e) {
				System.out.println("Could not load natura shelves");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}


	}

	public static void initCommon()
	{
	}

	public static void postInitCommon()
	{
	}

	public static void preInitClientOnly()
	{
	}
	
	@SideOnly(Side.CLIENT)
	public static void initClientOnly()
	{

		registerShelf(acaciaShelf,"acacia_shelf", MpConfiguration.BlockEnable[ConfigInfo.SHELF_ACACIA.ordinal()]);
		registerShelf(birchShelf,"birch_shelf", MpConfiguration.BlockEnable[ConfigInfo.SHELF_BIRCH.ordinal()]);
		registerShelf(darkOakShelf,"dark_oak_shelf", MpConfiguration.BlockEnable[ConfigInfo.SHELF_DARK_OAK.ordinal()]);
		registerShelf(jungleShelf,"jungle_shelf", MpConfiguration.BlockEnable[ConfigInfo.SHELF_JUNGLE.ordinal()]);
		registerShelf(oakShelf,"oak_shelf", MpConfiguration.BlockEnable[ConfigInfo.SHELF_OAK.ordinal()]);
		registerShelf(spruceShelf,"spruce_shelf", MpConfiguration.BlockEnable[ConfigInfo.SHELF_SPRUCE.ordinal()]);
		if (Loader.isModLoaded("natura")) {
			try {
				// Natura shelves
				registerShelf(amaranthShelf,"amaranth_shelf",	MpConfiguration.BlockEnable[ConfigInfo.SHELF_AMARANTH.ordinal()]);
				registerShelf(darkwoodShelf,"darkwood_shelf",	MpConfiguration.BlockEnable[ConfigInfo.SHELF_DARKWOOD.ordinal()]);
				registerShelf(eucalyptusShelf,"eucalyptus_shelf",MpConfiguration.BlockEnable[ConfigInfo.SHELF_EUCALYPTUS.ordinal()]);
				registerShelf(fusewoodShelf,"fusewood_shelf",	MpConfiguration.BlockEnable[ConfigInfo.SHELF_FUSEWOOD.ordinal()]);
				registerShelf(ghostwoodShelf,"ghostwood_shelf",MpConfiguration.BlockEnable[ConfigInfo.SHELF_GHOSTWOOD.ordinal()]);
				registerShelf(hopseedShelf,"hopseed_shelf",	 MpConfiguration.BlockEnable[ConfigInfo.SHELF_HOPSEED.ordinal()]);
				registerShelf(mapleShelf,"maple_shelf",	MpConfiguration.BlockEnable[ConfigInfo.SHELF_MAPLE.ordinal()]);
				registerShelf(redwoodShelf,"redwood_shelf",	MpConfiguration.BlockEnable[ConfigInfo.SHELF_REDWOOD.ordinal()]);
				registerShelf(sakuraShelf,"sakura_shelf",	MpConfiguration.BlockEnable[ConfigInfo.SHELF_SAKURA.ordinal()]);
				registerShelf(silverbellShelf,"silverbell_shelf",MpConfiguration.BlockEnable[ConfigInfo.SHELF_SILVERBELL.ordinal()]);
				registerShelf(tigerShelf,"tiger_shelf",	 MpConfiguration.BlockEnable[ConfigInfo.SHELF_TIGER.ordinal()]);
				registerShelf(willowShelf,"willow_shelf",	 MpConfiguration.BlockEnable[ConfigInfo.SHELF_WILLOW.ordinal()]);

				System.out.println("\nLoaded natura shelves\n");
			}
			catch (Exception e) {
				System.out.println("Could not load natura shelves");
				e.printStackTrace(System.err);
			}
		} else {
			System.out.println("\nNo Natura\n");
		}
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShelf.class, new TileEntitySpecialRendererShelf());

	}

	public static void postInitClientOnly()
	{
	}
	
	
	private static BlockShelf createShelf(String name, BlockType ingredientA, Material mType, Float hardness, Boolean enabled) {
		  BlockShelf blockShelf = null;
		  
		  if(enabled) {

			    blockShelf = (BlockShelf)(new BlockShelf(mType, hardness).setUnlocalizedName(name));
			    GameRegistry.register(blockShelf.setRegistryName(name));
				GameRegistry.register(new ItemBlock(blockShelf).setRegistryName(blockShelf.getRegistryName()));

				GameRegistry.registerTileEntity(TileEntityShelf.class, name);
			
				GameRegistry.addRecipe(new ItemStack(blockShelf, 3),
		        	" A ",
		        	"ABA",
		        	" A ",
		        	'A', BlockInfo.blockType2Stack(ingredientA),
		        	'B', BlockInfo.blockType2Stack(BlockType.BT_CHEST)
		    );
		  }

		  NetworkRegistry.INSTANCE.registerGuiHandler(MissingPieces.instance, GuiHandlerRegistry.getInstance());
		  GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerShelf(), GuiHandlerShelf.getGuiID());
		  return blockShelf;

	}
	
	private static void registerShelf(BlockShelf block, String name, boolean enabled){
		final int DEFAULT_ITEM_SUBTYPE = 0;
		if(enabled) { 

			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("missing_pieces:"+name, "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
			
			ItemStack stack = new ItemStack(block,1,0);
			OreDictionary.registerOre(block.getOredictName(), stack);

		}

	}

}
