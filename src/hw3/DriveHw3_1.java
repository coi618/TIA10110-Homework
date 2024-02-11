package hw3;

import java.util.Scanner;

public class DriveHw3_1 {

	public static void main(String[] args) {
		// Get sides from user
		int[] side = new int[3];
		System.out.println("Please enter integer for triangle's sides:");
		inputSide(side);

		// Declare a triangle with sides
		var myTri = new Triangle(side);
		// Call static method to check triangle type
		checkTriType(myTri);

		System.out.println("\nProgram end.");
	}

	private static void inputSide(int[] side) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < side.length; i++) {
			// If input is not integer
			if (!sc.hasNextInt()) {
				// Print prompts to input Integer
				System.out.println("Please enter an INTEGER: ");
				// Prepare Scanner
				sc = new Scanner(System.in);
				// Reset index to 0, forget all input before
				i = -1; // after i++, i = 0
			} else {
				// If input integer, write to side[]
				side[i] = sc.nextInt();
			}
		}
		sc.close();
	}

	private static void checkTriType(Triangle myTri) {
		// Show each sides, let user check triangle easily
		System.out.printf("(%d, %d, %d)", 
				myTri.shortSide, myTri.middleSide, myTri.longSide);

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
