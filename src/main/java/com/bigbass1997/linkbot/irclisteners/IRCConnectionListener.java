package com.bigbass1997.linkbot.irclisteners;

import java.util.ArrayList;

import com.bigbass1997.linkbot.ConfigManager;

import jerklib.events.IRCEvent;
import jerklib.events.IRCEvent.Type;
import jerklib.listeners.IRCEventListener;

public class IRCConnectionListener implements IRCEventListener {

	@Override
	public void receiveEvent(IRCEvent e) {
		Type type = e.getType();
		
		if(type == Type.CONNECT_COMPLETE){
			ArrayList<String> channels = ConfigManager.ircChannels;
			for(String channel : channels){
				e.getSession().join(channel);
			}
		}
	}
}
