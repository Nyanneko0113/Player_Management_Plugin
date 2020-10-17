package nyanneko.player.manager.listener;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import nyanneko.player.manager.Main;

public class onLoggerEvent implements Listener {

	private Main main;
	public onLoggerEvent(Main instance) {
		this.main = instance;
	}

	@EventHandler
	public void LoggerEvent(PlayerCommandPreprocessEvent e) {
		List<?> list = main.getConfig().getList("player.admin");
		if (list.contains(e.getPlayer().getName())) {
			for (int size = 0; size < list.size();) {
				String name = ((String)list.get(size));
                 Bukkit.getPlayer(name).sendMessage(ChatColor.AQUA + "[CommandLog] " + ChatColor.RESET +
                		 e.getMessage());
                 break;
			}
		}
	}

}
