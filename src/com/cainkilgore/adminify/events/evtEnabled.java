package com.cainkilgore.adminify.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class evtEnabled implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(Util.isFrozen(e.getPlayer())) {
			Util.sendMessage(e.getPlayer(), Messages.joinFrozen);
		}
		if(Util.isMuted(e.getPlayer())) {
			Util.sendMessage(e.getPlayer(), Messages.joinMuted);
		}
	}

}
