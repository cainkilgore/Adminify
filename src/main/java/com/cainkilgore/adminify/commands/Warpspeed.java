package com.cainkilgore.adminify.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Warpspeed implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("warpspeed")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "warpspeed")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
		
			if(player.getFlySpeed() == 0.1F) {
				player.setFlySpeed(1.0F);
				player.setWalkSpeed(1.0F);
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 7));
				player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 4));
				
				Util.sendMessage(player, Messages.warpOn);
				player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 6);
				return true;
			}
			
			player.setWalkSpeed(0.2F);
			player.setFlySpeed(0.1F);
			player.removePotionEffect(PotionEffectType.SPEED);
			player.removePotionEffect(PotionEffectType.JUMP);
			Util.sendMessage(player, Messages.warpOff);
			player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 0.1F);
		}
		return true;
	}

}
