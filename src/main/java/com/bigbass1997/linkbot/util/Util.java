package com.bigbass1997.linkbot.util;

import net.minecraft.util.ChatComponentText;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Util {
	
	public static final Logger log = LogManager.getLogger("LinkBot");
	
	public static ChatComponentText getChatComponent(String s){
		return new ChatComponentText(s);
	}
}
