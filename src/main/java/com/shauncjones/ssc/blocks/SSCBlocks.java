package com.shauncjones.ssc.blocks;

import java.util.ArrayList;
import java.util.List;

import com.shauncjones.ssc.blocks.util.SSCBlockContainerBase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class SSCBlocks {
	
	public static SSCBlockContainerBase basicCrate = new SSCBlockContainerBase(Material.WOOD, "basic_crate", 1F, "axe", 0);	
	public static SSCBlockContainerBase hardenedCrate = new SSCBlockContainerBase(Material.IRON, "hardened_crate", 2.5F, "pickaxe", 1);
	
	public static void register(IForgeRegistry<Block> registry){
        registry.registerAll(
        		basicCrate,
        		hardenedCrate
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry){
        registry.registerAll(
        		basicCrate.createItemBlock(),
        		hardenedCrate.createItemBlock()
        );
    }

    public static void registerModels(){
    	basicCrate.registerItemModel(Item.getItemFromBlock(basicCrate));
    	hardenedCrate.registerItemModel(Item.getItemFromBlock(hardenedCrate));
    }
	
}
