package org.encinet.afk.unit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Tools {
    public static Collection<Player> getAfkPlayers() {
        Collection<Player> players = new ArrayList<>();
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        for (Player p : onlinePlayers) {
            if (p.isAfk()) {
                players.add(p);
            }
        }
        return players;
    }
}
