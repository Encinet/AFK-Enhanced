package org.encinet.afk.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.encinet.afk.Config;
import org.encinet.afk.unit.dispose;
import org.purpurmc.purpur.event.PlayerAFKEvent;

public class PlayerAFK implements Listener {
    @EventHandler
    public void onPlayerAFK(PlayerAFKEvent e) {
        Player player = e.getPlayer();
        if (e.isGoingAfk()) {
            // 模拟距离设置为真实视距
            if (Config.broadcastAwayEnable) {
                e.setBroadcastMsg(dispose.papi(player, dispose.randomList(Config.broadcastAwayMessages)));
            }
            player.getWorld();
            player.setSimulationDistance(player.getViewDistance());
        } else {
            if (Config.broadcastBackEnable) {
                e.setBroadcastMsg(dispose.papi(player, dispose.randomList(Config.broadcastBackMessages)));
            }
            player.getWorld();
            player.setSimulationDistance(Bukkit.getSimulationDistance());
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public static void onEntityTargetEvent(EntityTargetLivingEntityEvent e) {
        if (e.getTarget() instanceof Player player) {
            if (player.isAfk()) {
                e.setCancelled(true);
                e.setTarget(null);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player player) {
            if (player.isAfk()) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player player) {
            if (player.isAfk()) {
                e.setCancelled(true);
            }
        }
    }
}
