package org.encinet.afk;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public static boolean broadcastAwayEnable;
    public static List<String> broadcastAwayMessages;
    public static boolean broadcastBackEnable;
    public static List<String> broadcastBackMessages;
    public static long notMoveTime;

    private static FileConfiguration config() {
        return AFK.plugin.getConfig();
    }

    public static void load() {
        broadcastAwayEnable = config().getBoolean("broadcast-away.enable", false);
        broadcastAwayMessages = config().getStringList("broadcast-away.message");
        broadcastBackEnable = config().getBoolean("broadcast-back.enable", false);
        broadcastBackMessages = config().getStringList("broadcast-back.message");
        notMoveTime = config().getLong("not-move-time");
    }

}
