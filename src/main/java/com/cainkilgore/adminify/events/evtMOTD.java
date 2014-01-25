package com.cainkilgore.adminify.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class evtMOTD implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		try {
			Util.sendPlayerMOTD(e.getPlayer());
		} catch (Exception e2) {
			Util.sendMessage(e.getPlayer(), Messages.motdError);
			Util.print(e2.getMessage());
		}
	}

}
