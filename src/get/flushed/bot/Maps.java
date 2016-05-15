package get.flushed.bot;

import java.util.ArrayList;
import java.util.Collections;

public class Maps {
	
	public ArrayList<String> maps = new ArrayList<String>();
	
	public Maps() {
		maps.add("Arowana Mall");
		maps.add("Blackbelly Skatepark");
		maps.add("Saltspray Rig");
		maps.add("Urchin Underpass");
		maps.add("Walleye Warehouse");
		maps.add("Port Mackerel");
		maps.add("Kelp Dome");
		maps.add("Bluefin Depot");
		maps.add("Moray Towers");
		maps.add("Camp Triggerfish");
		maps.add("Flounder Heights");
		maps.add("Hammerhead Bridge");
		maps.add("Museum D'Alfonsino");
		maps.add("Mahi-Mahi Resort");
		maps.add("Piranha Pit");
		maps.add("Ancho-V Games");
	}
	
	public void shuffle() {
		Collections.shuffle(maps);
	}
	
	public String getMap() {
		String remMap = maps.remove(0);
		// Adds removed map back into ArrayList.
		maps.add(remMap);
		return remMap;
	}
}
