package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Changerp implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(!(s instanceof Player)) {
			Util.print(Messages.noConsole);
			return true;
		}
		
		Player player = (Player) s;
		
		if(!Util.hasPermission(player, "changerp")) {
			Util.sendMessage(player, Messages.noPermission);
			return true;
		}
		
		if(args.length < 1) {
			Util.sendMessage(player, Messages.invalidArguments);
			Util.sendMessage(player, Util.getCommandUsage(l));
			return true;
		}
		
		if(args.length == 1) {
			String url = args[0];
			player.setResourcePack(url);
			Util.sendMessage(player, Messages.resourcePack);
		}
		
		if(args.length == 2) {
			Player otherPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(otherPlayer == null) {
				Util.sendMessage(player, Messages.invalidPlayer);
				return true;
			}
			String url = args[1];
			otherPlayer.setResourcePack(url);
			Util.sendMessage(player, Messages.resourcePack);
		}
		return true;
	}

}
