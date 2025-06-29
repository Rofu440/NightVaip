package org.rofu.nightvaip.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.rofu.nightvaip.NightVaip;

import java.util.List;

public class VaipCommand implements CommandExecutor {

    private final NightVaip plugin;

    public VaipCommand(NightVaip plugin){
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!sender.hasPermission("Vaip.admin")){
            sender.sendMessage(ChatColor.RED + "Нет прав!");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "Используйте /nightvaip help");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "start":
                executeCommands(plugin.getConfig().getStringList("start"), sender);
                break;
            case "stop":
                executeCommands(plugin.getConfig().getStringList("stop"), sender);
                break;
            case "help":
                List<String> info = plugin.getConfig().getStringList("info");
                info.forEach(sender::sendMessage);
                break;

        }
        return true;
    }
    private void executeCommands(List<String> commands, CommandSender sender){
        for (String command : commands) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
        sender.sendMessage(ChatColor.GREEN + "Успешно");
    }
}
