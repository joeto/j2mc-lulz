package to.joe.j2mc.lulz.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.J2MC_Manager;
import to.joe.j2mc.lulz.J2MC_Lulz;
import to.joe.j2mc.lulz.MasterCommand_Lulz;

public class AFKCommand extends MasterCommand_Lulz{
	
	public AFKCommand(J2MC_Lulz lulz){
		super(lulz);
	}

	@Override
	public void exec(CommandSender sender, String commandName, String[] args,
			Player player, String playerName, boolean isPlayer) {
		if(isPlayer){
		player.kickPlayer("Kicked: AFK");
		J2MC_Manager.getCore().adminAndLog(ChatColor.RED + "Kicking " + playerName + " by BobTheAFKer : AFK");
		J2MC_Manager.getCore().messageByPermission("receive.nomadin", ChatColor.RED + playerName + " kicked (AFK)");
		//TODO: broadcast leave message
		}
	}

}
