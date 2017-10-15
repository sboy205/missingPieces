package com.sb205.missing_pieces;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MissingPieces.MODID, 
			 version = MissingPieces.VERSION, 
			 name=MissingPieces.NAME, 
			 dependencies = "after:natura", //after:basemetals;after:mineralogy
			 guiFactory= MissingPieces.GUIFACTORY)

public class MissingPieces
{
    public static final String MODID = "missing_pieces";
    public static final String NAME = "Missing Pieces";
    public static final String VERSION = "4.3.0";
    public static final String GUIFACTORY = "com.sb205.missing_pieces.Config.MpGuiFactory"; 

    // The instance of your mod that Forge uses.  Optional.
    @Mod.Instance(MissingPieces.MODID)
    public static MissingPieces instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="com.sb205.missing_pieces.ClientOnlyProxy", serverSide="com.sb205.missing_pieces.DedicatedServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
      proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println(MissingPieces.MODID + " Is Rendering");
		Block mapleBlock = GameRegistry.findRegistry(Block.class).getValue( new ResourceLocation("natura:overworld_planks"));
		if (mapleBlock == null){
			System.out.println("no maple block");
		}
		System.out.println("init mapleBlock: "+ mapleBlock.toString());

      proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
      proxy.postInit();
		Block mapleBlock = GameRegistry.findRegistry(Block.class).getValue( new ResourceLocation("natura:overworld_planks"));
		if (mapleBlock == null){
			System.out.println("no maple block");
		}
		System.out.println("post mapleBlock: "+ mapleBlock.toString());

    }

    /**
     * Prepend the name with the mod ID, suitable for ResourceLocations such as textures.
     * @param name
     * @return eg "missing_pieces:myblockname"
     */
    public static String prependModID(String name) {return MODID + ":" + name;}
}
