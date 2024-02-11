package hw3;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleHw3 {

	public static void main(String[] args) {
		// Hw 3-1. 三角形判斷 Level-2
		System.out.println("Hw 3-1: 判斷三角形 Level-2\n");
		triangleJudgment();
		
		/***************************************************/
		// Hw 3-2: 猜數字 (0~9) Level-2
		System.out.println("\n\nHw 3-2: 猜數字 Level-2\n");
		guessNumber();

		/***************************************************/
		// Hw 3-3. 進階大樂透 Level-2
		System.out.println("\n\nHw 3-3: 進階大樂透 Level-2\n");
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
		System.out.println("請輸入三個整數：");
		for (int i = 0; i < side.length; i++)
			side[i] = askSide();

		// 在判斷前，排序邊長
		Arrays.sort(side);
		// 顯示邊長，讓使用者可以直覺判斷結果
		System.out.printf("(%d, %d, %d)", side[0], side[1], side[2]);

		// 判斷1. 檢查是否為三角形
		if (!isTriangle(side))
			System.out.println("不是一個三角形");

		// 判斷2. 正三角
		else if (isEquilTri(side))
			System.out.println("是一個正三角形");

		// 判斷3. 等腰三角形
		else if (isIsoscTri(side)) {
			System.out.println("是一個等腰三角形");
			// 同時為等腰三角形與直角三角形的情況 (1, 1, √2)
			// 雖然無法在本題中算到，還是保留邏輯運算過程
			if (isRightTri(side))
				System.out.println("也是一個直角三角形");
		}

		// 判斷4. 直角三角形
		else if (isRightTri(side))
			System.out.println("是一個直角三角形");

		// 以上皆不符合者判定為其他
		else
			System.out.println("是一個一般的三角形");

	} // End triangleJudgment()

	public static int askSide() {
		Scanner sc = new Scanner(System.in);
		// 檢查輸入不是整數的情況
		while (!sc.hasNextInt()) {
			System.out.println("請輸入數字： ");
			sc = new Scanner(System.in);
		}
		return sc.nextInt();
	}

	public static boolean isTriangle(int[] side) {
		int small = side[0], middle = side[1], longSide = side[2];
		// (1). 所有邊長需 > 0，因為邊長已排序過，只要檢查最小邊即可
		if (small <= 0)
			return false;

		// (2). 兩邊和[取短邊] > 第三邊
		if (small + middle <= longSide)
			return false;

		// (3). 兩邊差[取長邊] < 第三邊
		if (longSide - middle >= small)
			return false;

		// 所有條件吻合，是三角形
		return true;
	}

	public static boolean isEquilTri(int[] side) {
		// 所有邊長都相等 ? 是->回傳 true : 否->回傳 false
		return (side[0] == side[1] && side[1] == side[2]) ? true : false;
	}

	public static boolean isIsoscTri(int[] side) {
		// 其中2邊長相等 ? 是->回傳 true : 否->回傳 false
		return (side[0] == side[1] || side[1] == side[2] ? true : false);
	}

	public static boolean isRightTri(int[] side) {
		int result = -1;
		// side[0]^2 + side[1]^2 == side[2]^2
		result = Integer.compare((side[0] * side[0]) + (side[1] * side[1]), (side[2] * side[2]));
		return (result == 0);
	}

	/***************************************************/
	// Method for 3-2
	public static void guessNumber() {
		// 開始遊戲
		System.out.println("開始猜數字吧！");

		// 亂數產生一個答案
		int answer = (int) (Math.random() * 10);

//		System.out.println("Debug: Answer = " + answer);

		// 宣告比對結果變數：因為 0 為相同，預設使用 -1
		int compareResult = -1;

		// 建立無窮迴圈，當使用者猜中數字時結束
		while (true) {
			// 詢問使用者猜測，並與答案比較
			compareResult = Integer.compare(getUserGuess(), answer);
			// 如果猜對，輸出正確訊息並離開
			if (compareResult == 0) {
				System.out.println("答對了！答案就是 " + answer);
				break;
			} else {
				System.out.print("猜錯了，");
				// 如果比較的結果 > 0，表示使用者猜得比答案大。< 0 表示猜得比答案小
				// 依照比較的結果是否 > 0 ? 是->提示再小一些 : 否-> 提示再大一些
				System.out.println("再" + (compareResult > 0 ? "小" : "大") + "一些。");
			}
		} // end of while loop

		// System.out.println("Debug: Hw 3-2 Finish.");
	}

	public static int getUserGuess() {
		// 詢問使用者輸入數字 0~9
		System.out.print("請輸入一個 0~9 的數字： ");
		Scanner sc = new Scanner(System.in);
		// 判斷輸入不是整數的情況
		while (!sc.hasNextInt()) {
			System.out.print("請輸入數字!!： ");
			sc = new Scanner(System.in);
		}
		return sc.nextInt();
	}

	/***************************************************/
	// Method for 3-3
	public static void playLottery() {
		// 要求使用者輸入數字 (1~9)
		int hateNum = askUserHate();

//		System.out.print("Debug: Your hate number is " + hateNum);
		// 宣告存放可選取數字(optionNum)的陣列
		int[] optionNum = new int[49];
		// 計算可選取數字的數量
		int optCount = 0;

		for (int i = 1; i < 50; i++) {
			if (i % 10 == hateNum || (i >= 10 && i / 10 == hateNum)) {
				// 如果遇到討厭的數字，跳過
				// (i >= 10) : 特別處裡 hateNum = 0，1~9 全部不選的 bug
				continue;
			}
			// 其他數字依序放入陣列，計數器+1
			optionNum[optCount++] = i;
		}

		// 輸出可選數字 (輸出陣列)
		printArray(optionNum);
		System.out.printf("\n總共有%d數字可選\n", optCount);

		// 宣告挑選號碼陣列(pick) = 呼叫挑選號碼程式的回傳
		int[] pick = pickUpNumbers(optionNum, optCount);
		System.out.println("選取號碼為: ");
		// 依序列出選擇的號碼
		for (int p : pick)
			System.out.print(p + " ");
	}

	public static int askUserHate() {
		System.out.println("阿文...請輸入你討厭哪個數字？");
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) {
			System.out.print("請輸入整數 (1~9): ");
			sc = new Scanner(System.in);
			// 放棄檢查超出範圍的情況
		}
		return sc.nextInt();
	}

	public static void printArray(int[] intArray) {
		/*
		 * 1. int 預設為 0，遇到 0 表示可選取範圍結束 
		 * 2. 因為沒做範圍檢查，如果所有數字都可選(EX: hateNum = -1) 改用陣列長度作結束
		 * 3. 如果出現超出範圍的情況，先檢查 intArray[i] != 0 會超過 Array 長度 
		 *    因此 i < intArray.length 需先做判斷
		 */
		//System.out.println("Debug: Array.length = " + intArray.length);
		for (int i = 0; i < intArray.length && intArray[i] != 0; i++) {
			// 換行前置，後置換行版型會跑掉
			if (i % 6 == 0)
				System.out.println();
			System.out.print(intArray[i] + "\t");
		}
		System.out.println();
	}

	public static int[] pickUpNumbers(int[] optionNum, int optCount) {
		// 為了不影響原本的陣列，複製一個新的陣列
		int[] pickUp = Arrays.copyOf(optionNum, optCount);
		// 宣告選取的陣列 (open[6])
		int[] pick = new int[6];
		// 宣告索引
		int index;
		// 選出 6 個號碼
		for (int i = 0; i < 6; i++) {
			// 在 optCount 的範圍內選出 1 個號碼，放到 pick 陣列中
			index = (int) (Math.random() * optCount);
			pick[i] = pickUp[index];
			// 將選到的值與 Array 最後的值交換，然後對選取範圍-1 (optCount--)
			swap(pickUp, index, --optCount);
			/*
			 * optCount 是 Array 的長度，比 Array 最後的 index 大 1 所以要先 -1 才符合 Array 最後的 index 值。
			 * 剛好後續需要將 optCount -1 縮小選取範圍，就在這裡一併處理掉
			 */
		}
		// 不在乎順序，所以回傳前排序一下
		Arrays.sort(pick);

		return pick;
		/*
		 * 邏輯解釋: 在選完號碼後，將其與最後的值交換，然後下次選取的範圍-1。 可以避免出現重複選擇的情況
		 */
	}

	public static void swap(int[] pickUp, int index, int end) {
		// 宣告一個暫存 int，提供交換使用。以下將Array 中 index 與最後的值交換
		int tmp = pickUp[index];
		pickUp[index] = pickUp[end];
		pickUp[end] = tmp;
	}
} // End of SimpleHw3 class
