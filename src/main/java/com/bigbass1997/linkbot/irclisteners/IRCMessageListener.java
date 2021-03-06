package com.bigbass1997.linkbot.irclisteners;

import com.bigbass1997.linkbot.BotManager;
import com.bigbass1997.linkbot.ConfigManager;
import com.bigbass1997.linkbot.util.Util;

import net.minecraft.server.MinecraftServer;
import jerklib.events.IRCEvent;
import jerklib.events.IRCEvent.Type;
import jerklib.events.MessageEvent;
import jerklib.listeners.IRCEventListener;

public class IRCMessageListener implements IRCEventListener {

	@Override
	public void receiveEvent(IRCEvent ircEvent) {
		if(ircEvent.getType() == Type.CHANNEL_MESSAGE || ircEvent.getType() == Type.PRIVATE_MESSAGE){
			MessageEvent e = (MessageEvent) ircEvent;
			
			if(e.getMessage().startsWith("!list")){
				String list = "";
				for(String player : MinecraftServer.getServer().getAllUsernames()){
					if(list.isEmpty()){
						list = "Players: " + player;
					} else {
						list = list + ", " + player;
					}
				}
				BotManager.sendGlobalIRCMessage(list);
				return;
			}
			
			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(Util.getChatComponent(ConfigManager.botPrefix + ConfigManager.botName + ConfigManager.botSuffix + ConfigManager.ircMessagePrefix + e.getNick() + ConfigManager.ircMessageSuffix + e.getMessage()));
		}
	}
}
