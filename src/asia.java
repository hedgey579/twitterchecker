import parsing.ParseTweet;
import searching.Finder;
import bot.TwitterChecker;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class asia {

	public static void main(String[] args) throws TwitterException
	{
		Finder f = new Finder();
		TwitterChecker bot = new TwitterChecker();
		System.out.println(f.wordRecommend("victry"));
		System.out.println(bot.correctTweet("spellingsoldier"));
	}
}

