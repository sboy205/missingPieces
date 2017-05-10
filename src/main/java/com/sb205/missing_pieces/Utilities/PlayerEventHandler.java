package com.sb205.missing_pieces.Utilities;
import com.sb205.missing_pieces.MpBlocks.BlockWedge;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs.EnumHalf;
import net.minecraft.block.BlockStairs.EnumShape;
import net.minecraft.block.BlockStairs;
import net.minecraft.util.EnumFacing;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */

public class PlayerEventHandler {

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent event){
		if (event instanceof RightClickBlock){
			BlockPos pos = event.getPos();
			Block block = event.getWorld().getBlockState(pos).getBlock();
			if(block != com.sb205.missing_pieces.Blocks.grass_wedge){
				//System.out.println("wrong block " + block.getUnlocalizedName() + " at pos "+ pos);
				return;
			} else {
				ItemStack stack = event.getItemStack();
				//System.out.println("PLayer event handled for block " + curBlockState.getBlock().getLocalizedName() + "with " + stack.getDisplayName());
				if(stack == null){
					//System.out.println("player not holding anything");
					return;
				} else {
					//System.out.println("tool classes: " + stack.getItem().getToolClasses(stack));
					//if ( stack.getItem() instanceof ItemSpade){
					if (stack.getItem().getToolClasses(stack).contains("shovel")){
	                    IBlockState curBlockState = event.getWorld().getBlockState(pos);
	                    BlockWedge wedge = (BlockWedge) curBlockState.getBlock();
	                    wedge.flatten(event.getWorld(),  pos);
	
						//System.out.println(" can flatten");
	
					}
				}
			}
		} // else not a right click
	}



}
