package com.cainkilgore.adminify;

import org.bukkit.ChatColor;

public class Messages {
	
	public static String messagePrefix = Adminify.mainClass.getConfig().getString("settings.adminify-prefix") + "Adminify> " + ChatColor.WHITE;
	public static String errorPrefix = ChatColor.RED + "Error> " + ChatColor.WHITE;
	public static String msgFromPrefix = ChatColor.GOLD + "from {P}> " + ChatColor.WHITE + "{M}";
	public static String msgToPrefix = ChatColor.GOLD + "to {P}> " + ChatColor.WHITE + "{M}";
	
	// Console Messages
	public static String noConsole = Language.getStringFromFile("noConsole");
	public static String error = Language.getStringFromFile("error");
	
	// Player Messages
	public static String invalidPlayer = errorPrefix + Language.getStringFromFile("invalidPlayer");
	public static String noPermission = errorPrefix + Language.getStringFromFile("noPermission");
	public static String invalidArguments = errorPrefix + Language.getStringFromFile("invalidArguments");
	
	// Frozen Command
	public static String nowFrozen = messagePrefix + Language.getStringFromFile("nowFrozen");
	public static String selfFroze = messagePrefix + Language.getStringFromFile("selfFroze");
	public static String unFrozen = messagePrefix + Language.getStringFromFile("unFrozen");
	public static String selfUnfrozen = messagePrefix + Language.getStringFromFile("selfUnfrozen");
	
	public static String breakBlocks = errorPrefix + Language.getStringFromFile("breakBlocks");
	public static String placeBlocks = errorPrefix + Language.getStringFromFile("placeBlocks");
	public static String interactBlocks = errorPrefix + Language.getStringFromFile("interactBlocks");
	
	
	public static String joinFrozen = messagePrefix + Language.getStringFromFile("joinFrozen");
	
	// Teleport Command
	public static String playerToArg = messagePrefix + Language.getStringFromFile("playerToArg");
	public static String argToPlayer = messagePrefix + Language.getStringFromFile("argToPlayer");
	
	public static String player1to2 = messagePrefix + Language.getStringFromFile("player1to2");
	public static String adminTele1to2 = messagePrefix + Language.getStringFromFile("adminTele1to2");
	public static String adminTele2to1 = messagePrefix + Language.getStringFromFile("adminTele2to1");
	
	public static String TeleXyz = messagePrefix + Language.getStringFromFile("TeleXyz");
	public static String badXyz = errorPrefix + Language.getStringFromFile("badXyz");
	public static String tphereAdmin = messagePrefix + Language.getStringFromFile("tphereAdmin");
	
	// Spawn Command
	public static String teleportSpawn = messagePrefix + Language.getStringFromFile("teleportSpawn");
	public static String adminTeleportSpawn = messagePrefix + Language.getStringFromFile("adminTeleportSpawn");
	public static String playerTeleportSpawn = messagePrefix + Language.getStringFromFile("playerTeleportSpawn");
	
	// Muted Command
	public static String mutedPlayer = messagePrefix  + Language.getStringFromFile("mutedPlayer");
	public static String adminMute = messagePrefix + Language.getStringFromFile("adminMute");
	public static String cantChat = errorPrefix + Language.getStringFromFile("cantChat");
	public static String unmutedPlayer = messagePrefix + Language.getStringFromFile("unmutedPlayer");
	public static String adminUnmute = messagePrefix + Language.getStringFromFile("adminUnmute");
	public static String timeMuted = messagePrefix + Language.getStringFromFile("timeMuted");
	public static String adminTime = messagePrefix + Language.getStringFromFile("adminTime");
	public static String unmuted = messagePrefix + Language.getStringFromFile("unmuted");
	
	public static String joinMuted = messagePrefix + Language.getStringFromFile("joinMuted");
	
	// Fly Command
	public static String isFlying = messagePrefix + Language.getStringFromFile("isFlying");
	public static String notFlying = messagePrefix + Language.getStringFromFile("notFlying");
	public static String adminIsFlying = messagePrefix + Language.getStringFromFile("adminIsFlying");
	public static String adminNotFlying = messagePrefix + Language.getStringFromFile("adminNotFlying");
	public static String playerIsFlying = messagePrefix + Language.getStringFromFile("playerIsFlying");
	public static String playerNotFlying = messagePrefix + Language.getStringFromFile("playerNotFlying");
	public static String needFlyEnabled = errorPrefix + Language.getStringFromFile("needFlyEnabled");
	
	// God Command
	public static String isGod = messagePrefix + Language.getStringFromFile("isGod");
	public static String notGod = messagePrefix + Language.getStringFromFile("notGod");
	public static String playerGod = messagePrefix + Language.getStringFromFile("playerGod");
	public static String playerNotGod = messagePrefix + Language.getStringFromFile("playerNotGod");
	public static String adminGod = messagePrefix + Language.getStringFromFile("adminGod");
	public static String adminNotGod = messagePrefix + Language.getStringFromFile("adminNotGod");
	
	// Adminify Command
	public static String coderOnline = messagePrefix + "The creator of Adminify is currently on your server.";
	public static String author = messagePrefix + "Author: ThatJavaGuy / CainFoool";
	public static String version = messagePrefix + "Version: v";
	public static String url = messagePrefix + "URL: http://dev.bukkit.org/bukkit-plugins/adminify/";
	public static String supportURL = messagePrefix + "Help & Support: http://cain.im/support";
	
	// Time Command
	public static String timeInvalid = errorPrefix + Language.getStringFromFile("timeInvalid");
	public static String timeUpdate = messagePrefix + Language.getStringFromFile("timeUpdate");
	public static String timeChanged = messagePrefix + Language.getStringFromFile("timeChanged");
	
	// Heal Command
	public static String healthMax = messagePrefix + Language.getStringFromFile("healthMax");
	public static String adminHealth = messagePrefix + Language.getStringFromFile("adminHealth");
	public static String playerHealth = messagePrefix + Language.getStringFromFile("playerHealth");
	
	// Hit Command
	public static String hitPlayer = messagePrefix + Language.getStringFromFile("hitPlayer");
	public static String adminHit = messagePrefix + Language.getStringFromFile("adminHit");
	
	// Clear Command
	public static String clearInv = messagePrefix + Language.getStringFromFile("clearInv");
	public static String adminClear = messagePrefix + Language.getStringFromFile("adminClear");
	public static String playerClear = messagePrefix + Language.getStringFromFile("playerClear");
	
	// Kill Command
	public static String killSelf = messagePrefix + Language.getStringFromFile("killSelf");
	public static String adminKill = messagePrefix + Language.getStringFromFile("adminKill");
	public static String playerKill = messagePrefix + Language.getStringFromFile("playerKill");
	
	// Vanish Command
	public static String nowVanished = messagePrefix + Language.getStringFromFile("nowVanished");
	public static String noVanished = messagePrefix + Language.getStringFromFile("noVanished");
	
	// Lastpos Command
	public static String teleLast = messagePrefix + Language.getStringFromFile("teleLast");
	public static String teleError = errorPrefix + Language.getStringFromFile("teleError");
	public static String playerLast = messagePrefix + Language.getStringFromFile("playerLast");
	public static String playerError = errorPrefix + Language.getStringFromFile("playerError");
	
	// Strike Command
	public static String strikePlayer = messagePrefix + Language.getStringFromFile("strikePlayer");
	public static String adminStrike = messagePrefix + Language.getStringFromFile("adminStrike");
	
	// Sethome and Home Command
	public static String homeError = errorPrefix + Language.getStringFromFile("homeError");
	public static String homeSaved = messagePrefix + Language.getStringFromFile("homeSaved");
	public static String teleHome = messagePrefix + Language.getStringFromFile("teleHome");
	public static String noHome = errorPrefix + Language.getStringFromFile("noHome");

	// Msg Command
	// Handled by Prefixes at top
	
	// Spawnmob Command
	public static String invalidMob = errorPrefix + Language.getStringFromFile("invalidMob");
	public static String spawnSuccess = messagePrefix + Language.getStringFromFile("spawnSuccess");
	public static String invalidCount = errorPrefix + Language.getStringFromFile("invalidCount");
	
	// Gm command
	public static String gameModeSet = messagePrefix + Language.getStringFromFile("gameModeSet");
	public static String gameModePlayerSet = messagePrefix + Language.getStringFromFile("gameModePlayerSet");
	public static String gameModeAdmin = messagePrefix + Language.getStringFromFile("gameModeAdmin");
	
	// Feed Command
	public static String selfFed = messagePrefix + Language.getStringFromFile("selfFed");
	public static String adminFed = messagePrefix + Language.getStringFromFile("adminFed");
	public static String playerFed = messagePrefix + Language.getStringFromFile("playerFed");
	
	// Ride Command
	public static String selectingOn = messagePrefix + Language.getStringFromFile("selectingOn");
	public static String selectingOff = messagePrefix + Language.getStringFromFile("selectingOff");
	public static String selected = messagePrefix + Language.getStringFromFile("selected");
	public static String nowRiding = messagePrefix + Language.getStringFromFile("nowRiding");
	
	// Setspawn Command
	public static String spawnSet = messagePrefix + Language.getStringFromFile("spawnSet");
	
	// MOTD Command
	public static String motdError = messagePrefix + Language.getStringFromFile("motdError");
	
	// Snowman Command
	public static String isSnowman = messagePrefix + Language.getStringFromFile("isSnowman");
	public static String noSnowman = messagePrefix + Language.getStringFromFile("noSnowman");
	
	// Tphere Command
	public static String allPlayers = messagePrefix + Language.getStringFromFile("allPlayers");
	public static String allTped = messagePrefix + Language.getStringFromFile("allTped");
	
	// Bed Command
	public static String noBed = errorPrefix + Language.getStringFromFile("noBed");
	public static String tpBed = messagePrefix + Language.getStringFromFile("tpBed");
	
	// Kmob Command
	public static String kMobKilled = messagePrefix + Language.getStringFromFile("kMobKilled");
	
	// Maxhealth Command
	public static String maxHealth = messagePrefix + Language.getStringFromFile("maxHealth");
	public static String badHealth = errorPrefix + Language.getStringFromFile("badHealth");
	public static String playerHealthSet = messagePrefix + Language.getStringFromFile("playerHealthSet");
	public static String adminHealthSet = messagePrefix + Language.getStringFromFile("adminHealthSet");
	
	// Playerinfo Command
	public static String playerInfo = messagePrefix + Language.getStringFromFile("playerInfo");
	public static String playerInfoWorld = messagePrefix + Language.getStringFromFile("playerInfoWorld");
	public static String playerInfoX = messagePrefix + Language.getStringFromFile("playerInfoX");
	public static String playerInfoY = messagePrefix + Language.getStringFromFile("playerInfoY");
	public static String playerInfoZ = messagePrefix + Language.getStringFromFile("playerInfoZ");
	public static String playerInfoIP = messagePrefix + Language.getStringFromFile("playerInfoIP");
	
	// Readyup Command
	public static String foodHealth = messagePrefix + Language.getStringFromFile("foodHealth");
	public static String foodHealthRadius = messagePrefix + Language.getStringFromFile("foodHealthRadius");
	public static String invalidRadius = errorPrefix + Language.getStringFromFile("invalidRadius");
	
	// Flyspeed Command
	public static String flySet = messagePrefix + Language.getStringFromFile("flySet");
	public static String flyError = errorPrefix + Language.getStringFromFile("flyError");
	
	// Walkspeed Command
	public static String walkSet = messagePrefix + Language.getStringFromFile("walkSet");
	public static String walkError = errorPrefix + Language.getStringFromFile("walkError");
	
	
	// Warpspeed Command
	public static String warpOn = messagePrefix + Language.getStringFromFile("warpOn");
	public static String warpOff = messagePrefix + Language.getStringFromFile("warpOff");
	
	// Put Command
	public static String putted = messagePrefix + Language.getStringFromFile("putted");
	public static String adminPut = messagePrefix + Language.getStringFromFile("adminPut");
	
	// Repair command
	public static String emptyHand = errorPrefix + Language.getStringFromFile("emptyHand");
	public static String repaired = messagePrefix + Language.getStringFromFile("repaired");
	
	// Tpa Command
	public static String alreadySent = errorPrefix + Language.getStringFromFile("alreadySent");
	public static String alreadySentPlayer = errorPrefix + Language.getStringFromFile("alreadySentPlayer");
	public static String requestSent = messagePrefix + Language.getStringFromFile("requestSent");
	public static String requestReceived = messagePrefix + Language.getStringFromFile("requestReceived");
	public static String requestUsage = messagePrefix + Language.getStringFromFile("requestUsage");
	
	// Confirm Command
	public static String notSentRequest = errorPrefix + Language.getStringFromFile("notSentRequest");
	public static String noRequest = errorPrefix + Language.getStringFromFile("noRequest");
	public static String confirmedTeleport = messagePrefix + Language.getStringFromFile("confirmedTeleport");
	public static String confirmedPlayer = messagePrefix + Language.getStringFromFile("confirmedPlayer");
	
	// Deny Command
	public static String deniedTeleport = messagePrefix + Language.getStringFromFile("deniedTeleport");
	public static String deniedPlayer = messagePrefix + Language.getStringFromFile("deniedPlayer");
	
	// Fireworkshow Command
	public static String alreadyStarted = errorPrefix + Language.getStringFromFile("alreadyStarted");
	public static String showStarted = messagePrefix + Language.getStringFromFile("showStarted");
	public static String badTime = errorPrefix + Language.getStringFromFile("badTime");
	
	// Target Command
	public static String compassSet = messagePrefix + Language.getStringFromFile("compassSet");
	public static String compassWorld = messagePrefix + Language.getStringFromFile("compassWorld");
	public static String compassBed = messagePrefix + Language.getStringFromFile("compassBed");
	
	// Kickstick Command
	public static String kickStick = messagePrefix + Language.getStringFromFile("kickStick");
	public static String adminKickStick = messagePrefix + Language.getStringFromFile("adminKickStick");
	public static String kickedByStick = Language.getStringFromFile("kickedByStick");
	
	// Adminify Reload Command
	public static String reloaded = messagePrefix + Language.getStringFromFile("reloaded");
	
	// iProp Command
	public static String invalidName = errorPrefix + Language.getStringFromFile("invalidName");
	public static String mustbeHolding = errorPrefix + Language.getStringFromFile("mustBeHolding");
	public static String displaySet = messagePrefix + Language.getStringFromFile("displaySet");
	public static String loreSet = messagePrefix + Language.getStringFromFile("loreSet");
	
	// Countdown Command
	public static String invalidCountdown = errorPrefix + Language.getStringFromFile("invalidCountdown");
	
	// Admin command
	public static String alertSent = messagePrefix + Language.getStringFromFile("alertSent");
	
	// Give Command
	public static String badMaterial = errorPrefix + Language.getStringFromFile("badMaterial");
	
	public static String gaveMaterial = messagePrefix + Language.getStringFromFile("gaveMaterial");
	public static String gavePlayerMaterial = messagePrefix + Language.getStringFromFile("gamePlayerMaterial");
	public static String invalidQuantity = errorPrefix + Language.getStringFromFile("invalidQuantity");
	public static String invalidDataValue = errorPrefix + Language.getStringFromFile("invalidDataValue");
	
	// Hat Command
	public static String mustBeHoldingItem = errorPrefix + Language.getStringFromFile("mustBeHoldingItem");
	public static String nowWearingItem = messagePrefix + Language.getStringFromFile("nowWearingItem");
	public static String itemHelmet = errorPrefix + Language.getStringFromFile("itemHelmet");
	
	// Changerp Command
	public static String resourcePack = messagePrefix + Language.getStringFromFile("resourcePack");
	
	// Nuke Command
	public static String nukeTarget = messagePrefix + Language.getStringFromFile("nukeTarget");
	
	// Stopweather Command
	public static String weatherStopped = messagePrefix + Language.getStringFromFile("weatherStopped");
	public static String weatherContinued = messagePrefix + Language.getStringFromFile("weatherContinued");
	
}
