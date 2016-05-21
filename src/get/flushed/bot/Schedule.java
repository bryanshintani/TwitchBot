package get.flushed.bot;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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
		
		String result = "";
		DateTime currTime = new DateTime(DateTimeZone.UTC);

		try{
			JSONArray schedule = obj.getJSONArray("schedule");
			int scheduleLength = schedule.length();
			for (int i = 0; i < scheduleLength; i++) {
				JSONObject rotation = schedule.getJSONObject(i);
				String mode = rotation.getString("ranked_modeEN");
				String beginTime = rotation.getString("begin");
				JSONObject stages = rotation.getJSONObject("stages");
				
				JSONArray rankedMaps = stages.getJSONArray("ranked");
				JSONArray regularMaps = stages.getJSONArray("regular");
				int mapsLength = rankedMaps.length(); //assume rankedMaps.length() == regularMaps.length()
				
				String rankedMapsMsg = "";
				String regularMapsMsg = "";
				
				for(int j = 0; j < mapsLength; j++) {
					
					rankedMapsMsg += rankedMaps.getJSONObject(j).getString("nameEN");
					regularMapsMsg += regularMaps.getJSONObject(j).getString("nameEN");
					if (j == mapsLength - 1) { //last object in rankedMaps
						 rankedMapsMsg += ". ";
						 regularMapsMsg += ". ";
					} else {
						rankedMapsMsg += " & ";
						regularMapsMsg += " & ";
					}
				}
				
				boolean isCurrentRotation = i == 0;
				String modeMapsMsg = mode + " on " + rankedMapsMsg + "Turf War on " + regularMapsMsg;
				if (isCurrentRotation) {
					result += "[Current Rotation] " + modeMapsMsg;
				}else {
					DateTime dt = new DateTime(beginTime, DateTimeZone.UTC);
					int minDiff = dt.getMinuteOfDay() - currTime.getMinuteOfDay();
					int hours = minDiff / 60;
					int minutes = minDiff % 60;
					result += "[" + hours + "h"+" " + minutes + "m" + "] " + modeMapsMsg;
				}
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}