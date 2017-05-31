package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
