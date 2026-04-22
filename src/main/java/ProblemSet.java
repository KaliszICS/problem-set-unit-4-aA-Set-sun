/*
Title: Problem Set Unit 4
Name: Angie
Date Created: April 21, 2026
Date Updated: April 21, 2026
*/

import java.util.Scanner;
import java.util.Random;

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

			while (choice <= 0 && choice < 3) {
				input.nextLine(); //clear scanner
				System.out.println("Invalid Input!");

				System.out.print("Please select High, Low, or Even:" + "\n" + "1. High (11 to 20)" + "\n" + "2. Low (0 to 9)" + "\n" + "3. Even (10)" + "\n");					choice = input.nextInt();
			}

			//don't know, fix this
			if (choice = 1) {
				randomNumber() 
			}

			if (choice = 2) {
				randomNumber(0, 9)
			}

			if (choice = 3) {
				randomNumber(10)
			}
		}
		return "yay";
	}

		public static int randomNumber (int num1 = 0, int num2 = 20) { //fix these numbers
		
		Random random = new Random();

		int great = Math.max(num1, num2);
		int less = Math.min(num1, num2);

		int num;

		do {
			num = random.nextInt((great - less) + 1) + less; //negates it

		} while (num < less && num == 0);
		return num;    
	

}
