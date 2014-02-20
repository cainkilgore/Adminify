package com.cainkilgore.adminify.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.cainkilgore.adminify.Adminify;

public class evtPing implements Listener {
	
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		if(!Adminify.mainClass.getConfig().getBoolean("settings.chat-ping")) return;
		for(Player online : Bukkit.getServer().getOnlinePlayers()) {
			if(e.getMessage().contains(online.getName())) {
				online.playSound(online.getLocation(), Sound.ORB_PICKUP, 1, 1);
			}
		}
	}

}
