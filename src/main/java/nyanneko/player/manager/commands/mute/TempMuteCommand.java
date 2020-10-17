package nyanneko.player.manager.commands.mute;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TempMuteCommand implements CommandExecutor {

	public boolean onCommand(CommandSender send, Command cmd, String arg2, String[] arg3) {
		if (cmd.getName().equalsIgnoreCase("tempmute")) {

		}
		return false;
	}

}
