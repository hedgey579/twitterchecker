package bot;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

import config.ParseDictionary;
import parsing.ParseTweet;
import searching.Finder;

public class TwitterChecker {

	private Twitter twitter = TwitterFactory.getSingleton();
	public TwitterChecker() {
		
	}
	
	public void follow(String user){
		try {
			twitter.createFriendship(user);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	public void sendTweet(String content){
		try {
			twitter.updateStatus(content);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	public String correctTweet(String user){
		List<String> word = ParseTweet.getTweetWords(ParseTweet.getLatestTweet(user));
		String correctedTweet = "";
		for(int k = 0; k < word.size(); k++){
			correctedTweet = correctedTweet + Finder.wordRecommend(word.get(k)) + " ";
		}
		return correctedTweet;
	}
}
