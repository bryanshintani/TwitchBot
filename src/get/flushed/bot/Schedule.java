package get.flushed.bot;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class Schedule {
	
	private static String result = "";
	private static JSONObject obj = null;
	
	public Schedule() {
			
		}
	
	public void urlData() {
		try {
			URL url = new URL("http://splatapi.ovh/schedule_na.json");
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");
			InputStream in = conn.getInputStream();
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(in, "utf-8"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			result = sb.toString();
			obj = new JSONObject(result);
		} catch(Exception e) {
			
		}
	}

	public String getRankedModes() {
		String modes = "";
		try {
		JSONArray arr = obj.getJSONArray("schedule");
		for(int i = 0; i < arr.length(); i++) {
			modes = arr.getJSONObject(i).getString("ranked_modeEN");
		}
		} catch(Exception e) {
		
		}
		return modes;
	}
	
	public String getRankedMaps() {
		String maps = "";
		try {
		JSONArray arr = obj.getJSONArray("schedule");
		
		for(int i = 0; i < arr.length(); i++) {
			//grab 0 instead of i to grab first index of array.
			//try to grab and print ranked mode, ranked maps, regular maps
			//and beginning and ending times.
			JSONArray stages = arr.getJSONObject(i).getJSONArray("stages");
			for(int j = 0; j < stages.length(); j++) {
				if(j < 2) {
				maps += stages.getJSONObject(j).getString("nameEN") + ", ";
				} else {
					maps += stages.getJSONObject(j).getString("nameEN") + ". ";
				}
			}
		}
		} catch(Exception e) {

		}
		return maps;
	}
	
	/*public JSONArray getSched() {
		return obj.getJSONArray("schedule");
	}*/
}