package com.cainkilgore.adminify;

import org.bukkit.plugin.java.JavaPlugin;

import com.cainkilgore.adminify.commands.Alert;
import com.cainkilgore.adminify.commands.Clear;
import com.cainkilgore.adminify.commands.Fly;
import com.cainkilgore.adminify.commands.Freeze;
import com.cainkilgore.adminify.commands.God;
import com.cainkilgore.adminify.commands.Heal;
import com.cainkilgore.adminify.commands.Hit;
import com.cainkilgore.adminify.commands.Kill;
import com.cainkilgore.adminify.commands.Mute;
import com.cainkilgore.adminify.commands.Spawn;
import com.cainkilgore.adminify.commands.Time;
import com.cainkilgore.adminify.commands.Tp;
import com.cainkilgore.adminify.commands.Vanish;
import com.cainkilgore.adminify.commands.cmdAdminify;
import com.cainkilgore.adminify.events.evtAlert;
import com.cainkilgore.adminify.events.evtEnabled;
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
		Util.registerEvent(new evtEnabled());
		Util.registerEvent(new evtAlert());
		
		Util.registerCommand("freeze", new Freeze());
		Util.registerCommand("tp", new Tp());
		Util.registerCommand("spawn", new Spawn());
		Util.registerCommand("mute", new Mute());
		Util.registerCommand("fly", new Fly());
		Util.registerCommand("god", new God());
		Util.registerCommand("adminify", new cmdAdminify());
		Util.registerCommand("time", new Time());
		Util.registerCommand("heal", new Heal());
		Util.registerCommand("hit", new Hit());
		Util.registerCommand("clear", new Clear());
		Util.registerCommand("kill", new Kill());
		Util.registerCommand("vanish", new Vanish());
		Util.registerCommand("alert", new Alert());
		
		Timers.vanishTimer();
		
		try {
			SQL.startConnection();
		} catch (Exception e) {
			Util.print("Error whilst attempting to connect to database.");
			Util.print(e.getMessage());
		}
		
		Util.print("Adminify has been enabled.");
	}
	
	public void onDisable() {
		Util.setAllVanished(false);
		Util.print("Adminify has been disabled.");
	}
}
