package com.prova.whitelist;

import java.util.ArrayList;
import java.util.List;

public class WhitelistController {

    private final static List<String> allowedUsers = new ArrayList<>();

    private static boolean active;

    public static boolean inWhitelist(String name) {
        return allowedUsers.contains(name.toLowerCase());
    }

    public static void addUser(String name) {
        allowedUsers.add(name.toLowerCase());
    }

    public static void removeUser(String name) {
        allowedUsers.remove(name.toLowerCase());
    }

    public static boolean isActive() {
        return active;
    }

    public static void setActive(boolean active) {
        WhitelistController.active = active;
    }
}
