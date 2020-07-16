package com.shauncjones.opencrates;

import com.shauncjones.opencrates.proxy.CommonProxy;
import com.shauncjones.opencrates.util.OpenCratesTab;
import com.shauncjones.opencrates.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class OpenCrates
{
	@Mod.Instance
    public static OpenCrates instance;

    @SidedProxy(clientSide = Reference.CLIENTPROXYCLASS, serverSide = Reference.SERVERPROXYCLASS)
    public static CommonProxy proxy;

    public static final OpenCratesTab OCTab = new OpenCratesTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
}
