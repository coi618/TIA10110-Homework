package hw2;

public class SimpleHw2 {
	public static void main(String[] args) {
		System.out.println("Page 1.");
		// 1-1. 計算 1~1000 的偶數和 (2+4+6+8...+1000)
		int total = 0;
		for(int i=2; i<=1000; i+=2) 
			total += i;
		System.out.println("Total = " + total);
		
//		System.out.println("Total = " + (2+1000)*500/2);
		
		// 1-2. 計算 1~10的乘積(10!)，使用 for 迴圈
		total = 1; // reset total
		for(int i=1; i<=10; i++) {
			total = total * i;
		}
		System.out.println("Total = " + total);
		
		// 1-3. 計算 1~10的乘積(10!)，使用 while 迴圈
		total = 1; // reset total
		int count = 1;
		while(count <= 10) {
			total *= count;
			count++;
		}
		System.out.println("While's total = " + total);
		
		// 1-4. 輸出結果為以下：1 4 9 16 25 36 49 64 81 100
		for(int i=1; i<=10; i++) {
			System.out.print(i*i + " ");
		}
		
		System.out.println("\n\nPage 2.");
		
		// 2-1. 樂透(1~49)中不含4的數字有哪些? 有幾個?
		count = 0; // reset count
		for(int i=1; i<=49; i++) {
			if(i%10==4 || i/10==4) {
				continue;
			}
			System.out.print(i + " ");
			count++;
		}
		System.out.println("\nTotal: " + count + " numbers.");
		
		// 2-2. 輸出如下
		/********************
		1 2 3 4 5 6 7 8 9 10
		1 2 3 4 5 6 7 8 9 
		1 2 3 4 5 6 7 8
		1 2 3 4 5 6 7
		1 2 3 4 5 6
		1 2 3 4 5
		1 2 3 4
		1 2 3
		1 2
		1 
		 ********************/
		for(int i=10; i>0; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("\nPage 3.");
		// 3-1. 輸出如下
		/*******
		 A
		 BB
		 CCC
		 DDDD
		 EEEEE
		 FFFFFF
		 *******/
		for(char c='A'; c<='F'; c++) {
			for(int j=1; j<=c-'A'+1; j++) {
				System.out.print(c);
			}
			System.out.println();
		}
		
		// 9x9
		// 1. for + while
		System.out.println("\n9x9\n1. for + while");
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
