package nyanneko.player.manager.commands.ban;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnBanCommand implements CommandExecutor {

	public boolean onCommand(CommandSender send, Command cmd, String arg2, String[] arg3) {
		if (cmd.getName().equalsIgnoreCase("unban")) {

		}
		return false;
	}

}
