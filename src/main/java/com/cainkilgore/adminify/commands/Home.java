package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Home implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("home")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			final Player player = (Player) s;
			
			if(!Util.hasPermission(player, "home")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			Adminify.mainClass.getServer().getScheduler().runTaskAsynchronously(Adminify.mainClass, new Runnable() {
				public void run() {
					try {
						Util.teleportPlayer(player, Util.getHome(player));
						Util.sendMessage(player, Messages.teleHome);
					} catch (Exception e) {
						Util.sendMessage(player, Messages.noHome);
						Util.print(e.getMessage());
					}
				}
			});

		}
		return true;
	}

}
