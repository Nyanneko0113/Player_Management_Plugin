package nyanneko.player.management.commands;

import org.bukkit.Bukkit;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerSettingCommand implements CommandExecutor {

	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		Player player = Bukkit.getPlayer(send.getName());
		if (cmd.getName().equalsIgnoreCase("playersetting")) {
			if (args[0].equalsIgnoreCase("weather")) {
                if (args[1].equalsIgnoreCase("clear")) {
            	    player.setPlayerWeather(WeatherType.CLEAR);
            	    send.sendMessage("c");
                }
                else if (args[1].equalsIgnoreCase("downfall")) {
            	    player.setPlayerWeather(WeatherType.DOWNFALL);
            	    send.sendMessage("c");
                }
                else if (args[1].equalsIgnoreCase("reset")) {
            	    player.resetPlayerWeather();
            	    send.sendMessage("c");
                }
			}
			else if (args[1].equalsIgnoreCase("heart")) {
				if (player.hasPermission("nyanneko.commands.playersetting.heart")) {
					player.setHealth(Double.parseDouble(args[2]));
					send.sendMessage("set");
				}
			}
			else if (args[1].equalsIgnoreCase("permission")) {

			}
			else if (args[1].equalsIgnoreCase("xp")) {
                if (player.hasPermission("nyanneko.commands.playersetting.xp")) {
                	player.setExp(Float.parseFloat(args[2]));
                	send.sendMessage("set");
                }
			}
			else if (args[1].equalsIgnoreCase("effect")) {

			}
		}
		return true;
	}

}
