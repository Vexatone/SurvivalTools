package com.vexatone.survivaltools.survivaltools;

// Import Zone
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

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
        // Event Listener Register
        getServer().getPluginManager().registerEvents(new EventPlayerDeath(), this);

        console.sendMessage(ChatColor.BLUE + "Setup Complete!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        console.sendMessage(ChatColor.RED + "Plugin Disabled!");
    }
}
