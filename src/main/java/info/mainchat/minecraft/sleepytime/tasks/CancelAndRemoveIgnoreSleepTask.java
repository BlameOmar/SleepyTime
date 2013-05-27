package info.mainchat.minecraft.sleepytime.tasks;

import info.mainchat.minecraft.sleepytime.SleepyTime;
import org.bukkit.entity.Player;

/**
 * Author: Omar Stefan Evans <omar@mainchat.info>
 * Created on: 2013-05-26
 * Description:
 * Purpose:
 */

public final class CancelAndRemoveIgnoreSleepTask extends SleepyTimeTask
{
    public CancelAndRemoveIgnoreSleepTask(SleepyTime plugin, Player player)
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

        plugin.getIgnoreSleepTasks().get(player).cancel();
        plugin.getIgnoreSleepTasks().remove(player);
    }
}
