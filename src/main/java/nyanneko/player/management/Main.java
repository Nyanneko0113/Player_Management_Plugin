package nyanneko.player.management;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import nyanneko.player.management.commands.AdminCommand;
import nyanneko.player.management.commands.KickCommand;
import nyanneko.player.management.commands.NormalBanCommand;
import nyanneko.player.management.commands.NormalMuteCommand;
import nyanneko.player.management.commands.PlayerSettingCommand;
import nyanneko.player.management.commands.TempBanCommand;
import nyanneko.player.management.commands.TempMuteCommand;
import nyanneko.player.management.commands.UserInfoCommand;
import nyanneko.player.management.listener.onLoggerEvent;

public class Main extends JavaPlugin {

	public static FileConfiguration config;

	public Main() {
	    Main.config = getConfig();
	}

	@Override
	public void onEnable() {
		//admin専用コマンド
		getCommand("admin").setExecutor(new AdminCommand(this));
		getCommand("hide").setExecutor(new AdminCommand(this));
		getCommand("show").setExecutor(new AdminCommand(this));

		//プレイヤー設定コマンド
		getCommand("playersetting").setExecutor(new PlayerSettingCommand());

		//プレイヤー情報コマンド
		getCommand("lookup").setExecutor(new UserInfoCommand());

		//ban・kick・muteコマンド
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("normalban").setExecutor(new NormalBanCommand());
		getCommand("tempban").setExecutor(new TempBanCommand());
		getCommand("normalmute").setExecutor(new NormalMuteCommand());
		getCommand("tempmute").setExecutor(new TempMuteCommand());

		getServer().getPluginManager().registerEvents(new onLoggerEvent(this), this);
	}

	@Override
	public void onDisable() {

	}

}
