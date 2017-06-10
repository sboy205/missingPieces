package com.sb205.missing_pieces.Utilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

import com.sb205.missing_pieces.MpEntities.EntityMountableObject;
/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */

public class MountableUtil {

	public static boolean MountBlock(World worldIn, double xPos, double yPos, double zPos, EntityPlayer playerIn, double yOffset){
		if (!checkForExistingEntity(worldIn, xPos, yPos, zPos, playerIn))
		{
			// No entity, so create one and mount it.
			EntityMountableObject nemo = new EntityMountableObject(worldIn, xPos, yPos, zPos, yOffset);
			worldIn.spawnEntity(nemo);
			playerIn.startRiding(nemo);
			//System.out.println("mounting chair x:"+ xPos + " y:"+ yPos + " z:"+  zPos + " offset:"+ yOffset);
					
		}
		return true;
	}
	
	public static boolean checkForExistingEntity(World worldIn, double x, double y, double z, EntityPlayer playerIn)
	{
		List<EntityMountableObject> listEMO = worldIn.getEntitiesWithinAABB(EntityMountableObject.class, new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expand(1D, 1D, 1D));
		for (EntityMountableObject mount : listEMO)
		{
			if (mount.blockPosX == x && mount.blockPosY == y && mount.blockPosZ == z)
			{
				if (mount.getRidingEntity() == null)
				{
					//If there is an entity not being ridden then mount it.
					playerIn.startRiding(mount);
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean isSomeoneSitting(World world, double x, double y, double z)
	{
		List<EntityMountableObject> listEMB = world.getEntitiesWithinAABB(EntityMountableObject.class, new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expand(1D, 1D, 1D));
		for (EntityMountableObject mount : listEMB)
		{
			if (mount.blockPosX == x && mount.blockPosY == y && mount.blockPosZ == z)
			{
				return mount.getRidingEntity() != null;
			}
		}
		return false;
	}

}
