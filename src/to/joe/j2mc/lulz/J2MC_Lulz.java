package to.joe.j2mc.lulz;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.craftbukkit.CraftWorld;

import to.joe.j2mc.lulz.command.AFKCommand;
import to.joe.j2mc.lulz.command.ExtMeCommand;
import to.joe.j2mc.lulz.command.FlexCommand;
import to.joe.j2mc.lulz.command.HugglesCommand;

public class J2MC_Lulz extends JavaPlugin {

    @Override
    public void onDisable() {
        this.getLogger().info("Joke module disabled");
    }

    @Override
    public void onEnable() {
        this.getLogger().info("Joke module enabled");

        this.getCommand("flex").setExecutor(new FlexCommand(this));
        this.getCommand("afk").setExecutor(new AFKCommand(this));
        this.getCommand("extme").setExecutor(new ExtMeCommand(this));
        this.getCommand("huggles").setExecutor(new HugglesCommand(this));
    }

    private HashMap<String, Integer> huggles;

    public void hug(Player player) {
        this.unhug(player.getName());
        this.huggles.put(player.getName(), this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Love(player), 5, 5));
    }

    private void unhug(String name) {
        if (this.huggles.containsKey(name)) {
            this.getServer().getScheduler().cancelTask(this.huggles.get(name));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        this.unhug(event.getPlayer().getName());
    }

    public Random random = new Random();

    private class Love implements Runnable {

        private final Player player;
        World world;
        float width = 0.6F;
        float length = 1.8F;

        public Love(Player player) {
            this.player = player;
            this.world = player.getWorld();
        }

        @Override
        public void run() {
            final double d0 = J2MC_Lulz.this.random.nextGaussian() * 0.02D;
            final double d1 = J2MC_Lulz.this.random.nextGaussian() * 0.02D;
            final double d2 = J2MC_Lulz.this.random.nextGaussian() * 0.02D;
            final Location location = this.player.getLocation();
            final double locX = location.getX();
            final double locY = location.getY();
            final double locZ = location.getZ();

            ((CraftWorld) this.world).getHandle().a("heart", (locX + (J2MC_Lulz.this.random.nextFloat() * this.width * 2.0F)) - this.width, locY + 0.5D + (J2MC_Lulz.this.random.nextFloat() * this.length), (locZ + (J2MC_Lulz.this.random.nextFloat() * this.width * 2.0F)) - this.width, d0, d1, d2);
        }

    }

}
