package nyanneko.player.manager.listener;

import org.bukkit.BanEntry;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

public class onJoinEvent implements Listener {

	@EventHandler
	public void JoinEvent(AsyncPlayerPreLoginEvent e) {
		BanEntry banlist = Bukkit.getBanList(Type.NAME).getBanEntry(Bukkit.getPlayer(e.getUniqueId()).getName());
		if (e.getLoginResult() == Result.KICK_BANNED) {
			e.setKickMessage("あなたはBanされています。" + "/n" +
		                    "Banした理由: " + banlist.getReason() + "/n" +
					        "Ban期間: " + banlist.getCreated());
		}

	}
}
