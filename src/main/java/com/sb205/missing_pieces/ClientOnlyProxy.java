package com.sb205.missing_pieces;


import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * ClientProxy is used to set up the mod and start it running on normal minecraft.  It contains all the code that should run on the
 *   client side only.
 */
public class ClientOnlyProxy extends CommonProxy
{

  /**
   * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
   */
  public void preInit()
  {
    super.preInit();
    
    com.sb205.missing_pieces.Config.StartupClientOnly.preInitClientOnly();

  }

  /**
   * Do your mod setup. Build whatever data structures you care about. Register recipes,
   * send FMLInterModComms messages to other mods.
   */
  public void init()
  {
    super.init();
    
    com.sb205.missing_pieces.Config.StartupClientOnly.initClientOnly();
    com.sb205.missing_pieces.TileEntities.initClientOnly();
    com.sb205.missing_pieces.Items.initClientOnly();
    com.sb205.missing_pieces.Blocks.initClientOnly();


  }

  /**
   * Handle interaction with other mods, complete your setup based on this.
   */
  public void postInit()
  {
    super.postInit();

    com.sb205.missing_pieces.Config.StartupClientOnly.postInitClientOnly();

  }

}
