package com.shauncjones.opencrates.blocks;

import java.util.ArrayList;
import java.util.List;

import com.shauncjones.opencrates.blocks.util.OCBlockContainerBase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class OCBlocks {
	
	public static OCBlockContainerBase basicCrate = new OCBlockContainerBase(Material.WOOD, "basic_crate", 1F, "axe", 0);	
	public static OCBlockContainerBase hardenedCrate = new OCBlockContainerBase(Material.IRON, "hardened_crate", 2.5F, "pickaxe", 1);
	
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
