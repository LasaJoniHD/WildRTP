package joni.wildrtp.cmd;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import joni.utils.ConfigLoader;
import joni.utils.CooldownManager;
import joni.utils.MoveTimer;
import joni.utils.PlayerTeleportManager;
import joni.wildrtp.WildRTP;
import joni.wildrtp.api.SendInfo;

public class CMD_Wild implements CommandExecutor {

	static FileConfiguration config = WildRTP.getPlugin().getConfig();

	@Override
	public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String label,
			@NotNull String[] args) {

		if (args.length == 1) {
			String arg = args[0];
			switch (arg) {
			case "info":
				info(s);
				return false;
			case "reload":
				if (s.hasPermission("wildrtp.reload")) {
					WildRTP.reload();
					return false;
				}
			}
		}

		if (!(s instanceof Player))
			return false;

		Player p = (Player) s;

		if (!(p.hasPermission("wildrtp.rtp")))
			return false;

		List<String> blacklist = config.getStringList("blacklist");

		if (!blacklist.isEmpty())
			for (String bw : blacklist) {
				if (p.getWorld().getName().equals(bw)) {
					p.sendMessage(ConfigLoader.loadMessageWithPrefix("chat.blacklisted"));
					return false;
				}
			}

		Boolean cooldown = false;
		if (config.getBoolean("cooldown.enabled"))
			cooldown = CooldownManager.isOnCooldwon(p);

		if (cooldown)
			return false;

		if (config.getBoolean("movetimer.enabled")) {
			MoveTimer.wait(p);
			return false;
		}

		SendInfo.sendStart(p);

		PlayerTeleportManager.teleport(p);

		return false;
	}

	private void info(CommandSender s) {
		s.sendMessage(ConfigLoader.loadPrefix() + "by " + WildRTP.author + " | Version: " + WildRTP.ver);
	}

}
