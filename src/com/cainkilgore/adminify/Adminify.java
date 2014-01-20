package com.cainkilgore.adminify;

import org.bukkit.plugin.java.JavaPlugin;

import com.cainkilgore.adminify.commands.Freeze;
import com.cainkilgore.adminify.events.evtFreeze;


public class Adminify extends JavaPlugin {
	
	public static Adminify mainClass;
	
	public void onEnable() {
		mainClass = this;
		Util.registerEvent(new evtFreeze());
		Util.registerCommand("freeze", new Freeze());
		Util.print("Adminify has been enabled.");
	}
	
	public void onDisable() {
		Util.print("Adminify has been disabled.");
	}

}
