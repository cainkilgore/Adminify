package com.cainkilgore.adminify;

import org.bukkit.ChatColor;

public class Messages {
	
	public static String messagePrefix = ChatColor.BLUE + "Adminify> " + ChatColor.WHITE;
	public static String errorPrefix = ChatColor.RED + "Error> " + ChatColor.WHITE;
	
	// Console Messages
	public static String noConsole = "No commands work in console right now. They will in future versions.";
	
	// Player Messages
	public static String invalidPlayer = errorPrefix + "The player you specified does not exist.";
	public static String noPermission = errorPrefix + "You do not have permission to run this command.";
	public static String invalidArguments = errorPrefix + "You have specified invalid arguments for this command.";
	
	// Frozen Command
	public static String nowFrozen = messagePrefix + "{U} has now been frozen in their spot.";
	public static String selfFroze = messagePrefix + "{A} has frozen you.";
	public static String unFrozen = messagePrefix + "{U} has now been freed.";
	public static String selfUnfrozen = messagePrefix + "{A} has freed you.";
	
	// Teleport Command
	public static String playerToArg = messagePrefix + "You teleported to {P}.";
	public static String argToPlayer = messagePrefix + "{P} teleported you to them.";
	
	public static String player1to2 = messagePrefix + "You have teleported {P1} to {P2}.";
	public static String adminTele1to2 = messagePrefix + "{A} teleported you to {P2}.";
	public static String adminTele2to1 = messagePrefix + "{A} teleported {P1} to you.";
	
	public static String TeleXyz = messagePrefix + "You teleported to {X}, {Y}, {Z}";
	public static String badXyz = errorPrefix + "The co-ordinates you entered were invalid.";
	
	// Spawn Command
	public static String teleportSpawn = messagePrefix + "You have teleported to spawn.";
	public static String adminTeleportSpawn = messagePrefix + "You have teleported {P} to their spawn.";
	public static String playerTeleportSpawn = messagePrefix + "{A} teleported you to your spawn.";
	
	// Muted Command
	public static String mutedPlayer = messagePrefix  + "{P} has been muted in chat.";
	public static String adminMute = messagePrefix + "{A} has muted you. You can no longer chat.";
	public static String cantChat = errorPrefix + "You are currently muted from chat.";
	public static String unmutedPlayer = messagePrefix + "{P} may now talk in chat again.";
	public static String adminUnmute = messagePrefix + "{A} has unmuted you. You can now chat.";
	
	// Fly Command
	public static String isFlying = messagePrefix + "You now have the ability to fly.";
	public static String notFlying = messagePrefix + "You no longer have the ability to fly.";
	public static String adminIsFlying = messagePrefix + "{P} now has the ability to fly.";
	public static String adminNotFlying = messagePrefix + "{P} no longer has the ability to fly.";
	public static String playerIsFlying = messagePrefix + "{A} gave you the ability to fly.";
	public static String playerNotFlying = messagePrefix + "{A} took away your ability to fly.";
	public static String needFlyEnabled = errorPrefix + "Please set allow-flight=true in your server.properties.";
	
	// God Command
	public static String isGod = messagePrefix + "You now have god-mode enabled. Go nuts.";
	public static String notGod = messagePrefix + "You no longer have god-mode.";
	public static String playerGod = messagePrefix + "{P} now has god-mode enabled.";
	public static String playerNotGod = messagePrefix + "{P} no longer has god-mode enabled.";
	public static String adminGod = messagePrefix + "{A} has given you god-mode.";
	public static String adminNotGod = messagePrefix + "{A} has removed your god-mode.";
	
	// Adminify Command
	public static String coderOnline = messagePrefix + "The creator of Adminify is currently on your server.";
	public static String author = messagePrefix + "Author: ThatJavaGuy / CainFoool";
	public static String version = messagePrefix + "Version: v";
	public static String url = messagePrefix + "URL: http://dev.bukkit.org/bukkit-plugins/Adminify";
	
	// Time Command
	public static String timeInvalid = errorPrefix + "The time you specified was invalid.";
	public static String timeUpdate = messagePrefix + "The time of the world you're in changed to {T}.";
	
	// Heal Command
	public static String healthMax = messagePrefix + "Your health has been restored.";
	public static String adminHealth = messagePrefix + "{P}'s health has been restored.";
	public static String playerHealth = messagePrefix + "{A} has restored your health.";
	
	// Hit Command
	public static String hitPlayer = messagePrefix + "You smacked {P}.";
	public static String adminHit = messagePrefix + "{A} smacked you.";
}
