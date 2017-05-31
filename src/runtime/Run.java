package runtime;

import java.util.Scanner;

import bot.TwitterChecker;

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

public class Run {

	public static void main(String[] args) {
		String in;
		Scanner s = new Scanner(System.in);
		TwitterChecker c = new TwitterChecker();
		System.out.println("\nSpelling Soldier v. 1.0");
		System.out.println("Copyright (C) 2017 Alexander Berry, Adam Hamden, Theo Shin, and Harry Huang");
		System.out.print("\nThis program is free software: you can redistribute it and/or modify "
				+ "\nit under the terms of the GNU General Public License as published by "
				+ "\nthe Free Software Foundation, either version 3 of the License, or "
				+ "\n(at your option) any later version."
				+ "\n"
				+ "\nThis program is distributed in the hope that it will be useful, "
				+ "\nbut WITHOUT ANY WARRANTY; without even the implied warranty of "
				+ "\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the "
				+ "\nGNU General Public License for more details."
				+ "\n"
				+ "\nYou should have received a copy of the GNU General Public License "
				+ "\nalong with this program.  If not, see <http://www.gnu.org/licenses/>.");
		System.out.print("\n \n \n");
		System.out.println("Please enter a command or type 'help' for help.");
		in = s.nextLine();
		if(in.equalsIgnoreCase("help")){
			System.out.print("\n");
			System.out.print("\ncheck - Checks and corrects a sequentially numbered tweet from a user. "
					+ "\nfollow - Follows a user. "
					+ "\nexit - Exits the program.");
			System.out.print("\n \nPlease enter a command. \n");
			in = s.nextLine();
			if(in.equalsIgnoreCase("help")){
				System.out.println("Please refer to the above help message and then enter a command.");
				in = s.nextLine();
			}
		}
		if(in.equalsIgnoreCase("check")){
			int num;
			String corrected;
			String choice;
			System.out.println("Please enter the username to check tweets from.");
			in = s.nextLine();
			System.out.print("\nPlease enter the sequential number of the tweet "
					+ "\nyou would like to check.\n");
			num = s.nextInt();
			corrected = c.correctTweet(in, num);
			System.out.print("Your corrected tweet reads," + "\n" + corrected + "\n" + "\n");
			System.out.print("Would you like to tweet the corrected tweet? (y/n) \n");
			choice = s.next();
			if(choice.equalsIgnoreCase("y")){
				System.out.println("Sending tweet");
				c.sendTweet(corrected);
				System.out.println("Process completed.");
			}
			else if(choice.equalsIgnoreCase("n")){
				System.out.println("Aborting");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(".");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(".");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(".");
				System.out.println("\nProcess successfully aborted.");
			}
			else{
				System.out.println("CRITICAL ERROR: ILLEGAL ARGUMENT PROVIDED. HALTING\n");
				throw new IllegalArgumentException("You may only enter y or n as an argument.");
			}
		}
		if(in.equalsIgnoreCase("follow")){
			System.out.println("Please enter the username you would like to follow. \n");
			in = s.nextLine();
			c.follow(in);
		}
		if(in.equalsIgnoreCase("exit")){
			Thread.currentThread().interrupt();
		}
	}

}
