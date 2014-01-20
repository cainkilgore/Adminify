package com.cainkilgore.adminify;

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

}
