package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Fly implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("fly")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
//			if(Adminify.mainClass.getServer().getAllowFlight() == false) {			// Turns out it's just player-based errors, not server.
//				Util.sendMessage(player, Messages.needFlyEnabled);					// Keep it for the future just in case something
//				return true;														// Doesn't exactly turn out the best.
//			}																		// - Cain
			
			if(args.length < 1) {
				if(!Util.hasPermission(player, "fly")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				if(!Util.canFly(player)) {
					Util.setFlying(player, true);
					Util.sendMessage(player, Messages.isFlying);
					return true;
				}
				
				Util.setFlying(player, false);
				Util.sendMessage(player, Messages.notFlying);
				return true;
			}
			
			if(args.length == 1) {
				
				if(args[0].equalsIgnoreCase("?")) {
					Util.sendMessage(player, Util.getCommandUsage(l));
					return true;
				}
				
				if(!Util.hasPermission(player, "fly.others")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				if(!Util.canFly(argPlayer)) {
					Util.setFlying(argPlayer, true);
					Util.sendMessage(player, Messages.adminIsFlying.replace("{P}", argPlayer.getName()));
					Util.sendMessage(argPlayer, Messages.playerIsFlying.replace("{A}", player.getName()));
					return true;
				}
				
				Util.setFlying(argPlayer, false);
				Util.sendMessage(player, Messages.adminNotFlying.replace("{P}", argPlayer.getName()));
				Util.sendMessage(argPlayer, Messages.playerNotFlying.replace("{A}", player.getName()));
				return true;
			}
//		}
		return true;
	}

}
