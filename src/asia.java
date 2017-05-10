import parsing.ParseTweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class asia {

	public static void main(String[] args) throws TwitterException
	{
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.updateStatus("Testing properties file");
	}
}
