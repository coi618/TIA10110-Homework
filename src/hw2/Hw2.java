package hw2;

public class Hw2 {
	public static void main(String[] args) {
		// Declare global use variables
		int total = 0;
		int count = 1;
		System.out.println("===========Page 1.===========");
		// 1-1. 計算 1~1000 的偶數和 (2+4+6+8...+1000)
		System.out.println("1-1. Calculate the sum of even numbers from 1 to 1000.");
		/*
		 * Use for loop calculate total = 0; // reset total for(int i=2; i<=1000; i+=2)
		 * total += i; System.out.println("Total = " + total);
		 */

		// Trapezoidal formula: (Top+Bottom)*height/2
		System.out.println("Total = " + (2 + 1000) * 500 / 2);

		// 1-2. 計算 1~10的乘積(10!)，使用 for 迴圈
		System.out.println("\n1-2. Calculate 10! with for loop.");
		total = 1; // reset total
		// Calculate inside for loop
		for (int i = 1; i < 10; i++, total *= i)
			;
		System.out.println("Total = " + total);

		// 1-3. 計算 1~10的乘積(10!)，使用 while 迴圈
		System.out.println("\n1-3. Calculate 10! with while loop.");
		total = 1; // reset total
		count = 1; // reset count
		while (count++ < 10)
			total *= count;
		System.out.println("While's total = " + total);

		// 1-4. 輸出結果為以下：1 4 9 16 25 36 49 64 81 100
		System.out.println("\n1-4. Print below: 1 4 9 16 25 36 49 64 81 100");
		for (int i = 1; i <= 10; i++)
			System.out.print(i * i + " ");

		System.out.println("\n\n===========Page 2.===========");

		// 2-1. 樂透(1~49)中不含4的數字有哪些? 有幾個?
		System.out.println("2-1. ");
		System.out.println("(1) Print all number without 4 (X4, 4X) from 1 to 49.");
		System.out.println("(2) Count how many number above.");
		System.out.print("<1> ");
		count = 0; // reset count
		for (int i = 1; i <= 49; i++) {
			if (i % 10 == 4 || i / 10 == 4)
				continue;
			System.out.print(i + " ");
			count++;
		}
		System.out.println("\n<2> Total: " + count + " numbers.");

		// 2-2. 輸出如下
		/********************
		 * 1 2 3 4 5 6 7 8 9 10 
		 * 1 2 3 4 5 6 7 8 9 
		 * 1 2 3 4 5 6 7 8 
		 * 1 2 3 4 5 6 7 
		 * 1 2 3 4 5 6
		 * 1 2 3 4 5 
		 * 1 2 3 4 
		 * 1 2 3 
		 * 1 2 
		 * 1
		 ********************/
		System.out.println("\n2-2. Print number inverted triangle.\n");
		for (int i = 10; i > 0; i--) {
			for (int j = 1; j <= i; j++)
				System.out.print(j + " ");
			System.out.println();
		}

		System.out.println("\n===========Page 3.===========");
		// 3-1. 輸出如下
		/*******
		 * A 
		 * BB 
		 * CCC 
		 * DDDD 
		 * EEEEE 
		 * FFFFFF
		 *******/
		System.out.println("3-1. Print character inverted triangle.\n");
		for (char c = 'A'; c <= 'F'; c++) {
			for (int j = 1; j <= c - 'A' + 1; j++)
				System.out.print(c);
			System.out.println();
		}
		
		System.out.println("\n=============9x9=============");
		// 1. for + while
		System.out.println("1. for + while");
		for (int i = 1; i < 10; i++) {
			int j = 1;
			while (j < 10) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
				j++;
			}
			System.out.println();
		}

		// 2. for + do...while
		System.out.println("\n2. for + do...while");
		for (int i = 1; i < 10; i++) {
			int j = 1;
			do {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
				j++;
			} while (j < 10);
			System.out.println();
		}

		// 3. while + do...while
		System.out.println("\n3. while + do...while");
		int i = 1;
		while (i < 10) {
			int j = 1;
			do {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
				j++;
			} while (j < 10);
			i++;
			System.out.println();
		}
	}
}
