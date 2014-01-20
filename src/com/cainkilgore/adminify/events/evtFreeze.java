package com.cainkilgore.adminify.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.cainkilgore.adminify.Util;

public class evtFreeze implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		
		Player player = e.getPlayer();
		if(Util.isFrozen(player)) {
			Location freezeLoc = Util.getPlayerFrozenLocation(player);
			
			double x = player.getLocation().getX();
			double y = player.getLocation().getY();
			double z = player.getLocation().getZ();
			float pitch = player.getLocation().getPitch();
			float yaw = player.getLocation().getYaw();
			
			if(freezeLoc.getX() != x || freezeLoc.getY() != y || freezeLoc.getZ() != z) {
				freezeLoc.setPitch(pitch);
				freezeLoc.setYaw(yaw);
				Util.teleportPlayer(player, freezeLoc);
			}
		}
	}

}
