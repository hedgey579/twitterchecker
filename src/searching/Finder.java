package searching;

import java.util.List;

import config.ParseDictionary;
import parsing.ParseTweet;

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
