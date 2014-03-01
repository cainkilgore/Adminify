package com.cainkilgore.adminify.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Tp implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("tp")) {
			if(!(s instanceof Player)) {
				if(args.length < 4) return false;
				
				try {
					Util.teleportPlayer(Adminify.mainClass.getServer().getPlayer(args[0]), new Location(Adminify.mainClass.getServer().getPlayer(args[1]).getWorld(), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])));
				} catch (Exception e) {
				// Unable to teleport.
				}
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			if(args.length == 1) {
				if(!Util.hasPermission(player, "tp")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				Util.teleportPlayer(player, argPlayer.getLocation());
				Util.sendMessage(player, Messages.playerToArg.replace("{P}", argPlayer.getName()));
			}
			
			if(args.length == 2) {
				if(!Util.hasPermission(player, "tp.multi")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				Player oneArg = Adminify.mainClass.getServer().getPlayer(args[0]);
				Player twoArg = Adminify.mainClass.getServer().getPlayer(args[1]);
				
				if(oneArg == null || twoArg == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				oneArg.teleport(twoArg.getLocation());
				Util.sendMessage(player, Messages.player1to2.replace("{P1}", oneArg.getName()).replace("{P2}", twoArg.getName()));
				Util.sendMessage(oneArg, Messages.adminTele1to2.replace("{A}", player.getName()).replace("{P2}", twoArg.getName()));
				if(twoArg == player) return true;
				Util.sendMessage(twoArg, Messages.adminTele2to1.replace("{A}", player.getName()).replace("{P1}", oneArg.getName()));
			}
			
			if(args.length == 3) {
				if(!Util.hasPermission(player, "tp.xyz")) {
					Util.sendMessage(player, Messages.noPermission);
					return true;
				}
				
				try {
					int x = Integer.parseInt(args[0]);
					int y = Integer.parseInt(args[1]);
					int z = Integer.parseInt(args[2]);
					
					Location loc = new Location(player.getWorld(), x, y, z);
					Util.teleportPlayer(player, loc);
					
					Util.sendMessage(player, Messages.TeleXyz.replace("{X}", Integer.toString(x)).replace("{Y}", Integer.toString(y)).replace("{Z}", Integer.toString(z)));
				} catch (NumberFormatException e) {
					Util.sendMessage(player, Messages.badXyz);
				}
			}
		}
		
		return true;
	}

}
