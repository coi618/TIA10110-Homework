package hw4;

import java.util.Scanner;

public class SimpleHw4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Hw 4-1. 陣列處理
		// Hw 4-1-1. 平均值 & 列舉高於平均元素
		System.out.println("Hw 4-1-1: 有個一維陣列如下: "
				+ "\n\t{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}"
				+ "\n\t請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素");
		dealIntArray();
		
		// Hw 4-1-2. 反向字串
		System.out.println("\n\nHw 4-1-2: 請建立一個字串,經過程式執行後,輸入結果是反過來的");
//	for (int i = 0; i < 10; i++)
		negativeOrderString(); 
		// Hw 4-1-3. 計算母音
		System.out.println("\n\nHw 4-1-3: 有個字串陣列如下 (八大行星):\r\n"
				+ "\t{\"mercury\", \"venus\", \"earth\", \"mars\", "
				+ "\"jupiter\", \"saturn\", \"uranus\", \"neptune\"}\r\n"
				+ "\t請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)");
		vowelStatistics();
		/***************************************************/
		
		// Hw 4-2. 借錢
		System.out.println("\n\nHw 4-2: "
				+ "員工編號: No.25\tNo.32\tNo.8\tNo.19\tNo.27\n\t身上現金: 2500\t800\t500\t1000\t1200\n"
				+ "\t請設計一個程式,可以讓小華輸入欲借的金額後,便會顯示哪些員工編號的同事\r\n"
				+ "\t有錢可借他;並且統計有錢可借的總人數:例如輸入 1000 就顯示「有錢可借的\r\n"
				+ "\t員工編號: 25 19 27 共 3 人!」");
		checkForBorrow();
		/***************************************************/
		
		// Hw 4-3. 天數計算
//		System.out.println("\n\nHw 4-3:");
		/***************************************************/
		
		// Hw 4-4. 班級成績
//		System.out.println("\n\nHw 4-4:");

		System.out.println("\n\nHw4 結束");
	}

	// Method for 4-1-1
	private static void dealIntArray() {
		// 宣告要計算的數字，已陣列儲存
		final int[] calc = {29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
		// 宣告 getAverage，計算數字平均值
		double average = getAverage(calc);
		// 列出平均值，不顯示小數位
		System.out.printf("Average: %1.0f%n", average);
		// 列出高於平均數值
		printAboveAve(calc, average);
	}

	private static double getAverage(int[] intArray) {
		// 宣告 sum 儲存所有陣列內的數值
		double sum = 0;
		// 提出所有陣列內數值
		for (int element : intArray)
			// 累加在 sum
			sum += element;
		// 回傳加總/個數
		return sum / intArray.length;
	}

	private static void printAboveAve(int[] intArray, double average) {
		// 顯示高於平均數提示
		System.out.print("比平均數高的數有: ");
		// 比較所有陣列中的數
		for (int element : intArray)
			// 當有高於平均的數時，列印出來
			if (average < element)
				System.out.printf("%d ", element);
		System.out.println();
	}

	/***************************************************/
	// Method for 4-1-2
	private static void negativeOrderString() {
		// 宣告 askInput 接收使用者的輸入，與 input 儲存輸入 
		String input = askInput();
//		System.out.println("Debug: input is: " + input);
		// 輸出提示
		System.out.print("倒轉輸入內容：");
		// 倒序提出 input 中的每個字元並輸出
		for (int i = input.length() - 1; i >= 0 ; i--)
			System.out.print(input.charAt(i));
		System.out.println();
		
	}

	private static String askInput() {
		// 輸出提示
		System.out.println("請輸入文字：");
		// 宣告 Scanner
		var strScanner = new Scanner(System.in);
		// 使用 nextLine() 方法讓數入為一整行
		return strScanner.nextLine();
	}

	/***************************************************/
	// Method for 4-1-3
	private static void vowelStatistics() {
		// 宣告 octagram 陣列儲存題目文字
		String[] octagram = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
		// 宣告vowelCount 陣列，用於儲存每個母音出現次數
		int vowelCount[] = new int[5];
		// 宣告 all，用於將字串合成單一字串
		String all = "";
		// 用 loop 將所有字串串接
		for (String element : octagram) 
			all += element;
//		System.out.println("Debug: To a String: " + all);
		// 宣告 statisVowel 方法計算所有母音出現次數
		vowelCount = statisVowel(all);
		// 輸出所有母音出現次數
		printTotalVowelCount(vowelCount);
		printVowelCount(vowelCount);
	}

	private static int[] statisVowel(String input) {
		// 先將 String 裡的字母改為小寫
		input.toLowerCase();
		int vowelCount[] = {0, 0, 0, 0, 0};
		// 建立母音字串，確認抓出來的字是不是母音，用法 voewl.indexOf(pickChar)
		String vowel = "aeiou";
		char pickChar;
		int vowelIndex;
		/*
		 * Another: 
		 * if(input.charAt(c).lower() == vowel)
		 *     case vowel++
		 */
		// Debug: 確認 voewl 每個母音的位置
//		for(int i = 0; i < vowel.length(); i++)
//			System.out.printf("%c:%d ", vowel.charAt(i), i);
//		System.out.println();

		// 對每個字元檢查
		for (int c = 0; c < input.length(); c++) {
			pickChar = input.charAt(c);
			// 檢查字元是否是母音 -> 字元在vowel字串中的位置是? 如果沒找到，回傳-1
			vowelIndex = vowel.indexOf(pickChar);
			if (vowelIndex >= 0) {
				// 確認 indexOf 回傳的位置與 voewl 母音位置一致
//				System.out.println("Debug: " + pickChar + " : " + vowelIndex);
				// 在統計母音次數陣列對應的位置上+1
				vowelCount[vowelIndex]++;
			}
		}	
		return vowelCount;
	}
	
	private static void printVowelCount(int[] vowelCount) {
		// 宣告字串 vowel，提示目前顯示的是哪個母音
		String vowel = "aeiou";
		// 將所有母音統計列出
		for (int i = 0; i < vowelCount.length; i++)
			System.out.printf("%c:%d ", vowel.charAt(i), vowelCount[i]);
		System.out.println();
	}
	
	private static void printTotalVowelCount(int[] vowelCount) {
		// 宣告 sum 儲存所有母音計數
		int sum = 0;
		// 對所有母音出現次數加總
		for (int num : vowelCount)
			sum += num;
		// 輸出母音出現總共次數
		System.out.println("總共出現 " + sum + " 個母音。");
	}

	/***************************************************/
	// Method for 4-2

	private static void checkForBorrow() {
		// 宣告二維陣列存放每個員工資料
		int[][] employee = {{25, 32, 8, 19, 27}, {2500, 800, 500, 1000, 1200}};
		// 宣告 borrow 來儲存使用者輸入，宣告 askHowMuch() 來處理輸入內容
		int borrow = askHowMuch();
		// 宣告 able 陣列來儲存每個員工是否有足夠的金錢可借 
		boolean[] able = checkToBrrow(employee, borrow);
		// 顯示哪些人可以借，共幾人可以借
		printAble(employee, able);
	}

	private static int askHowMuch() {
		// 宣告 num 用於回傳
		int num;
		// 提示使用者輸入需借款金額
		System.out.print("請輸入你需要借多少錢(> 0)：");
		// 宣告 input 用來儲存使用者輸入
		Scanner input;
		// 建立無窮回圈不斷檢查使用者輸入
		while(true) {
			// 建立 input 時替讓使用者輸入
			input = new Scanner(System.in);
			// 檢查輸入是否為整數
			if (input.hasNextInt()) {
				// 將輸入數字指定給 num
				num = input.nextInt();
				// 如果數字 < 0，要求使用者重新輸入，重新執行 Loop
				if(num < 0) { // 如果不需要檢查 > 0，將 if (num < 0) {...} 都註解掉即可
					// 提示使用者輸入 > 0 的數字
					System.out.print("請輸入 > 0 的數字：");
					continue;
				} // IF(num < 0) End
				// 如果是 > 0，回傳 num
				input.close(); // 消除沒 close() 警告
				return num;
			} // IF(input.hasNextInt()) End
			// 提示使用者輸入數字
			System.out.print("請輸入數字：");
		} // WHILE(true) End
	}

	private static boolean[] checkToBrrow(int[][] employee, int borrow) {
		// 宣告 able 來儲存那些員工可以借錢
		boolean[] able = new boolean[5];
		// 檢查每位員工的錢
		for (int i = 0; i < employee[1].length; i++) {
			// 如果這位員工的錢夠借
			if (employee[1][i] >= borrow) {
				// 將這位員工的能力設為 true
				able[i] = true;
			} // IF (employee[1][i] >= borrow) End
		} // FOR employee[1] End
		// 回傳能力陣列
		return able;
	}

	private static void printAble(int[][] employee, boolean[] able) {
		// 宣告 total 來計算總共多少人有能力借
		int total = 0;
		// 輸出提示那些人可借
		System.out.print("有錢可借的員工編號： ");
		// 檢查所有員工
		for (int i = 0; i < employee[0].length; i++) {
			// 如果是有足夠的能力借錢的員工
			if (able[i]) {
				// 顯示員工ID
				System.out.print(employee[0][i] + " ");
				// 加總可借員工數量
				total++;
			} // IF (able[i]) End
		} // FOR (employee[0]) End
		// 顯示可借錢的總人數
		System.out.println("共 " + total + "人！");
	}
	
}
