package com.sb205.missing_pieces.Shelf;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.sb205.missing_pieces.Utilities.UsefulFunctions;

import java.awt.*;

/**
 * User: The Grey Ghost
 * Date: 12/01/2015
 * The base model is drawn by the block model, not this class.
 */
public class TileEntitySpecialRendererShelf extends TileEntitySpecialRenderer
{
	

  /**
   * render the tile entity - called every frame while the tileentity is in view of the player
   * @param tileEntity the associated tile entity
   * @param relativeX the x distance from the player's eye to the tileentity
   * @param relativeY the y distance from the player's eye to the tileentity
   * @param relativeZ the z distance from the player's eye to the tileentity
   * @param partialTicks the fraction of a tick that this frame is being rendered at - used to interpolate frames between
   *                     ticks, to make animations smoother.  For example - if the frame rate is steady at 80 frames per second,
   *                     this method will be called four times per tick, with partialTicks spaced 0.25 apart, (eg) 0, 0.25, 0.5, 0.75
   * @param blockDamageProgress the progress of the block being damaged (0 - 10), if relevant.  -1 if not relevant.
   *     
   */
  @Override
  public void render(TileEntity tileEntity, double relativeX, double relativeY, double relativeZ, float partialTicks, int blockDamageProgress, float alpha) {
		 EntityItem entityTemp1 = new EntityItem(Minecraft.getMinecraft().world, 0D, 0D, 0D);
		 EntityItem entityTemp2 = new EntityItem(Minecraft.getMinecraft().world, 0D, 0D, 0D);
		 EntityItem entityTemp3 = new EntityItem(Minecraft.getMinecraft().world, 0D, 0D, 0D);
		 EntityItem entityTemp4 = new EntityItem(Minecraft.getMinecraft().world, 0D, 0D, 0D);

	if (!(tileEntity instanceof TileEntityShelf)) return; // should never happen
 TileEntityShelf tileEntityShelf = (TileEntityShelf) tileEntity;
 ItemStack item0 = tileEntityShelf.getStackInSlot(0);
 ItemStack item1 = tileEntityShelf.getStackInSlot(1);
 ItemStack item2 = tileEntityShelf.getStackInSlot(2);
 ItemStack item3 = tileEntityShelf.getStackInSlot(3);
 ItemRenderer renderTool = Minecraft.getMinecraft().getItemRenderer();
 EntityPlayerSP player = Minecraft.getMinecraft().player;
 
 try {
     // save the transformation matrix and the rendering attributes, so that we can restore them after rendering.  This
     //   prevents us disrupting any vanilla TESR that render after ours.
     //  using try..finally is not essential but helps make it more robust in case of exceptions
     GL11.glPushMatrix();
     GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
     GL11.glTranslatef((float) relativeX+0.50F, (float) relativeY+0.0F, (float) relativeZ+0.50F); 

     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); 
     
     int meta = tileEntityShelf.getBlockMetadata();
     EnumFacing facing = EnumFacing.getHorizontal(meta);
     int angle = 0; // EnumFacing.SOUTH
		if(facing == EnumFacing.EAST)
		{
			angle = 90;
		}
		if(facing == EnumFacing.NORTH)
		{
			angle = 180;
		}
		if(facing == EnumFacing.WEST)
		{
			angle = 270;
		}

     GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F); 
     GL11.glScalef(0.33F, 0.33F, 0.33F);
     GL11.glTranslatef(0.7F, 2.1F, 0.70F); 
     if(item0 != null) {
   	  renderTool.renderItem(player, item0, TransformType.NONE);
   	  //System.out.println("render item0");
     } 
     GL11.glTranslatef(-1.4F, 0.0F, 0.0F); 
     if(item1 != null) {
   	  renderTool.renderItem(player, item1, TransformType.NONE);
   	  //System.out.println("render item1");
     } 
     GL11.glTranslatef(1.4F, -1.4F, 0.0F); 
     if(item2 != null) {
   	  renderTool.renderItem(player, item2, TransformType.NONE);
   	  //System.out.println("render item2");
     } 
     GL11.glTranslatef(-1.4F, 0.0F, 0.0F); 
     if(item3 != null) {
   	  renderTool.renderItem(player, item3, TransformType.NONE);
   	  //System.out.println("render item3");
    } 

   } finally {
     GL11.glPopAttrib();
     GL11.glPopMatrix();
   }
 
}

  
  public void renderTileEntityFast(TileEntity tileEntity, double relativeX, double relativeY, double relativeZ, float partialTicks, int blockDamageProgress, float partial, net.minecraft.client.renderer.BufferBuilder buffer) {
  }


}
