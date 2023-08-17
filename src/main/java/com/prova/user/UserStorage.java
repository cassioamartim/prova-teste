package com.prova.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserStorage {

    private static final Map<UUID, User> map = new HashMap<>();

    public static Collection<User> getUsers() {
        return map.values();
    }

    public static void save(User user) {
        map.put(user.getUuid(), user);
    }

    public static void delete(UUID uuid) {
        map.remove(uuid);
    }

    public static boolean exists(UUID uuid) {
        return map.containsKey(uuid);
    }

    public static User get(UUID uuid) {
        return map.get(uuid);
    }
}