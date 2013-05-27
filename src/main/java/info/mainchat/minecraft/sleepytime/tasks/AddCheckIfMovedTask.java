package info.mainchat.minecraft.sleepytime.tasks;

import info.mainchat.minecraft.sleepytime.SleepyTime;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/**
 * Author: Omar Stefan Evans <omar@mainchat.info>
 * Created on: 2013-05-26
 * Description:
 * Purpose:
 */

public final class AddCheckIfMovedTask extends SleepyTimeTask {
    public AddCheckIfMovedTask(SleepyTime plugin, Player player)
    {
        super(plugin, player);
    }

    @Override
    public void run()
    {
        if (player == null) {
            return;
        }

        BukkitTask task = plugin.getCheckIfMovedTasks().get(player);
        if (task != null) {
            task.cancel();
        }

        long delay = plugin.getCheckIfMovedTaskDelay();
        task = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, new CheckIfMovedTask(plugin, player), delay, delay);
        plugin.getCheckIfMovedTasks().put(player, task);
    }
}
