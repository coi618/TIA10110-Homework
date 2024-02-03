package hw1;

public class SimpleHw1 {
	public static void main(String[] args) {
		// 1. 12+6 & 12*6
		int num1 = 12;
		int num2 = 6;
		System.out.println(num1+num2);
		System.out.println(num1*num2);
		
		// 2. 200 eggs are how many dozen? and how many?
		System.out.println(200/12);
		System.out.println(200%12);
		
		// 3. How long is 256559s is?(Day/Hour/Minute/Second)
		int day = 60 * 60 * 24;
		int hour = 60 * 60;
		int minute = 60;
		
		int getDay = 256559 / day;
		int leftover = 256559 % day;
		int getHour = leftover / hour;
		leftover = leftover % hour;
		int getMinute = leftover / minute;
		leftover = leftover % minute;
		int getSecond = leftover;
		
		System.out.printf("%d days, %d hours, %d minutes, %d seconds\n", 
							getDay, getHour, getMinute, getSecond);
		
		// Hw 4. Define PI = 3.1415 and calculate a circle's area and circumference with radius 5.
		final double PI = 3.1415;
		double area = 5*5*PI;
		double circumference = 2*5*PI;
		System.out.println("Area: "+area+", circumference: "+circumference);
		
		// Hw 5. Calculate the total amount of 1.5 million, compound interest at 2%, after 10 years.
		int origin = 1500000;
		double rate = 1.02;
		double tenYearRate = rate*rate*rate*rate*rate * rate*rate*rate*rate*rate;
		System.out.println(origin*tenYearRate);
		
		// Hw 6. print the result with 5+5, 5+'5' and 5+"5" and explain the reason with comment.
		System.out.println(5+5); // int+int
		System.out.println(5+'5'); // int+char
		System.out.println(5+"5"); // print int and String
	}
}
