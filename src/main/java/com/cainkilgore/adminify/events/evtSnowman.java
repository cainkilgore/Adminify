package com.cainkilgore.adminify.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.cainkilgore.adminify.Util;

public class evtSnowman implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if(!Util.isSnowman(player)) return;
		
		if(!player.getLocation().getBlock().getRelative(0, -1, 0).isLiquid()) {
			player.getLocation().getBlock().setType(Material.SNOW);
		}
		
	}

}
