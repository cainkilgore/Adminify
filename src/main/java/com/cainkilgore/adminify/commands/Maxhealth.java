package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Maxhealth implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("maxhealth")) {
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
			
			if(args.length == 1) {
				try {
					player.setMaxHealth(Integer.parseInt(args[0]));
					Util.sendMessage(player, Messages.maxHealth.replace("{H}", args[0]));
					return true;
				} catch (Exception e) {
					Util.sendMessage(player, Messages.badHealth);
					return true;
				}
			}
			
			if(args.length == 2) {
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				try {
					argPlayer.setMaxHealth(Integer.parseInt(args[1]));
					Util.sendMessage(player, Messages.playerHealthSet.replace("{P}", argPlayer.getName()).replace("{H}", args[1]));
					Util.sendMessage(argPlayer, Messages.adminHealthSet.replace("{A}", player.getName()).replace("{H}", args[1]));
					return true;
				} catch (Exception e) {
					Util.sendMessage(player, Messages.badHealth);
				}
			}
		}
		return true;
	}

}
