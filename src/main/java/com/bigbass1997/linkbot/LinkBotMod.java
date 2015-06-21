package com.bigbass1997.linkbot;

import com.bigbass1997.linkbot.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = LinkBotMod.MODID, version = LinkBotMod.VERSION, acceptableRemoteVersions = "*")
public class LinkBotMod {
	public static final String MODID = "LinkBot";
	public static final String VERSION = "0.0";
	
	@Mod.Instance(MODID)
	public static LinkBotMod instance;
	
	@SidedProxy(clientSide = "com.bigbass1997.linkbot.proxy.ClientProxy", serverSide = "com.bigbass1997.linkbot.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.preInit(e);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e){
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e){
	}
	
	@Mod.EventHandler
	public void serverStopping(FMLServerStoppingEvent e){
		proxy.stop();
	}
}
