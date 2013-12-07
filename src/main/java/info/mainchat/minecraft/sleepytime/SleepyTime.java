/*
 * ©2013 Omar Stefan Evans <omar@evansbros.info>
 *
 * Permission is hereby granted to all persons to use and redistribute this software
 * for any purpose, with or without modification, provided that this notice appears
 * in all copies or substantial portions of the software.
 */

package info.mainchat.minecraft.sleepytime;

import info.mainchat.minecraft.sleepytime.tasks.AddIgnoreSleepTask;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class SleepyTime extends JavaPlugin {
    private PlayerListener playerListener;

    private HashMap<String, BukkitTask> ignoreSleepTasks;

    private long ignoreSleepTaskDelay;

    @Override
    public void onEnable() {
        playerListener = new PlayerListener(this);

        ignoreSleepTaskDelay = 20 * 60;
        ignoreSleepTasks = new HashMap<>();
        for (Player player : getServer().getOnlinePlayers()) {
            getServer().getScheduler().runTask(this, new AddIgnoreSleepTask(this, player.getName()));
        }

        getServer().getPluginManager().registerEvents(playerListener, this);
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);

        ignoreSleepTasks = null;
        playerListener = null;
    }

    public HashMap<String, BukkitTask> getIgnoreSleepTasks() {
        return ignoreSleepTasks;
    }

    public long getIgnoreSleepTaskDelay() {
        return ignoreSleepTaskDelay;
    }

}
