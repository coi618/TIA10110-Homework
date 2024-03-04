package hw6;

import java.util.Scanner;

public class CalTest {

	public static void main(String[] args) {
		int x, y; 
		System.out.println("請輸入x的值：");
		x = CheckInput();
		System.out.println("請輸入y的值：");
		y = CheckInput();
		Calculator calc = new Calculator();
		System.out.println(calc.powerXY(x, y));	
	}

	private static int CheckInput() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			if (!sc.hasNextInt()) {
				System.out.println("請輸入整數：");
				continue;
			}
			return sc.nextInt();
		}	
	}
}
