# WildRTP

[![Modrinth Downloads](https://img.shields.io/modrinth/dt/wildrtp?label=Modrinth&color=green)](https://modrinth.com/plugin/wildrtp "Modrinth")
![Version](<https://img.shields.io/badge/Version-3.0%20(Alpha)-orange>)

**WildRTP** is a feature-packed random teleportation plugin for Minecraft servers. It allows players to find a safe, random location in the world to start their adventure.

---

## ⚠️ Version 3.0 (Alpha) Notice

**Version 3.0 is a complete rewrite of the plugin.**
This update introduces a new codebase designed for better performance and maintainability.

> **Please Note:**
>
> - **Status:** This is an **Alpha** release. While stable, it is not fully battle-tested.
> - **Bugs:** Unexpected issues may occur. Please report them on our [Discord](https://discord.com/invite/Mbq2P92XqC) or GitHub Issues.
> - **Config Reset:** The configuration structure has changed. **You must regenerate your config files** when upgrading from V2.
> - **Wiki:** [Read the Version 3.0 Changelog](<https://github.com/LasaJoniHD/WildRTP/wiki/Version-3.0-(Alpha)>)

---

## ✨ Features

- **🚀 High Performance:** Completely rewritten with async chunk loading to prevent server lag during teleports.
- **🌍 Custom World Support:** Define specific settings (radius, shape, center) for different worlds (New in 3.0!).
- **🛡️ Safe Landing:** Smart location checking avoids water, lava, and specific blocked biomes.
- **⏲️ Cooldowns & Warmups:** Configurable wait times before teleporting and cooldowns after use.
- **⚡ Auto-RTP:** Automatically teleport players on their first join, every join, or upon death.
- **🎨 Customizable:** Full control over messages, titles and shapes (Circle/Square).

---

## 📥 Installation & Migration

### fresh Installation

1.  Download the latest JAR from the [Releases](https://github.com/LasaJoniHD/WildRTP/releases) page.
2.  Place the file into your server's `plugins` folder.
3.  Restart your server.

### Upgrading from V2 to V3

**⚠️ Breaking Change:** Old configuration files are **not compatible**.

1.  Stop your server.
2.  Delete (or backup/rename) the existing `WildRTP` folder in your `plugins` directory.
3.  Install the new V3 JAR file.
4.  Start the server to generate the new `config.yml`.
5.  Manually re-apply your settings to the new file.

---

## 💻 Commands

| Command         | Description                                   | Permission        |
| :-------------- | :-------------------------------------------- | :---------------- |
| `/wild`         | Randomly teleport in the current world.       | `wildrtp.rtp`     |
| `/wild help`    | Show the help menu.                           | `wildrtp.rtp`     |
| `/wild info`    | Display plugin version and info.              | `wildrtp.rtp`     |
| `/wild updates` | Check for available updates.                  | `wildrtp.updates` |
| `/wild reload`  | Reload the configuration files.               | `wildrtp.reload`  |
| `/customrtp`    | Teleport with specific parameters (See Wiki). | `wildrtp.custom`  |

### Permissions

- **Default:** `wildrtp.rtp` (Given to all players by default)
- **Bypass Cooldown:** `wildrtp.cooldown.bypass`
- **Bypass Move Timer:** `wildrtp.movetimer.bypass`
- **Admin:** `wildrtp.reload`, `wildrtp.custom`, `wildrtp.updates`

---

## ⚙️ Configuration

The configuration has been completely overhauled in Version 3.0 to support per-world settings.

**View the full configuration documentation here:**
👉 **[Config for Version 3.0 (Alpha)](<https://github.com/LasaJoniHD/WildRTP/wiki/Config-for-Version-3.0-(Alpha)>)**

---

## 🐛 Bug Reports & Support

Found a bug in the Alpha? Have a suggestion?

- **Wiki:** [Read the Version 3.0 Changelog](<https://github.com/LasaJoniHD/WildRTP/wiki/Version-3.0-(Alpha)>)
- **Issues:** [Report on GitHub](https://github.com/LasaJoniHD/WildRTP/issues)
- **Discord:** [Join our Community](https://discord.com/invite/Mbq2P92XqC)
