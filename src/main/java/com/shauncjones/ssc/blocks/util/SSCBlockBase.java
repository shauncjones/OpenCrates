package com.shauncjones.ssc.blocks.util;

import com.shauncjones.ssc.SSC;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class SSCBlockBase extends Block{

	protected String name;

    public SSCBlockBase(Material material, String name){
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(SSC.SSCTab);
    }

    public void registerItemModel(Item itemBlock){
    	SSC.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock(){
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public SSCBlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
	
}
