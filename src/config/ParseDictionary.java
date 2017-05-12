package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseDictionary {
		public static List<String> parseDictionary(){
			Scanner s = null;
			try {
				s = new Scanner(new File("src/files/words.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			List<String> words = new ArrayList<String>();
			while(s.hasNext())
					words.add(s.next());
			s.close();
			return words;
	}
}
