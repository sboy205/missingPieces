package com.sb205.missing_pieces.MpItems;

import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.sb205.missing_pieces.MpBlocks.MpBlockSlab_double;
import com.sb205.missing_pieces.MpBlocks.MpBlockSlab_half;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */

/**
 * Wrapper around ItemSlab to allow init from GameRegistry.
 *
 */
public class ItemBlockSlab extends ItemSlab {
    /**
     * Initializes a new instance of the ItemBlockSlab class.
     * @param block the block behind the item.
     * @param slab the half height slab.
     * @param doubleSlab the full height slab.
     * @param stacked whether or not the block is the stacked version.
     */

    public ItemBlockSlab(
        final Block block,
        final MpBlockSlab_half slab,
        final MpBlockSlab_double doubleSlab,
        final Boolean stacked) {
        super(block, slab, doubleSlab);

    }

}

