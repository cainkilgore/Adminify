package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Tpa implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("tpa")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			final Player player = (Player) s;
			
			if(!Util.hasPermission(player, "tpa")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			final Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(argPlayer == null) {
				Util.sendMessage(player, Messages.invalidPlayer);
				return true;
			}
			
			if(Util.alreadySentRequest(player)) {
				Util.sendMessage(player, Messages.alreadySent);
				return true;
			}
			
			if(Util.isPendingRequest(argPlayer)) {
				Util.sendMessage(player, Messages.alreadySentPlayer.replace("{P}", argPlayer.getName()));
				return true;
			}
			
			Util.addTeleportRequest(player, argPlayer);
			Util.sendMessage(player, Messages.requestSent.replace("{P}", argPlayer.getName()));
			Util.sendMessage(argPlayer, Messages.requestReceived.replace("{P}", player.getName()));
			Util.sendMessage(argPlayer, Messages.requestUsage.replace("{P}", player.getName()));
			
			Adminify.mainClass.getServer().getScheduler().runTaskLater(Adminify.mainClass, new Runnable() {
				public void run() {
					Util.removeTeleportRequest(player, argPlayer);
				}
			}, 20 * 60);
		}
		return true;
	}

}
