package com.shauncjones.opencrates.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class OpenCratesTab extends CreativeTabs {

    public OpenCratesTab() {
        super(Reference.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Blocks.CHEST);
    }
}
