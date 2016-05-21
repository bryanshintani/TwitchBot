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
		System.currentTimeMillis();
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

	public String getSchedule() {
		
		String message = "";
		String rankedMsg = "";
		String regularMsg= "";

		try{
			JSONArray schedule = obj.getJSONArray("schedule");
			
			int length = schedule.length();
			if(length > 0) {
				JSONObject stages = schedule.getJSONObject(0).getJSONObject("stages");
				/* stages is only grabbing the first (0) object in schedule
				 * rankedMsg and regularMsg are always set to the respective
				 * values in (0) of schedule.*/
				 
				JSONArray regularMaps = stages.getJSONArray("regular");
				JSONArray rankedMaps = stages.getJSONArray("ranked");
				for(int k = 0; k <regularMaps.length(); k++){
					if(k < regularMaps.length()-1) {
						regularMsg += regularMaps.getJSONObject(k).getString("nameEN") + " & ";
					} else {
						regularMsg += regularMaps.getJSONObject(k).getString("nameEN") + ". ";
					}
				}
				for(int j = 0; j < rankedMaps.length(); j++){
					if(j < rankedMaps.length()-1) {
						rankedMsg += rankedMaps.getJSONObject(j).getString("nameEN") + " & ";
					} else {
						rankedMsg += rankedMaps.getJSONObject(j).getString("nameEN") + ". ";
					}
				}
				message = "Current Rotation: " 
						+ schedule.getJSONObject(0).getString("ranked_modeEN") + " on "
						+ rankedMsg + " Turf War on " + regularMsg;
				//TODO Change time format to display in how many hours/minutes the next rotations start
				
				for(int i = 1; i < length; i++) {
					String time = schedule.getJSONObject(i).getString("begin");
					String nextTime = "";
					//temporary "time" place holder.
					if(time.contains("T07")) {
						nextTime = "3:00PM PDT";
					} else if(time.contains("T11")) {
						nextTime = "7:00PM PDT";
					} else if(time.contains("T15")) {
						nextTime = "11:00PM PDT";
					} else if(time.contains("T19")) {
						nextTime = "3:00AM PDT";
					} else if(time.contains("T23")) {
						nextTime = "7:00AM PDT";
					} else if(time.contains("T03")) {
						nextTime = "11:00AM PDT";
					}
					message += "[" + nextTime + "] "
							+ schedule.getJSONObject(i).getString("ranked_modeEN") + " on "
							+ rankedMsg + " Turf War on " + regularMsg;
				}
			}
		} catch(Exception e) {

		}
		return message;
	}
}