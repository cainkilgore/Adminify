package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class God implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("god")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				if(!Util.hasPermission(player, "god")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				if(!Util.hasGod(player)) {
					Util.setGod(player, true);
					Util.sendMessage(player, Messages.isGod);
					return true;
				}
				Util.setGod(player, false);
				Util.sendMessage(player, Messages.notGod);
				return true;
			}
			
			if(args.length == 1) {
				if(!Util.hasPermission(player, "god.others")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				if(!Util.hasGod(argPlayer)) {
					Util.setGod(argPlayer, true);
					Util.sendMessage(player, Messages.playerGod.replace("{P}", argPlayer.getName()));
					Util.sendMessage(argPlayer, Messages.adminGod.replace("{A}", player.getName()));
					return true;
				}
				Util.setGod(argPlayer, false);
				Util.sendMessage(player, Messages.playerNotGod.replace("{P}", argPlayer.getName()));
				Util.sendMessage(argPlayer, Messages.adminNotGod.replace("{A}", player.getName()));
				return true;
			}
		}
		return true;
	}

}
