package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Walkspeed implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("walkspeed")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "walkspeed")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			try {
				player.setWalkSpeed(Float.valueOf(args[0]));
				Util.sendMessage(player, Messages.walkSet.replace("{F}", args[0]));
			} catch (Exception e) {
				Util.sendMessage(player, Messages.walkError);
			}
		}
		return true;
	}
}
