package to.joe.j2mc.lulz;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.craftbukkit.CraftWorld;

import to.joe.j2mc.lulz.command.AFKCommand;
import to.joe.j2mc.lulz.command.ExtMeCommand;
import to.joe.j2mc.lulz.command.FlexCommand;
import to.joe.j2mc.lulz.command.HugglesCommand;

public class J2MC_Lulz extends JavaPlugin implements Listener {

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

        this.getServer().getPluginManager().registerEvents(this, this);
        this.huggles = new HashMap<String, Integer>();
    }

    private HashMap<String, Integer> huggles;

    public void hug(Player player) {
        this.unhug(player.getName());
        this.burst(player);
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

    public void burst(Player player) {
        System.out.println("Bursting " + player.getName());
        final double d0 = this.random.nextGaussian() * 0.02D;
        final double d1 = this.random.nextGaussian() * 0.02D;
        final double d2 = this.random.nextGaussian() * 0.02D;
        final Location location = player.getLocation();
        final double locX = location.getX();
        final double locY = location.getY();
        final double locZ = location.getZ();
        ((CraftWorld) player.getWorld()).getHandle().a("heart", (locX + (this.random.nextFloat() * this.width * 2.0F)) - this.width, locY + 0.5D + (this.random.nextFloat() * this.length), (locZ + (this.random.nextFloat() * this.width * 2.0F)) - this.width, d0, d1, d2);
    }

    public Random random = new Random();
    float width = 0.6F;
    float length = 1.8F;

    private class Love implements Runnable {

        private final Player player;

        public Love(Player player) {
            this.player = player;
        }

        @Override
        public void run() {
            J2MC_Lulz.this.burst(this.player);
        }

    }

}
