package get.flushed.bot;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Modes {

	private Random rnd;
	public ArrayList<String> modes = new ArrayList<String>();
	
	public Modes() {
		modes.add("Rainmaker");
		modes.add("Tower Control");
		modes.add("Splat Zones");
		rnd = new Random();
	}
	
	public void shuffle() {
		Collections.shuffle(modes);
	}
	// Find different way to pull element from ArrayList.
	public String getMode() {
		String mode = modes.remove(0);
		modes.add(mode);
		return mode;
	}
	
	public String anyItem() {
		int index = rnd.nextInt(modes.size());
		String random = modes.get(index);
		return random;
	}
}
