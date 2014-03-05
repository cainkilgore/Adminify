package com.cainkilgore.adminify.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Hat implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(!(s instanceof Player)) {
			Util.print(Messages.noConsole);
			return true;
		}
		
		Player player = (Player) s;
		
		if(!Util.hasPermission(player, "hat")) {
			Util.sendMessage(player, Messages.noPermission);
			return true;
		}
		
		if(player.getItemInHand() == null) {
			Util.sendMessage(player, Messages.mustBeHoldingItem);
			return true;
		}
		
		if(player.getItemInHand().getType() == Material.AIR) {
			Util.sendMessage(player, Messages.mustBeHoldingItem);
			return true;
		}
		
		if(player.getInventory().getHelmet() != null) {
			Util.sendMessage(player, Messages.itemHelmet);
			return true;
		}
		
		player.getInventory().setHelmet(player.getItemInHand());
		player.getInventory().remove(player.getItemInHand());
		Util.sendMessage(player, Messages.nowWearingItem.replace("{I}", StringUtils.capitalize(player.getInventory().getHelmet().getType().name().toLowerCase().replace("_", " "))));
		return true;
	}

}
