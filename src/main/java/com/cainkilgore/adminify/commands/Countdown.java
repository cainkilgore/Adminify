package com.cainkilgore.adminify.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class CountdownCommand implements CommandExecutor {
	
	BukkitTask countdown = null;
	
	public boolean onCommand(CommandSender s, Command c, String l, final String [] args) {
//		if(l.equalsIgnoreCase("countdown")) {
			if(!(s instanceof Player)) {
				try {
					Adminify.mainClass.getServer().broadcastMessage(ChatColor.RED + "=========== " + Integer.parseInt(args[0]) + " ===========");
					playDing(false);
					
					Util.delayChat(Integer.parseInt(args[0]));
					
					countdown = Adminify.mainClass.getServer().getScheduler().runTaskTimer(Adminify.mainClass, new Runnable() {
						int count = Integer.parseInt(args[0]);
						public void run() {
							count--;
							playDing(true);
							Adminify.mainClass.getServer().broadcastMessage(ChatColor.RED + "=========== " + count + " ===========");
							if(count <= 0) {
								countdown.cancel();
							}
						}
					}, 20L, 20L);
				} catch (Exception e) {
					Util.print(Messages.error);
				}
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "countdown")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			try {
				int getArg = Integer.parseInt(args[0]);
			} catch (Exception e) {
				Util.sendMessage(player, Messages.invalidCountdown);
				return true;
			}
			
			Adminify.mainClass.getServer().broadcastMessage(ChatColor.RED + "=========== " + Integer.parseInt(args[0]) + " ===========");
			playDing(false);
			
			Util.delayChat(Integer.parseInt(args[0]));
			
			countdown = Adminify.mainClass.getServer().getScheduler().runTaskTimer(Adminify.mainClass, new Runnable() {
				int count = Integer.parseInt(args[0]);
				public void run() {
					count--;
					playDing(true);
					Adminify.mainClass.getServer().broadcastMessage(ChatColor.RED + "=========== " + count + " ===========");
					if(count <= 0) {
						countdown.cancel();
					}
				}
			}, 20L, 20L);
//		}
		return true;
	}
	
	public static void playDing(boolean end) {
		for(Player online : Adminify.mainClass.getServer().getOnlinePlayers()) {
			if(!end) {
				online.playSound(online.getLocation(), Sound.ORB_PICKUP, 1, 1);
			}
			online.playSound(online.getLocation(), Sound.ORB_PICKUP, 3, 1);
		}
	}

}
