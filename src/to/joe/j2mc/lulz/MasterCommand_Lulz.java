package to.joe.j2mc.lulz;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.command.MasterCommand;

public abstract class MasterCommand_Lulz extends MasterCommand {

	protected final J2MC_Lulz lulz;
	
	public MasterCommand_Lulz(J2MC_Lulz plugin) {
		super(plugin);
		this.lulz=plugin;
	}

	@Override
	public abstract void exec(CommandSender sender, String commandName, String[] args, Player player, String playerName, boolean isPlayer);

    protected J2MC_Lulz getLulz(){
        return this.lulz;
    }
}
