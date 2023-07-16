package org.encinet.afk.unit;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.encinet.afk.AFK;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class dispose {
    public static <T> T randomList(List<T> list) {
        return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }

    public static String papi(Player player, String text) {
        return AFK.pm.getPlugin("PlaceholderAPI") == null ? text : PlaceholderAPI.setPlaceholders(player, text);
    }
}
