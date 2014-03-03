package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Lastpos implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("lastpos")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				if(!Util.hasPermission(player, "lastpos")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				try {
					Util.teleportPlayer(player, Util.getLastPos(player));
					Util.sendMessage(player, Messages.teleLast);
				} catch (Exception e) {
					Util.sendMessage(player, Messages.teleError);
					Util.print(e.getMessage());
				}
			}
			
			if(args.length == 1) {
				if(!Util.hasPermission(player, "lastpos.others")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				try {
					Util.teleportPlayer(player, Util.getLastPos(argPlayer));
					Util.sendMessage(player, Messages.playerLast.replace("{P}", argPlayer.getName()));
				} catch (Exception e) {
					Util.sendMessage(player, Messages.playerError.replace("{P}", argPlayer.getName()));
					Util.print(e.getMessage());
				}
			}
//		}
		return true;
	}

}
