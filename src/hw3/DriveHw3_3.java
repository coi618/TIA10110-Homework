package hw3;

import java.util.Scanner;

public class DriveHw3_3 {

	public static void main(String[] args) {
		// Ask to enter player's hate number
		int num = askUserHate();

		// Create Player p and assign hate number for it
		var p = new Player(num);

		// Print option number table
		p.getOptionNumTable();
		// Print how many numbers player can choose
		System.out.printf("There are %d numbers can choose.\n", p.getOptCount());
		// Player pick up 6 numbers
		p.pickUpNumber();
		// Print player's pick up
		p.printPickUp();

		System.out.println("Program end");
	}

	// Check player's input
	private static int askUserHate() {
		// Set a num for return hate number
		int num;
		// Print prompts
		System.out.println("Input a number you don't want to choose: ");
		// Infinite loop, break when player input number between 1~9
		while (true) {
			Scanner sc = new Scanner(System.in);
			// Check player input an integer
			if (sc.hasNextInt()) {
				// Assign number to num
				num = sc.nextInt();
				// Check number between 1~9
				if (num > 0 && num < 10) {
					return num;
				}
				// If num not between 1~9, print prompts and ask player input
				System.out.println("Please enter number between 1~9:");
				// Restart loop
				continue;
			}
			// If player not input an integer, ask player to enter an integer.
			System.out.println("Please enter an INTEGER: ");
		}
	}
}
