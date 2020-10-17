package nyanneko.player.manager.commands.player;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nyanneko.player.manager.Main;

public class SavePlayerDataCommand implements CommandExecutor {

	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("saveplayerdata")) {
			Player p = Bukkit.getPlayer(args[0]);
            p.saveData();
            send.sendMessage(Main.info + "正常にプレイヤーデータを保存しました。");
	    }
		return false;
	}

}
