package hw3;

import java.util.Arrays;
import java.util.Scanner;
public class SimpleHw3 {

	public static void main(String[] args) {
		// Hw 3-1. 三角形判斷 Level 1
		System.out.println("Hw 3-1: 判斷三角形 Level-1\n");
		triangleJudgment();
		
		/***************************************************/
		// Hw 3-2: 猜數字 (0~9) Level-1
		System.out.println("\n\nHw 3-2: 猜數字 Level-1\n");
		guessNumber();
		
		/***************************************************/
		// Hw 3-3. 進階大樂透 Level-1
		System.out.println("\n\nHw 3-3: 進階大樂透 Level-1\n");
		playLottery();
		
		/***************************************************/
		System.out.println("\n\nHw3 結束");
	}

	// 在這次作業中的方法都宣告為靜態(static)方法，直接使用
	
	// Method for 3-1
	public static void triangleJudgment() {
		// 設定 int [3] 陣列存放三個邊
		int side[] = new int[3];
			
		// 提示、接收使用者輸入
		System.out.println("Please enter 3 side(positive integer):");
		for(int i = 0; i < side.length; i++) 
			side[i] = askSide(); 
		
		// 在判斷前，排序邊長
		Arrays.sort(side);
		// 顯示邊長，讓使用者可以直覺判斷結果
		System.out.printf("(%d, %d, %d)", side[0], side[1], side[2]);
		
		// 判斷1. 檢查是否為三角形
		if(!isTriangle(side)) 
			System.out.println("不是一個三角形");
	
		// 判斷2. 正三角
		else if(isEquilTri(side)) 
			System.out.println("是一個正三角形");
	
		// 判斷3. 等腰三角形
		else if(isIsoscTri(side)) 
			System.out.println("是一個等腰三角形");
	
		// 以上皆不符合者判定為其他
		else
			System.out.println("是一個一般的三角形");
			
	} // End triangleJudgment()
	
	public static int askSide() {
		Scanner sc = new Scanner(System.in);
		// 檢查輸入不是整數的情況
		while(!sc.hasNextInt()) {
			System.out.println("Not integer, retype: ");
			sc = new Scanner(System.in);
		}
		return sc.nextInt();
	}
		
	public static boolean isTriangle(int[] side) {
		int small = side[0], middle = side[1], longSide = side[2];
		// (1). 所有邊長需 > 0，因為邊長以排序過，只要檢查最小邊即可
		if (small <= 0) return false; 
		
		// (2). 兩邊和[取短邊] > 第三邊
		if (small + middle <= longSide) return false;
		
		// (3). 兩邊差[取長邊] < 第三邊 
		if (longSide - middle >= small) return false;
		
		// 所有條件吻合，是三角形
		return true;
	}

	public static boolean isEquilTri(int[] side) {
		// 所有邊長都相等 ? 是->回傳 true : 否->回傳 false
		return (side[0] == side[1] && side[1] == side[2]) ? true : false ;
	}
	
	public static boolean isIsoscTri(int[] side) {
		// 其中2邊長相等 ? 是->回傳 true : 否->回傳 false
		return (side[0] == side[1] || side[1] == side[2] ? true : false);
	}

	/***************************************************/
	// Method for 3-2
	public static void guessNumber() {
		// 開始遊戲
		System.out.println("開始猜數字吧！");
		
		// 亂數產生一個答案
		int answer = (int)(Math.random()*10);
		
//		System.out.println("Debug: Answer = " + answer);
		
		// 比對結果：因為 0 為相同，預設使用 -1
		int compareResult = -1;
		
		// 建立無窮迴圈，當使用者猜中數字時結束
		while(true) {
			// 詢問使用者猜測，並與答案比較
			compareResult = Integer.compare(getUserGuess(), answer);
			// 如果猜對，輸出正確訊息並離開
			if(compareResult == 0) {
				System.out.println("答對了！答案就是 " + answer);
				break;
			} else
				System.out.println("猜錯了");
		} // end of while loop
		
		// Debug: 提示 Hw 3-2 結束
		//System.out.println("Hw 3-2 Finish."); 
	}

	private static int getUserGuess() {
		// 詢問使用者輸入數字 0~9
		System.out.print("Enter a number between 0~9: ");
		Scanner sc = new Scanner(System.in);
		// 判斷輸入不是整數的情況
		while(!sc.hasNextInt()) {
			System.out.print("Please enter an integer: ");
			sc = new Scanner(System.in);
		}
		return sc.nextInt();
	}
	
	/***************************************************/
	// Method for 3-3
	private static void playLottery() {
		// 提示：開始遊戲
		System.out.println("Hw 3-3:");
		// 要求使用者輸入數字 (1~9)
		int hateNum = askUserHate();
		
//		System.out.print("Debug: Your hate number is " + hateNum);
		// 宣告存放可選取數字(optionNum)的陣列
		int[] optionNum = new int[49];
		// 計算可選取數字的數量
		int optCount = 0; 

		for(int i = 1; i < 50; i++) {
			if(i % 10 == hateNum || i / 10 == hateNum) {
				// 如果遇到討厭的數字，跳過
				continue;
			}
			// 其他數字依序放入陣列，計數器+1
			optionNum[optCount++] = i; 
		}
		
		// 輸出可選數字 (輸出陣列)
		printArray(optionNum);
		System.out.printf("\n總共有%d數字可選\n", optCount);
	}

	private static int askUserHate() {
		System.out.println("阿文...請輸入你討厭哪個數字？");
		Scanner sc = new Scanner(System.in);
		while(!sc.hasNextInt()) {
			System.out.print("請輸入整數 (1~9): ");
			sc = new Scanner(System.in);
			// 放棄檢查超出範圍的情況
		}
		return sc.nextInt();
	}

	private static void printArray(int[] intArray) {
		// int 預設為 0，遇到 0 表示可選取範圍結束
		for(int i = 0; intArray[i] != 0; i++) {
			// 換行前置，後置換行版型會跑掉
			if(i % 6 == 0)
				System.out.println();
			System.out.print(intArray[i] + "\t");
		}
		System.out.println();
	}
	
} // End of SimpleHw3 class

