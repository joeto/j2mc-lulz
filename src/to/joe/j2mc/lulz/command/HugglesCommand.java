package to.joe.j2mc.lulz.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.command.MasterCommand;
import to.joe.j2mc.lulz.J2MC_Lulz;

public class HugglesCommand extends MasterCommand {

    public HugglesCommand(J2MC_Lulz lulz) {
        super(lulz);
    }

    @Override
    public void exec(CommandSender sender, String commandName, String[] args, Player player, boolean isPlayer) {
        if (isPlayer) {
            ((J2MC_Lulz) this.plugin).hug((Player) sender);
        }
    }

}
