/*
 * ©2013 Omar Stefan Evans <omar@evansbros.info>
 *
 * Permission is hereby granted to all persons to use and redistribute this software
 * for any purpose, with or without modification, provided that this notice appears
 * in all copies or substantial portions of the software.
 */

package info.mainchat.minecraft.sleepytime.tasks;

import info.mainchat.minecraft.sleepytime.SleepyTime;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class SleepyTimeTask extends BukkitRunnable {
    protected final SleepyTime plugin;
    protected final String playerName;

    public SleepyTimeTask(SleepyTime plugin, String playerName) {
        this.plugin = plugin;
        this.playerName = playerName;
    }

}
