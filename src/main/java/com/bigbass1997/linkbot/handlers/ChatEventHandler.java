package com.bigbass1997.linkbot.handlers;

import com.bigbass1997.linkbot.BotManager;

import net.minecraftforge.event.ServerChatEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChatEventHandler {
	
	@SubscribeEvent
	public void onServerChat(ServerChatEvent e){
		BotManager.sendGlobalIRCMessage("<" + e.username + "> " + e.message);
	}
}
