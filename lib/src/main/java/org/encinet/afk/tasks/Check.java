package org.encinet.afk.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.encinet.afk.Config;
import org.encinet.afk.unit.MoveStore;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.encinet.afk.AFK.plugin;

public class Check extends BukkitRunnable {
    public static Map<Player, MoveStore> move = new ConcurrentHashMap<>();

    public void start() {
        this.runTaskTimerAsynchronously(plugin, 20, 20);
    }

    public void stop() {
        do {
            this.cancel();
        } while (!this.isCancelled());
    }

    @Override
    public void run() {
        // 检测位置
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        if (players.size() == 0) return;
        for (Player player : players) {
            if (player.isAfk()) {
                continue;
            }
            Location location = player.getLocation();
            MoveStore ms = get(player);
            if (!location.equals(ms.getLocation())) {
                ms.setLocation(location);
                ms.setTimeNow();
            }
        }
        // 检测时间
        for (Map.Entry<Player, MoveStore> entry : move.entrySet()) {
            MoveStore ms = entry.getValue();
            if (ms.getTime() >= Config.notMoveTime) {
                Player player = entry.getKey();
                move.remove(player);
                player.setAfk(true);
            }
        }
    }

    /**
     * 安全的get
     *
     * @param player 玩家
     * @return 返回MoveStore
     */
    public static MoveStore get(Player player) {
        if (!move.containsKey(player)) {
            move.put(player, new MoveStore(player.getLocation()));
        }
        return move.get(player);
    }
}
