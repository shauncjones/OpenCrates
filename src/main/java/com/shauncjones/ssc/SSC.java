package com.shauncjones.ssc;

import com.shauncjones.ssc.proxy.CommonProxy;
import com.shauncjones.ssc.util.SSCTab;
import com.shauncjones.ssc.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION, updateJSON = Reference.UPDATEURL)
public class SSC
{
	@Mod.Instance
    public static SSC instance;

    @SidedProxy(clientSide = Reference.CLIENTPROXYCLASS, serverSide = Reference.SERVERPROXYCLASS)
    public static CommonProxy proxy;

    public static final SSCTab SSCTab = new SSCTab();

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
