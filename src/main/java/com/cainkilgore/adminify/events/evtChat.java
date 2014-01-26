package com.cainkilgore.adminify.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.cainkilgore.adminify.Util;

public class evtChat implements Listener {
	
	@EventHandler
	public void onPlayerAsyncChat(AsyncPlayerChatEvent e) {
		if(Util.hasPermission(e.getPlayer(), "color")) {
			e.setMessage(ChatColor.translateAlternateColorCodes(ChatColor.COLOR_CHAR, e.getMessage()));
		}
	}

}
