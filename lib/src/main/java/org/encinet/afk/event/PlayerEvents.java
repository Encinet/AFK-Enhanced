package org.encinet.afk.event;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.encinet.afk.tasks.Check;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onPlayerEvent(AsyncChatEvent e) {
        // 聊天
        update(e.getPlayer());
    }
    @EventHandler
    public void onPlayerEvent(PlayerCommandPreprocessEvent e) {
        // 输入命令事件
        update(e.getPlayer());
    }

    private void update(Player player) {
        if (!player.isAfk()) {
            Check.get(player).setTimeNow();
        }
    }
}
