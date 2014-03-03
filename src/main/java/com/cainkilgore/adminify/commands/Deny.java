package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Deny implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("deny")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "deny")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(argPlayer == null) {
				Util.sendMessage(player, Messages.invalidPlayer);
				return true;
			}
			
			if(!Util.isPendingRequest(player)) {
				Util.sendMessage(player, Messages.noRequest);
				return true;
			}
			
//			if(!Util.alreadySentRequest(argPlayer)) {
//				Util.sendMessage(player, Messages.notSentRequest);
//				return true;
//			}
			
			Util.sendMessage(player, Messages.deniedTeleport.replace("{P}", argPlayer.getName()));
			Util.sendMessage(argPlayer, Messages.deniedPlayer.replace("{P}", player.getName()));
			
			Util.removeTeleportRequest(argPlayer, player);
//		}
		return true;
	}

}
