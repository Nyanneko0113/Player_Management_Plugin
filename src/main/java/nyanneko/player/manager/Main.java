package nyanneko.player.manager;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import nyanneko.player.manager.commands.ban.GetBanListCommand;
import nyanneko.player.manager.commands.ban.KickCommand;
import nyanneko.player.manager.commands.ban.NormalBanCommand;
import nyanneko.player.manager.commands.ban.TempBanCommand;
import nyanneko.player.manager.commands.ban.UnBanCommand;
import nyanneko.player.manager.commands.mute.GetMuteListCommand;
import nyanneko.player.manager.commands.mute.NormalMuteCommand;
import nyanneko.player.manager.commands.mute.TempMuteCommand;
import nyanneko.player.manager.commands.mute.UnMuteCommand;
import nyanneko.player.manager.commands.player.AdminCommand;
import nyanneko.player.manager.commands.player.PlayerOpenInventoryCommand;
import nyanneko.player.manager.commands.player.PlayerSettingCommand;
import nyanneko.player.manager.commands.player.RideCommand;
import nyanneko.player.manager.commands.player.SavePlayerDataCommand;
import nyanneko.player.manager.commands.player.UserInfoCommand;
import nyanneko.player.manager.listener.onLoggerEvent;

public class Main extends JavaPlugin {

	public static String info = ChatColor.GREEN + "[情報] " + ChatColor.RESET;
	public static String warm = ChatColor.YELLOW + "[警告] " + ChatColor.RESET;
	public static String error = ChatColor.RED + "[エラー] " + ChatColor.RESET;
	public static String arg = error + "引数が指定されていません。";

	@Override
	public void onEnable() {
		//admin専用コマンド
		getCommand("admin").setExecutor(new AdminCommand(this));
		getCommand("hide").setExecutor(new AdminCommand(this));
		getCommand("show").setExecutor(new AdminCommand(this));

		//プレイヤー情報コマンド
		getCommand("lookup").setExecutor(new UserInfoCommand());
		getCommand("openinv").setExecutor(new PlayerOpenInventoryCommand());

		//ban・kick・mute系コマンド
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("normalban").setExecutor(new NormalBanCommand(this));
		getCommand("tempban").setExecutor(new TempBanCommand());
		getCommand("normalmute").setExecutor(new NormalMuteCommand());
		getCommand("tempmute").setExecutor(new TempMuteCommand());
		getCommand("unban").setExecutor(new UnBanCommand());
		getCommand("unmute").setExecutor(new UnMuteCommand());
		getCommand("getbanlist").setExecutor(new GetBanListCommand(this));
		getCommand("getmutelist").setExecutor(new GetMuteListCommand(this));

		//プレイヤー設定コマンド
		getCommand("playersetting").setExecutor(new PlayerSettingCommand());
		getCommand("saveplayerdata").setExecutor(new SavePlayerDataCommand());
		getCommand("ride").setExecutor(new RideCommand());

        //リスナー
		getServer().getPluginManager().registerEvents(new onLoggerEvent(this), this);
	}

	@Override
	public void onDisable() {

	}

	public String PluginFolder() {
		return this.getDataFolder().toURI().toString().replace("file:/", "");
	}

}
