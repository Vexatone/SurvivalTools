package com.vexatone.survivaltools.survivaltools;

// Import Zone
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * <b>EventListener:</b> This listener detects if a player is dead or not
 *
 * @author  Vexatone
 * @version 1.0-SNAPSHOT
 * @since   2021-02-01
 */
public class EventPlayerDeath implements Listener {

    /**
     * <b>EventHandler</b> This handler executes when someone dies.
     *
     * @param death Event called when a player dies.
     */
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent death) {
        death.setKeepInventory(false);
        death.setKeepLevel(false);
        death.setDeathMessage(ChatColor.DARK_RED + "A player died while playing.");
    }
}
