package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Target implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("target")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "target")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				if(player.getBedSpawnLocation() != null) {
					player.setCompassTarget(player.getBedSpawnLocation());
					Util.sendMessage(player, Messages.compassBed);
					return true;
				}
				player.setCompassTarget(player.getWorld().getSpawnLocation());
				Util.sendMessage(player, Messages.compassWorld);
				return true;
			}
			
			Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(argPlayer == null) {
				Util.sendMessage(player, Messages.invalidPlayer);
				return true;
			}
			
			player.setCompassTarget(argPlayer.getLocation());
			Util.sendMessage(player, Messages.compassSet.replace("{P}", argPlayer.getName()));
//		}
		return true;
	}

}
