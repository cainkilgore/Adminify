package com.cainkilgore.adminify.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class evtFreeze implements Listener {
	
	@SuppressWarnings("deprecation")
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
				
				if(player.getLocation().getBlock().getRelative(0, -1, 0).getType() == Material.AIR) {
					player.sendBlockChange(player.getLocation().getBlock().getRelative(0, -1, 0).getLocation(), Material.GLASS, (byte) 1);
				}
			}
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(Util.isFrozen(e.getPlayer())) {
			e.setCancelled(true);
			Util.sendMessage(e.getPlayer(), Messages.breakBlocks);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(Util.isFrozen(e.getPlayer())) {
			e.setCancelled(true);
			Util.sendMessage(e.getPlayer(), Messages.placeBlocks);
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(Util.isFrozen(e.getPlayer())) {
			e.setCancelled(true);
			if(e.getClickedBlock() == null) return;
			
			Util.sendMessage(e.getPlayer(), Messages.interactBlocks.replace("{B}", e.getClickedBlock().getType().name().toLowerCase()));
		}
	}

}
