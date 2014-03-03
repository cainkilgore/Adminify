package com.cainkilgore.adminify.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Mute implements CommandExecutor {
	
	public static HashMap<String, Integer> mutedTaskID = new HashMap<String, Integer>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("mute")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "mute")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			if(args.length == 1) {
				Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				if(!Util.isMuted(argPlayer)) {
					Util.setMuted(argPlayer, true);
					Util.sendMessage(player, Messages.mutedPlayer.replace("{P}", argPlayer.getName()));
					Util.sendMessage(argPlayer, Messages.adminMute.replace("{A}", player.getName()));
					return true;
				}
				
				Util.setMuted(argPlayer, false);
				Util.sendMessage(player, Messages.unmutedPlayer.replace("{P}", argPlayer.getName()));
				Util.sendMessage(argPlayer, Messages.adminUnmute.replace("{A}", player.getName()));
			}
			
			if(args.length == 2) {
				final Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
				if(argPlayer == null) {
					Util.sendMessage(player, Messages.invalidPlayer);
					return true;
				}
				
				try {
					if(!Util.isMuted(argPlayer)) {
						Util.setMuted(argPlayer, true);
						Util.sendMessage(player, Messages.adminTime.replace("{P}", argPlayer.getName()).replace("{M}", args[1]));
						Util.sendMessage(argPlayer, Messages.timeMuted.replace("{A}", player.getName()).replace("{M}", args[1]));
						BukkitTask muteTask = Adminify.mainClass.getServer().getScheduler().runTaskLater(Adminify.mainClass, new Runnable() {
							public void run() {
								if(argPlayer != null) {
									Util.setMuted(argPlayer, false);
									Util.sendMessage(argPlayer, Messages.unmuted);
								}
							}
						}, 20 * Integer.parseInt(args[1]));
						mutedTaskID.put(argPlayer.getName(), muteTask.getTaskId());
						return true;
					}
					
					Util.setMuted(argPlayer, false);
					Util.sendMessage(player, Messages.unmutedPlayer.replace("{P}", argPlayer.getName()));
					Util.sendMessage(argPlayer, Messages.adminUnmute.replace("{A}", player.getName()));
					Adminify.mainClass.getServer().getScheduler().cancelTask(mutedTaskID.get(argPlayer.getName()));
					mutedTaskID.remove(argPlayer.getName());
				} catch (Exception e) {
					// 
				}
			}
			
//		}
		return true;
	}

}
