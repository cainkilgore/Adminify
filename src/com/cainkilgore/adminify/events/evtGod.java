package com.cainkilgore.adminify.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.cainkilgore.adminify.Util;

public class evtGod implements Listener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if(!Util.hasGod(player)) return;
			e.setCancelled(true);
		}
	}

}
