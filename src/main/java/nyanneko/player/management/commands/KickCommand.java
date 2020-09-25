package nyanneko.player.management.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class KickCommand implements CommandExecutor {

	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kick")) {

		}
		return true;
	}

}
