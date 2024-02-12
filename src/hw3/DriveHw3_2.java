package hw3;

import java.util.Scanner;

public class DriveHw3_2 {
	public static void main(String[] args) {
		// Declare a game
		GuessNumGame game = new GuessNumGame(0, 100);
		// Declare guess to save user guess
		int guess;
		// If game is not over, keep ask user to guess
		while (!game.isGameOver()) {
			// Print prompts
			System.out.printf("Guess a number between %d ~ %d:\n",
					game.getMin(), game.getMax());
			guess = askNum(game.getMin(), game.getMax());
			// Check answer and guess
			game.checkAnswer(guess);
		}

		System.out.println("Program end.");
	}

	private static int askNum(int min, int max) {
		// Set a num for return guess number
		int num;

		// Infinite loop, break when user input number between range
		while (true) {
			Scanner sc = new Scanner(System.in);
			// Check user input an integer
			if (sc.hasNextInt()) {
				// Assign number to num
				num = sc.nextInt();
				// Check number between range
				if (num >= min && num < max) {
					return num;
				}
				// If num not between min to max, print prompts and ask user input
				System.out.printf("Please enter number "
						+ "between %d ~ %d:%n", min, max);
				// Restart loop
				continue;
			}
			// If user not input an integer, ask user to enter an integer.
			System.out.println("Please enter an INTEGER: ");
		}
	}
}