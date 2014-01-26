package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Kmob implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("kmob")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "kmob")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			int entityCount = 0;
			
			for(Entity entities : player.getWorld().getEntities()) {
				if(entities instanceof Monster || entities instanceof Creature) {
					entities.remove();
					entityCount++;
				}
			}
			
			Util.sendMessage(player, Messages.kMobKilled.replace("{N}", Integer.toString(entityCount)));
		}
		return true;
	}

}
