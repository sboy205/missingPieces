package com.sb205.missing_pieces;

import com.sb205.missing_pieces.Config.MpConfiguration;
import com.sb205.missing_pieces.MpEntities.EntityMountableObject;
import com.sb205.missing_pieces.Utilities.BlockInfo.BlockType;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Entities {
    static int MpEntityId = 1;

	public static void preInitCommon(){
		// Register mountable entity for chairs
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("missing_pieces:"+"MountableObject", "inventory");

	    EntityRegistry.registerModEntity(itemModelResourceLocation, EntityMountableObject.class, "MountableObject", MpEntityId++, MissingPieces.instance, 80, 3, false);
	};



}
