package com.bigbass1997.linkbot.proxy;

import net.minecraftforge.common.MinecraftForge;

import com.bigbass1997.linkbot.BotManager;
import com.bigbass1997.linkbot.ConfigManager;
import com.bigbass1997.linkbot.handlers.ChatEventHandler;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {
	
	public ServerProxy(){
		
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent e){
		ConfigManager.loadConfig(e);
		BotManager.init();
	}
	
	@Override
	public void init(){
		MinecraftForge.EVENT_BUS.register(new ChatEventHandler());
		
		//FMLCommonHandler.instance().bus().register(new ConnectionHandler());

		//CommandHandler ch = (CommandHandler) MinecraftServer.getServer().getCommandManager();
		//ch.registerCommand(new Command());
	}
}
