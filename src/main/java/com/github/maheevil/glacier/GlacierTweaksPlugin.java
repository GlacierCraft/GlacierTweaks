package com.github.maheevil.glacier;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class GlacierTweaksPlugin extends JavaPlugin {
    public static Server server;
    @Override
    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(new EventListener(),this);
        server = this.getServer();
    }

    @Override
    public void onDisable() {

    }
}
