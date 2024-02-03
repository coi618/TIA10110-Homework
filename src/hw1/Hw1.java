package hw1;

import java.lang.Math;

public class Hw1 {
	public static void main(String[] args) {

		// 1. 12+6 & 12*6
		System.out.println("Hw 1. Print the answer of [12 + 6] and [12 * 6]:");
		final int SIX = 6, TWELVE = 12;
		System.out.println("6 + 12 = " + (SIX + TWELVE));
		System.out.println("6 * 12 = " + (SIX * TWELVE));

		// 2. 200 eggs are how many dozen?
		System.out.println("\n\nHw 2. How many dozen are 200 eggs? And how many left?");
		int eggs = 200;
		int dozen = eggs / 12;
		int left = eggs % 12;
		System.out.println("200 eggs are " + dozen + " dozen and " + left + ".");

		// 3. How long is 256559s is?(Day/Hour/Minute/Second)
		System.out.println("\n\nHw 3. How long is 256559s? (Day/Hour/Minute/Second)");
		// Know each unit is how many second.
		final int second = 1;
		final int minute = 60 * second;
		final int hour = 60 * minute;
		final int day = 24 * hour;

		int leftover = 256559;
		int getDay = leftover / day;
		leftover %= day;
		int getHour = leftover / hour;
		leftover %= hour;
		int getMinute = leftover / minute;
		leftover %= minute;
		int getSecond = leftover;

		System.out.println("256559s is " + getDay + " days, " + getHour + " hours, " + getMinute + " minutes, "
				+ getSecond + " seconds.");

		// Hw 4. Define PI = 3.1415 and calculate a circle's area and circumference with
		// radius 5.
		System.out.println(
				"\n\nHw 4. Define PI = 3.1415, and calculate a circle's area and circumference with radius 5.");
		final double PI = 3.1415;
		int radius = 5;
		double area = radius * radius * PI;
		double circumference = 2 * radius * PI;
		System.out.println("Area = " + area + ", circumference = " + circumference);

		// Hw 5. Calculate the total amount of 1.5 million, compound interest at 2%,
		// after 10 years.
		System.out.println(
				"\n\nHw 5. Calculate the total amount of 1.5 million, compound interest at 2%, after 10 years.");
		// Formula: FV = PV * (1+i)^n (n is 10 years)
		int presentValue = 1_500_000;
		double interest = 1.02;
		double valueSquare = interest * interest;
		double valueQuadra = valueSquare * valueSquare;
		double value10Pow = valueQuadra * valueQuadra * valueSquare;
		double futureValue = presentValue * value10Pow;
		System.out.println("1.5m * (1.02)^10 = " + futureValue);

		
		// with Math 
		int years = 10; 
		futureValue = presentValue * Math.pow(interest, years); 
		System.out.println("1.5m * (1.02)^10 = " + futureValue + " (Answer with Math API)");
		 

		// Hw 6. print the result with 5+5, 5+'5' and 5+"5" and explain the reason with
		// comment.
		System.out.println("\n\nHw 6. print the result with 5+5, 5+'5' and 5+\"5\" and explain the reason with comment.");
		System.out.print("5 + 5 = ");
		System.out.println(5 + 5);
		System.out.print("5 + \'5\' = ");
		System.out.println(5 + '5');
		System.out.print("5 + \"5\" = ");
		System.out.println(5 + "5");
		/*
		 * for 5+5: int variables add, with int variable answer.
		 * 
		 * for 5+'5': reference:
		 * https://stackoverflow.com/questions/13630346/how-do-i-add-an-integer-to-a-
		 * char-in-java
		 * "In Java, char and int are compatible types so just add them with + operator."
		 * '5' is char with ASCII: 53, add 5 is 58(:)
		 * 
		 * for 5+"5": Concatenate string to an int value Display (convert int) 5 to
		 * String "5", and then display String "5" in console.
		 */

	}
}
