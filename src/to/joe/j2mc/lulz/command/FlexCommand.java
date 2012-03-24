package to.joe.j2mc.lulz.command;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.command.MasterCommand;
import to.joe.j2mc.lulz.J2MC_Lulz;

public class FlexCommand extends MasterCommand {

    private final Random random = new Random();

    public FlexCommand(J2MC_Lulz lulz) {
        super(lulz);
    }

    @Override
    public void exec(CommandSender sender, String commandName, String[] args, Player player, boolean isPlayer) {
        if (isPlayer && (sender.hasPermission("j2mc.lulz.flex") || player.getName().equalsIgnoreCase("MrBlip"))) {
            String message = "" + ChatColor.GOLD;
            switch (this.random.nextInt(5)) {
                case 0:
                    message += "All the ladies watch as " + player.getName() + " flexes";
                    break;
                case 1:
                    message += "Everybody stares as " + player.getName() + " flexes";
                    break;
                case 2:
                    message += "Sexy party! " + player.getName() + " flexes and the gods stare";
                    break;
                case 3:
                    message += player.getName() + " is too sexy for this party";
                    break;
                case 4:
                    message += player.getName() + " knows how to flex";
                    break;
            }
            if (player.getName().equalsIgnoreCase("MrBlip") && this.random.nextBoolean()) {
                if (this.random.nextBoolean()) {
                    message = ChatColor.GOLD + "MrBlip shows off his chin";
                } else {
                    message = ChatColor.GOLD + "MrBlip shows off his hat";
                }
            }

            Bukkit.getServer().broadcastMessage(message);
            this.plugin.getLogger().info(ChatColor.GOLD + player.getName() + " flexed.");
        }
    }

}
