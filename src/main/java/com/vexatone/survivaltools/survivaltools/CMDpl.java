package com.vexatone.survivaltools.survivaltools;

// Import Zone
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * <b>Command:</b> This command is plugin-related.
 *
 * @author  Vexatone
 * @version 1.0-SNAPSHOT
 * @since   2021-02-01
 */
public class CMDpl implements CommandExecutor {
    private final SurvivalTools plugin;

    CMDpl(SurvivalTools plugin) {
        this.plugin = plugin;
    }

    /**
     * <b>CommandHandler:</b> This handler handles a command named "pl".
     *
     * @param sender The sender of command
     * @param command Executed command
     * @param label Displayed command name
     * @param args Additional subcommands
     * @return A single boolean
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // OP check
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!(p.isOp())) {
                p.sendMessage(ChatColor.DARK_RED + "Only OP can execute this command!");
                return true;
            }
        }

        return true;
    }
}
