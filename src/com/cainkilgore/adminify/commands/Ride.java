package com.cainkilgore.adminify.commands;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Ride implements CommandExecutor {
	
	public static HashSet<String> ridePlayers = new HashSet<String>();
	public static HashMap<String, Integer> entity1 = new HashMap<String, Integer>();
	
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("ride")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "ride")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(!Util.isSelecting(player)) {
				Util.setSelecting(player, true);
				Util.sendMessage(player, Messages.selectingOn);
				return true;
			}
			
			Util.setSelecting(player, false);
			entity1.remove(player.getName());
			Util.sendMessage(player, Messages.selectingOff);
		}
		return true;
	}

}
