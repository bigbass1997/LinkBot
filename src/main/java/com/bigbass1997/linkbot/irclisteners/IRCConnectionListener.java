package com.bigbass1997.linkbot.irclisteners;

import com.bigbass1997.linkbot.ConfigManager;

import jerklib.events.IRCEvent;
import jerklib.events.IRCEvent.Type;
import jerklib.listeners.IRCEventListener;

public class IRCConnectionListener implements IRCEventListener {

	@Override
	public void receiveEvent(IRCEvent e) {
		Type type = e.getType();
		
		if(type == Type.CONNECT_COMPLETE){
			for(String channel : ConfigManager.ircChannels){
				e.getSession().join(channel);
			}
		}
	}
}
