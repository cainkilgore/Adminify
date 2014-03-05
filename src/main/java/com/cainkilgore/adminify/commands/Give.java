package com.cainkilgore.adminify.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Give implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(!(s instanceof Player)) {
			// Will do
			Util.print(Messages.noConsole);
			return true;
		}
		
		Player player = (Player) s;
		
		if(!Util.hasPermission(player, "give")) {
			Util.sendMessage(player, Messages.noPermission);
			return true;
		}
		
		if(args.length < 1) {
			Util.sendMessage(player, Messages.invalidArguments);
			Util.sendMessage(player, Util.getCommandUsage(l));
			return true;
		}
		
		if(args.length == 1) {
			Material getMaterial = Material.getMaterial(args[0].toUpperCase());
			if(getMaterial == null) {
				Util.sendMessage(player, Messages.badMaterial);
				return true;
			}
			player.getInventory().addItem(new ItemStack(getMaterial, 1));
			String formatName = StringUtils.capitalize(getMaterial.name().toLowerCase());
			Util.sendMessage(player, Messages.gaveMaterial.replace("{Q}", "1").replace("{M}", formatName).replace("_", ""));
			return true;
		}
		
		if(args.length == 2) {
			Player otherPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(otherPlayer != null) {
				Material getMaterial = Material.getMaterial(args[1].toUpperCase());
				if(getMaterial == null) {
					Util.sendMessage(player, Messages.badMaterial);
					return true;
				}
				otherPlayer.getInventory().addItem(new ItemStack(getMaterial, 1));
				String formatName = StringUtils.capitalize(getMaterial.name().toLowerCase());
				Util.sendMessage(player, Messages.gavePlayerMaterial.replace("{Q}", "1").replace("{M}", formatName).replace("{P}", otherPlayer.getName()).replace("_", ""));
				return true;
			}
			
			Material getMaterial = Material.getMaterial(args[0].toUpperCase());
			if(getMaterial == null) {
				Util.sendMessage(player, Messages.badMaterial);
				return true;
			}
			try {
				player.getInventory().addItem(new ItemStack(getMaterial, Integer.parseInt(args[1])));
				String formatName = StringUtils.capitalize(getMaterial.name().toLowerCase());
				Util.sendMessage(player, Messages.gaveMaterial.replace("{Q}", args[1]).replace("{M}", formatName).replace("_", ""));
			} catch (Exception e) {
				Util.sendMessage(player, Messages.invalidQuantity);
				return true;
			}
			return true;
		}
		
		if(args.length == 3) {
			Player otherPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(otherPlayer == null) {
				Util.sendMessage(player, Messages.invalidPlayer);
				return true;
			}
			
			Material getMaterial = Material.getMaterial(args[1].toUpperCase());
			if(getMaterial == null) {
				Util.sendMessage(player, Messages.badMaterial);
				return true;
			}
			try {
				otherPlayer.getInventory().addItem(new ItemStack(getMaterial, Integer.parseInt(args[2])));
				String formatName = StringUtils.capitalize(getMaterial.name().toLowerCase());
				Util.sendMessage(player, Messages.gavePlayerMaterial.replace("{Q}", args[2]).replace("{M}", formatName).replace("{P}", otherPlayer.getName()).replace("_", ""));
			} catch (Exception e) {
				Util.sendMessage(player, Messages.invalidQuantity);
				return true;
			}
			return true;
		}
		
		Util.sendMessage(player, Messages.invalidArguments);
		Util.sendMessage(player, Util.getCommandUsage(l));
		return true;
	}

}
