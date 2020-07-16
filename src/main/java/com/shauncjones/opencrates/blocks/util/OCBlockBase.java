package com.shauncjones.opencrates.blocks.util;

import com.shauncjones.opencrates.OpenCrates;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class OCBlockBase extends Block{

	protected String name;

    public OCBlockBase(Material material, String name){
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(OpenCrates.OCTab);
    }

    public void registerItemModel(Item itemBlock){
    	OpenCrates.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock(){
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public OCBlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
	
}
