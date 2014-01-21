package com.cainkilgore.adminify;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Util {
	
	public static void print(String message) {
		System.out.println("Adminify > " + message);
	}
	
	public static void registerCommand(String command, CommandExecutor executor) {
		Adminify.mainClass.getServer().getPluginCommand(command).setExecutor(executor);
	}
	
	public static void registerEvent(Listener listener) {
		Adminify.mainClass.getServer().getPluginManager().registerEvents(listener, Adminify.mainClass);
	}
	
	public static boolean hasPermission(Player player, String permission) {
		if(player.hasPermission("adminify." + permission)) {
			return true;
		}
		return false;
	}
	
	public static void sendMessage(Player player, String message) {
		player.sendMessage(message);
	}
	
	public static String getCommandUsage(String command) {
		return Messages.errorPrefix + "Usage: " + Adminify.mainClass.getServer().getPluginCommand(command).getUsage().replace("<command>", command);
	}
	
	// Frozen Usage
	
	public static boolean isFrozen(Player player) {
		if(HashMaps.frozenPlayers.containsKey(player.getName())) {
			return true;
		}
		return false;
	}
	
	public static void setFrozen(Player player, boolean frozen) {
		if(frozen) {
			HashMaps.frozenPlayers.put(player.getName(), player.getLocation());
		} else {
			HashMaps.frozenPlayers.remove(player.getName());
		}
	}
	
	public static Location getPlayerFrozenLocation(Player player) {
		return HashMaps.frozenPlayers.get(player.getName());
	}
	
	public static void teleportPlayer(Player player, Location location) {
		player.teleport(location);
	}
	
	// Mute Usage
	
	public static boolean isMuted(Player player) {
		if(HashMaps.mutedPlayers.contains(player.getName())) {
			return true;
		}
		return false;
	}
	
	public static void setMuted(Player player, boolean muted) {
		if(muted) {
			HashMaps.mutedPlayers.add(player.getName());
		} else {
			HashMaps.mutedPlayers.remove(player.getName());
		}
	}
	
	// Fly Usage
	
	public static boolean canFly(Player player) {
		if(player.isFlying()) {
			return true;
		}
		return false;
	}
	
	public static void setFlying(Player player, boolean flying) {
		if(flying) {
			player.setAllowFlight(true);
			player.setFlying(true);
		} else {
			player.setAllowFlight(false);
			player.setFlying(false);
		}
	}
	
	public static boolean hasGod(Player player) {
		if(HashMaps.godPlayers.contains(player.getName())) {
			return true;
		}
		return false;
	}
	
	public static void setGod(Player player, boolean god) {
		if(god) {
			HashMaps.godPlayers.add(player.getName());
		} else {
			HashMaps.godPlayers.remove(player.getName());
		}
	}
	
	public static boolean isTimeValid(String time) {
		if(time.equalsIgnoreCase("day")) {
			return true;
		}
		if(time.equalsIgnoreCase("night")) {
			return true;
		}
		return false;
	}
	
	public static int getTimeFromString(String time) {
		if(time.equalsIgnoreCase("day")) {
			return 0;
		}
		if(time.equalsIgnoreCase("night")) {
			return 12200;
		}
		return 0;
	}
	
	public static void setWorldTime(Player player, int time) {
		player.getWorld().setTime(time);
	}
	
	public static void setPlayerHealth(Player player, double health) {
		player.setHealth(health);
	}
	
	public static void hitPlayer(Player player) {
		Random r = new Random();
		int random = r.nextInt(5);
		if(random < 1) {
			random = r.nextInt(5);
		}
		player.damage(random);
	}
	
	public static void clearInventory(Player player) {
		player.getInventory().clear();
	}

}
