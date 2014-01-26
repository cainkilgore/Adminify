package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Tphere implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("tphere")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "tphere")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			if(args[0].equalsIgnoreCase("*")) {
				if(!Util.hasPermission(player, "tphere.all")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				for(Player onlinePlayers : Adminify.mainClass.getServer().getOnlinePlayers()) {
					Util.teleportPlayer(onlinePlayers, player.getLocation());
					Util.sendMessage(onlinePlayers, Messages.allTped.replace("{A}", player.getName()));
				}
				Util.sendMessage(player, Messages.allPlayers);
				return true;
			}
			
			Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(argPlayer == null) {
				Util.sendMessage(player, Messages.invalidPlayer);
				return true;
			}
			
			Util.teleportPlayer(argPlayer, player.getLocation());
			Util.sendMessage(player, Messages.tphereAdmin.replace("{P}", argPlayer.getName()));
			Util.sendMessage(argPlayer, Messages.argToPlayer.replace("{P}", player.getName()));
		}
		return true;
	}

}
