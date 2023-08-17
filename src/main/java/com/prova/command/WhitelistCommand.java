package com.prova.command;

import com.prova.whitelist.WhitelistController;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class WhitelistCommand extends Command {

    public WhitelistCommand() {
        super("whitelist");
    }

    @Override
    public boolean execute(CommandSender sender, String lb, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(new String[]{
                    "§cComo usar /" + lb + ":",
                    "§c* /" + lb + " stats - §eAtive ou desative a whitelist.",
                    "§c* /" + lb + " add/remove <nick> - §eAdicione ou remova um jogador da whitelist."
            });
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "stats": {
                WhitelistController.setActive(!WhitelistController.isActive());

                sender.sendMessage(WhitelistController.isActive()
                        ? "§aA whitelist foi ativada!"
                        : "§cA whitelist foi desativada!");

                break;
            }
            case "add": {
                if (args.length == 1) {
                    sender.sendMessage("§cComo usar: /" + lb + " add <nick>.");
                    return false;
                }

                String name = args[1];

                if (WhitelistController.inWhitelist(name)) {
                    sender.sendMessage("§cEste jogador já está na whitelist!");
                    return false;
                }

                WhitelistController.addUser(name);

                sender.sendMessage("§eJogador §b" + name + "§e adicionado na whitelist!");
                break;
            }
            case "remove": {
                if (args.length == 1) {
                    sender.sendMessage("§cComo usar: /" + lb + " remove <nick>.");
                    return false;
                }

                String name = args[1];

                if (!WhitelistController.inWhitelist(name)) {
                    sender.sendMessage("§cEste jogador não está na whitelist!");
                    return false;
                }

                WhitelistController.removeUser(name);

                sender.sendMessage("§cJogador §e" + name + "§c removido da whitelist!");
                break;
            }
            default: {
                sender.sendMessage(new String[]{
                        "§cComo usar /" + lb + ":",
                        "§c* /" + lb + " on/off - §eAtive ou desative a whitelist.",
                        "§c* /" + lb + " add/remove <nick> - §eAdicione ou remova um jogador da whitelist."
                });
                break;
            }
        }

        return false;
    }
}
