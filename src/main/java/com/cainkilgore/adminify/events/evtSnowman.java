package com.cainkilgore.adminify.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Util;

public class evtSnowman implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		final Player player = e.getPlayer();
		if(!Util.isSnowman(player)) return;
		
		if(player.getLocation().getBlock().isLiquid()) return;
		if(player.getLocation().getBlock().getRelative(0, -1, 0).isLiquid()) return;
		// if(!player.getLocation().getBlock().getType().isSolid()) return;
		if(player.getLocation().getBlock().getRelative(0, -1, 0).getType() == Material.SNOW) return;
		if(player.getLocation().getBlock().getType().isSolid()) return;
		if(player.getLocation().getBlock().getTypeId() != 0) return;
		if(player.getLocation().getBlock().getRelative(0, -1, 0).getType() != Material.AIR) {
			final Location r = player.getLocation().getBlock().getLocation();
			player.getLocation().getBlock().setType(Material.SNOW);
			Adminify.mainClass.getServer().getScheduler().runTaskLater(Adminify.mainClass, new Runnable() {
				public void run() {
					player.getWorld().getBlockAt(r).setType(Material.AIR);
				}
			}, 10 * 20);
		}
		
	}

}
