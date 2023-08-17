package com.prova;

import com.prova.command.ChatClearCommand;
import com.prova.command.OperationCommand;
import com.prova.command.RegisteredUserCommand;
import com.prova.command.WhitelistCommand;
import com.prova.listener.UserListener;
import com.prova.listener.WhitelistListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getCommandMap().register("whitelist", new WhitelistCommand());
        getServer().getCommandMap().register("cc", new ChatClearCommand());
        getServer().getCommandMap().register("ru", new RegisteredUserCommand());
        getServer().getCommandMap().register("operation", new OperationCommand());

        getServer().getPluginManager().registerEvents(new UserListener(), this);
        getServer().getPluginManager().registerEvents(new WhitelistListener(), this);
    }
}
