package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Motd implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("motd")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "motd")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			try {
				Util.sendPlayerMOTD(player);
			} catch (Exception e) {
				Util.sendMessage(player, Messages.motdError);
				Util.print(e.getMessage());
			}
//		}
		return true;
	}

}
