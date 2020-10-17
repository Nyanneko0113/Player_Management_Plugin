package nyanneko.player.manager.commands.ban;

import java.util.Date;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import nyanneko.player.manager.Main;

public class TempBanCommand implements CommandExecutor {

	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tempban")) {
            if (args.length == 0) {
            	send.sendMessage(Main.arg + "/n" +
                                 "使用例: /tempban [arg0] [arg1]" + "/n" +
            			         "arg0(必須): Playerを指定" + "/n" +
                                 "arg1(必須): Banする期間を指定" + "/n" +
            			         "arg2: Banした理由を指定");
            }
            else if (args.length == 1) {
            	send.sendMessage(Main.arg + "/n" +
                                 "使用例: /tempban " + args[0] + " [arg1]" + "/n" +
                                 "arg1(必須): Banする期間を指定" + "/n" +
   			                     "arg2: Banした理由を指定");
            }
            else if (args.length == 2) {
            	Date data = new Date();
				Bukkit.getBanList(Type.NAME).addBan(args[0], null, data, send.getName());
            	send.sendMessage(Main.info + args[0] + " をBanしました。");
            }
            else if (args.length == 3) {
            	Date data = new Date();
				Bukkit.getBanList(Type.NAME).addBan(args[0], args[1], data , send.getName());
            	send.sendMessage(Main.info + args[0] + " をBanしました。");
            }
		}
		return true;
	}

}
