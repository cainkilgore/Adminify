package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Stopweather implements CommandExecutor {
	
	public static boolean stopWeather = false;
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(!(s instanceof Player)) {
			Util.print(Messages.noConsole);
			return true;
		}
		
		Player player = (Player) s;
		
		if(!Util.hasPermission(player, "stopweather")) {
			Util.sendMessage(player, Messages.noPermission);
			return true;
		}
		
		if(!stopWeather) {
			player.getWorld().setStorm(false);
			player.getWorld().setThundering(false);
			stopWeather = true;
			Util.sendMessage(player, Messages.weatherStopped);
			return true;
		}
		stopWeather = false;
		Util.sendMessage(player, Messages.weatherContinued);
		return true;
	}

}
