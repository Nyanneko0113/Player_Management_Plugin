package nyanneko.player.manager.commands.ban;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nyanneko.player.manager.Main;

public class KickCommand implements CommandExecutor {

	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kick")) {
            Player player = Bukkit.getPlayer(args[0]);
            if (args.length == 0) {
                send.sendMessage(Main.arg + "/n" +
                                 "使用例: /kick [arg0] [arg1]" + "/n" +
                		         "arg[0] (必須): Playerを指定" + "/n" +
                                 "arg[1]: Kick理由を指定");
            }
            else if (args.length == 1) {
            	player.kickPlayer("あなたはサーバーからKickされました。");
            	send.sendMessage(Main.info + args[0] + " をサーバーからKickしました。");
            }
            else if (args.length == 2) {
            	player.kickPlayer(args[1]);
            	send.sendMessage(Main.info + args[0] + " をサーバーからKickしました (理由: " + args[2] + " )。");
            }
		}
		return true;
	}

}
