package com.prova.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public class ChatClearCommand extends Command {

    public ChatClearCommand() {
        super("cc");
    }

    @Override
    public boolean execute(CommandSender sender, String lb, String[] args) {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();

        for (int i = 0; i < 100; i++)
            players.forEach(player -> player.sendMessage(""));

        players.forEach(player -> player.sendMessage("§eO chat do servidor foi limpo por §b" + sender.getName() + "§e!"));

        return false;
    }
}
