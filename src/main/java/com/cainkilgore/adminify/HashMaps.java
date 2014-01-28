package com.cainkilgore.adminify;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Location;

public class HashMaps {
	
	public static HashMap<String, Location> frozenPlayers = new HashMap<String, Location>();
	public static HashSet<String>			mutedPlayers = new HashSet<String>();
	public static HashSet<String>			godPlayers = new HashSet<String>();
	public static HashSet<String>			vanishPlayers = new HashSet<String>();
	public static HashSet<String>			snowPlayers = new HashSet<String>();
	public static HashMap<String, String>	requestPlayers = new HashMap<String, String>();
	public static HashSet<String>			alreadySentPlayers = new HashSet<String>();
	
	
}
