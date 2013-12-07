/*
 * ©2013 Omar Stefan Evans <omar@evansbros.info>
 *
 * Permission is hereby granted to all persons to use and redistribute this software
 * for any purpose, with or without modification, provided that this notice appears
 * in all copies or substantial portions of the software.
 */

package info.mainchat.minecraft.sleepytime.tasks;

import info.mainchat.minecraft.sleepytime.SleepyTime;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class CancelAndRemoveIgnoreSleepTask extends SleepyTimeTask {
    public CancelAndRemoveIgnoreSleepTask(SleepyTime plugin, String playerName) {
        super(plugin, playerName);
    }

    @Override
    public void run() {
        Player player = Bukkit.getPlayer(playerName);
        if (player == null) {
            return;
        }

        player.setSleepingIgnored(false);

        plugin.getIgnoreSleepTasks().get(playerName).cancel();
        plugin.getIgnoreSleepTasks().remove(playerName);
    }
}
