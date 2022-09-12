package com.github.maheevil.glacier;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerRespawnEvent;


@SuppressWarnings("deprecation")
public class EventListener implements Listener {
    @EventHandler
    public void preCommand(PlayerCommandPreprocessEvent commandEvent){
        if(commandEvent.getMessage().contains("vanish") && !commandEvent.getMessage().contains("unvanish")) {
            GlacierTweaksPlugin.server.sendMessage(Component.text(
                    commandEvent.getPlayer().getDisplayName() + " left the game"
            ).color(NamedTextColor.YELLOW));
        }else if(commandEvent.getMessage().contains("unvanish")){
            commandEvent.setMessage("/vanish");
            GlacierTweaksPlugin.server.sendMessage(Component.text(
                    commandEvent.getPlayer().getDisplayName() + " joined the game"
            ).color(NamedTextColor.YELLOW));
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent respawnEvent){
        if(respawnEvent.isBedSpawn() || respawnEvent.isAnchorSpawn()){
            return;
        }
        respawnEvent.setRespawnLocation(
                new Location(
                        respawnEvent.getRespawnLocation().getWorld(),
                        GlacierTweaksPlugin.config.getInt("cryptx"),
                        GlacierTweaksPlugin.config.getInt("crypty"),
                        GlacierTweaksPlugin.config.getInt("cryptz")
                )
        );
    }
}
