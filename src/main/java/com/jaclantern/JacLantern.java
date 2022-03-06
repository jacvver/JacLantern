package com.jaclantern;

import com.jaclantern.commands.NightVisionToggle;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;



public class JacLantern extends JavaPlugin {

    private static JacLantern instance;

    @Override
    public void onEnable() {
        instance = this;
        loadConfig();
        loadCommands();
    }

    public void loadCommands(){
        getCommand("nv").setExecutor(new NightVisionToggle());
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static JacLantern getInstance() {
        return instance;
    }
}
