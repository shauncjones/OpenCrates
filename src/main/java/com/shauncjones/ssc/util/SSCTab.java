package com.shauncjones.ssc.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class SSCTab extends CreativeTabs {

    public SSCTab() {
        super(Reference.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Blocks.CHEST);
    }
}
