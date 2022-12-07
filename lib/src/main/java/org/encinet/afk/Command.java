package org.encinet.afk;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command,
            @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            player.setAfk(!player.isAfk());
        } else {
            AFK.logger.info("你不是玩家");
        }
        return true;
    }
}