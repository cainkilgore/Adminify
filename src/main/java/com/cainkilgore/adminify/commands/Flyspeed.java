package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Flyspeed implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("flyspeed")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "flyspeed")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			try {
				player.setFlySpeed(Float.valueOf(args[0]));
				Util.sendMessage(player, Messages.flySet.replace("{F}", args[0]));
			} catch (Exception e) {
				Util.sendMessage(player, Messages.flyError);
			}
		}
		return true;
	}
}
