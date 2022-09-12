package com.github.maheevil.glacier;

import org.bukkit.Server;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class GlacierTweaksPlugin extends JavaPlugin {
    public static Server server;
    public static GlacierTweaksPlugin glacierTweaksPlugin;
    public static Configuration config;
    @Override
    public void onEnable(){
        this.reloadConfig();
        glacierTweaksPlugin = this;
        config = this.getConfig();
        this.getServer().getPluginManager().registerEvents(new EventListener(),this);
        this.getCommand("setCrypt").setExecutor(
                (sender, command, label, args) -> {
                    try{
                        Configuration config = GlacierTweaksPlugin.config;
                        config.set("cryptx",Integer.parseInt(args[0]));
                        config.set("crypty",Integer.parseInt(args[1]));
                        config.set("cryptz",Integer.parseInt(args[2]));
                        glacierTweaksPlugin.saveConfig();
                        return true;
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                        return false;
                    }
                }
        );
        server = this.getServer();
    }

    @Override
    public void onDisable() {

    }
}
