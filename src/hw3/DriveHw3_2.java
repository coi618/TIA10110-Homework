package hw3;

import java.util.Scanner;

public class DriveHw3_2 {
	public static void main(String[] args) {
		// Declare a game
		GuessNumGame game = new GuessNumGame();
		// Declare guess to save user guess
		int guess;
		// If game is not over, keep ask user to guess
		while (!game.isGameOver()) {
			// Print prompt
			System.out.println("Guess a number between 0~9: ");
			guess = askNum();
			// Check answer and guess
			game.checkAnswer(guess);
		}

		System.out.println("Program end.");
	}

	private static int askNum() {
		// Set a num for return guess number
		int num;

		// Infinite loop, break when user input number between 0~9
		while (true) {
			Scanner sc = new Scanner(System.in);
			// Check user input an integer
			if (sc.hasNextInt()) {
				// Assign number to num
				num = sc.nextInt();
				// Check number between 0~9
				if (num >= 0 && num < 10) {
					return num;
				}
				// If num not between 0~9, print prompt and ask user input
				System.out.println("Please enter number between 0~9:");
				// Restart loop
				continue;
			}
			// If user not input an integer, ask user to enter an integer.
			System.out.println("Please enter an INTEGER: ");
		}
	}
}