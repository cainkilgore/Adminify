package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Clear implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				if(!Util.hasPermission(player, "clear")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Util.clearInventory(player);
				Util.sendMessage(player, Messages.clearInv);
				return true;
			}
			
			if(args.length >= 1) {
				if(!Util.hasPermission(player, "clear.others")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				Util.clearInventory(argPlayer);
				Util.sendMessage(player, Messages.playerClear.replace("{P}", argPlayer.getName()));
				Util.sendMessage(argPlayer, Messages.adminClear.replace("{A}", player.getName()));
			}
		return true;
	}

}
