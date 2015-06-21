package com.bigbass1997.linkbot;

import jerklib.ConnectionManager;

public class Bot {
	
	private ConnectionManager con;
	
	public Bot(){
		con = new ConnectionManager(new Profile("LinkBot"));
	}
}
