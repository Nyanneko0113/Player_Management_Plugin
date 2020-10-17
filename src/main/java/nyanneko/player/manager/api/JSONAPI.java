package nyanneko.player.manager.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.bukkit.Bukkit;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import nyanneko.player.manager.Main;

public class JSONAPI {

	private Main main;
	private String str;
	public JSONAPI(Main instance) {
		this.main = instance;
	}

	public void saveDefaultConfig() {

	}

	public void reloadConfig() {

	}

	public String getConfig(String player) throws IOException {
		File file = new File(main.getDataFolder().toURI().toString().replace("file:/", "") + "config.json");
		FileReader filereader = new FileReader(file);
		BufferedReader br = new BufferedReader(filereader);
		Gson gson = new Gson();
		str = br.readLine();
		JsonObject obj = gson.fromJson(this.str, JsonObject.class);
		while(str != null){
			String bandata = obj.get("bandata").getAsString();
			JsonObject data = gson.fromJson(bandata, JsonObject.class);
			return data.getAsJsonArray("1").get(0).toString();
		}
		br.close();
		return null;
	}

	public void saveConfig(String player, String reason, Date time, Enum<CheckAPI.ban> bantype) {
		File file = new File(main.getDataFolder().toURI().toString().replace("file:/", "") + "config.json");
		try {
			FileWriter filewriter = new FileWriter(file);
			JsonWriter json = new JsonWriter(filewriter);
			JsonWriter obj = json.beginObject();
            obj.name("bandata");
            json.beginObject();
            obj.name("1");
            json.beginArray();
            json.beginObject();
            if (reason == null) {
            	json.name("name").value(player);
            	json.name("uuid").value(Bukkit.getPlayer(player).getUniqueId().toString());
            	json.name("type").value(bantype.name());
            }
            else if (time == null) {
            	json.name("name").value(player);
            	json.name("uuid").value(Bukkit.getPlayer(player).getUniqueId().toString());
            	json.name("reason").value(reason);
            	json.name("type").value(bantype.name());
            }
            else {
            	json.name("name").value(player);
            	json.name("uuid").value(Bukkit.getPlayer(player).getUniqueId().toString());
            	json.name("reason").value(reason);
            	json.name("type").value(bantype.name());
            }
            json.endObject();
            json.endArray();
            json.endObject();
            json.endObject();
            json.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
