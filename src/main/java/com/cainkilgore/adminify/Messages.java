package com.cainkilgore.adminify;

import org.bukkit.ChatColor;

public class Messages {
	
	public static String messagePrefix = Adminify.mainClass.getConfig().getString("settings.adminify-prefix") + "Adminify> " + ChatColor.WHITE;
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
	public static String timeMuted = messagePrefix + "You have been muted by {A} for {M} seconds.";
	public static String adminTime = messagePrefix + "You muted {P} for {M} seconds.";
	public static String unmuted = messagePrefix + "Your time is up, you are free to talk in chat again.";
	
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
	public static String url = messagePrefix + "URL: http://dev.bukkit.org/bukkit-plugins/adminify/";
	public static String supportURL = messagePrefix + "Help & Support: http://cain.im/support";
	
	// Time Command
	public static String timeInvalid = errorPrefix + "The time you specified was invalid.";
	public static String timeUpdate = messagePrefix + "The time of the world you're in changed to {T}.";
	public static String timeChanged = messagePrefix + "The time has had an additional {T} added.";
	
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
	
	// Gm command
	public static String gameModeSet = messagePrefix + "Your gamemode has been changed to {G}.";
	public static String gameModePlayerSet = messagePrefix + "{P}'s gamemode has been changed to {G}.";
	public static String gameModeAdmin = messagePrefix + "{A} has changed your gamemode to {G}.";
	
	// Feed Command
	public static String selfFed = messagePrefix + "Your hunger bar has been replenished.";
	public static String adminFed = messagePrefix + "{A} has replenished your hunger.";
	public static String playerFed = messagePrefix + "You have replenished {P}'s hunger.";
	
	// Ride Command
	public static String selectingOn = messagePrefix + "Now right click two entities with an empty hand..";
	public static String selectingOff = messagePrefix + "You are no longer selecting.";
	public static String selected = messagePrefix + "{E} selected. Please select another.";
	public static String nowRiding = messagePrefix + "The selected entities are now riding!";
	
	// Setspawn Command
	public static String spawnSet = messagePrefix + "The world '{W}' spawn was set to your position.";
	
	// MOTD Command
	public static String motdError = messagePrefix + "There was an error getting the MOTD.";
	
	// Snowman Command
	public static String isSnowman = messagePrefix + "You now have the features of a snowman.";
	public static String noSnowman = messagePrefix + "You no longer have the features of a snowman.";
	
	// Tphere Command
	public static String allPlayers = messagePrefix + "All players have been teleported to you.";
	public static String allTped = messagePrefix + "{A} has teleported all players to them.";
	
	// Bed Command
	public static String noBed = errorPrefix + "{P} doesn't appear to have a bed.";
	public static String tpBed = messagePrefix + "You have teleported to {P}'s bed.";
	
	// Kmob Command
	public static String kMobKilled = messagePrefix + "{N} monsters and creatures have been removed.";
	
	// Maxhealth Command
	public static String maxHealth = messagePrefix + "Your max health has been changed to {H}.";
	public static String badHealth = errorPrefix + "You entered an invalid number.";
	public static String playerHealthSet = messagePrefix + "{P}'s max health was set to {H}.";
	public static String adminHealthSet = messagePrefix + "{A} has set your max health to {H}.";
	
	// Playerinfo Command
	public static String playerInfo = messagePrefix + "Player Info for {P}";
	public static String playerInfoWorld = messagePrefix + "World: {W}";
	public static String playerInfoX = messagePrefix + "X: {X}";
	public static String playerInfoY = messagePrefix + "Y: {Y}";
	public static String playerInfoZ = messagePrefix + "Z: {Z}";
	public static String playerInfoIP = messagePrefix + "IP: {IP}";
	
	// Readyup Command
	public static String foodHealth = messagePrefix + "All online players have had their food and health levels maxed out.";
	public static String foodHealthRadius = messagePrefix + "All online players within {X} blocks of you have had their food and health levels maxed out.";
	public static String invalidRadius = errorPrefix + "You have entered an invalid radius.";
	
	// Flyspeed Command
	public static String flySet = messagePrefix + "Your flying speed was set to {F}.";
	public static String flyError = errorPrefix + "You entered an invalid fly speed.";
	
	// Walkspeed Command
	public static String walkSet = messagePrefix + "Your walking speed was set to {F}.";
	public static String walkError = errorPrefix + "You entered an invalid walk speed.";
	
	
	// Warpspeed Command
	public static String warpOn = messagePrefix + "Engage!";
	public static String warpOff = messagePrefix + "Dropping to impulse..";
	
	// Put Command
	public static String putted = messagePrefix + "{P} has been teleported to your cursor.";
	public static String adminPut = messagePrefix + "{A} has teleported you to their cursor.";
	
	// Repair command
	public static String emptyHand = errorPrefix + "You have to be holding a valid item to repair it.";
	public static String repaired = messagePrefix + "Your {I} has been repaired.";
	
	// Tpa Command
	public static String alreadySent = errorPrefix + "You have already sent a teleport request. Please wait 1 minute for your request to expire.";
	public static String alreadySentPlayer = errorPrefix + "{P} already has a teleport request to them from another player. Please wait for this request to expire before trying again.";
	public static String requestSent = messagePrefix + "Your teleport request has been sent to {P}.";
	public static String requestReceived = messagePrefix + "{P} wants to teleport to you.";
	public static String requestUsage = messagePrefix + "/confirm {P} or /deny {P}.";
	
	// Confirm Command
	public static String notSentRequest = errorPrefix + "{P} has not sent a request to you.";
	public static String noRequest = errorPrefix + "No requests have been sent to you.";
	public static String confirmedTeleport = messagePrefix + "You have confirmed {P}'s teleport.";
	public static String confirmedPlayer = messagePrefix + "{P} has accepted your teleport request.";
	
	// Deny Command
	public static String deniedTeleport = messagePrefix + "You have denied {P}'s teleport.";
	public static String deniedPlayer = messagePrefix + "{P} has denied your teleport request.";
	
	// Fireworkshow Command
	public static String alreadyStarted = errorPrefix + "The firework show has already started. Please wait for it to finish.";
	public static String showStarted = messagePrefix + "The firework show has been started!";
	public static String badTime = errorPrefix + "Please enter a valid firework time.";
	
	// Target Command
	public static String compassSet = messagePrefix + "Your compass has been pointed towards {P}.";
	public static String compassWorld = messagePrefix + "Your compass has been pointed towards your world spawn.";
	public static String compassBed = messagePrefix + "Your compass has been pointed towards your bed.";
	
	// Kickstick Command
	public static String kickStick = messagePrefix + "You have received the kick stick. Right click on players who you want to kick.";
	public static String adminKickStick = messagePrefix + "You have kicked {P} using the kick stick.";
	public static String kickedByStick = "You were kicked by {A} using the Kick Stick.";
	
	// Adminify Reload Command
	public static String reloaded = messagePrefix + "Adminify's config was reloaded.";
	
	// iProp Command
	public static String invalidName = errorPrefix + "You entered an invalid display name.";
	public static String mustbeHolding = errorPrefix + "You must be holding an item to change it's properties.";
	public static String displaySet = messagePrefix + "The item held had it's display name changed to: ";
	public static String loreSet = messagePrefix + "The item held has it's lore changed to: ";
	
	// Countdown Command
	public static String invalidCountdown = errorPrefix + "You entered an invalid countdown.";
	
}
