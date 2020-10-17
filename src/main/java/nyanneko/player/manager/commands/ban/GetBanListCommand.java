package nyanneko.player.manager.commands.ban;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import nyanneko.player.manager.Main;
import nyanneko.player.manager.api.JSONAPI;

public class GetBanListCommand implements CommandExecutor {

	private Main main;
	public GetBanListCommand(Main instance) {
		this.main = instance;
	}

	public boolean onCommand(CommandSender send, Command cmd, String arg2, String[] args) {
		if (cmd.getName().equalsIgnoreCase("getbanlist")) {
            try {
				send.sendMessage(new JSONAPI(main).getConfig(send.getName()));
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return false;
	}

}
