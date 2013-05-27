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

public final class ResetIgnoreSleepTask extends SleepyTimeTask
{
    public ResetIgnoreSleepTask(SleepyTime plugin, Player player)
    {
        super(plugin, player);
    }

    @Override
    public void run()
    {
        if (player == null) {
            return;
        }
        player.setSleepingIgnored(false);

        BukkitTask task = plugin.getIgnoreSleepTasks().get(player);
        if (task != null) {
            task.cancel();
            task = new IgnoreSleepTask(plugin, player).runTaskLater(plugin, plugin.getIgnoreSleepTaskDelay());
            plugin.getIgnoreSleepTasks().put(player, task);
        }
    }
}
