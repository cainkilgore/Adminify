package com.cainkilgore.adminify;

import org.bukkit.ChatColor;

public class Messages {
	
	public static String messagePrefix = ChatColor.BLUE + "Adminify> " + ChatColor.WHITE;
	public static String errorPrefix = ChatColor.RED + "Error> " + ChatColor.WHITE;
	
	// Console Messages
	public static String noConsole = "There is no added console support for this command.";
	
	// Player Messages
	public static String invalidPlayer = errorPrefix + "The player you specified does not exist.";
	public static String noPermission = errorPrefix + "You do not have permission to run this command.";
	public static String invalidArguments = errorPrefix + "You have specified invalid arguments for this command.";
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
}
