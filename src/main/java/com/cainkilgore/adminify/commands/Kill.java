package com.cainkilgore.adminify.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Kill implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("kill")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				if(!Util.hasPermission(player, "kill")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Util.killPlayer(player);
				Util.sendMessage(player, Messages.killSelf);
				return true;
			}
			
			if(args.length == 1) {
				if(!Util.hasPermission(player, "kill.others")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				argPlayer.setGameMode(GameMode.SURVIVAL);
				Util.killPlayer(argPlayer, player);
				Util.sendMessage(player, Messages.adminKill.replace("{P}", argPlayer.getName()));
				Util.sendMessage(argPlayer, Messages.playerKill.replace("{A}", player.getName()));
			}
//		}
		return true;
	}

}
