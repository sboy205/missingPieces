package com.sb205.missing_pieces.MpBlocks;

import java.util.Locale;

import net.minecraft.block.material.Material;
/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */

// Defines the single or half portion of the stone slab

public class MpBlockSlab_half extends MpBlockSlab {

	public MpBlockSlab_half(Material mType, Float matHardness,	String toolClass, int toolLevel)
 {
		super(mType, matHardness, toolClass, toolLevel);
	}
	
	@Override
	public boolean isDouble() {
		return false;
	}

}
