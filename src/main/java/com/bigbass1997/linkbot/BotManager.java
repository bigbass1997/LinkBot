package com.bigbass1997.linkbot;

import com.bigbass1997.linkbot.irclisteners.IRCConnectionListener;
import com.bigbass1997.linkbot.irclisteners.IRCMessageListener;

public class BotManager {
	
	private static Bot bot;
	
	public static void init(){
		bot = new Bot(ConfigManager.botName, ConfigManager.ircServerHostName, ConfigManager.ircServerPort);
		bot.addIRCEventListener(new IRCConnectionListener());
		bot.addIRCEventListener(new IRCMessageListener());
	}
	
	public static void sendGlobalIRCMessage(String s){
		bot.sendGlobalChatMessage(s);
	}
}
