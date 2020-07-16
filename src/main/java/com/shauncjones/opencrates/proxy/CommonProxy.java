package com.shauncjones.opencrates.proxy;

import com.shauncjones.opencrates.OpenCrates;
import com.shauncjones.opencrates.blocks.tile.TileEntityBasicCrate;
import com.shauncjones.opencrates.blocks.tile.TileEntityHardenedCrate;
import com.shauncjones.opencrates.util.Reference;
import com.shauncjones.opencrates.util.handlers.GuiHandler;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(OpenCrates.instance, new GuiHandler());
    	GameRegistry.registerTileEntity(TileEntityBasicCrate.class, (Reference.MODID + ":basic_crate"));
    	GameRegistry.registerTileEntity(TileEntityHardenedCrate.class, (Reference.MODID + ":hardened_crate"));
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerItemRenderer(Item item, int meta, String id){

    }
	
}
