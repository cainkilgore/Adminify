package com.cainkilgore.adminify.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Repair implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("repair")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "repair")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(player.getItemInHand().getType().getMaxStackSize() != 1) {
				Util.sendMessage(player, Messages.emptyHand);
				return true;
			}
			
			if(player.getItemInHand().getType() == Material.AIR) {
				Util.sendMessage(player, Messages.emptyHand);
				return true;
			}
			
			player.getItemInHand().setDurability((short) 0);
			Util.sendMessage(player, Messages.repaired.replace("{I}", player.getItemInHand().getType().name()));
//		}
		return true;
	}

}
