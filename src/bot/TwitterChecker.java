package bot;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

import config.ParseDictionary;
import parsing.ParseTweet;
import searching.Finder;
import gui.AppWindow;

public class TwitterChecker {

	private Twitter twitter;
	Finder f = new Finder();
	public TwitterChecker() {
		twitter = TwitterFactory.getSingleton();
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
	public String correctTweet(String user,int num){
		List<String> word = ParseTweet.getTweetWords(ParseTweet.getTweet(user,num));
		String correctedTweet = "";
		for(int i = 0; i < word.size(); i++){
			correctedTweet += f.wordRecommend(word.get(i)) + " ";
		}
		return correctedTweet;
	}
	public void run(){
		boolean halted = false;
		while(!halted){
			AppWindow.main(null);
		}
	}
}
