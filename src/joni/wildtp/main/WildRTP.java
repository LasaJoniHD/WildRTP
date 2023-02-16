package joni.wildtp.main;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import joni.wildtp.cmd.RTP;

public class WildRTP extends JavaPlugin {

	public static String name = "WildRTP";
	public static String author = "Joni";
	public static String ver = "1.2";

	@Override
	public void onEnable() {
		Information(getServer());
		saveDefaultConfig();
		if (getConfig().getDouble("config-version") <= 1.2)  {
			Bukkit.getLogger().warning("[WildRTP] Please update your config file to avoid issues!");
		}
		getCommand("wild").setExecutor(new RTP());
	}

	public void Information(Server s) {
		System.out.println("WildRTP by " + author);
		System.out.println("Your are running on version " + ver);
		System.out.println("Dedected following version " + s.getVersion());
	}
	
	public static Plugin getPlugin() {
		return Bukkit.getPluginManager().getPlugin("WildRTP");
	}
}