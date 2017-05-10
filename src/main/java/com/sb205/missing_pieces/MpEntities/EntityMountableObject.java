package com.sb205.missing_pieces.MpEntities;

// Tribute to MrCrayfish who inspired this method  with his EntitySittableBlock
/**
 * User: sboy205
 * Date: 5/9/2017
 *
 */

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMountableObject extends Entity {

	public int blockPosX, blockPosY, blockPosZ;
	
	public EntityMountableObject(World worldIn) {
		super(worldIn);
		this.noClip = true;
		this.height = 0.01F;
		this.width = 0.01F;
	}

	public EntityMountableObject(World worldIn, double xPos, double yPos, double zPos, double yOffset ) {
		this(worldIn);
		blockPosX = (int)xPos;
		blockPosY = (int)yPos;
		blockPosZ = (int)zPos;
		//System.out.println("emo: yPos:" + yPos);
		//System.out.println("new emo x:"+blockPosX+" y:"+blockPosY+" z:"+blockPosZ);

		setPosition(xPos +0.5D, yPos+yOffset, zPos + 0.5D);
	}

	@Override
	public double getMountedYOffset()
	{
		return 0.0D;
	}

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return false;
    }

	@Override
	public void onEntityUpdate()
	{
		if (!this.worldObj.isRemote && !this.firstUpdate) // allow time to mount
		{
			if ( this.worldObj.isAirBlock(new BlockPos(blockPosX, blockPosY, blockPosZ)))
			{
				// Kill entity when chair is destroyed
				//System.out.println("killing chair air x:"+blockPosX+" y:"+blockPosY+" z:"+blockPosZ);
				this.setDead();
				worldObj.updateComparatorOutputLevel(getPosition(), worldObj.getBlockState(getPosition()).getBlock());
			}
			if ( !this.isBeingRidden()  )
			{
				// Kill entity when dismounted
				//System.out.println("killing chair no passenger x:"+blockPosX+" y:"+blockPosY+" z:"+blockPosZ);
				this.setDead();
				worldObj.updateComparatorOutputLevel(getPosition(), worldObj.getBlockState(getPosition()).getBlock());
			}
			if( this.getRidingEntity() != null && this.getRidingEntity().isSneaking() ){
				this.removePassenger(this.getRidingEntity());
				//System.out.println("removing passengers");
			}
		} 
	}
	
	@Override
	protected boolean shouldSetPosAfterLoading()
	{
		return false;
	}

	@Override
	protected void entityInit() {
		// Do nothing
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		// Do nothing
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		// Do nothing
		
	}

}
