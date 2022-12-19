package org.encinet.afk.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.encinet.afk.Config;
import org.encinet.afk.unit.dispose;
import org.purpurmc.purpur.event.PlayerAFKEvent;

public class PlayerAFK implements Listener {
    @EventHandler
    public void onPlayerAFK(PlayerAFKEvent e) {
        Player player = e.getPlayer();
        if (e.isGoingAfk()) {
            // 模拟距离设置为真实视距
            player.setSimulationDistance(player.getViewDistance());
            if (Config.broadcastAwayEnable) {
                e.setBroadcastMsg(dispose.papi(player, dispose.randomList(Config.broadcastAwayMessages)));
            }
        } else {
            player.setSimulationDistance(Bukkit.getSimulationDistance());
            if (Config.broadcastBackEnable) {
                e.setBroadcastMsg(dispose.papi(player, dispose.randomList(Config.broadcastBackMessages)));
            }
        }
    }
}
