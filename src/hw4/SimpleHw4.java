package hw4;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleHw4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Hw 4-1. 陣列處理
		// Hw 4-1-1. 平均值 & 列舉高於平均元素
		System.out.println("\nHw 4-1-1: 有個一維陣列如下: "
				+ "\n{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}"
				+ "\n請寫出所有元素的平均值與大於平均值的元素");
		dealIntArray();
		
		// Hw 4-1-2. 反向字串
		System.out.println("\n\nHw 4-1-2: \n請建立一個字串,經過程式執行後,輸入結果是反過來的");
//	for (int i = 0; i < 10; i++)
		negativeOrderString(); 
		// Hw 4-1-3. 計算母音
		System.out.println("\n\nHw 4-1-3: \n有個字串陣列如下 (八大行星):\r\n"
				+ "{\"mercury\", \"venus\", \"earth\", \"mars\", "
				+ "\"jupiter\", \"saturn\", \"uranus\", \"neptune\"}\r\n"
				+ "請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)");
		vowelStatistics();
		/***************************************************/
		
		// Hw 4-2. 借錢
		System.out.println("\n\nHw 4-2: \n"
				+ "員工編號: No.25\tNo.32\tNo.8\tNo.19\tNo.27\n"
				+ "身上現金: 2500\t800\t500\t1000\t1200\n"
				+ "請設計一個程式,可以讓小華輸入欲借的金額後,便會顯示哪些員工編號的同事\r\n"
				+ "有錢可借他;並且統計有錢可借的總人數:例如輸入 1000 就顯示「有錢可借的\r\n"
				+ "員工編號: 25 19 27 共 3 人!」");
		checkForBorrow();
		/***************************************************/
		
		// Hw 4-3. 天數計算
		System.out.println("\n\nHw 4-3:\n"
				+ "請設計由鍵盤輸入三個整數,分別代表西元yyyy年,mm月,dd日,執行後會顯示是該年的第幾天"
				+ "\n例:輸入 1984 9 8 三個號碼後,程式會顯示「輸入的日期為該年第252天」");
		calendar();
		/***************************************************/
		
		// Hw 4-4. 班級成績
		System.out.println("\n\nHw 4-4:\n"
				+ "班上有8位同學,他們進行了6次考試結果如下:\n"
				+ "場\\學生\t1號\t2號\t3號\t4號\t5號\t6號\t7號\t8號\n"
				+ "1考\t10\t35\t40\t100\t90\t85\t75\t70\n"
				+ "2考\t37\t75\t77\t89\t64\t75\t70\t95\n"
				+ "3考\t100\t70\t79\t90\t75\t70\t79\t90\n"
				+ "4考\t77\t95\t70\t89\t60\t76\t85\t89\n"
				+ "5考\t98\t70\t89\t90\t75\t90\t89\t90\n"
				+ "6考\t90\t80\t100\t75\t50\t20\t99\t75");
		System.out.println("請算出每位同學考最高分的次數：\n");
		classRate();

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
		System.out.print("請輸入文字：");
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
				//input.close(); // 消除沒 close() 警告 // bug infinite-loop
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

	/***************************************************/
	// Method for 4-3
	
	private static void calendar() {
		// 宣告 daysOfMonth 陣列存放每個月的天數：[0]放0，[1]放31...[12]放31
		int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// 宣告 date 陣列存放使用者輸入的年、月、日 
		int[] date = new int[3];
		// 提示使用者輸入
		System.out.print("請輸入年、月、日：");
		// 檢查使用者輸入，並指定給 date
		date = askUser(daysOfMonth);
		// 計算天數，並輸出
		System.out.printf("輸入的日期為該年第 %d 天。%n", howManyDays(daysOfMonth, date));
	}

	private static int[] askUser(int[] dayOfYear) {
		// 準備回傳的陣列
		int[] date = new int[3];
		// 格式正確前不段要求使用者輸入
		while(true) {
			// 使用者輸入
			Inputdate(date);
			// 檢查年份是否為閏年
			dayOfYear[2] = febCheck(date[0]);
			// 檢查月份應在 1~12
			if (date[1] > 12 || date[1] < 1) {
				// 超出範圍的話，重新輸入
				System.out.print("請輸入正確的月份：");
				continue;
			}
			// 檢查日期範圍在 1~月份日期範圍內
			if (date[2] > dayOfYear[date[1]] || date[2] < 1) {
				// 超出範圍的話，重新輸入
				System.out.print("請輸入正確的日期：");
				continue;
			}
			// 所有條件符合，回傳陣列
			return date;
		}		
	}
	
	private static int febCheck(int year) {
		// 用 isLeap() 判斷 2 月有幾天
		return isLeap(year) ? 29 : 28;
	}

	private static boolean isLeap(int year) {
		// 用年判斷是否是閏年
		// 如果不能被 4 整除 -> 不是閏年
		if (year % 4 != 0) return false;
		// 被 4 整除：如果不能被 100 整除 -> 是閏年
		if (year % 100 != 0) return true;
		// 被 100 整除：如果不能被 400 整除 ? -> 不是閏年 : 否則是閏年
		return year % 400 != 0 ? false : true;
	}

	private static void Inputdate(int[] date) {
		// 基本的整數檢查
		// 準備輸入
		Scanner sc = new Scanner(System.in);
		// 依序輸入年、月、日
		for (int i = 0; i < date.length; i++) {
			// 如果輸入非整數的情況
			if (!sc.hasNextInt()) {
				// 提示輸入整數
				System.out.println("請輸入整數:");
				// 重新準備輸入
				sc = new Scanner(System.in);
				// 重設索引，前面輸入做廢
				i = -1; // i++ 執行後 i = 0
			} else {
				// 輸入整數的情況，依序寫入年、月、日
				date[i] = sc.nextInt();
			}
		}
		// 消除警告：sc never closed
		// sc.close();
		// 產生無窮迴圈
		// hhh hhh hhh / 555 555 55
	}
	
	private static int howManyDays(int[] daysOfMonth, int[] date) {
		// 宣告 days 為要回傳的天數，初值為 0
		int days = 0;
		// 將月份的天數加到 days，自己本身不加(EX: 1/7 不加1月的 31 天)
		for (int i = 1; i < date[1]; i++)
			days += daysOfMonth[i];
		// 將'日'的部分也加上去
		days += date[2];
		return days;
	}
	
	/***************************************************/
	// Method for 4-4
	
	private static void classRate() {
		// TODO Auto-generated method stub
		// 宣告 int[exam][studentNo.]score = {}; 存放考試資料
		int[][] score = {
			{10, 35, 40, 100, 90, 85, 75, 70},
			{37, 75, 77, 89, 64, 75, 70, 95},
			{100, 70, 79, 90, 75, 70, 79, 90},
			{77, 95, 70, 89, 60, 76, 85, 89},
			{98, 70, 89, 90, 75, 90, 89, 90},
			{90, 80, 100, 75, 50, 20, 99, 75}
		};
		
		// Debug: All highest
//		for (int i = 0; i < score.length; i++)
//			for (int j = 0; j < score[i].length; j++)
//				score[i][j] = 100;
		// 使用 String 紀錄每位同學考最高成績的場次，呼叫 getHighestScore() 取得結果 
		String[] highestScore = getHighestScore(score);
		// 輸出每位同學考最高分的場次
		printHighestScore(highestScore);
	}

	private static String[] getHighestScore(int[][] score) {
		// 宣吿 String[studentNo.] highestScore = {"",...""}; 紀錄(並回傳)每位同學考最高分的場次，預設 ""
		String[] highestScore = {"", "", "", "", "", "", "", ""};
		// 避免更動到原始資料，宣告 int[] examTmp，用來 copyArray 
		int[] examTmp;
		// FOR 每次考試
		for (int examNo = 0; examNo < score.length; examNo++) {
			// copyArray 到 int[] examTmp
			examTmp = Arrays.copyOf(score[examNo], score[examNo].length);
			// 對 exam 排序，最高分排在最後，index 為 score[examNo].length -1 
			Arrays.sort(examTmp);
			// FOR 每位同學
			for (int studentNo = 0; studentNo < score[examNo].length; studentNo++) {
				// IF 同學的成績最高，highestScore 加上該次考試 index
				if (score[examNo][studentNo] == examTmp[examTmp.length - 1]) {
					// 如果該同學不是第一次拿到最高分，在場次前加上'、'
					if (!highestScore[studentNo].isEmpty())
						highestScore[studentNo] += "、";
					// 因為陣列從 0 開始，考試場次+1 才是正確場次
					highestScore[studentNo] += examNo + 1;
//					System.out.printf("Debug: Highest score in exam No.%d is %d%n"
//							, examNo + 1, examTmp[examTmp.length - 1]);
//					System.out.printf("Debug: Student No.%d get it: highestScore[%d] = %s%n"
//							, studentNo + 1, studentNo + 1, highestScore[studentNo]);
				} // IF 同學的成績最高 END
			} // FOR 每位同學 END		
		} // FOR 每次考試 END
		return highestScore;
	}

	private static void printHighestScore(String[] highestScore) {
		// 查看每個同學考最高分的紀錄
		// FOR 每個同學
		for(int i = 0; i < highestScore.length; i++) {
			// IF 字串為空集合，輸出該同學沒考過最高分
			if (highestScore[i].isEmpty()) {
				System.out.println(i + 1 + " 號同學沒有考過最高分。");
			} 
			// ELSE 輸出同學考最高分的場次
			else {
				System.out.printf("%d 號同學在第 %s 場考試考了最高分！！%n", i+1, highestScore[i]);
			} // ELSE END
		} // FOR 每個同學 END
	}
}
