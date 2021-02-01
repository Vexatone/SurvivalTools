package com.vexatone.survivaltools.survivaltools;

// Import Zone
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        // OP check
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!p.isOp()) {
                p.sendMessage(ChatColor.DARK_RED + "Only OP can execute this command!");
                return true;
            }
        }

        // Checks if there are no sub-commands
        if (args.length == 0) {
            sender.sendMessage(ChatColor.DARK_RED + "There are no sub-commands! Type '/pl help' for help.");
        } else {
            if (args[0].equalsIgnoreCase("activate")) {

                // "activate" : Activate Rules
                if (plugin.activatedState()) {
                    sender.sendMessage(ChatColor.BLUE + "Rules are already activated.");
                } else {
                    plugin.activatedUpdate(true);
                    sender.sendMessage(ChatColor.BLUE + "Rules activated.");
                }

            } else if (args[0].equalsIgnoreCase("deactivate")) {

                // "deactivate" : Deactivate Rules
                if (!plugin.activatedState()) {
                    sender.sendMessage(ChatColor.BLUE + "Rules are already deactivated.");
                } else {
                    plugin.activatedUpdate(false);
                    sender.sendMessage(ChatColor.BLUE + "Rules deactivated.");
                }

            }
        }

        return true;
    }
}
