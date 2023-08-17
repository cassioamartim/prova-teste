package com.prova.user;

import org.bukkit.entity.Player;

import java.util.UUID;

public class User {

    private final UUID uuid;
    private final String name;

    public User(Player player) {
        this.uuid = player.getUniqueId();
        this.name = player.getName();

        UserStorage.save(this);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}

