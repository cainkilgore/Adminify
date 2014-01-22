package com.cainkilgore.adminify.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.cainkilgore.adminify.Util;

public class evtLastpos implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		try {
			Util.addLastPos(e.getPlayer());
		} catch (Exception e1) {
			Util.print("There was an error saving " + e.getPlayer().getName() + "'s last location.");
			Util.print(e1.getMessage());
		}
	}

}
