package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Fireball implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(!(s instanceof Player)) {
			Util.print(Messages.noConsole);
			return true;
		}
		
		Player player = (Player) s;
		
		if(!Util.hasPermission(player, "fireball")) {
			Util.sendMessage(player, Messages.noPermission);
			return true;
		}
		
		if(args.length < 1) {
			player.launchProjectile(LargeFireball.class);
			return true;
		}
		
		if(args[0].equalsIgnoreCase("-a")) {
			LargeFireball fireball = player.getWorld().spawn(player.getTargetBlock(null, 0).getRelative(0, 30, 0).getLocation(), LargeFireball.class);
			fireball.setVelocity(new Vector(0, -4, 0));
		}
		return true;
	}

}
