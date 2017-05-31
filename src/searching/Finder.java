package searching;

import java.util.List;

import config.ParseDictionary;
import parsing.ParseTweet;

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

public class Finder{
	
	public int max = Integer.MAX_VALUE;
	public String rec = "";
	public List<String> words = ParseDictionary.parseDictionary();
	
	public static int distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
	public String wordRecommend(String word){
		int error = Integer.MAX_VALUE;
		for(int i = 0; i < words.size(); i++){
			if(distance(word,words.get(i)) < error){
				error = distance(word,words.get(i));
				rec = words.get(i);
			}
		}
		return rec;
	}
}
