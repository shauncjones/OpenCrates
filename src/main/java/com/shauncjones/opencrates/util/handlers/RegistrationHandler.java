package com.shauncjones.opencrates.util.handlers;


import com.shauncjones.opencrates.blocks.OCBlocks;
import com.shauncjones.opencrates.items.OCItems;

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
        OCItems.register(event.getRegistry());
        OCBlocks.registerItemBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
    	OCItems.registerModels();
        OCBlocks.registerModels();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
    	OCBlocks.register(event.getRegistry());
    }

}
