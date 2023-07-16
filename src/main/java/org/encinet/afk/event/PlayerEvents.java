package org.encinet.afk.event;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.encinet.afk.tasks.Check;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent e) {
        // 移动事件
        update(e.getPlayer());
    }
    @EventHandler
    public void onPlayerChatEvent(AsyncChatEvent e) {
        // 聊天
        update(e.getPlayer());
    }
    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
        // 输入命令事件
        update(e.getPlayer());
    }
    @EventHandler
    public void onPlayerCommandSendEvent(PlayerCommandSendEvent e) {
        // 执行命令事件
        update(e.getPlayer());
    }

    private void update(Player player) {
        if (!player.isAfk()) {
            Check.setTimeNow(player);
        }
    }
}
