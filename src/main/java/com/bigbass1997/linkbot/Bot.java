package com.bigbass1997.linkbot;

import java.util.List;

import jerklib.Channel;
import jerklib.ConnectionManager;
import jerklib.Profile;
import jerklib.Session;
import jerklib.listeners.IRCEventListener;

public class Bot {
	
	private ConnectionManager connectionManager;
	private Session session;
	
	/**
	 * 
	 * @param name Username of the bot.
	 * @param hostName Hostname for the IRC server it should join.
	 * @param port Port of the IRC server it should join.
	 */
	public Bot(String name, String hostName, int port){
		connectionManager = new ConnectionManager(new Profile(name));
		session = connectionManager.requestConnection(hostName, port);
	}
	
	public void addIRCEventListener(IRCEventListener listener){
		session.addIRCEventListener(listener);
	}
	
	public void sendGlobalChatMessage(String s){
		for(Channel channel : session.getChannels()){
			session.sayChannel(channel, s);
		}
	}
	
	public List<String> getUserList(String channelName){
		return session.getChannel(channelName).getNicks();
	}
}
