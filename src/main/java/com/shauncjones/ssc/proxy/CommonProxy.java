package com.shauncjones.ssc.proxy;

import com.shauncjones.ssc.SSC;
import com.shauncjones.ssc.blocks.tile.TileEntityBasicCrate;
import com.shauncjones.ssc.blocks.tile.TileEntityHardenedCrate;
import com.shauncjones.ssc.util.Reference;
import com.shauncjones.ssc.util.handlers.GuiHandler;

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
    	NetworkRegistry.INSTANCE.registerGuiHandler(SSC.instance, new GuiHandler());
    	GameRegistry.registerTileEntity(TileEntityBasicCrate.class, (Reference.MODID + ":basic_crate"));
    	GameRegistry.registerTileEntity(TileEntityHardenedCrate.class, (Reference.MODID + ":hardened_crate"));
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerItemRenderer(Item item, int meta, String id){

    }
	
}
