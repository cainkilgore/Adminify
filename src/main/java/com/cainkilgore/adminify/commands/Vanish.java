package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Vanish implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("vanish")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "vanish")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			player.getWorld().createExplosion(player.getLocation(), 0.0F, false);
			
			if(!Util.isVanished(player)) {
				Util.setVanished(player, true);
				Util.sendMessage(player, Messages.nowVanished);
				
				for(Player online : Adminify.mainClass.getServer().getOnlinePlayers()) {
					online.hidePlayer(player);
				}
				return true;
			}
			Util.setVanished(player, false);
			
			for(Player online : Adminify.mainClass.getServer().getOnlinePlayers()) {
				online.showPlayer(player);
			}
			
			Util.sendMessage(player, Messages.noVanished);
//		}
		return true;
	}

}
