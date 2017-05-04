import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class asia {

	public static void main(String[] args) throws TwitterException
	{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("1qa6gOuB6kDIj1c56LZRnIddb")
		.setOAuthConsumerSecret("DYDa84kWwDOBbpHrmOnzZErWrHn4AdfK9hI9oxnRFGPdpm6Fp1")
		.setOAuthAccessToken("860231890879397888-QeSNd0gSChRBkaiLoGyXJOkhhlBFu3w")
		.setOAuthAccessTokenSecret("nG47Jhoj014TJ3WCThuhHLMkaxLd1b2CF0mHXQdaHD7Wk");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		twitter.updateStatus("Test");
	}
}
