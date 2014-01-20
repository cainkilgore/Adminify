package com.cainkilgore.adminify.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class evtMute implements Listener {
	
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		if(Util.isMuted(e.getPlayer())) {
			e.setCancelled(true);
			Util.sendMessage(e.getPlayer(), Messages.cantChat);
		}
	}
	
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		if(Util.isMuted(e.getPlayer())) {
			if(e.getMessage().contains("me")) {
				e.setCancelled(true);
				Util.sendMessage(e.getPlayer(), Messages.cantChat);
			}
		}
	}

}
