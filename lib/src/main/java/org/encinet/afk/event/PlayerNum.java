package org.encinet.afk.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.encinet.afk.Check;

public class PlayerNum implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Check.move.remove(e.getPlayer());
    }
}
