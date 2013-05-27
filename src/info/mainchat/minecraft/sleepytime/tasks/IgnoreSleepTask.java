package info.mainchat.minecraft.sleepytime.tasks;

import info.mainchat.minecraft.sleepytime.SleepyTime;
import org.bukkit.entity.Player;

/**
 * Author: Omar Stefan Evans <omar@mainchat.info>
 * Created on: 2013-05-26
 * Description:
 * Purpose:
 */

public final class IgnoreSleepTask extends SleepyTimeTask
{
    public IgnoreSleepTask(SleepyTime plugin, Player player)
    {
        super(plugin, player);
    }

    @Override
    public void run()
    {
        player.setSleepingIgnored(true);
    }
}
