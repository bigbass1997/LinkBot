package com.bigbass1997.linkbot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.bigbass1997.linkbot.util.Util;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigManager {
	
	public static String botName, ircServerHostName;
	public static int ircServerPort;
	public static ArrayList<String> ircChannels;
	
	public static boolean debug;

	public static String configJsonPath;
	public static JsonObject configJson;
	
	public static void loadConfig(FMLPreInitializationEvent e){
		configJsonPath = e.getModConfigurationDirectory() + "/LinkBot.json";
		
		String configString = readFile(configJsonPath);
		if(configString == null || configString == ""){
			createConfig(e);
		}
		
		configJson = new JsonParser().parse(readFile(configJsonPath)).getAsJsonObject();
		
		//--
		
		JsonObject irc = configJson.getAsJsonObject("irc");
		botName = irc.get("botName").getAsString();
		ircServerHostName = irc.get("ircServerHostName").getAsString();
		ircServerPort = irc.get("ircServerPort").getAsInt();
		
		ircChannels = new ArrayList<String>();
		for(JsonElement channel : irc.get("ircChannels").getAsJsonArray()){
			ircChannels.add(channel.getAsString());
		}
		
		//--
		
		debug = configJson.get("debug").getAsBoolean();
	}
	
	public static void reloadConfig(){
		configJson = new JsonParser().parse(readFile(configJsonPath)).getAsJsonObject();
		
		//--

		JsonObject irc = configJson.getAsJsonObject("irc");
		botName = irc.get("botName").getAsString();
		ircServerHostName = irc.get("ircServerHostName").getAsString();
		ircServerPort = irc.get("ircServerPort").getAsInt();
		
		ircChannels = new ArrayList<String>();
		for(JsonElement channel : irc.get("ircChannels").getAsJsonArray()){
			ircChannels.add(channel.getAsString());
		}
		
		//--
		
		debug = configJson.get("debug").getAsBoolean();
	}
	
	private static void createConfig(FMLPreInitializationEvent e){
		try {
			File file = new File(configJsonPath);
			FileUtils.copyURLToFile(ConfigManager.class.getClassLoader().getResource("LinkBot-default.json"), file);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * @author http://stackoverflow.com/a/19459884/4816410
	 * @author bigbass1997
	 * 
	 * @param path
	 * @return textFromFile or null
	 */
	private static String readFile(String path){
		try {
			File myFile = new File(path);
	        FileInputStream fIn;
			fIn = new FileInputStream(myFile);
			BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
	        String aDataRow = "";
	        String aBuffer = "";
	        while ((aDataRow = myReader.readLine()) != null) 
	        {
	            aBuffer += aDataRow ;
	        }
	        myReader.close();

			return aBuffer;
		} catch (FileNotFoundException e) {
			Util.log.info("File '" + path + "' not found! Creating default file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
