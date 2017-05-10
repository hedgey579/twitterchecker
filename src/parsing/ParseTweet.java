package parsing;
import java.util.ArrayList;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class ParseTweet {
	private String[] tweets;
	
	public ParseTweet() {
		
	}

	public static String getLatestTweet(String user){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("1qa6gOuB6kDIj1c56LZRnIddb")
		.setOAuthConsumerSecret("DYDa84kWwDOBbpHrmOnzZErWrHn4AdfK9hI9oxnRFGPdpm6Fp1")
		.setOAuthAccessToken("860231890879397888-QeSNd0gSChRBkaiLoGyXJOkhhlBFu3w")
		.setOAuthAccessTokenSecret("nG47Jhoj014TJ3WCThuhHLMkaxLd1b2CF0mHXQdaHD7Wk");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		Paging paging = new Paging(1,1);
		List<Status> tweets = new ArrayList<Status>();
		try {
			tweets = twitter.getUserTimeline(user,paging);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return tweets.get(0).getText();
	}
}
