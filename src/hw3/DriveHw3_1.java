package hw3;

import java.util.Scanner;

public class DriveHw3_1 {

	public static void main(String[] args) {
		// Get sides from user
		int[] side = new int[3];
		for (int s = 0; s < side.length; s++)
			side[s] = inputSide();

		// Declare a triangle with sides
		var myTri = new Triangle(side);
		// Call static method to check triangle type
		checkTriType(myTri);

		System.out.println("\nProgram end.");
	}

	private static int inputSide() {
		// Declare an int for return
		int num;
		// Check until user input integer
		while (true) {
			// Ask user to input a number
			System.out.println("Please enter an integer for triangle's sides:");
			Scanner sc = new Scanner(System.in);
			// If user's input not an integer, ask user to input integer and restart loop
			if (!sc.hasNextInt()) {
				System.out.println("Please enter INTEGER!");
				continue;
			}
			// If user input an integer, assign it to num
			num = sc.nextInt();
			// Close sc, just don't want to see warning
			// sc.close();
			// Cannot close(), will become infinite loop

			// break from loop
			break;
		}
		return num;
	}

	private static void checkTriType(Triangle myTri) {
		// Show each sides, let user check triangle easily
		System.out.printf("(%d, %d, %d)", myTri.shortSide, myTri.middleSide, myTri.longSide);

		// Check conditions from strict to loose
		// Check 1. Is triangle or not
		if (!myTri.isTriangle())
			System.out.println(" is not a triangle.");

		// Check 2. Is equilateral or not
		else if (myTri.isEquilTri())
			System.out.println(" is an equilateral.");

		// Check 3. Is isosceles or not
		else if (myTri.isIsoscTri()) {
			System.out.println(" is an isosceles.");
			// There exist situation a triangle is isosceles also a right triangle
			// (1, 1, √2). Although not exist in integer situation, still keep the
			// algorithm process.
			if (myTri.isRightTri())
				System.out.println(" Also a right triangle.");
		}

		// Check 4. Is right triangle or not
		else if (myTri.isRightTri())
			System.out.println(" is a right triangle.");

		// If non of above applies, say it's a general triangle
		else
			System.out.println(" is a general triangle.");

	}
}
