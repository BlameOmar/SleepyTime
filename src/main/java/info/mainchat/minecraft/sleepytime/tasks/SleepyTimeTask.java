package info.mainchat.minecraft.sleepytime.tasks;

import info.mainchat.minecraft.sleepytime.SleepyTime;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Author: Omar Stefan Evans <omar@mainchat.info>
 * Created on: 2013-05-26
 * Description:
 * Purpose:
 */

public abstract class SleepyTimeTask extends BukkitRunnable {
    protected final SleepyTime plugin;
    protected final Player player;

    public SleepyTimeTask(SleepyTime plugin, Player player)
    {
        this.plugin = plugin;
        this.player = player;
    }

}
