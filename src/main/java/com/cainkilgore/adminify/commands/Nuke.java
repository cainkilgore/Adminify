package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Nuke implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(!(s instanceof Player)) {
			Util.print(Messages.noPermission);
			return true;
		}
		
		Player player = (Player) s;
		
		if(!Util.hasPermission(player, "nuke")) {
			Util.sendMessage(player, Messages.noPermission);
			return true;
		}
		
		if(args.length < 1) {
			Util.sendMessage(player, Messages.invalidArguments);
			Util.sendMessage(player, Util.getCommandUsage(l));
			return true;
		}
		
		Player otherPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
		if(otherPlayer == null) {
			Util.sendMessage(player, Messages.invalidPlayer);
			return true;
		}
		
		for(int x = -3; x < 4; x++) {
			for(int z = -3; z < 4; z++) {
				TNTPrimed tnt = player.getWorld().spawn(player.getLocation().getBlock().getRelative(x, 60, z).getLocation(), TNTPrimed.class);
				// tnt.set
			}
		}
		Util.sendMessage(player, Messages.nukeTarget.replace("{P}", otherPlayer.getName()));
		return true;
	}

}
