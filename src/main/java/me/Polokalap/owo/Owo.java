package me.Polokalap.owo;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import io.papermc.paper.event.player.PlayerArmSwingEvent;
import org.bukkit.Location;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Owo extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("The plugin has started.");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has ended.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws InterruptedException {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GOLD + player.getName() + " Welcome to the server.");
        player.sendMessage(ChatColor.GOLD + "Your name is " + player.getName());
        player.sendMessage(ChatColor.GOLD + "Your hp is " + player.getHealth());
        player.sendMessage(ChatColor.GOLD + "Your ping is " + player.getPing());
    }

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();

        player.getWorld().spawnEntity(location, EntityType.ARROW);
        player.getWorld().spawnEntity(location, EntityType.ENDER_CRYSTAL);
        player.getWorld().spawnEntity(location, EntityType.LIGHTNING);
        player.getWorld().spawnEntity(location, EntityType.MINECART_TNT);
        player.setHealth(1);
    }
}