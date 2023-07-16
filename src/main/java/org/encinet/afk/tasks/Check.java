package org.encinet.afk.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.encinet.afk.Config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.encinet.afk.AFK.plugin;

public class Check extends BukkitRunnable implements Listener {
    public static Map<Player, Long> time = new ConcurrentHashMap<>();

    public Check() {
        start();
        for (Player p : Bukkit.getOnlinePlayers()) {
            time.put(p, System.currentTimeMillis());
        }
    }

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
        // 检测时间
        for (Map.Entry<Player, Long> entry : time.entrySet()) {
            Player player = entry.getKey();
            if (player.isOnline()) {
                long period = System.currentTimeMillis() - entry.getValue();
                if (period >= Config.notMoveTime) {
                    time.remove(player);
                    player.setAfk(true);
                }
            } else {
                time.remove(player);
            }
        }
    }

    /**
     * 设置玩家上次改变状态的时间为现在
     *
     * @param player 玩家
     */
    public static void setTimeNow(Player player) {
        time.put(player, System.currentTimeMillis());
    }
}
