package nyanneko.player.manager.commands.ban;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import nyanneko.player.manager.Main;
import nyanneko.player.manager.api.CheckAPI;
import nyanneko.player.manager.api.JSONAPI;

public class NormalBanCommand implements CommandExecutor {

	private Main main;
	public NormalBanCommand(Main instance) {
		this.main = instance;
	}

	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		JSONAPI api = new JSONAPI(main);
		if (cmd.getName().equalsIgnoreCase("normalban")) {
            if (args.length == 0) {
            	send.sendMessage(Main.arg + "/n" +
                                 "使用例: /normalban [arg0] [arg1]" + "/n" +
            			         "arg0(必須): Playerを指定" + "/n" +
                                 "arg1: Banした理由を指定");
            }
            else if (args.length == 1) {
            	Bukkit.getBanList(Type.NAME).addBan(args[0], null, null, send.getName());
                api.saveConfig(args[0], null, null, CheckAPI.ban.normal);
            	send.sendMessage(Main.info + args[0] + " をBanしました。");
            }
            else if (args.length == 2) {
            	Bukkit.getBanList(Type.NAME).addBan(args[0], args[1], null, send.getName());
            	api.saveConfig(args[0], args[1], null, CheckAPI.ban.normal);
            	send.sendMessage(Main.info + args[0] + " をBanしました。");
            }
		}
		return true;
	}

}
