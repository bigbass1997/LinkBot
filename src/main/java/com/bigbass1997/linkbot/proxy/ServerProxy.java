package com.bigbass1997.linkbot.proxy;

import com.bigbass1997.linkbot.ConfigManager;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {
	
	public ServerProxy(){
		
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent e){
		ConfigManager.loadConfig(e);
	}
	
	@Override
	public void init(){
		//MinecraftForge.EVENT_BUS.register(new EventHandler());
		
		//FMLCommonHandler.instance().bus().register(new ConnectionHandler());

		//CommandHandler ch = (CommandHandler) MinecraftServer.getServer().getCommandManager();
		//ch.registerCommand(new Command());
	}
}
