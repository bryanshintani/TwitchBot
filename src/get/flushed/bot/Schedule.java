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
		
		String modes = "";
		String begin = "";
		String end = "";

		try{
			JSONArray schedule = obj.getJSONArray("schedule");

			for(int i = 0; i < schedule.length(); i++) {
				if(i < 2) {
					modes += schedule.getJSONObject(i).getString("ranked_modeEN") + ", ";
					begin += " " + schedule.getJSONObject(i).getString("begin") + ", ";
					end += " " + schedule.getJSONObject(i).getString("end") + ", ";
				} else {
					modes += schedule.getJSONObject(i).getString("ranked_modeEN") + ".";
					begin += " " + schedule.getJSONObject(i).getString("begin") + ". ";
					end += " " + schedule.getJSONObject(i).getString("end") + ", ";
				}
			}
		} catch(Exception e) {

		}
		return modes + begin + end;
	}
}