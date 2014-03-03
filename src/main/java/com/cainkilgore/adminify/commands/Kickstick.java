package com.cainkilgore.adminify.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Kickstick implements CommandExecutor {
	
	ItemStack kickStick = new ItemStack(Material.STICK, 1);
	ItemMeta stickMeta = kickStick.getItemMeta();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("kickstick")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "kickstick")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			stickMeta.setDisplayName(ChatColor.GREEN + "Kick Stick");
			kickStick.setItemMeta(stickMeta);
			
			player.getInventory().addItem(kickStick);
			Util.sendMessage(player, Messages.kickStick);
//		}
		return true;
	}

}
