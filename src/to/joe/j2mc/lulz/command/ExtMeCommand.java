package to.joe.j2mc.lulz.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.command.MasterCommand;
import to.joe.j2mc.lulz.J2MC_Lulz;

public class ExtMeCommand extends MasterCommand<J2MC_Lulz> {

    public ExtMeCommand(J2MC_Lulz lulz) {
        super(lulz);
    }

    @Override
    public void exec(CommandSender sender, String commandName, String[] args, Player player, boolean isPlayer) {
        if (isPlayer && player.hasPermission("j2mc.lulz.extinguish")) {
            player.setFireTicks(600);
            player.sendMessage(ChatColor.RED + "You have been extinguished!");
        }
    }

}
