package org.rofu.nightvaip.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VaipTabCompleter implements TabCompleter {

    private final List<String> options = List.of("start", "stop", "help");

    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], options, new ArrayList<>());
        }
        return Collections.emptyList();
    }

}
