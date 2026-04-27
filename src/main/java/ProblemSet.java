/* Title: Problem Set Unit 4
Name: Angie
Date Created: April 21, 2026
Date Updated: April 27, 2026 */
import java.util.Random;
import java.util.Scanner;

public class ProblemSet {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the High Low Guessing Game.");
		System.out.print("Input a number of rounds to play: ");
		System.out.println(selectMenu());
		input.close();
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

		//range selection
		System.out.println("What Range would you like to play between (#-#)?"); //range
		
		String range = findRange();
		int greatNum = findGreatRange(range);
		int lessNum = findLowRange(range);
		
		while (greatNum - lessNum == 0) { //if your numbers are weird
			range = "";
			System.out.println("Invalid Input!");
			System.out.println("What Range would you like to play between (#-#)?");
		
			range = findRange();
			greatNum = findGreatRange(range);
			lessNum = findLowRange(range);
		} 
		int median = greatNum/2;
		double firstMedian = median;
		double secondMedian = median;
		String combinedMedian;
		boolean doubleMedian = false; 

		if (!(greatNum%2 == 0)) {
			firstMedian = Math.floor(median);
			secondMedian = Math.ceil(median);

			combinedMedian = firstMedian + ", " + secondMedian;
			doubleMedian = true;
		} else {
			combinedMedian = "" + median;
		} //end range finding
  
		for (int currentRound = 1; currentRound < roundNum + 1; currentRound++) {//round loop
			System.out.println("Round " + currentRound + ":");

			System.out.println("Please select High, Low, or Even:" + "\n" + "1. High (" + combinedMedian + " to " + greatNum + ")" + "\n" + "2. Low (" + lessNum + " to " + combinedMedian + ")" + "\n" + "3. Even (" + combinedMedian + ")" + "\n");

			while (!(input.hasNextInt())) { //checking for input
				input.nextLine(); //clear scanner
				System.out.println("Invalid Input!");

				System.out.println("Please select High, Low, or Even:" + "\n" + "1. High (" + combinedMedian + " to " + greatNum + ")" + "\n" + "2. Low (" + lessNum + " to " + combinedMedian + ")" + "\n" + "3. Even (" + combinedMedian + ")" + "\n");
			}
			int choice = input.nextInt();

			while (choice <= 0 || choice > 3) {
				input.nextLine(); //clear scanner
				System.out.println("Invalid Input!");

				System.out.print("Please select High, Low, or Even:" + "\n" + "1. High (" + combinedMedian + " to " + greatNum + ")" + "\n" + "2. Low (" + lessNum + " to " + combinedMedian + ")" + "\n" + "3. Even (" + combinedMedian + ")" + "\n");
				choice = input.nextInt();
			}

            String result = "incorrect";
			int num = randomNumber(lessNum, greatNum);

			if (choice == 1) {
				
				if (doubleMedian = true) { //check if there's two medians
					if (num >= firstMedian || num >= secondMedian && num <= greatNum) {
				 		result = "correct";
						points++; 
						correctRound++;
					}
				}
				else if (doubleMedian = false) {
					if (num >= median && num <= greatNum) { //only one median
						result = "correct";
						points++; 
						correctRound++;
					}
				}
				else {
					result = "incorrect";
				}
			} //high

			if (choice == 2) {

				if (doubleMedian = true) { //check if there's two medians
					if (num <= firstMedian || num <= secondMedian && num >= lessNum) {
				 		result = "correct";
						points++; 
						correctRound++;
					}
				} 
				else if (doubleMedian = false) {
					if (num <= median && num >= lessNum) {
						result = "correct";
						points++; 
						correctRound++;
					}
				}
				else {
					result = "incorrect";
				}
			 } //low

			if (choice == 3) {

				if (doubleMedian = true) { //check if there's two medians
					if (num == firstMedian || num == secondMedian) {
				 		result = "correct";
						points++; 
						correctRound++;
					}
				}
				else if (doubleMedian = false) {
					if (num == median) {
						result = "correct";
						points++; 
						correctRound++;
					}
				}
				else {
					result = "incorrect";
				 }
			} //even

			System.out.println("The number was " + num + ", you were " + result + "."); 
			System.out.println("Current Score: " + points);
		} //end of rounds loop
		System.out.println("Total Score: " + points);
		if (correctRound >= roundNum/2) {
		return ("Congratulations you got " + correctRound + " out of " + roundNum + " rounds right!");
		}
		else { //rng poor sucker
			return "You got " + correctRound + " out of " + roundNum + " rounds correct. Better Luck next time.";
		}
	}

	public static int randomNumber(int num1, int num2) { 
		Random random = new Random();

		int great = Math.max(num1, num2);
		int less = Math.min(num1, num2);

		int num;

		do {
			num = random.nextInt((great - less) + 1) + less; //negates it
		} while (num < less && num == 0);
		return num;
	}

	public static String findRange() {
		Scanner input = new Scanner(System.in);
		String range;

		while (!(input.hasNextLine())) {
			range = "";			
			System.out.println("Invalid Input!");
			System.out.println("What Range would you like to play between (#-#)?");
		}
		range = input.nextLine();
		range = range.replace(" ", ""); //take out any spaces

		while (!(range.contains("-"))) {
			range = "";
			System.out.println("Invalid Input!");
			System.out.println("What Range would you like to play between (#-#)?");
			range = input.nextLine();
		}
		return range;
	}

	public static int findGreatRange (String range) {
		String greatRange = "";
		if (range.startsWith("-")) {//has negative
			int firstDash = range.indexOf('-');
			int secondDash = range.lastIndexOf('-');

			if (firstDash != secondDash) { //both negative
				greatRange = range.substring(range.lastIndexOf("-"));
			} 
			else { //one negative
				greatRange = range.substring(range.lastIndexOf("-") + 1);
			}
		}
		else { //both positive
			greatRange = range.substring(range.lastIndexOf("-") + 1);
		}
		int greatNum = Integer.parseInt(greatRange);
		return greatNum;
	}

	public static int findLowRange (String range) {
		String lessRange= "";
		if (range.startsWith("-")) {//has negative
			int firstDash = range.indexOf('-');
			int secondDash = range.lastIndexOf('-');

			if (firstDash != secondDash) { //both negative
				lessRange = range.substring(0, range.indexOf("-", range.indexOf("-") + 1));
			} 
			else { //one negative
			lessRange = range.substring(0, range.lastIndexOf("-"));
			}
		}
		else { //both positive
			lessRange = range.substring(0, range.lastIndexOf("-"));
		}
		int lessNum = Integer.parseInt(lessRange);
		return lessNum;
	}
} //what was THAT 😨 at least I have less lines than mikah (i hope) lolololol

