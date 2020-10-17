package nyanneko.player.manager.commands.mute;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import nyanneko.player.manager.Main;

public class GetMuteListCommand implements CommandExecutor {

	private Main main;
	public GetMuteListCommand(Main instance) {
		this.main = instance;
	}

	public boolean onCommand(CommandSender send, Command cmd, String arg2, String[] args) {
		if (cmd.getName().equalsIgnoreCase("getmutelist")) {

		}
		return false;
	}

}
