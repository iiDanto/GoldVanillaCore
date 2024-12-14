package dev.iiDanto.mainCore.commands.essentials;

import dev.iiDanto.mainCore.MainCore;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.eclipse.sisu.launch.Main;
import org.jetbrains.annotations.NotNull;

public class TeleportCommand implements CommandExecutor {
    private final MainCore main;

    public TeleportCommand(MainCore main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can use this command!");
            return true;
        }
        Player p = (Player) sender;
        String prefix = main.getConfig().getString("config.prefix");
        String colour = main.getConfig().getString("config.colour");
        if (args.length > 2){
            p.sendRichMessage(prefix + " &cInvalid &7Arguments!");
            p.playSound(p, Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0f);
            return true;
        }
        if (args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null && target.isOnline()){
                p.teleport(target);
                p.sendRichMessage(prefix + " <gray>Successfully " + colour + "Teleported <gray>to " + colour + target.getName());
                p.playSound(p, Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);
                return true;
            }
        }
        if (args.length == 0){
            p.sendRichMessage(prefix + " <#ff0000>Invalid <gray>arguments!");
            p.playSound(p, Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
            return true;
        }
        if (args.length == 2){
            Player target1 = Bukkit.getPlayer(args[0]);
            Player target2 = Bukkit.getPlayer(args[1]);
            if (target1 != null && target1.isOnline() && target2 != null && target2.isOnline()){
                target1.teleport(target2);
                p.sendRichMessage(prefix + " <gray>Successfully " + colour + "Teleported %t1% <gray>to ".replace("%t1%", target1.getName()) + colour + "%p2%".replace("%p2%", target2.getName()));
                p.playSound(p, Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0F);
            }
        }
        return true;
    }
}
