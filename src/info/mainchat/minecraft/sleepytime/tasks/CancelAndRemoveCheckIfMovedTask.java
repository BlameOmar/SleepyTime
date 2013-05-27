package info.mainchat.minecraft.sleepytime.tasks;

import info.mainchat.minecraft.sleepytime.SleepyTime;
import org.bukkit.entity.Player;

/**
 * Author: Omar Stefan Evans <omar@mainchat.info>
 * Created on: 2013-05-26
 * Description:
 * Purpose:
 */

public final class CancelAndRemoveCheckIfMovedTask extends SleepyTimeTask
{
    public CancelAndRemoveCheckIfMovedTask(SleepyTime plugin, Player player)
    {
        super(plugin, player);
    }

    public void run()
    {
        if (player == null) {
            return;
        }

        plugin.getCheckIfMovedTasks().get(player).cancel();
        plugin.getCheckIfMovedTasks().remove(player);
    }
}
