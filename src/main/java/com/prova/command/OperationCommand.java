package com.prova.command;

import com.prova.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

public class OperationCommand extends Command {

    public OperationCommand() {
        super("operation");
    }

    @Override
    public boolean execute(CommandSender sender, String lb, String[] args) {

        sender.sendMessage("§aIniciando...");

        new BukkitRunnable() {
            int time = 5;

            @Override
            public void run() {
                time--;

                if (time <= 5 && time >= 3) {
                    sender.sendMessage("§etempo " + time);
                }

                if (time <= 2 && time >= 1) {
                    sender.sendMessage("§atempo " + time);
                }

                if (time == 0) {
                    // enviar pra warp
                }

                if (time <= 5 && time >= 1) {
                    sender.sendMessage("§cTempo atual: §e" + time);
                }

                if (time == 0) {
                    sender.sendMessage("§cO tempo acabou!");
                    cancel();
                }

            }
        }.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);

        return false;
    }
}
