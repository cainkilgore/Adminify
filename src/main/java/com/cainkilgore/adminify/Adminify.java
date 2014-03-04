package com.cainkilgore.adminify;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import com.cainkilgore.adminify.events.evtAlert;
import com.cainkilgore.adminify.events.evtChat;
import com.cainkilgore.adminify.events.evtCommand;
import com.cainkilgore.adminify.events.evtEnabled;
import com.cainkilgore.adminify.events.evtFreeze;
import com.cainkilgore.adminify.events.evtGod;
import com.cainkilgore.adminify.events.evtKickstick;
import com.cainkilgore.adminify.events.evtLastpos;
import com.cainkilgore.adminify.events.evtMOTD;
import com.cainkilgore.adminify.events.evtMute;
import com.cainkilgore.adminify.events.evtPing;
import com.cainkilgore.adminify.events.evtRide;
import com.cainkilgore.adminify.events.evtSnowman;


public class Adminify extends JavaPlugin {
	
	public static String prefix;
	
	public static Adminify mainClass;
	public void onEnable() {
		
		setupConfig();
		mainClass = this;
		
		Util.registerEvent(new evtFreeze());
		Util.registerEvent(new evtMute());
		Util.registerEvent(new evtGod());
		Util.registerEvent(new evtEnabled());
		Util.registerEvent(new evtAlert());
		Util.registerEvent(new evtLastpos());
		Util.registerEvent(new evtRide());
		Util.registerEvent(new evtMOTD());
		Util.registerEvent(new evtChat());
		Util.registerEvent(new evtSnowman());
		Util.registerEvent(new evtKickstick());
		Util.registerEvent(new evtPing());
		Util.registerEvent(new evtCommand());
		
		for(Entry<String, Map<String, Object>> i : this.getDescription().getCommands().entrySet()) {
			String formatCommand = i.getKey().replace("adminify_", "");
			String commandClass = "com.cainkilgore.adminify.commands." + StringUtils.capitalize(formatCommand);
			
			try {
				Util.registerCommand(formatCommand, (CommandExecutor) Class.forName(commandClass).newInstance());
			} catch (Exception e) {
				Util.print("There was an error registering /" + formatCommand);
			}
		}
		
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
		
		Timers.vanishTimer();
		
		Bukkit.getServer().getScheduler().runTaskAsynchronously(this, new Runnable() {
			public void run() {
				try {
					SQL.startConnection();
				} catch (Exception e) {
					Util.print("Error whilst attempting to connect to database.");
					Util.print(e.getMessage());
				}
			}
		});

		
		Util.print("Adminify has been enabled.");
	}
	
	public void onDisable() {
		// Util.setAllVanished(false);
		System.out.println("Adminify has been disabled.");
	}
	
	public void setupConfig() {
		boolean needsSaved = false;
		if(getConfig().get("settings.chat-ping") == null) {
			getConfig().set("settings.chat-ping", false);
			needsSaved = true;
		}
		if(getConfig().get("settings.adminify-prefix") == null) {
			getConfig().set("settings.adminify-prefix", "&9");
			needsSaved = true;
		}
		if(needsSaved)  saveConfig();
	}
	
	// Note: Read Requests, also, Jenkins available! again..
}
