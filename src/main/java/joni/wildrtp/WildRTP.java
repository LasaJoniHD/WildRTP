package joni.wildrtp;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import joni.wildrtp.cmd.CMD_Wild;

public class WildRTP extends JavaPlugin {

	public static String name = "WildRTP";
	public static String author = "Joni";
	public static String ver = "2.0";

	@Override
	public void onEnable() {
		Information(getServer());
		/*
		 * saveDefaultConfig(); if (getConfig().getInt("config-version") < 4) {
		 * Bukkit.getLogger().
		 * warning("[WildRTP] Please update your config file to avoid issues!"); }
		 */
		initEvents();
		initCommands();
	}

	public void Information(Server s) {
		System.out.println("WildRTP by " + author);
		System.out.println("Your are running on version " + ver);
		System.out.println("Thank you for using my plugin!");
	}

	public static Plugin getPlugin() {
		return Bukkit.getPluginManager().getPlugin("WildRTP");
	}

	private void initEvents() {
		@SuppressWarnings("unused")
		PluginManager pm = Bukkit.getPluginManager();
	}

	private void initCommands() {
		getCommand("wild").setExecutor(new CMD_Wild());
	}

}
