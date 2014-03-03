package com.cainkilgore.adminify.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class IpropCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("iprop")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "iprop")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 2) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			if(player.getItemInHand() == null) {
				Util.sendMessage(player, Messages.mustbeHolding);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("name")) {
				StringBuilder x = new StringBuilder();
				for(int i = 1; i < args.length; i++){
					x.append(args[i] + " ");
				}
				
				Util.setDisplayName(player.getItemInHand(), ChatColor.translateAlternateColorCodes('&', x.toString().trim()));
				Util.sendMessage(player, Messages.displaySet);
				
				if(args[0].equalsIgnoreCase("blank")) {
					Util.setDisplayName(player.getItemInHand(), ChatColor.RED + "");
					return true;
				}
				Util.sendMessage(player, Messages.messagePrefix + ChatColor.translateAlternateColorCodes('&', x.toString().trim()));
				return true;
			}
			
			if(args[0].equalsIgnoreCase("lore")) {
				StringBuilder x = new StringBuilder();
				for(int i = 1; i < args.length; i++){
					x.append(args[i] + " ");
				}
				
				Util.setLore(player.getItemInHand(), ChatColor.translateAlternateColorCodes('&', x.toString().trim()));
				Util.sendMessage(player, Messages.loreSet);
				if(args[0].equalsIgnoreCase("blank")) {
					Util.setLore(player.getItemInHand(), ChatColor.RED + "");
					return true;
				}
				Util.sendMessage(player, Messages.messagePrefix + ChatColor.translateAlternateColorCodes('&', x.toString().trim()));
				return true;
			}
		}
		return true;
	}

}
