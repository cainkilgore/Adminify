package com.cainkilgore.adminify.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;
import com.cainkilgore.adminify.commands.Ride;

public class evtRide implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
		Player player = e.getPlayer();
		Entity entity = e.getRightClicked();
		String entityName = null;
		if(!Util.isSelecting(player)) return;
		
		if(Ride.entity1.get(player.getName()) == null) {
			Ride.entity1.put(player.getName(), entity.getEntityId());
			entityName = entity.getType().getName();
			Util.sendMessage(player, Messages.selected.replace("{E}", entityName));
			return;
		}
		
		for(Entity entities : player.getWorld().getEntities()) {
			if(entities.getEntityId() == Ride.entity1.get(player.getName())) {
				entity.setPassenger(entities);
			}
		}
		
		Util.sendMessage(player, Messages.nowRiding);
		Ride.entity1.remove(player.getName());
		Util.setSelecting(player, false);
	}

}
