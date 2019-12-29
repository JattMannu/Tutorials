package com.example.demo.Plugins;

import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {
    @Override
    public void onDisable() {
        getLogger().info("onDisable is triggered.");
    }

    @Override
    public void onEnable() {
        getLogger().info("onEnable is triggered.");
    }
}
