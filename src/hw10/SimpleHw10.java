package hw10;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;
import java.text.Format;
import java.text.DecimalFormat;

public class SimpleHw10 {

	public static void main(String[] args) {
//		System.out.println("Hw10-1: 請設計一隻程式，用亂數產生5個介於1~100之間的整數，"
//				+ "\n\t而輸出結果可以判斷出這5個整數為是否為質數 (提示:Math類別)");
//		fiveNumber();
		
		System.out.println("Hw10-2: 請設計一隻程式，讓使用者可以輸入一個任意數後，可以選擇要以下列何種表示方法顯示"
				+ "\n\t(1)千分位 (2)百分比(3)科學記號，而輸入非任意數會顯示提示訊息如圖 "
				+ "\n\t(提示: TestFormatter.java, Java API 文件, 判斷數字可用正規表示法)"
				+ "\n\t補充 (依此類推): "
				+ "\n\t\t輸入12345，千分位為12,345，"
				+ "\n\t\t輸入123，千分位為123"
				+ "\n\t\t輸入0.75，百分比為75%，"
				+ "\n\t\t輸入1，結果為100%");
//		numFormatter();
		Scanner sc = new Scanner(System.in);
		numFormatter2(sc); // 1) 使用 RE 判斷輸入。 2) Scanner 單一宣告
//		
//		System.out.println("Hw10-3: 請設計一隻程式，讓使用者輸入日期(年月日，例如:20110131)後，"
//				+ "\n\t可以轉成想要的輸出格式化成(1) 年/月/日(2)月/日/年(3)日/月/年三選一，"
//				+ "\n\t而輸入非指定日期數字格式會顯示出提示訊息如圖"
//				+ "\n\t(提示:TestFormatter.java, Java API文件，判斷格式可用正規表示法)");
//		calFormatter();
	}
	
	/******************** For Hw10-1 ********************/
	private static void fiveNumber() {
		int num;
		/* 1. 用亂數產生5個介於1~100之間的整數 */
		Set<Integer> set5 = new TreeSet<Integer>();
		while(set5.size() < 5) { 
			set5.add((int)(Math.random() * 100 + 1));
		} /* END of while() 加入5個不重複的數 */
//		System.out.println(set5.toString());
		/* 2. 判斷出這5個整數為是否為質數 */
		Iterator<Integer> it = set5.iterator();
		while(it.hasNext()) {
			num = (int) it.next();
			System.out.printf("%d%s是質數%n", num, (isPrime(num) ? "" : "不"));
		} /* END of while() 判斷5個數是否為質數 */	
	} /* END of fiveNumber() */
	
	private static boolean isPrime(double num) {
		/* (%2==0 || 1) -> Short path calculate */
		if (num % 2 == 0 || num == 1) return false; 
		/* 將 num 開根號的值存到 sqrt
		 * 如果從 3~sqrt 都沒有可整除 num 的數存在
		 * 則 num 為質數 */
		int sqrt = (int)(Math.sqrt(num));
		for (int i = 3; i <= sqrt; i += 2) {
			if(num % i == 0) return false;
		} /* END of for(3~sqrt) */
		return true;
	} /* END of isPrime() */
	
	/******************** For Hw10-2 ********************/
	private static void numFormatter() {
		/* 1. 輸入數字 > 格式檢查 */
		/* 2. 選擇格式 > 選擇檢查 */
		/* 3. 輸出結果 */
		
		/* Test Case: 
		 * ("abc", "數字格式不正確，請再輸入一次") 
		 * ("123", "123, 12300%, 1.23E2")
		 * ("-123", "-123, -12300%, -1.23E2")
		 * ("1234567890", "1,234,567,890, 123456789000%, 1.23457E9")
		 * ("0.123456789", "0.123456789, 12.3456789%, 1.23457E-1")
		 * ("0", "0, 0%, 0E0")
		 * (double MAX)
		 * (double MIN)
		 * (double )
		 * */
		/* test zoom */
//		double num = 
//				Double.MAX_VALUE; 	/* 1.7976931348623157E308 */
//				Double.MIN_NORMAL; 	/* 2.2250738585072014E-308 */
//				Double.MIN_VALUE; 	/* 4.9E-324 */
//				Double.NaN; 		/* NaN -> kPlace: 非數值 */
//				Double.NEGATIVE_INFINITY; /* -Infinity -> kPlace: -∞ */
//				Double.POSITIVE_INFINITY; /* Infinity -> kPlace: ∞ */

		double num = inputNum(); /* 1. 輸入數字 > 格式檢查 */
		System.out.println("Input: " + num);
		
//		int choose = inputChoose(); /* 2. 選擇格式 > 選擇檢查 */
		int choose = 3;
		/* test zoom */
		resultPrint(num, choose); /* 3. 輸出結果 */
		
		System.out.println("End of numFormatter.");
	} /* END of numFormatter() */
	
	private static double inputNum() {
		while (true) {
			System.out.print("請輸入數字: ");
//			try (Scanner sc = new Scanner(System.in)) { /* Infinite Loop */
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextDouble()) {
				return sc.nextDouble();
			}
			System.out.println("數字格式不正確，請再輸入一次!");
		}
	} /* END of double inputNum() */
	
	private static int inputChoose() {
		int input;
		while (true) {
			System.out.print("欲格式化成(1)千分位(2)百分比(3)科學記號: ");
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()) {
				input = sc.nextInt();
				if(input >= 1 && input <= 3)
					return input;
			}
			System.out.println("數字格式不正確，請再輸入一次!");
		}
	} /* END of int inputChoose() */
	
	private static void resultPrint(double num, int choose) {
		/* test zoom */
		/* test zoom */
		/* '#' occur if exists | '0' add '0' if not exists */
		Format kPlace = new DecimalFormat(); /* Empty work, SURPISE!! */
		Format percentage = new DecimalFormat("#.##%"); 
		Format sciNotation = new DecimalFormat("0.0###E0");
		switch(choose) { 
		case 1:
			System.out.println(kPlace.format(num));
			break;
		case 2:
			System.out.println(percentage.format(num));
			break;
		case 3:
			System.out.println(sciNotation.format(num));
			break;
		default:
			/* Do nothing */
		}
	} /* END of void resultPrint() */
	
	/******************** For Hw10-2 ********************/
	private static void numFormatter2(Scanner sc) { // 1) 使用 RE 判斷輸入。 2) Scanner 單一宣告
		double num = inputNum2(sc);
	}
	
	private static double inputNum2(Scanner sc) {
//		while (true) {
//			System.out.println("請輸入數字: ");
//		}
//		java.lang.Runtime rt = null;
		java.lang.Runtime.getRuntime();
		return 0.0;
		
	}
		
	/******************** For Hw10-3 ********************/
	private static void calFormatter() {
		
	} /* END of calFormatter() */
}
