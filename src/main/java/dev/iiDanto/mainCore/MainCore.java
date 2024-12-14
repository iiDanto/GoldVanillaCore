package dev.iiDanto.mainCore;

import dev.iiDanto.mainCore.commands.essentials.TeleportCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainCore extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("teleport").setExecutor(new TeleportCommand(this));
    }

}
