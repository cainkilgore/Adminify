package com.cainkilgore.adminify.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Gm implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("gm")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
					if(args.length == 1) {
						if(!Util.hasPermission(player, "gamemode.creative")) {
							Util.sendMessage(player, Messages.noPermission);
							return true;
						}
						
						player.setGameMode(GameMode.CREATIVE);
						Util.sendMessage(player, Messages.gameModeSet.replace("{G}", "creative"));
					}
					
					if(args.length == 2) {
						if(!Util.hasPermission(player, "gamemode.creative.others")) {
							Util.sendMessage(player, Messages.noPermission);
							return true;
						}
						
						Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[1]);
						if(argPlayer == null) {
							Util.sendMessage(player, Messages.invalidPlayer);
							return true;
						}
						argPlayer.setGameMode(GameMode.CREATIVE);
						Util.sendMessage(player, Messages.gameModePlayerSet.replace("{P}", argPlayer.getName()).replace("{G}", "creative"));
						Util.sendMessage(argPlayer, Messages.gameModeAdmin.replace("{A}", player.getName()).replace("{G}", "creative"));
					}
				}
				
				if(args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
					if(args.length == 1) {
						if(!Util.hasPermission(player, "gamemode.survival")) {
							Util.sendMessage(player, Messages.noPermission);
							return true;
						}
						
						player.setGameMode(GameMode.SURVIVAL);
						Util.sendMessage(player, Messages.gameModeSet.replace("{G}", "survival"));
					}
					
					if(args.length == 2) {
						if(!Util.hasPermission(player, "gamemode.survival.others")) {
							Util.sendMessage(player, Messages.noPermission);
							return true;
						}
						
						Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[1]);
						if(argPlayer == null) {
							Util.sendMessage(player, Messages.invalidPlayer);
							return true;
						}
						argPlayer.setGameMode(GameMode.SURVIVAL);
						Util.sendMessage(player, Messages.gameModePlayerSet.replace("{P}", argPlayer.getName()).replace("{G}", "survival"));
						Util.sendMessage(argPlayer, Messages.gameModeAdmin.replace("{A}", player.getName()).replace("{G}", "survival"));
					}
				}
				
				if(args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
					if(args.length == 1) {
						if(!Util.hasPermission(player, "gamemode.adventure")) {
							Util.sendMessage(player, Messages.noPermission);
							return true;
						}
						
						player.setGameMode(GameMode.ADVENTURE);
						Util.sendMessage(player, Messages.gameModeSet.replace("{G}", "adventure"));
					}
					
					if(args.length == 2) {
						if(!Util.hasPermission(player, "gamemode.adventure.others")) {
							Util.sendMessage(player, Messages.noPermission);
							return true;
						}
						
						Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[1]);
						if(argPlayer == null) {
							Util.sendMessage(player, Messages.invalidPlayer);
							return true;
						}
						argPlayer.setGameMode(GameMode.ADVENTURE);
						Util.sendMessage(player, Messages.gameModePlayerSet.replace("{P}", argPlayer.getName()).replace("{G}", "adventure"));
						Util.sendMessage(argPlayer, Messages.gameModeAdmin.replace("{A}", player.getName()).replace("{G}", "adventure"));
					}
				}
			}
		}
		return true;
	}

}
