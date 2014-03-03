package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Playerinfo implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("playerinfo")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "playerinfo")) {
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
			
			Util.sendMessage(player, Messages.playerInfo.replace("{P}", argPlayer.getName()));
			Util.sendMessage(player, Messages.playerInfoWorld.replace("{W}", argPlayer.getWorld().getName()));
			Util.sendMessage(player, Messages.playerInfoX.replace("{X}", Double.toString(argPlayer.getLocation().getX())));
			Util.sendMessage(player, Messages.playerInfoY.replace("{Y}", Double.toString(argPlayer.getLocation().getY())));
			Util.sendMessage(player, Messages.playerInfoZ.replace("{Z}", Double.toString(argPlayer.getLocation().getZ())));
			Util.sendMessage(player, Messages.playerInfoIP.replace("{IP}", argPlayer.getAddress().getAddress().toString()));
//		}
		return true;
	}

}
