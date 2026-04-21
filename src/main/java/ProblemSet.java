/*
Title: Problem Set Unit 4
Name: Angie
Date Created: April 21, 2026
Date Updated: April 21, 2026
*/

import java.util.Scanner;

public class ProblemSet {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);


		System.out.println("Welcome to the High Low Guessing Game.");

		System.out.print("Input a number of rounds to play: ");
		System.out.println(inputChecker());
		
	}

	public static int inputChecker() {
	
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
	}
	return rounds;
}
 

	

}
