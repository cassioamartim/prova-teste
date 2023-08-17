package com.prova.command;

import com.prova.user.User;
import com.prova.user.UserStorage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class RegisteredUserCommand extends Command {

    public RegisteredUserCommand() {
        super("ru");
    }

    @Override
    public boolean execute(CommandSender sender, String lb, String[] args) {

        for (User user : UserStorage.getUsers()) {
            System.out.println(user.getName());
        }

        // UserStorage.getUsers().forEach(user -> System.out.println(user.getName()));

        sender.sendMessage("§aLista enviada!");

        return false;
    }
}
