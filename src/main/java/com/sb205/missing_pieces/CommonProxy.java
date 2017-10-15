package com.sb205.missing_pieces;



import com.sb205.missing_pieces.Utilities.PlayerEventHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * CommonProxy is used to set up the mod and start it running.  It contains all the code that should run on both the
 *   Standalone client and the dedicated server.
 */
public abstract class CommonProxy {

  /**
   * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
   */
  public void preInit()
  {
	   //read config first

	com.sb205.missing_pieces.Config.StartupCommon.preInitCommon();
	com.sb205.missing_pieces.Items.preInitCommon();
	com.sb205.missing_pieces.Blocks.preInitCommon();
	com.sb205.missing_pieces.Entities.preInitCommon();
	com.sb205.missing_pieces.TileEntities.preInitCommon();


  }

  /**
   * Do your mod setup. Build whatever data structures you care about. Register recipes,
   * send FMLInterModComms messages to other mods.
   */
  public void init()
  {
	  
	com.sb205.missing_pieces.Config.StartupCommon.initCommon();
	com.sb205.missing_pieces.Blocks.initCommon();
	com.sb205.missing_pieces.TileEntities.initCommon();


  }

  /**
   * Handle interaction with other mods, complete your setup based on this.
   */
  public void postInit()
  {
	  
	  com.sb205.missing_pieces.Config.StartupCommon.postInitCommon();
	  MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
  }


}
