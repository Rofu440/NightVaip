package org.rofu.nightvaip;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.rofu.nightvaip.commands.VaipCommand;
import org.rofu.nightvaip.commands.VaipTabCompleter;

public final class NightVaip extends JavaPlugin {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        getLogger().info("Включен");
        saveDefaultConfig();
        getCommand("Vaip").setExecutor(new VaipCommand(this));
        getCommand("Vaip").setTabCompleter(new VaipTabCompleter());
    }

    @Override
    public void onDisable() {
        getLogger().info("Выключен");
    }
}
