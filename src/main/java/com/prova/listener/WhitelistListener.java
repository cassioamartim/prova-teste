package com.prova.listener;

import com.prova.whitelist.WhitelistController;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class WhitelistListener implements Listener {

    @EventHandler
    public void onAsyncPreLogin(AsyncPlayerPreLoginEvent event) {
        String name = event.getName();

        if (WhitelistController.isActive() && !WhitelistController.inWhitelist(name)) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, "§cO servidor está em manutenção!");
        }
    }
}
