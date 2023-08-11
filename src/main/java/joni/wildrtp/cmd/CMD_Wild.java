package joni.wildrtp.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import joni.utils.ConfigLoader;
import joni.utils.CooldownManager;
import joni.wildrtp.WildRTP;
import joni.wildrtp.api.RandomPoint.Algorithm;
import joni.wildrtp.api.SendInfo;
import joni.wildrtp.api.TeleportToRandom;

public class CMD_Wild implements CommandExecutor {

	static FileConfiguration config = WildRTP.getPlugin().getConfig();

	@Override
	public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String label,
			@NotNull String[] args) {

		if (args.length == 1 && args[0].equals("info"))
			info(s);

		if (!(s instanceof Player))
			return false;

		Player p = (Player) s;

		// if (!(p.hasPermission("") || !true))

		Boolean cooldown = false;
		if (config.getBoolean("cooldown.enabled"))
			cooldown = CooldownManager.isOnCooldwon(p);

		if (cooldown)
			return false;

		SendInfo.sendStart(p);

		TeleportToRandom.teleportWithInfo(p.getWorld(), Algorithm.CIRCLE, Double.parseDouble(args[0]),
				Double.parseDouble(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), p);
		return false;
	}

	private void info(CommandSender s) {
		s.sendMessage(ConfigLoader.loadPrefix() + "by " + WildRTP.author + " | Version: " + WildRTP.ver);
	}

}
