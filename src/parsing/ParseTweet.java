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
		Twitter twitter = TwitterFactory.getSingleton();
		Paging paging = new Paging(1,1);
		List<Status> tweets = new ArrayList<Status>();
		try {
			tweets = twitter.getUserTimeline(user,paging);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return tweets.get(0).getText();
	}
	public static List<String> getTweetWords(String tweet){
		List<String> words = new ArrayList<String>();
		int currentPos = 0;
		for(int i = 0; i < tweet.length(); i++){
			if(tweet.substring(i, i+1).equals(" ")){
				if(currentPos == 0){
					words.add(tweet.substring(currentPos,i));
					currentPos = i;
				}
				else{
					words.add(tweet.substring(currentPos+1,i));
					currentPos = i;
				}
			}
			if(i == tweet.length()-1){
				words.add(tweet.substring(currentPos+1,i+1));
			}
		}
		System.out.println(words.get(2));
		return words;
	}
}
