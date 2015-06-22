package com.bigbass1997.linkbot;

import com.bigbass1997.linkbot.irclisteners.IRCConnectionListener;

public class BotManager {
	
	public static Bot bot;
	
	public static void init(){
		bot = new Bot(ConfigManager.botName, ConfigManager.ircServerHostName, ConfigManager.ircServerPort);
		bot.addIRCEventListener(new IRCConnectionListener());
	}
}
