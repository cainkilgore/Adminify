package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Admin implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(!(s instanceof Player)) {
			Util.print(Messages.noConsole);
			return true;
		}
		
		Player player = (Player) s;
		
		if(!Util.hasPermission(player, "admin")) {
			Util.sendMessage(player, Messages.noPermission);
			return true;
		}
		
		if(args.length < 1) {
			Util.sendMessage(player, Messages.invalidArguments);
			Util.sendMessage(player, Util.getCommandUsage(l));
			return true;
		}
		
		StringBuilder x = new StringBuilder();
		for(int i = 0; i < args.length; i++) {
			x.append(args[i] + " ");
		}
		
		for(Player online : Adminify.mainClass.getServer().getOnlinePlayers()) {
			if(Util.hasPermission(online, "receive-admin-messages")) {
				Util.sendAdminMessage(online, player, x.toString());
			}
		}
		
		Util.sendMessage(player, Messages.alertSent);
		return true;
	}

}
