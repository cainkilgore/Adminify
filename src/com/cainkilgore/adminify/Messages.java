package com.cainkilgore.adminify;

import org.bukkit.ChatColor;

public class Messages {
	
	public static String messagePrefix = ChatColor.BLUE + "Adminify> " + ChatColor.WHITE;
	public static String errorPrefix = ChatColor.RED + "Error> " + ChatColor.WHITE;
	public static String msgFromPrefix = ChatColor.GOLD + "from {P}> " + ChatColor.WHITE + "{M}";
	public static String msgToPrefix = ChatColor.GOLD + "to {P}> " + ChatColor.WHITE + "{M}";
	
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
	
	public static String breakBlocks = errorPrefix + "You can not break blocks whilst frozen.";
	public static String placeBlocks = errorPrefix + "You can not place blocks whilst frozen.";
	public static String interactBlocks = errorPrefix + "You can not interact with {B} whilst frozen.";
	
	
	public static String joinFrozen = messagePrefix + "You are still frozen from your previous session.";
	
	// Teleport Command
	public static String playerToArg = messagePrefix + "You teleported to {P}.";
	public static String argToPlayer = messagePrefix + "{P} teleported you to them.";
	
	public static String player1to2 = messagePrefix + "You have teleported {P1} to {P2}.";
	public static String adminTele1to2 = messagePrefix + "{A} teleported you to {P2}.";
	public static String adminTele2to1 = messagePrefix + "{A} teleported {P1} to you.";
	
	public static String TeleXyz = messagePrefix + "You teleported to {X}, {Y}, {Z}";
	public static String badXyz = errorPrefix + "The co-ordinates you entered were invalid.";
	public static String tphereAdmin = messagePrefix + "You teleported {P} to you.";
	
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
	
	public static String joinMuted = messagePrefix + "You are still muted from your previous session.";
	
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
	
	// Clear Command
	public static String clearInv = messagePrefix + "Your inventory has been wiped.";
	public static String adminClear = messagePrefix + "{A} has wiped your inventory.";
	public static String playerClear = messagePrefix + "You have wiped {P}'s inventory.";
	
	// Kill Command
	public static String killSelf = messagePrefix + "You have killed yourself.";
	public static String adminKill = messagePrefix + "You killed {P}.";
	public static String playerKill = messagePrefix + "{A} killed you.";
	
	// Vanish Command
	public static String nowVanished = messagePrefix + "You are now vanished from all players.";
	public static String noVanished = messagePrefix + "You are no longer vanished from all players.";
	
	// Lastpos Command
	public static String teleLast = messagePrefix + "You teleported to your previous location.";
	public static String teleError = errorPrefix + "There was an error getting your last location.";
	public static String playerLast = messagePrefix + "You teleported to {P}'s previous location.";
	public static String playerError = errorPrefix + "There was an error getting {P}'s previous location.";
	
	// Strike Command
	public static String strikePlayer = messagePrefix + "You have struck {P} with lightning.";
	public static String adminStrike = messagePrefix + "{A} has struck you with lightning.";
	
	// Sethome and Home Command
	public static String homeError = errorPrefix + "There was an error saving your home location.";
	public static String homeSaved = messagePrefix + "Your home location has been saved.";
	public static String teleHome = messagePrefix + "You have teleported to your home.";
	public static String noHome = errorPrefix + "You do not have a home. /sethome now.";

	// Msg Command
	// Handled by Prefixes at top
	
	// Spawnmob Command
	public static String invalidMob = errorPrefix + "That entity does not exist.";
	public static String spawnSuccess = messagePrefix + "{N} of {E} were spawned at your cursor location.";
	public static String invalidCount = errorPrefix + "You entered an invalid number of entities to spawn.";
	
	
}
