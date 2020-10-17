package nyanneko.player.manager.commands.player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HideShowChatCommand implements CommandExecutor {

	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("hidechat")) {

	    }
		else if (cmd.getName().equalsIgnoreCase("showchat")) {

	    }
		return false;
	}
}
