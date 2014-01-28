package com.cainkilgore.adminify;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Timers {
	
	public static void vanishTimer() {
		Adminify.mainClass.getServer().getScheduler().runTaskTimer(Adminify.mainClass, new Runnable() {
			public void run() {
				for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()) {
					for(Object vanishPlayers : HashMaps.vanishPlayers.toArray()) {
						if(Util.isVanished(Adminify.mainClass.getServer().getPlayer(vanishPlayers.toString()))) {
							if(!Util.hasPermission(onlinePlayers, "vanish.exempt")) {
								onlinePlayers.hidePlayer(Adminify.mainClass.getServer().getPlayer(vanishPlayers.toString()));
							}
						} else {
							onlinePlayers.showPlayer(Adminify.mainClass.getServer().getPlayer(vanishPlayers.toString()));
						}
					}
				}
			}
		}, 10L, 10L);
	}

}
