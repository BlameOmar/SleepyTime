/*
 * ©2013 Omar Stefan Evans <omar@evansbros.info>
 *
 * Permission is hereby granted to all persons to use and redistribute this software
 * for any purpose, with or without modification, provided that this notice appears
 * in all copies or substantial portions of the software.
 */

package info.mainchat.minecraft.sleepytime;

import info.mainchat.minecraft.sleepytime.tasks.AddIgnoreSleepTask;
import info.mainchat.minecraft.sleepytime.tasks.CancelAndRemoveIgnoreSleepTask;
import info.mainchat.minecraft.sleepytime.tasks.ResetIgnoreSleepTask;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class PlayerListener implements Listener {
    SleepyTime plugin;

    public PlayerListener(SleepyTime plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerJoins(PlayerJoinEvent event) {
        plugin.getServer().getScheduler().runTask(plugin, new AddIgnoreSleepTask(plugin, event.getPlayer().getName()));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerQuits(PlayerQuitEvent event) {
        plugin.getServer().getScheduler().runTask(plugin, new CancelAndRemoveIgnoreSleepTask(plugin, event.getPlayer().getName()));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteracts(PlayerInteractEvent event) {
        plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer().getName()));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteractsWithEntity(PlayerInteractEntityEvent event) {
        plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer().getName()));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerDropsItem(PlayerDropItemEvent event) {
        plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer().getName()));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerChats(AsyncPlayerChatEvent event) {
        plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer().getName()));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerMovesArm(PlayerAnimationEvent event) {
        if (event.getAnimationType() == PlayerAnimationType.ARM_SWING) {
            plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer().getName()));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerChangesHeldItem(PlayerAnimationEvent event) {
        plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer().getName()));
    }
}
