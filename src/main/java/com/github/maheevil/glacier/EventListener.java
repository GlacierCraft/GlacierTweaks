package com.github.maheevil.glacier;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


@SuppressWarnings("deprecation")
public class EventListener implements Listener {
    @EventHandler
    public void preCommand(PlayerCommandPreprocessEvent commandEvent){
        if (commandEvent.getMessage().contains("vanish")) {
            GlacierTweaksPlugin.server.sendMessage(Component.text(
                    commandEvent.getPlayer().getDisplayName() + " left the game"
            ).color(NamedTextColor.YELLOW));
        }
    }
}
