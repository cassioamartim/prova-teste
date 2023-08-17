package com.prova.listener;

import com.prova.user.User;
import com.prova.user.UserStorage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UserListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event) {
        event.setJoinMessage(null);

        Player player = event.getPlayer();

        new User(player);

        System.out.println("Existe ? " + UserStorage.exists(player.getUniqueId()));

        player.sendMessage("§aBem-vindo(a)!");
    }

    @EventHandler
    public void quit(PlayerQuitEvent event) {
        event.setQuitMessage(null);

        UserStorage.delete(event.getPlayer().getUniqueId());

        System.out.println("Existe ? " + UserStorage.exists(event.getPlayer().getUniqueId()));
    }
}
