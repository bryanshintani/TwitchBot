package get.flushed.bot;

import org.jibble.pircbot.*;

public class TwitchBot extends PircBot {

	WeaponList weapon = new WeaponList();
	Maps map = new Maps();
	Modes mode = new Modes();
	Schedule schedule = new Schedule();
	
	
	
	public TwitchBot() {
		this.setName("UseWeapon");
		schedule.urlData();
	}
	
	public void onMessage(String channel, String sender,
				String login, String hostname, String message) {
		// Outputs a random weapon to channel.
		if(message.equalsIgnoreCase("!weapon")) {
			// Shuffles the weapon ArrayList.
			weapon.shuffle();
			// Posts the first element in weapon ArrayList.
			sendMessage(channel, "∴ " + weapon.post() + " ∴");
		// Outputs number of weapons left	
		} else if(message.equalsIgnoreCase("!size")) {
			// Posts the number of elements(weapons) left in weapon ArrayList to channel.
			sendMessage(channel, weapon.getListSize() + " weapons left.");
		// Randomize and post to channel, 5 maps and modes.
		// Figure out how to implement int parsing 
		// and have int variable dictate number of iterations.
		} else if(message.equalsIgnoreCase("!stages 5")) {
			for(int i = 0; i < 5; i++) {
		
				sendMessage(channel, mode.getMode() + " ∴ " + map.getMap());
			}
		} else if(message.equalsIgnoreCase("!schedule")) {

			sendMessage(channel, schedule.getRankedMaps());
		}
	}
}