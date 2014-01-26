package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Time implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("time")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "time")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			if(args[0].equalsIgnoreCase("add")) {
				if(args.length < 2) {
					Util.sendMessage(player, Messages.invalidArguments);
					Util.sendMessage(player, Util.getCommandUsage(l));
					return true;
				}
				
				try {
					Integer newTime = Integer.parseInt(args[1]);
					Util.setWorldTime(player, (int) (player.getWorld().getTime() + newTime));
					Util.sendMessage(player, Messages.timeChanged.replace("{T}", newTime.toString()));
				} catch (Exception e) {
					Util.sendMessage(player, Messages.timeInvalid);
					return true;
				}
			}
			if(!Util.isTimeValid(args[0])) {
				Util.sendMessage(player, Messages.timeInvalid);
				return true;
			}
			
			Util.setWorldTime(player, Util.getTimeFromString(args[0]));
			Util.sendMessage(player, Messages.timeUpdate.replace("{T}", args[0].toLowerCase()));
		}
		return true;
	}

}
