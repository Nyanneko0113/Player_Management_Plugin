package nyanneko.player.management.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UserInfoCommand implements CommandExecutor {

	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("lookup")) {
			Player player = Bukkit.getPlayer(args[1]);
            if (args[0].equalsIgnoreCase("mcid-history")) {

            }
            else if (args[0].equalsIgnoreCase("host")) {
            	send.sendMessage("==ユーザーの情報==" + "\n" +
                                 "IP: " + player.getAddress().getHostName());
            }
            else if (args[0].equalsIgnoreCase("uuid")) {
            	send.sendMessage("UUID: " + player.getUniqueId().toString());
            }
		}
		return true;
	}

}
