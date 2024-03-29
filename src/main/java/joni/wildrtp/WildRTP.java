package joni.wildrtp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import io.papermc.lib.PaperLib;
import joni.listener.OnDeath;
import joni.listener.OnJoin;
import joni.listener.OnMove;
import joni.utils.CooldownManager;
import joni.utils.MessageFile;
import joni.utils.PlayerTeleportManager;
import joni.wildrtp.cmd.CMD_Wild;

public class WildRTP extends JavaPlugin {

	public static String name = "WildRTP";
	public static String author = "Joni";
	public static String ver = "2.1";

	@Override
	public void onEnable() {
		Information(getServer());
		initEvents();
		initCommands();
		saveDefaultConfig();
		MessageFile.createConfig();
		metrics();
		updateChecker();
	}

	public void Information(Server s) {
		getLogger().info("WildRTP by " + author);
		getLogger().info("Thank you for using my plugin!");
		if (PaperLib.isSpigot() && !PaperLib.isPaper()) {
			getLogger().info("===============================");
			getLogger().info("I strongly recommend paper for better performance!");
		}
		PaperLib.suggestPaper(this);
	}

	public static Plugin getPlugin() {
		return Bukkit.getPluginManager().getPlugin("WildRTP");
	}

	public static Logger logger() {
		return getPlugin().getLogger();
	}

	public static void reload() {
		getPlugin().reloadConfig();
		MessageFile.createConfig();
		getPlugin().saveDefaultConfig();
		OnDeath.reload();
		OnJoin.reload();
		CooldownManager.reload();
		PlayerTeleportManager.reload();
		CMD_Wild.reload();
		logger().info("The config and messages have been reloaded!");
	}

	private void initEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		if (getConfig().getBoolean("movetimer.enabled"))
			pm.registerEvents(new OnMove(), this);
		if (getConfig().getBoolean("auto.onfirstjoin") || getConfig().getBoolean("auto.onjoin"))
			pm.registerEvents(new OnJoin(), this);
		if (getConfig().getBoolean("auto.ondeath"))
			pm.registerEvents(new OnDeath(), this);
	}

	private void initCommands() {
		getCommand("wild").setExecutor(new CMD_Wild());
	}

	public void metrics() {
		if (!getConfig().getBoolean("metrics"))
			return;
		int pluginId = 17799;
		new Metrics(this, pluginId);
	}

	private void updateChecker() {
		new Thread() {
			public void run() {
				try {
					StringBuilder content = new StringBuilder();

					URL url = new URL("https://raw.githubusercontent.com/LasaJoniHD/WildRTP/main/this-version.txt");
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

					String line;
					while ((line = reader.readLine()) != null) {
						content.append(line);
					}

					reader.close();

					if (content.toString().equals(ver)) {
						getLogger().info("You are running the latest version!");
						return;
					}

					getLogger().info("There is an update avaible for WildRTP!");
					getLogger().info("https://modrinth.com/plugin/wildrtp");

				} catch (IOException e) {
					getLogger().info("Can't check for updates? Server might be unavailable...");
				}
			}
		}.start();

	}

}
