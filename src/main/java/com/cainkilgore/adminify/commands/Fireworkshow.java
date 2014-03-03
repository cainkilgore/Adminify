package com.cainkilgore.adminify.commands;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Fireworkshow implements CommandExecutor {
	
	BukkitTask fireworkShow = null;
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("fireworkshow")) {
			if(!(s instanceof Player)) {
				if(args.length < 5) {
					Util.print(Messages.invalidArguments);
					Util.print(Util.getCommandUsage(l));
					return true;
				}
				

				try {
					new Location(Adminify.mainClass.getServer().getWorld(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
				} catch (Exception e) {
					Util.print("Incorrect data.");
					return true;
				}
				
				final Location fireworkLoc = new Location(Adminify.mainClass.getServer().getWorld(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
				final BukkitTask getTask = Adminify.mainClass.getServer().getScheduler().runTaskTimer(Adminify.mainClass, new Runnable() {
					public void run() {
						if(new Random().nextInt(5) >= 2) {
							Util.spawnFireworkEntity(fireworkLoc, getRandomColor(), getRandomType(), getRandomPower(), getRandomFlicker(), getRandomTrail());
						}
					}
				}, 5L, 5L);
				
				Adminify.mainClass.getServer().getScheduler().runTaskLater(Adminify.mainClass, new Runnable() {
					public void run() {
						getTask.cancel();
					}
				}, 20 * Integer.parseInt(args[4]));
				
				return true;
			}
			
			final Player player = (Player) s;
			
			if(!Util.hasPermission(player, "fireworkshow")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(fireworkShow != null) {
				Util.sendMessage(player, Messages.alreadyStarted);
				return true;
			}
			
			if(args.length < 1) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			int r = 0;
			try {
				r = Integer.parseInt(args[0]);
			} catch (Exception e) {
				Util.sendMessage(player, Messages.badTime);
			}
			
			final Location getEyeTarget = player.getTargetBlock(null, 50).getLocation();
			
			final BukkitTask getTask = Adminify.mainClass.getServer().getScheduler().runTaskTimer(Adminify.mainClass, new Runnable() {
				public void run() {
					if(new Random().nextInt(5) >= 2) {
						Util.spawnFireworkEntity(getEyeTarget, getRandomColor(), getRandomType(), getRandomPower(), getRandomFlicker(), getRandomTrail());
					}
				}
			}, 5L, 5L);
			
			Adminify.mainClass.getServer().getScheduler().runTaskLater(Adminify.mainClass, new Runnable() {
				public void run() {
					getTask.cancel();
				}
			}, 20 * r);
//		}
		return true;
	}
	
	public Color getRandomColor() {
		Random r = new Random();
		int randInt = r.nextInt(17);
		
		if(randInt == 1) return Color.AQUA;
		if(randInt == 2) return Color.BLACK;
		if(randInt == 3) return Color.BLUE;
		if(randInt == 4) return Color.FUCHSIA;
		if(randInt == 5) return Color.GRAY;
		if(randInt == 6) return Color.GREEN;
		if(randInt == 7) return Color.LIME;
		if(randInt == 8) return Color.MAROON;
		if(randInt == 9) return Color.NAVY;
		if(randInt == 10) return Color.OLIVE;
		if(randInt == 11) return Color.ORANGE;
		if(randInt == 12) return Color.PURPLE;
		if(randInt == 13) return Color.RED;
		if(randInt == 14) return Color.SILVER;
		if(randInt == 15) return Color.TEAL;
		if(randInt == 16) return Color.WHITE;
		if(randInt == 17) return Color.YELLOW;
		return Color.WHITE;
	}
	
	public Type getRandomType() {
		Random r = new Random();
		int randInt = r.nextInt(5);
		
		if(randInt == 1) return Type.BALL;
		if(randInt == 2) return Type.BALL_LARGE;
		if(randInt == 3) return Type.BURST;
		if(randInt == 4) return Type.CREEPER;
		if(randInt == 5) return Type.STAR;
		return Type.BALL;
	}
	
	public int getRandomPower() {
		Random r = new Random();
		return 2 + r.nextInt(3);
	}
	
	public boolean getRandomFlicker() {
		Random r = new Random();
		int randInt = r.nextInt(2);
		if(randInt == 1) return true;
		return false;
	}
	
	public boolean getRandomTrail() {
		Random r = new Random();
		int randInt = r.nextInt(2);
		if(randInt == 1) return true;
		return false;
	}

}
