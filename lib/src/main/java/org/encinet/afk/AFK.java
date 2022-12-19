package org.encinet.afk;

import java.util.Objects;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.encinet.afk.event.PlayerAFK;
import org.encinet.afk.event.PlayerNum;

public final class AFK extends JavaPlugin {
    public static final Logger logger = Logger.getLogger("AFK-Enhanced");
    public static Plugin plugin;
    public static final PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = JavaPlugin.getProvidingPlugin(AFK.class);

        logger.info("加载配置文件");
        saveDefaultConfig();
        reloadConfig();
        Config.load();

        logger.info("注册监听");
        pm.registerEvents(new PlayerAFK(), this);
        pm.registerEvents(new PlayerNum(), this);

        logger.info("注册指令");
        if (Bukkit.getPluginCommand("afk") != null) {
            Objects.requireNonNull(Bukkit.getPluginCommand("afk")).setExecutor(new Command());
        }

        logger.info("注册任务");
        new Check().start();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
