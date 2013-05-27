package info.mainchat.minecraft.sleepytime;

import info.mainchat.minecraft.sleepytime.tasks.AddCheckIfMovedTask;
import info.mainchat.minecraft.sleepytime.tasks.AddIgnoreSleepTask;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

/**
 * Author: Omar Stefan Evans <omar@mainchat.info>
 * Created on: 2013-05-26
 * Description:
 * Purpose:
 */

public class SleepyTime extends JavaPlugin
{
    private PlayerListener playerListener;

    private HashMap<Player, BukkitTask> ignoreSleepTasks;
    private HashMap<Player, BukkitTask> checkIfMovedTasks;

    private long ignoreSleepTaskDelay;
    private long checkIfMovedTaskDelay;

    @Override
    public void onEnable()
    {
        playerListener = new PlayerListener(this);

        ignoreSleepTaskDelay = 20 * 60;
        ignoreSleepTasks = new HashMap<Player, BukkitTask>();
        for (Player player : getServer().getOnlinePlayers()) {
            getServer().getScheduler().runTask(this, new AddIgnoreSleepTask(this, player));
        }

        checkIfMovedTaskDelay = 20 * 30;
        checkIfMovedTasks = new HashMap<Player, BukkitTask>();
        for (Player player : getServer().getOnlinePlayers()) {
            getServer().getScheduler().runTask(this, new AddCheckIfMovedTask(this, player));
        }

        getServer().getPluginManager().registerEvents(playerListener, this);
    }

    @Override
    public void onDisable()
    {
        getServer().getScheduler().cancelTasks(this);

        checkIfMovedTasks = null;
        ignoreSleepTasks = null;
        playerListener = null;
    }

    public HashMap<Player, BukkitTask> getIgnoreSleepTasks()
    {
        return ignoreSleepTasks;
    }

    public long getIgnoreSleepTaskDelay()
    {
        return ignoreSleepTaskDelay;
    }

    public  HashMap<Player, BukkitTask> getCheckIfMovedTasks()
    {
        return checkIfMovedTasks;
    }

    public long getCheckIfMovedTaskDelay()
    {
        return checkIfMovedTaskDelay;
    }
}
