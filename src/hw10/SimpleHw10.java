package hw10;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class SimpleHw10 {

	public static void main(String[] args) {
		System.out.println("Hw10-1: 請設計一隻程式，用亂數產生5個介於1~100之間的整數，"
				+ "\n\t而輸出結果可以判斷出這5個整數為是否為質數 (提示:Math類別)");
		fiveNumber();
		
		System.out.println("Hw10-2: 請設計一隻程式，讓使用者可以輸入一個任意數後，可以選擇要以下列何種表示方法顯示"
				+ "\n\t(1)千分位 (2)百分比(3)科學記號，而輸入非任意數會顯示提示訊息如圖 "
				+ "\n\t(提示: TestFormatter.java, Java API 文件, 判斷數字可用正規表示法)"
				+ "\n\t補充 (依此類推): "
				+ "\n\t\t輸入12345，千分位為12,345，"
				+ "\n\t\t輸入123，千分位為123"
				+ "\n\t\t輸入0.75，百分比為75%，"
				+ "\n\t\t輸入1，結果為100%");
		numFormatter();

		System.out.println("Hw10-3: 請設計一隻程式，讓使用者輸入日期(年月日，例如:20110131)後，"
				+ "\n\t可以轉成想要的輸出格式化成(1) 年/月/日(2)月/日/年(3)日/月/年三選一，"
				+ "\n\t而輸入非指定日期數字格式會顯示出提示訊息如圖"
				+ "\n\t(提示:TestFormatter.java, Java API文件，判斷格式可用正規表示法)");
		calFormatter();
		
//		System.out.println("End of main()");
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
		
		double num = inputNum(); /* 1. 輸入數字 > 格式檢查 */
//		System.out.println("Input: " + num);
		
		int choose = inputChoose(); /* 2. 選擇格式 > 選擇檢查 */

		resultPrint(num, choose); /* 3. 輸出結果 */
		
//		System.out.println("End of numFormatter.");
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
			
	/******************** For Hw10-3 ********************/
	private static void calFormatter() {
		Date input = getDateInput(); // EX: 20240617
		int choose = getChoose();	// 1 | 2 | 3
		
		printCal(input, choose);
//		System.out.println("End of calFormatter()");
		
	} /* END of calFormatter() */

	private static void printCal(Date input, int choose) {
		Format mySfm1 = new SimpleDateFormat("yyyy/MM/dd");
		Format mySfm2 = new SimpleDateFormat("MM/dd/yyyy");
		Format mySfm3 = new SimpleDateFormat("dd/MM/yyyy");
		switch (choose) {
		case 1:	// (1) 年/月/日
//			System.out.println("Choose: 1");
			System.out.println(mySfm1.format(input));
			break;
		case 2: // (2)月/日/年
//			System.out.println("Choose: 2");
			System.out.println(mySfm2.format(input));
			break;
		case 3: // (3)日/月/年
//			System.out.println("Choose: 3");
			System.out.println(mySfm3.format(input));
			break;
		default:
			System.out.println("default");
		}
		
		
	} // END of printCal()

	private static int getChoose() {
		String str = null;
		int choose = 0;
		String regChoose = "^[1-3]$";
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("欲格式化成(1) 年/月/日(2)月/日/年(3)日/月/年: ");
			if (sc.hasNextLine()) {
				str = sc.nextLine();
				if (str.matches(regChoose)) {
					choose = Integer.valueOf(str);
					return choose;
				}
			}
			System.out.println("請重新選擇");
		}
			
	} // END of getChoose()

	private static Date getDateInput() {
		String str = null;
		Date day = null; // util.Date
		// 定義正則表達式，匹配格式為 yyyyMMdd 的日期 | SimpleDateFormat.setLenient(false), 就不需要了
//  		String regDate = "^(\\d{4})(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$";
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");
		inputFormat.setLenient(false); 
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("請輸入日期(年月日，例如:20240615): ");
			if (sc.hasNextLine()) { 
				str = sc.nextLine();
//				if (!str.matches(regDate)) continue; // continue | break
				try {
					day = inputFormat.parse(str);
					return day;
				} catch (ParseException pe) {
					// Do nothing...
				}
			}
        	System.out.println("日期格式不正確，請再輸入一次!");
        }
        
//		return null;
	} // END of getDateInput()
}
