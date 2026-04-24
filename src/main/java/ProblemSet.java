/*
Title: Problem Set Unit 4
Name: Angie
Date Created: April 21, 2026
Date Updated: April 21, 2026
*/

import java.util.Random;
import java.util.Scanner;

public class ProblemSet {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);


		System.out.println("Welcome to the High Low Guessing Game.");

		System.out.print("Input a number of rounds to play: ");
		System.out.println(selectMenu());
	}

	public static int inputChecker() { //mostly functional, just weird spacing

		Scanner input = new Scanner(System.in);

		while (!(input.hasNextInt())) {
			input.nextLine(); //clear scanner
			System.out.println("Invalid Input!");

			System.out.print("Input a number of rounds to play: ");
		}
		int rounds = input.nextInt();

		while (rounds <= 0) {
			input.nextLine(); //clear scanner
			System.out.println("Invalid Input!");

			System.out.print("Input a number of rounds to play: ");
			rounds = input.nextInt();

		}
		return rounds;
	}

	public static String selectMenu() {

		Scanner input = new Scanner(System.in);

		int roundNum = inputChecker();
		int points = 0;
		int correctRound = 0;

		System.out.println("What Range would you like to play between (#-#)?");
		
		String range = input.nextLine();

			//(-5 - (-5)) -> 3 -
			//(-5 - 5) or (5 - (-5))-> 2 -
			//(5 - 5) -> 1 -

			String greatRange ="";
			String lessRange="";

		//if (range.startsWith("-")) {//(-5 - 5) 
		// 	greatRange = range.substring(range.indexOf(range.indexOf("-"), range.indexOf("-") + 1), range.length());
		// 	lessRange = range.substring(0, range.lastIndexOf(range.indexOf("-"), range.indexOf("-") + 1));
		// }
		// System.out.println(lessRange + " yey " + greatRange);

        //round loop
		for (int currentRound = 1; currentRound < roundNum + 1; currentRound++) {
			System.out.println("Round " + currentRound + ":");

			System.out.println("Please select High, Low, or Even:" + "\n" + "1. High (11 to 20)" + "\n" + "2. Low (0 to 9)" + "\n" + "3. Even (10)" + "\n");

			//checking for input
			while (!(input.hasNextInt())) {
				input.nextLine(); //clear scanner
				System.out.println("Invalid Input!");

				System.out.println("Please select High, Low, or Even:" + "\n" + "1. High (11 to 20)" + "\n" + "2. Low (0 to 9)" + "\n" + "3. Even (10)" + "\n");
			}
			int choice = input.nextInt();

            //checking the input
			while (choice <= 0 && choice < 3) {
				input.nextLine(); //clear scanner
				System.out.println("Invalid Input!");

				System.out.print("Please select High, Low, or Even:" + "\n" + "1. High (11 to 20)" + "\n" + "2. Low (0 to 9)" + "\n" + "3. Even (10)" + "\n");
				choice = input.nextInt();
			}

            String result = "incorrect";
			int num = randomNumber(0, 20);

			if (choice == 1) {

				if (num >= 11 && num <= 20) {
				    result = "correct";
					points++; 
					correctRound++;
				}
				else {
					result = "incorrect";
				}
			} //high

			if (choice == 2) {

				if (num >= 0 && num <= 9) {
				    result = "correct";
					points++; 
					correctRound++;

				}
				else {
					result = "incorrect";
				}
			 } //low

			if (choice == 3) {
				if (num == 10) {
				    result = "correct";
					points++; 
					correctRound++;
				}
				else {
					result = "incorrect";
				 }
			} //even

			System.out.println("The number was " + num + ", you were " + result + "."); 
			System.out.println("Current Score: " + points);
		}
		System.out.println("Total Score: " + points);
		System.out.println("Congratulations you got " + correctRound + " out of " + roundNum + " rounds right!");

		return "yay";
	}

	public static int randomNumber(int num1, int num2) { //fix these numbers

		Random random = new Random();

		int great = Math.max(num1, num2);
		int less = Math.min(num1, num2);

		int num;

		do {
			num = random.nextInt((great - less) + 1) + less; //negates it

		} while (num < less && num == 0);
		return num;


	}
	
	
	}


