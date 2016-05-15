package get.flushed.bot;

public class TwitchBotMain {
	
	public static void main(String[] args) throws Exception {
		
		TwitchBot bot = new TwitchBot();
		bot.setVerbose(true);
		bot.connect("irc.twitch.tv", 6667, args[0]);
		bot.joinChannel("#feecz");
		//bot.joinChannel("#mtn_dru");
	}

}
