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
		TwitterChecker bot = new TwitterChecker();
		System.out.println(Finder.wordRecommend("victry"));
		System.out.println(bot.correctTweet("spellingsoldier"));
	}
}
