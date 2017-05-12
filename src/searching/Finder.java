package searching;

import java.util.List;

import config.ParseDictionary;
import parsing.ParseTweet;

public class Finder{
	
	public static int max = Integer.MAX_VALUE;
	public static String rec = "";
	public static List<String> words = ParseDictionary.parseDictionary();
	
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
	
	public static String wordRecommend(String word){
		
		for(int p = 0; p < words.size(); p++){
			if(distance(word, words.get(p)) < max){
				max = distance(word, words.get(p));
				rec = words.get(p);
			}		
		}
	return rec;
 }
	
	
}
