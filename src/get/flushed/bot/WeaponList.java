package get.flushed.bot;

import java.util.ArrayList;
import java.util.Collections;


public class WeaponList {
	
	public ArrayList<String> weaponList = new ArrayList<String>();
	public WeaponList() {
		weaponList.add("Splattershot Jr.");
		weaponList.add("Custom Splattershot Jr.");
		weaponList.add("Splattershot");
		weaponList.add("Tentatek Splattershot");
		weaponList.add("Hero Shot Replica");
		weaponList.add("Octoshot Replica"); 
		weaponList.add("Wasabi Splattershot"); 
		weaponList.add("Splattershot Pro");
		weaponList.add("Forge Splattershot Pro");
		weaponList.add("Berry Splattershot Pro");
		weaponList.add("Aerospray MG");
		weaponList.add("Aerospray RG");
		weaponList.add("Jet Squelcher");
		weaponList.add("Custom Jet Squelcher");
		weaponList.add("Dual Squelcher");
		weaponList.add("Custom Dual Squelcher");
		weaponList.add("L-3 Nozzlenose");
		weaponList.add("L-3 Nozzlenose D");
		weaponList.add("H-3 Nozzlenose");
		weaponList.add("H-3 Nozzlenose D");
		weaponList.add("N-ZAP '85");
		weaponList.add("N-ZAP '89");
		weaponList.add("Splash-o-matic");
		weaponList.add("Neo Splash-o-matic");
		weaponList.add("Sploosh-o-matic");
		weaponList.add("Neo Sploosh-o-matic");
		weaponList.add(".52 Gal");
		weaponList.add(".52 Gal Deco");
		weaponList.add(".96 Gal");
		weaponList.add(".96 Gal Deco");
		weaponList.add("Blaster");
		weaponList.add("Custom Blaster");
		weaponList.add("Range Blaster");
		weaponList.add(" Custom Range Blaster");
		weaponList.add("Rapid Blaster");
		weaponList.add("Rapid Blaster Deco");
		weaponList.add("Rapid Blaster Pro");
		weaponList.add("Rapid Blaster Pro Deco");
		weaponList.add("Luna Blaster");
		weaponList.add("Luna Blaster Neo");
		weaponList.add("Splat Charger");
		weaponList.add("Kelp Splat Charger");
		weaponList.add("Hero Charger Replica");
		weaponList.add("Splatterscope");
		weaponList.add("Kelp Splatterscope");
		weaponList.add("E-Liter 3K");
		weaponList.add("Custom E-Liter 3K");
		weaponList.add("E-Liter 3K Scope");
		weaponList.add("Custom E-Liter 3K Scope");
		weaponList.add("Classic Squiffer");
		weaponList.add("New Squiffer");
		weaponList.add("Fresh Squiffer");
		weaponList.add("Bamboozler 14 MK I");
		weaponList.add("Bamboozler 14 MK II");
		weaponList.add("Bamboozler 14 MK III");
		weaponList.add("Splat Roller");
		weaponList.add("Krak-On Splat Roller");
		weaponList.add("Hero Roller Replica");
		weaponList.add("Dynamo Roller");
		weaponList.add("Gold Dynamo Roller");
		weaponList.add("Tempered Dynamo Roller");
		weaponList.add("Carbon Roller");
		weaponList.add("Carbon Roller Deco");
		weaponList.add("Inkbrush");
		weaponList.add("Inkbrush Nouveau");
		weaponList.add("Permanent Inkbrush");
		weaponList.add("Octobrush");
		weaponList.add("Octobrush Nouveau");
		weaponList.add("Slosher");
		weaponList.add("Slosher Deco");
		weaponList.add("Soda Slosher");
		weaponList.add("Tri-Slosher");
		weaponList.add("Tri-Slosher Nouveau");
		weaponList.add("Sloshing Machine");
		weaponList.add("Sloshing Machine Neo");
		weaponList.add("Heavy Splatling");
		weaponList.add("Heavy Splatling Deco");
		weaponList.add("Mini Splatling");
		weaponList.add("Zink Mini Splatling");
		weaponList.add("Refurbished Mini Splatling");
		weaponList.add("Hydra Splatling");
		weaponList.add("Custom Hydra Splatling");
	
	}
	
	public void shuffle() {
		Collections.shuffle(weaponList);
	}
	
	public String post() {
		String weapon = weaponList.remove(0);
		weaponList.add(weapon);
		return weapon;
	}
	
	public int getListSize() {
		return weaponList.size();
	}
}
