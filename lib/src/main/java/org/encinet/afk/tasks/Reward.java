package org.encinet.afk.tasks;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.encinet.afk.unit.Tools;

import java.util.Collection;

import static org.encinet.afk.AFK.plugin;

public class Reward extends BukkitRunnable {

    public void start() {
        this.runTaskTimerAsynchronously(plugin, 20, 200);
    }
    public void stop() {
        do {
            this.cancel();
        } while (!this.isCancelled());
    }

    @Override
    public void run() {
        Collection<Player> players = Tools.getAfkPlayers();
        if (players.size() == 0) return;
        for (Player player : players) {
            detail(player);
        }
    }

    /**
     * 奖励玩家
     * @param player 玩家
     */
    private void detail(Player player) {
        player.giveExp(16);
    }
}
