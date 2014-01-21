package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Heal implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("heal")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				if(!Util.hasPermission(player, "heal")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Util.setPlayerHealth(player, player.getMaxHealth());
				Util.sendMessage(player, Messages.healthMax);
			}
			
			if(args.length == 1) {
				if(!Util.hasPermission(player, "heal.others")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				Util.setPlayerHealth(argPlayer, argPlayer.getMaxHealth());
				Util.sendMessage(player, Messages.adminHealth.replace("{P}", argPlayer.getName()));
				Util.sendMessage(argPlayer, Messages.playerHealth.replace("{A}", player.getName()));
				return true;
			}
		}
		return true;
	}

}
