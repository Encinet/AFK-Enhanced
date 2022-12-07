package org.encinet.afk;

import java.util.Objects;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AFK extends JavaPlugin {
    public static final Logger logger = Logger.getLogger("AFK-Enhanced");
    public static final PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.info("注册指令");
        if (Bukkit.getPluginCommand("afk") != null) {
            Objects.requireNonNull(Bukkit.getPluginCommand("afk")).setExecutor(new Command());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
