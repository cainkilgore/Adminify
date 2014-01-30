package com.cainkilgore.adminify.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Util;

public class evtLastpos implements Listener {
	
	@EventHandler
	public void onPlayerQuit(final PlayerQuitEvent e) {
		Adminify.mainClass.getServer().getScheduler().runTaskAsynchronously(Adminify.mainClass, new Runnable() {
			public void run() {
				try {
				Util.addLastPos(e.getPlayer(), e.getPlayer().getLocation());
				} catch (Exception e1) {
					Util.print("There was an error saving " + e.getPlayer().getName() + "'s last location.");
					Util.print(e1.getMessage());
				}
			}
		});
	}
	
	@EventHandler
	public void onPlayerTeleport(final PlayerTeleportEvent e) {
		Adminify.mainClass.getServer().getScheduler().runTaskAsynchronously(Adminify.mainClass, new Runnable() {
			public void run() {
				try {
				Util.addLastPos(e.getPlayer(), e.getFrom());
			} catch (Exception e1) {
				Util.print("There was an error saving " + e.getPlayer().getName() + "'s last location.");
				Util.print(e1.getMessage());
			}
		}
		});

	}

}
