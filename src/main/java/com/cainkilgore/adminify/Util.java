package com.cainkilgore.adminify;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import com.cainkilgore.adminify.commands.Ride;
import com.cainkilgore.adminify.events.evtAlert;

public class Util {
	
	public static ArrayList<String> pluginCommands = new ArrayList<String>();
	
	public static void print(String message) {
		System.out.println("Adminify > " + message);
	}
	
	public static void registerCommand(String command, CommandExecutor executor) {
		if(Adminify.mainClass.getConfig().options().header() == null) {
			Adminify.mainClass.getConfig().options().header("Welcome to the Adminify Configuration!\nHere you can customize some things, including toggling on and off commands.\nPlease make sure to follow the same format, as one mistake could end up\nresetting your configuration file. ~ Cain\n");
			Adminify.mainClass.saveConfig();
		}
		if(Adminify.mainClass.getConfig().get("commands." + command) == null) {
			Adminify.mainClass.getConfig().set("commands." + command, true);
			Adminify.mainClass.saveConfig();
		}
		
		if(Adminify.mainClass.getConfig().getBoolean("commands." + command)) {
			Adminify.mainClass.getServer().getPluginCommand("adminify_" + command).setExecutor(executor);
			pluginCommands.add(command);
			print("Successfully registered command /" + command);
		}
	}
	
	public static void sendAdminMessage(Player player, String message) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', Adminify.mainClass.getConfig().getString("settings.adminify-prefix")) + "Alert> " + ChatColor.RESET + message);
	}
	
	public static void sendAdminMessage(Player player, Player sender, String message) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', Adminify.mainClass.getConfig().getString("settings.adminify-prefix")) + "Alert from " + sender.getName() + "> " + ChatColor.RESET + message);
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
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
	
	public static String getCommandUsage(String command) {
		return Messages.errorPrefix + "Usage: " + Adminify.mainClass.getServer().getPluginCommand(command).getUsage().replace("<command>", command).replace("adminify_", "");
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
	
	// God Usage
	
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
	
	//  Time Usage
	
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
			return 14400;
		}
		if(time.equalsIgnoreCase("sunset")) {
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
	
	//Hit Usage
	
	public static void hitPlayer(Player player) {
		Random r = new Random();
		int random = r.nextInt(5);
		if(random < 1) {
			random = r.nextInt(5);
		}
		player.damage(random);
	}
	
	
	// Clear Usage
	public static void clearInventory(Player player) {
		player.getInventory().clear();
	}
	
	
	// Kill Usage 
	
	public static void killPlayer(Player player, Player damager) {
		player.damage(player.getMaxHealth(), damager);
	}
	
	public static void killPlayer(Player player) {
		player.damage(player.getMaxHealth());
	}
	
	// Vanish Usage
	
	public static boolean isVanished(Player player) {
		if(HashMaps.vanishPlayers.contains(player.getName())) {
			return true;
		}
		return false;
	}
	
	public static void setVanished(Player player, boolean vanished) {
		if(vanished) {
			HashMaps.vanishPlayers.add(player.getName());
		} else {
			HashMaps.vanishPlayers.remove(player.getName());
		}
	}
	
	public static void setAllVanished(boolean vanished) {
		for(Player players : Adminify.mainClass.getServer().getOnlinePlayers()) {
			if(vanished) {
				if(!hasPermission(players, "vanish.exempt")) {
					players.hidePlayer(players);
				}
			} else {
				players.showPlayer(players);
			}
		}
	}
	
	// /alert usage
	public static void broadcastUnformatted(String message) {
		Adminify.mainClass.getServer().broadcastMessage(message);
	}
	
	public static void delayChat(int seconds) {
		evtAlert.r = Adminify.mainClass.getServer().getScheduler().runTaskLater(Adminify.mainClass, new Runnable() {
			public void run() {
				evtAlert.r = null;
			}	
		}, seconds * 20);
	}
	
	public static void strikePlayer(Player player) {
		player.getWorld().strikeLightning(player.getLocation());
	}
	
	public static void sendPrivateMsg(Player one, Player two, String message) {
		one.sendMessage(Messages.msgToPrefix.replace("{P}", two.getName()).replace("{M}", message));
		two.sendMessage(Messages.msgFromPrefix.replace("{P}", one.getName()).replace("{M}", message));
		print(one.getName() + " to " + two.getName() + "> " + message);
	}
	
	public static void replenishHunger(Player player) {
		player.setFoodLevel(20);
	}
	
	public static void setSelecting(Player player, boolean is) {
		if(is) { 
			Ride.ridePlayers.add(player.getName());
		} else {
			Ride.ridePlayers.remove(player.getName());
		}
	}
	
	public static boolean isSelecting(Player player) {
		if(Ride.ridePlayers.contains(player.getName())) {
			return true;
		}
		return false;
	}
	
	public static void broadcastMOTD() throws IOException {
		File file = new File("plugins/Adminify/motd.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		for(Object line : FileUtils.readLines(file)) {
			Util.broadcastUnformatted(ChatColor.translateAlternateColorCodes('&', line.toString()));
		}
	}
	
	public static void sendPlayerMOTD(Player player) throws IOException {
		File file = new File("plugins/Adminify/motd.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		for(Object line : FileUtils.readLines(file)) {
			Util.sendMessage(player, ChatColor.translateAlternateColorCodes('&', line.toString()));
		}
	}
	
	public static void setSnowman(Player player, boolean snowman) {
		if(snowman) {
			HashMaps.snowPlayers.add(player.getName());
		} else {
			HashMaps.snowPlayers.remove(player.getName());
		}
	}
	
	public static boolean isSnowman(Player player) {
		if(HashMaps.snowPlayers.contains(player.getName())) {
			return true;
		}
		return false;
	}
	
	public static void addTeleportRequest(Player one, Player two) {
		HashMaps.requestPlayers.put(one.getName(), two.getName());
	}
	
	public static void removeTeleportRequest(Player one, Player two) {
		HashMaps.requestPlayers.remove(one.getName());
		HashMaps.alreadySentPlayers.remove(two.getName());
	}
	
	public static boolean isPendingRequest(Player player) {
		if(HashMaps.requestPlayers.containsKey(player.getName())) {
			return true;
		}
		return false;
	}
	
	public static boolean alreadySentRequest(Player player) {
		if(HashMaps.alreadySentPlayers.contains(player.getName())) {
			return true;
		}
		return false;
	}
	
	public static void spawnFireworkEntity(Location loc, Color color, Type type, int power, boolean flicker, boolean trail) {
		Firework fw = Bukkit.getServer().getWorld("world").spawn(loc, Firework.class);
		FireworkMeta fwm = fw.getFireworkMeta();
		FireworkEffect effect = FireworkEffect.builder().withColor(color).with(type).flicker(flicker).trail(trail).build();
		fwm.addEffects(effect);
		fwm.setPower(power);       
		fw.setFireworkMeta(fwm);
	}
	
	public static boolean isHoldingKickstick(Player player) {
		if(player.getInventory().getItemInHand() == null) return false;
		if(player.getInventory().getItemInHand().getItemMeta() == null) return false;
		if(player.getInventory().getItemInHand().getItemMeta().getDisplayName() == null) return false;
		
		if(player.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kick Stick")) {
			return true;
		}
		return false;
	}
	
	public static void setDisplayName(ItemStack type, String name) {
		ItemMeta meta = type.getItemMeta();
		meta.setDisplayName(name);
		type.setItemMeta(meta);
	}
	
	public static void setLore(ItemStack type, String name) {
		ItemMeta meta = type.getItemMeta();
		ArrayList<String> list = new ArrayList<String>();
		list.add(name);
		meta.setLore(list);
		type.setItemMeta(meta);
	}
	
	/*
	 * ANY CODES BELOW THIS ARE ENTIRELY FOR DATABASE PURPOSES. 
	 */
	
	
	public static void addLastPos(Player player, Location loc) throws Exception {
		boolean alreadyExists = false;
		Class.forName("org.sqlite.JDBC");
		ResultSet r = null;
		Connection conn = DriverManager.getConnection("jdbc:sqlite:plugins/Adminify/adminify.db");
		PreparedStatement stat = null;
		Statement insert = null;
		try {
			try {
			
				stat = conn.prepareStatement("select * from lastpos where player = '" + player.getName() + "';");
				insert = conn.createStatement();
				r = stat.executeQuery();
				while(r.next()) {
					if(r.getString(1).equalsIgnoreCase(player.getName())) {
						alreadyExists = true;
					}
				}
			} catch (Exception e) {
				Util.print("Error whilst looking through database.");
				Util.print(e.getMessage());
			}
			
			if(alreadyExists == true) {
				try {
					insert.executeUpdate("update lastpos set x = '" + loc.getX() + "' where player = '" + player.getName() + "';");
					insert.executeUpdate("update lastpos set y = '" + loc.getY() + "' where player = '" + player.getName() + "';");
					insert.executeUpdate("update lastpos set z = '" + loc.getZ() + "' where player = '" + player.getName() + "';");
					insert.executeUpdate("update lastpos set world='" + player.getWorld().getName() + "' where player = '" + player.getName() + "';");
				} catch (SQLException e) {
					Util.print(e.getMessage());
				}
			} else {
			alreadyExists = true;
			try {
				insert.executeUpdate("insert into lastpos(player, x, y, z, world) values"
									+ "('" + player.getName() + "', '" + loc.getX() + "', "
									+ "'" + loc.getY() + "', "
									+ "'" + loc.getZ() + "', "
									+ "'" + player.getWorld().getName() + "');");
			} catch (SQLException e) {
				Util.print(e.getMessage());
			}
			}
		} finally {
			r.close();
			stat.close();
			conn.close();
		}
	}
	
	public static Location getLastPos(Player player) throws Exception {
		Class.forName("org.sqlite.JDBC");
		ResultSet r = null;
		Connection conn = DriverManager.getConnection("jdbc:sqlite:plugins/Adminify/adminify.db");
		
		double x = 0;
		double y = 0;
		double z = 0;
		String world = "";
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement("select * from lastpos where player = '" + player.getName() + "';");
			r = stat.executeQuery();
			while(r.next()) {
				if(r.getString(1).equalsIgnoreCase(player.getName())) {
					x = Double.parseDouble(r.getString(2));
					y = Double.parseDouble(r.getString(3));
					z = Double.parseDouble(r.getString(4));
					world = r.getString(5);					
					}
			}
		} catch (Exception e) {
			Util.print("Error whilst looking through database.");
			Util.print(e.getMessage());
		} finally {
			r.close();
			stat.close();
			conn.close();
		}
		
		return new Location(Adminify.mainClass.getServer().getWorld(world), x, y, z);
	}
	
	/* HOME */ 
	public static void addHome(Player player, Location loc) throws Exception {
		boolean alreadyExists = false;
		Class.forName("org.sqlite.JDBC");
		ResultSet r = null;
		Connection conn = DriverManager.getConnection("jdbc:sqlite:plugins/Adminify/adminify.db");
		PreparedStatement stat = null;
		Statement insert = null;
		try {
			try {
			
				stat = conn.prepareStatement("select * from homes where player = '" + player.getName() + "';");
				insert = conn.createStatement();
				r = stat.executeQuery();
				while(r.next()) {
					if(r.getString(1).equalsIgnoreCase(player.getName())) {
						alreadyExists = true;
					}
				}
			} catch (Exception e) {
				Util.print("Error whilst looking through database.");
				Util.print(e.getMessage());
			}
			
			if(alreadyExists == true) {
				try {
					insert.executeUpdate("update homes set x = '" + loc.getX() + "' where player = '" + player.getName() + "';");
					insert.executeUpdate("update homes set y = '" + loc.getY() + "' where player = '" + player.getName() + "';");
					insert.executeUpdate("update homes set z = '" + loc.getZ() + "' where player = '" + player.getName() + "';");
					insert.executeUpdate("update homes set world='" + player.getWorld().getName() + "' where player = '" + player.getName() + "';");
				} catch (SQLException e) {
					Util.print(e.getMessage());
				}
			} else {
			alreadyExists = true;
			try {
				insert.executeUpdate("insert into homes(player, x, y, z, world) values"
									+ "('" + player.getName() + "', '" + loc.getX() + "', "
									+ "'" + loc.getY() + "', "
									+ "'" + loc.getZ() + "', "
									+ "'" + player.getWorld().getName() + "');");
			} catch (SQLException e) {
				Util.print(e.getMessage());
			}
			}
		} finally {
			r.close();
			stat.close();
			conn.close();
		}
	}
	
	public static Location getHome(Player player) throws Exception {
		Class.forName("org.sqlite.JDBC");
		ResultSet r = null;
		Connection conn = DriverManager.getConnection("jdbc:sqlite:plugins/Adminify/adminify.db");
		
		double x = 0;
		double y = 0;
		double z = 0;
		String world = "";
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement("select * from homes where player = '" + player.getName() + "';");
			r = stat.executeQuery();
			while(r.next()) {
				if(r.getString(1).equalsIgnoreCase(player.getName())) {
					x = Double.parseDouble(r.getString(2));
					y = Double.parseDouble(r.getString(3));
					z = Double.parseDouble(r.getString(4));
					world = r.getString(5);					
					}
			}
		} catch (Exception e) {
			Util.print("Error whilst looking through database.");
			Util.print(e.getMessage());
		} finally {
			r.close();
			stat.close();
			conn.close();
		}
		
		return new Location(Adminify.mainClass.getServer().getWorld(world), x, y, z);
	}
	
	

}
