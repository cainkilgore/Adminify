package com.cainkilgore.adminify.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
			Material getMaterial = Material.getMaterial(args[0].split(":")[0].toUpperCase());
			if(getMaterial == null) {
				Util.sendMessage(player, Messages.badMaterial);
				return true;
			}
			short durability = 0;
			
			if(args[0].split(":").length == 2) {
				try {
					durability = Short.parseShort(args[0].split(":")[1]);
				} catch (NumberFormatException e) {
					Util.sendMessage(player, Messages.invalidDataValue);
					return true;
				}
			}
			ItemStack item = new ItemStack(getMaterial, 1);
			item.setDurability(durability);
			player.getInventory().addItem(item);
			String formatName = StringUtils.capitalize(getMaterial.name().toLowerCase());
			Util.sendMessage(player, Messages.gaveMaterial.replace("{Q}", "1").replace("{M}", formatName).replace("_", ""));
			return true;
		}
		
		if(args.length == 2) {
			Player otherPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(otherPlayer != null) {
				Material getMaterial = Material.getMaterial(args[1].split(":")[0].toUpperCase());
				if(getMaterial == null) {
					Util.sendMessage(player, Messages.badMaterial);
					return true;
				}
				short durability = 0;
				if(args[1].split(":").length == 2) {
				try {
					durability = Short.parseShort(args[1].split(":")[1]);
				} catch (NumberFormatException e) {
					Util.sendMessage(player, Messages.invalidDataValue);
					return true;
				}
				}
				ItemStack item = new ItemStack(getMaterial, 1);
				item.setDurability(durability);
				otherPlayer.getInventory().addItem(item);
				String formatName = StringUtils.capitalize(getMaterial.name().toLowerCase());
				Util.sendMessage(player, Messages.gavePlayerMaterial.replace("{Q}", "1").replace("{M}", formatName).replace("{P}", otherPlayer.getName()).replace("_", ""));
				return true;
			}
			
			Material getMaterial = Material.getMaterial(args[0].split(":")[0].toUpperCase());
			if(getMaterial == null) {
				Util.sendMessage(player, Messages.badMaterial);
				return true;
			}
			short durability = 0;
			if(args[0].split(":").length == 2) {
				try {
					durability = Short.parseShort(args[0].split(":")[1]);
				} catch (NumberFormatException e) {
					Util.sendMessage(player, Messages.invalidDataValue);
					return true;
				}
			}
			String itemName = "";
			if(args[1].split(":").length == 2) {
				if(args[1].split(":")[0].equalsIgnoreCase("name")) {
					itemName = args[1].split(":")[1];
				}
			}
			
			if(!itemName.equalsIgnoreCase("")) {
				try {
					ItemStack item = new ItemStack(getMaterial, 1);
					item.setDurability(durability);
					ItemMeta r = item.getItemMeta();
					r.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemName.replace("_", " ")));
					item.setItemMeta(r);
					player.getInventory().addItem(item);
					String formatName = StringUtils.capitalize(getMaterial.name().toLowerCase());
					Util.sendMessage(player, Messages.gaveMaterial.replace("{Q}", "1").replace("{M}", formatName).replace("_", "") + " (" + itemName + ChatColor.RESET + ")");
				} catch (Exception e) {
					Util.sendMessage(player, Messages.invalidQuantity);
				}
				return true;
			}
			
			try {
				ItemStack item = new ItemStack(getMaterial, Integer.parseInt(args[1]));
				item.setDurability(durability);
				player.getInventory().addItem(item);
				String formatName = StringUtils.capitalize(getMaterial.name().toLowerCase());
				Util.sendMessage(player, Messages.gaveMaterial.replace("{Q}", args[1]).replace("{M}", formatName).replace("_", ""));
			} catch (Exception e) {
				Util.sendMessage(player, Messages.invalidQuantity);
				return true;
			}
			return true;
		}
		
		if(args.length >= 3) {
			Player otherPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(otherPlayer == null) {
				Util.sendMessage(player, Messages.invalidPlayer);
				return true;
			}
			
			Material getMaterial = Material.getMaterial(args[1].split(":")[0].toUpperCase());
			if(getMaterial == null) {
				Util.sendMessage(player, Messages.badMaterial);
				return true;
			}
			short durability = 0;
			if(args[1].split(":").length == 2) {
				try {
				durability = Short.parseShort(args[1].split(":")[1]);
				} catch (NumberFormatException e) {
					Util.sendMessage(player, Messages.invalidDataValue);
					return true;
				}
			}
			
			String itemName = "";
			if(args[3].split(":").length == 2) {
				if(args[3].split(":")[0].equalsIgnoreCase("name")) {
					itemName = args[3].split(":")[1];
				}
			}
			
			if(!itemName.equalsIgnoreCase("")) {
				try {
					ItemStack item = new ItemStack(getMaterial, Integer.parseInt(args[2]));
					item.setDurability(durability);
					ItemMeta r = item.getItemMeta();
					r.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemName.replace("_", " ")));
					item.setItemMeta(r);
					otherPlayer.getInventory().addItem(item);
					String formatName = StringUtils.capitalize(getMaterial.name().toLowerCase());
					Util.sendMessage(player, Messages.gavePlayerMaterial.replace("{Q}", args[2]).replace("{M}", formatName).replace("{P}", otherPlayer.getName()).replace("_", ""));
				} catch (Exception e) {
					Util.sendMessage(player, Messages.invalidQuantity);
					return true;
				}
				return true;
			}
			
			try {
				ItemStack item = new ItemStack(getMaterial, Integer.parseInt(args[2]));
				item.setDurability(durability);
				otherPlayer.getInventory().addItem(item);
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
