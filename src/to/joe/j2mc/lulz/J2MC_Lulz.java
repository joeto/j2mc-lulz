package to.joe.j2mc.lulz;

import org.bukkit.plugin.java.JavaPlugin;

import to.joe.j2mc.lulz.command.AFKCommand;
import to.joe.j2mc.lulz.command.ExtMeCommand;
import to.joe.j2mc.lulz.command.FlexCommand;

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
    }

}
