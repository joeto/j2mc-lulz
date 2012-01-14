package to.joe.j2mc.lulz.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.lulz.J2MC_Lulz;
import to.joe.j2mc.lulz.MasterCommand_Lulz;

public class ExtMeCommand extends MasterCommand_Lulz {
	
	public ExtMeCommand(J2MC_Lulz lulz){
		super(lulz);
	}
	
	@Override
	public void exec(CommandSender sender, String commandName, String[] args,
			Player player, String playerName, boolean isPlayer) {
		if(isPlayer && player.hasPermission("j2mc.lulz.extinguish")){
			player.setFireTicks(300);
		}
	}

}
