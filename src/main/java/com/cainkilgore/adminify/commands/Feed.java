package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Feed implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("feed")) {
			if(!(s instanceof Player)) {
				try {
					Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
					if(argPlayer == null) {
						Util.print(Messages.invalidPlayer);
						return true;
					}
					
					Util.replenishHunger(argPlayer);
					Util.print("Player fed.");
				} catch (Exception e) {
					Util.print(Messages.error);
				}
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				if(!Util.hasPermission(player, "feed")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Util.replenishHunger(player);
				Util.sendMessage(player, Messages.selfFed);
			}
			
			if(args.length == 1) {
				if(!Util.hasPermission(player, "feed.others")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				Util.replenishHunger(argPlayer);
				Util.sendMessage(player, Messages.playerFed.replace("{P}", argPlayer.getName()));
				Util.sendMessage(argPlayer, Messages.adminFed.replace("{A}", player.getName()));
			}
//		}
		return true;
	}

}
