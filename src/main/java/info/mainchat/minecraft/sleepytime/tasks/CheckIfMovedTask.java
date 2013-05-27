package info.mainchat.minecraft.sleepytime.tasks;

import info.mainchat.minecraft.sleepytime.SleepyTime;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * Author: Omar Stefan Evans <omar@mainchat.info>
 * Created on: 2013-05-26
 * Description:
 * Purpose:
 */

public final class CheckIfMovedTask extends SleepyTimeTask {
    private Location lastLocation;
    private World lastWorld;

    public CheckIfMovedTask(SleepyTime plugin, Player player)
    {
        super(plugin, player);
        synchronized (this.player) {
            lastLocation = this.player.getLocation();
            lastWorld = this.player.getWorld();
        }

    }

    @Override
    public void run()
    {
        Location currentLocation;
        World currentWorld;

        synchronized (player) {
            currentLocation = player.getLocation();
            currentWorld = player.getWorld();
        }

        if (currentWorld != lastWorld ||
                currentLocation.getBlockX() != lastLocation.getBlockX() ||
                currentLocation.getBlockY() != lastLocation.getBlockY() ||
                currentLocation.getBlockZ() != lastLocation.getBlockZ()
                ) {
            plugin.getServer().getScheduler().runTask(plugin, new ResetIgnoreSleepTask(plugin, player));
        }
        lastLocation = currentLocation;
        lastWorld = currentWorld;
    }
}
