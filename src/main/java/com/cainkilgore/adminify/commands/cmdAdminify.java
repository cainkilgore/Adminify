package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class cmdAdminify implements CommandExecutor {
	
	boolean ownerOnline = false;
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("adminify")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			Util.sendMessage(player, Messages.author);
			Util.sendMessage(player, Messages.version + Adminify.mainClass.getDescription().getVersion());
			Util.sendMessage(player, Messages.url);
			Util.sendMessage(player, Messages.supportURL)
			
			for(Player online : Adminify.mainClass.getServer().getOnlinePlayers()) {
				if(online.getName().equalsIgnoreCase("ThatJavaGuy")) {
					ownerOnline = true;
				}
			}
			
			if(ownerOnline) {
				Util.sendMessage(player, Messages.coderOnline);
			}
		}
		return true;
	}

}
