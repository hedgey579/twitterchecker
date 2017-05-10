package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<String> words = new ArrayList<String>(); 
        BufferedReader inFile = null;
		try {
			inFile = new BufferedReader (new FileReader("words.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String inputLine;
        try {
			while ((inputLine = inFile.readLine())!=null){ 
			    try {
					words.add(inFile.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.print(words.get(3));
        try {
			inFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
