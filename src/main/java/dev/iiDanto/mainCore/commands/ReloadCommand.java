package dev.iiDanto.mainCore.commands;

import dev.iiDanto.mainCore.MainCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.eclipse.sisu.launch.Main;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    private final MainCore main;

    public ReloadCommand(MainCore main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can execute this command!");
            return true;
        }
        Player p = (Player) sender;
        main.reloadConfig();
        String prefix = main.getConfig().getString("config.prefix");
        String colour = main.getConfig().getString("config.colour");
        p.sendRichMessage(prefix + " <gray>Successfully Reloaded the " + colour + "Configuration");
        return true;
    }
}
