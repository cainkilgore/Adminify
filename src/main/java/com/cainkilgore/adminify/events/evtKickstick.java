package com.cainkilgore.adminify.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class evtKickstick implements Listener {
	
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
		Player clicker = e.getPlayer();
		if(!Util.isHoldingKickstick(clicker)) return;
		if(!Util.hasPermission(clicker, "kickstick")) return;
		
		if(e.getRightClicked() instanceof Player) {
			Player clicked = (Player) e.getRightClicked();
			clicked.kickPlayer(Messages.kickedByStick.replace("{A}", clicker.getName()));
			Util.sendMessage(clicker, Messages.adminKickStick.replace("{P}", clicked.getName()));
		}
	}

}
