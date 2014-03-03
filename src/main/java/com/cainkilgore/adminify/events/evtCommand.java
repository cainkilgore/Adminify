package com.cainkilgore.adminify.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.cainkilgore.adminify.Util;

public class evtCommand implements Listener {
	
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		for(String pluginCommands : Util.pluginCommands) {
		//	System.out.println(pluginCommands);
			if(e.getMessage().split(" ")[0].equalsIgnoreCase("/" + pluginCommands)) {
				e.setMessage(e.getMessage().replace(e.getMessage().split(" ")[0], "/adminify_" + pluginCommands));
				return;
			}
		}
	}

}
