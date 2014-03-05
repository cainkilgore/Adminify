package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Readyup implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("readyup")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "readyup")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				for(Player onlinePlayers : Adminify.mainClass.getServer().getOnlinePlayers()) {
					onlinePlayers.setHealth(onlinePlayers.getMaxHealth());
					onlinePlayers.setFoodLevel(20);
					player.setHealth(player.getMaxHealth());
					player.setFoodLevel(20);
				}
				
				Util.sendMessage(player, Messages.foodHealth);
			}
			
			if(args.length == 1) {
				try {
					for(Entity entity : player.getNearbyEntities(Integer.parseInt(args[0]), Integer.parseInt(args[0]), Integer.parseInt(args[0]))) {
						if(entity instanceof Player) {
							Player entityPlayer = (Player) entity;
							entityPlayer.setHealth(entityPlayer.getMaxHealth());
							entityPlayer.setFoodLevel(20);
							player.setHealth(player.getMaxHealth());
							player.setFoodLevel(20);
						}
					}
					
					Util.sendMessage(player, Messages.foodHealthRadius.replace("{X}", args[0]));
				} catch (Exception e) {
					Util.sendMessage(player, Messages.invalidRadius);
				}
			}
//		}
		return true;
	}

}
