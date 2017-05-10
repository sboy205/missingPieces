package com.sb205.missing_pieces.MpBlocks;

import net.minecraft.block.material.Material;
/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */

// Defines the double portion of the stone slab

public class MpBlockSlab_double extends MpBlockSlab {

	public MpBlockSlab_double(Material mType, Float matHardness,	String toolClass, int toolLevel) {
		super( mType,  matHardness,	 toolClass,  toolLevel);
	}
	@Override
	public final boolean isDouble() {
		return true;
	}

}
