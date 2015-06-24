package com.bigbass1997.linkbot.handlers;

import com.bigbass1997.linkbot.BotManager;
import com.bigbass1997.linkbot.ConfigManager;
import com.bigbass1997.linkbot.util.Util;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.ServerChatEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChatEventHandler {
	
	@SubscribeEvent
	public void onServerChat(ServerChatEvent e){
		
		if(e.message.startsWith("!list")){
			String list = "";
			for(String user : BotManager.getUserList(ConfigManager.ircChannel)){
				if(list.isEmpty()){
					list = "IRCUsers: " + user;
				} else {
					list = list + ", " + user;
				}
			}
			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(Util.getChatComponent(list));
			return;
		}
		
		BotManager.sendGlobalIRCMessage("<" + e.username + "> " + e.message);
	}
}
