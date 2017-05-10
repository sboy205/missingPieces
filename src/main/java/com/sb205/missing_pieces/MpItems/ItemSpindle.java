package com.sb205.missing_pieces.MpItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * User: sboy205
 * Date: 16-June-2016
 *
 * Item Spindle is a simple item which is used for tables and chairs
 */
public class ItemSpindle extends Item
{

    public ItemSpindle()
    {
      final int MAXIMUM_NUMBER_OF_SPINDLES = 64;
      this.setMaxStackSize(MAXIMUM_NUMBER_OF_SPINDLES);
      this.setCreativeTab(CreativeTabs.MISC);   // the item will appear on the Miscellaneous tab in creative
    }

}
