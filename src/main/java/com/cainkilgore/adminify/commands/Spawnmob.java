package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Spawnmob implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("spawnmob")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "spawnmob")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			if(args[0].equalsIgnoreCase("?")) {
				StringBuilder x = new StringBuilder();
				for(EntityType name : EntityType.values()) {
					x.append(name.toString() + ", ");
				}
				
				Util.sendMessage(player, x.toString());
				return true;
			}
			
			if(args.length < 2) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			try {
				if(EntityType.valueOf(args[0].toUpperCase()) == null) {
					Util.sendMessage(player, Messages.invalidMob);
					return true;
				}
			} catch (IllegalArgumentException e) {
				Util.sendMessage(player, Messages.invalidMob);
				return true;
			}

			try {
				Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				Util.sendMessage(player, Messages.invalidCount);
				return true;
			}
			
			for(int i = 0; i < Integer.parseInt(args[1]); i++) {
				player.getWorld().spawnEntity(player.getTargetBlock(null, 0).getRelative(0, 1, 0).getLocation(), EntityType.valueOf(args[0].toUpperCase()));
			}
			
			Util.sendMessage(player, Messages.spawnSuccess.replace("{N}", args[1]).replace("{E}", EntityType.valueOf(args[0].toUpperCase()).getName()));
		}
		return true;
	}

}
