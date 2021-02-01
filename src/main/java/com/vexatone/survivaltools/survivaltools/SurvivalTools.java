package com.vexatone.survivaltools.survivaltools;

// Import Zone
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

/**
 * The Survival Tools Plugin prepares a Minecraft survival environment.
 *
 * @author  Vexatone
 * @version 1.0-SNAPSHOT
 * @since   2021-02-01
 */
public final class SurvivalTools extends JavaPlugin {
    ConsoleCommandSender console = Bukkit.getConsoleSender();

    @Override
    public void onEnable() {
        // Config
        File file = new File(getDataFolder() + File.separator + "config.yml");

        if (file.exists()) {
            CheckConfig();
            saveConfig();
            reloadConfig();
        } else {
            // Adds default config path
            getConfig().addDefault("isActivated", true);

            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        // Event Listener Register
        getServer().getPluginManager().registerEvents(new EventPlayerDeath(this), this);

        // Command Register
        Objects.requireNonNull(this.getCommand("pl")).setExecutor(new CMDpl(this));

        console.sendMessage(ChatColor.BLUE + "Setup Complete!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        console.sendMessage(ChatColor.RED + "Plugin Disabled!");
    }

    public void CheckConfig() {
        if(getConfig().get("isActivated") == null) {
            getConfig().set("isActivated", true);
            saveConfig();
            reloadConfig();
        }
    }

    public boolean activatedState() {
        return getConfig().getBoolean("isActivated");
    }

    public void activatedUpdate(boolean newState) {
        getConfig().set("isActivated", newState);
        saveConfig();
        reloadConfig();
    }
}
