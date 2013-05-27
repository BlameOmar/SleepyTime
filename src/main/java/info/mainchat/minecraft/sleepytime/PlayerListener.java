package info.mainchat.minecraft.sleepytime;

import info.mainchat.minecraft.sleepytime.tasks.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;

/**
 * Author: Omar Stefan Evans <omar@mainchat.info>
 * Created on: 2013-05-26
 * Description:
 * Purpose:
 */
public class PlayerListener implements Listener
{
    SleepyTime plugin;

    public PlayerListener(SleepyTime plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        plugin.getServer().getScheduler().runTask(plugin, new AddIgnoreSleepTask(plugin, event.getPlayer()));
        plugin.getServer().getScheduler().runTask(plugin, new AddCheckIfMovedTask(plugin, event.getPlayer()));
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        plugin.getServer().getScheduler().runTask(plugin, new CancelAndRemoveIgnoreSleepTask(plugin, event.getPlayer()));
        plugin.getServer().getScheduler().runTask(plugin, new CancelAndRemoveCheckIfMovedTask(plugin, event.getPlayer()));
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer()));
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onPlayerInteractsWithEntity(PlayerInteractEntityEvent event)
    {
        plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer()));
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onPlayerDroppedItem(PlayerDropItemEvent event)
    {
        plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer()));
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onInventoryOpen(InventoryOpenEvent event)
    {
        //Unfortunately, getPlayer returns HumanEntities on this event, not Players.
        if (event.getPlayer() instanceof Player) {
            plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, (Player) event.getPlayer()));
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onInventoryClose(InventoryCloseEvent event)
    {
        //Unfortunately, getPlayer returns HumanEntities on this event, not Players.
        if (event.getPlayer() instanceof Player) {
            plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, (Player) event.getPlayer()));
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onInventoryClick(InventoryClickEvent event)
    {
        //Unfortunately, getPlayer returns HumanEntities on this event, not Players.
        if (event.getWhoClicked() instanceof Player) {
            plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, (Player) event.getWhoClicked()));
        }
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, event.getPlayer()));
    }
}
