package com.shauncjones.ssc.util.handlers;


import com.shauncjones.ssc.blocks.SSCBlocks;
import com.shauncjones.ssc.items.SSCItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistrationHandler {

	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        SSCItems.register(event.getRegistry());
        SSCBlocks.registerItemBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
    	SSCItems.registerModels();
        SSCBlocks.registerModels();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
    	SSCBlocks.register(event.getRegistry());
    }

}
