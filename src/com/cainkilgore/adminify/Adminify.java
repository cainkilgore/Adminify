package com.cainkilgore.adminify;

import org.bukkit.plugin.java.JavaPlugin;

public class Adminify extends JavaPlugin {
	
	public void onEnable() {
		Util.print("Adminify has been enabled.");
	}
	
	public void onDisable() {
		Util.print("Adminify has been disabled.");
	}

}
