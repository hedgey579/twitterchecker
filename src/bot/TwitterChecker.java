package bot;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

import config.ParseDictionary;
import parsing.ParseTweet;
import searching.Finder;
import gui.AppWindow;

/*
* Copyright (C) 2017 Alexander Berry, Adam Hamden, Theo Shin, and Harry Huang
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
}
