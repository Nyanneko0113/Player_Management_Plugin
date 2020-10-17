package nyanneko.player.manager.commands.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import nyanneko.player.manager.Main;

public class AdminCommand implements CommandExecutor {

	private Main main;
	public AdminCommand(Main instance) {
		this.main = instance;
	}

	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("admin")) {
			FileConfiguration config = main.getConfig();
			List<String> player = new ArrayList<String>();
            if (args[0].equalsIgnoreCase("add")) {
            	 player.add(args[1]);
            	 config.set("player.admin", player);
                 main.saveConfig();
                 send.sendMessage("あ");
            }
            else if (args[0].equalsIgnoreCase("remove")) {
                player.remove(args[1]);
           	    config.set("player.admin", player);
                main.saveConfig();
                send.sendMessage("あ");
            }
            else if (args[0].equalsIgnoreCase("list")) {
                for (int n = 0; n > player.size(); n++) {
                	send.sendMessage("==Admin==");
                	send.sendMessage(player.get(n) + "\n");
                }
            }
		}
		else if (cmd.getName().equalsIgnoreCase("hide")) {
			if (args.length == 0) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					p.hidePlayer(main, Bukkit.getPlayer(send.getName()));
				}
			}
			else if (args.length == 1){
				for (Player p : Bukkit.getOnlinePlayers()) {
					p.hidePlayer(main, Bukkit.getPlayer(args[1]));
				}
			}
			send.sendMessage("姿を非表示にしました。");
		}
		else if (cmd.getName().equalsIgnoreCase("show")) {
			if (args.length == 0) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					p.showPlayer(main, Bukkit.getPlayer(send.getName()));
				}
			}
			else if (args.length == 1){
				for (Player p : Bukkit.getOnlinePlayers()) {
					p.showPlayer(main, Bukkit.getPlayer(args[1]));
				}
			}
			send.sendMessage("姿を表示にしました。");
		}
		return true;
	}

}
