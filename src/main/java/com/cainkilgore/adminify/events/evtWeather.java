package com.cainkilgore.adminify.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import com.cainkilgore.adminify.commands.Stopweather;

public class evtWeather implements Listener {
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		if(Stopweather.stopWeather) e.setCancelled(true);
	}

}
