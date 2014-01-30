package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Sethome implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("sethome")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			final Player player = (Player) s;
			
			if(!Util.hasPermission(player, "sethome")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			Adminify.mainClass.getServer().getScheduler().runTaskAsynchronously(Adminify.mainClass, new Runnable() {
				public void run() {
					try {
						Util.addHome(player, player.getLocation());
						Util.sendMessage(player, Messages.homeSaved);
					} catch (Exception e) {
						Util.sendMessage(player, Messages.homeError);
						Util.print(e.getMessage());
					}
				}
			});

		}
		return true;
	}

}
