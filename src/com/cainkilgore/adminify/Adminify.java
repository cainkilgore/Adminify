package com.cainkilgore.adminify;

import org.bukkit.plugin.java.JavaPlugin;

import com.cainkilgore.adminify.commands.Fly;
import com.cainkilgore.adminify.commands.Freeze;
import com.cainkilgore.adminify.commands.God;
import com.cainkilgore.adminify.commands.Mute;
import com.cainkilgore.adminify.commands.Spawn;
import com.cainkilgore.adminify.commands.Tp;
import com.cainkilgore.adminify.commands.cmdAdminify;
import com.cainkilgore.adminify.events.evtFreeze;
import com.cainkilgore.adminify.events.evtGod;
import com.cainkilgore.adminify.events.evtMute;


public class Adminify extends JavaPlugin {
	
	public static Adminify mainClass;
	
	public void onEnable() {
		mainClass = this;
		Util.registerEvent(new evtFreeze());
		Util.registerEvent(new evtMute());
		Util.registerEvent(new evtGod());
		Util.registerCommand("freeze", new Freeze());
		Util.registerCommand("tp", new Tp());
		Util.registerCommand("spawn", new Spawn());
		Util.registerCommand("mute", new Mute());
		Util.registerCommand("fly", new Fly());
		Util.registerCommand("god", new God());
		Util.registerCommand("adminify", new cmdAdminify());
		Util.print("Adminify has been enabled.");
	}
	
	public void onDisable() {
		Util.print("Adminify has been disabled.");
	}

}
