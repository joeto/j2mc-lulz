package to.joe.j2mc.lulz.command;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.J2MC_Core;
import to.joe.j2mc.core.J2MC_Manager;
import to.joe.j2mc.lulz.J2MC_Lulz;
import to.joe.j2mc.lulz.MasterCommand_Lulz;

public class FlexCommand extends MasterCommand_Lulz{
	
	public FlexCommand(J2MC_Lulz lulz){
		super(lulz);
	}
	
	private Random random = new Random();

	@Override
	public void exec(CommandSender sender, String commandName, String[] args,
			Player player, String playerName, boolean isPlayer) {
        if (!isPlayer || player.hasPermission("j2mc.lulz.flex") || playerName.equalsIgnoreCase("MrBlip")) {
            String message = "" + ChatColor.GOLD;
            switch (random.nextInt(5)) {
                case 0:
                    message += "All the ladies watch as " + playerName + " flexes";
                    break;
                case 1:
                    message += "Everybody stares as " + playerName + " flexes";
                    break;
                case 2:
                    message += "Sexy party! " + playerName + " flexes and the gods stare";
                    break;
                case 3:
                    message += playerName + " is too sexy for this party";
                    break;
                case 4:
                    message += playerName + " knows how to flex";
                    break;
            }
            if (playerName.equalsIgnoreCase("MrBlip") && random.nextBoolean()) {
                if (random.nextBoolean()) {
                    message = ChatColor.GOLD + "MrBlip shows off his chin";
                } else {
                    message = ChatColor.GOLD + "MrBlip shows off his hat";
                }
            }
            
            Bukkit.getServer().broadcastMessage(message);
            J2MC_Manager.getLog().info(ChatColor.GOLD + playerName + " flexed.");
        }
	}

}
