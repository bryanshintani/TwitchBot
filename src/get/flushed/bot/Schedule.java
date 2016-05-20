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

	public String getRankedMaps() {
		
		String message = "";

		try{
			JSONArray schedule = obj.getJSONArray("schedule");
			
			int length = schedule.length();
			if(length > 0) {
				JSONObject stages = schedule.getJSONObject(0).getJSONObject("stages");
				JSONArray regularMaps = stages.getJSONArray("regular");
				JSONArray rankedMaps = stages.getJSONArray("ranked");
				message = "Current Rotation: " 
						+ schedule.getJSONObject(0).getString("ranked_modeEN") + ". ";
					
				for(int i = 1; i < length; i++) {
					message += schedule.getJSONObject(i).getString("ranked_modeEN") + " starts at "	
							+ schedule.getJSONObject(i).getString("begin") + "... ";
				}
			}
		} catch(Exception e) {

		}
		return message;
	}
}