package nyanneko.player.manager.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MojangAPI {

	private int a = 0;

	public String getUUID(String player) {
		JsonObject jsonObj = (JsonObject) new Gson().fromJson(getResult("", "https://api.mojang.com/users/profiles/minecraft/" + player), JsonObject.class);
		return jsonObj.get("id").getAsString();
	}

    private String getResult(String postData, String postURL){
        try{
            String data = postData;
            URL url = new URL(postURL);
            HttpURLConnection uc = (HttpURLConnection)url.openConnection();
            uc.setDoOutput(true); //生成したURL接続からOutputStreamを取得するためのフラグを立てる
            uc.setRequestMethod("POST");
            OutputStream os = uc.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            os.close();
            InputStream is = uc.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"Shift_JIS"));
            String line;
            StringBuffer buf = new StringBuffer();
            while((line = reader.readLine()) != null){
                buf.append(line + "\n");
            }
            is.close();
            uc.disconnect();
            return buf.toString();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
