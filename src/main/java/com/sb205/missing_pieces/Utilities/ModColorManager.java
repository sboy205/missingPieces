package com.sb205.missing_pieces.Utilities;

import javax.annotation.Nullable;

import com.sb205.missing_pieces.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** 
  * Registers {@link IBlockColor}/{@link IItemColor} handlers for this mod's blocks/items. 
  * 
	 * User: sboy205
	 * Date: 5/9/2017
	 *
  */ 
 @SideOnly(Side.CLIENT) 
 public class ModColorManager { 
 	private static final Minecraft minecraft = Minecraft.getMinecraft(); 
 

 	/** 
 	 * Register the colour handlers. 
 	 */ 
 	public static void registerColourHandlers() { 
 		final BlockColors blockColors = minecraft.getBlockColors(); 
 		final ItemColors itemColors = minecraft.getItemColors(); 
 
 
 		registerBlockColourHandlers(blockColors); 
 		registerItemColourHandlers(blockColors, itemColors); 
 	} 
 
 	/** 
 	 * Register the {@link IBlockColor} handlers. 
 	 * 
 	 * @param blockColors The BlockColors instance 
 	 */ 
 	private static void registerBlockColourHandlers(final BlockColors blockColors) { 
 		blockColors.registerBlockColorHandler(new IBlockColor()
        {
            public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex)
            {
                return worldIn != null && pos != null ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : ColorizerGrass.getGrassColor(0.5D, 1.0D);
            }
        }, new Block[] {Blocks.grass_wedge});
 		
 	} 
 	 
 	/** 
 	 * Register the {@link IItemColor} handlers 
 	 * 
 	 * @param blockColors The BlockColors instance 
 	 * @param itemColors  The ItemColors instance 
 	 */ 
 	private static void registerItemColourHandlers(final BlockColors blockColors, final ItemColors itemColors) { 
 		// Use the Block's color handler for an ItemBlock 
 		itemColors.registerItemColorHandler(new IItemColor()
        {
 			@Override
 			public int getColorFromItemstack(ItemStack stack, int tintIndex)
            {
                IBlockState iblockstate = ((ItemBlock)stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
                return blockColors.colorMultiplier(iblockstate, (IBlockAccess)null, (BlockPos)null, tintIndex);
            }

        }, new Block[] {Blocks.grass_wedge});
 		
  	} 
 	
 	
 }
