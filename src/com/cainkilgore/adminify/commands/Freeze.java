package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Freeze implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("freeze")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "freeze")) {
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
			
			if(!Util.isFrozen(argPlayer)) {
				Util.setFrozen(argPlayer, true);
				Util.sendMessage(player, Messages.nowFrozen.replace("{U}", argPlayer.getName()));
				Util.sendMessage(argPlayer, Messages.selfFroze.replace("{A}", player.getName()));
				return true;
			}
			
			Util.setFrozen(argPlayer, false);
			Util.sendMessage(player, Messages.unFrozen.replace("{U}", argPlayer.getName()));
			Util.sendMessage(argPlayer, Messages.selfUnfrozen.replace("{A}", player.getName()));
		}
		
		return true;
	}

}
