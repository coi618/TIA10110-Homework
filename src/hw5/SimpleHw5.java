package hw5;

import java.util.Scanner;

public class SimpleHw5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  請設計一個方法為starSquare(int width, int height),
		 *  當使用者鍵盤輸入寬與高時,即會印出對應的*長方形
		 */
		System.out.print("Hw 5-1: 請設計一個方法為starSquare"
				+ "\n\t當使用者鍵盤輸入寬與高時,即會印出對應的*長方形"
				+ "\n\t請輸入 寬, 高：");
		dealStarSquare();
		
		/*
		 * 請設計一個方法為randAvg(),從10個 0~100(含100)的整數亂數中取平均值並印出這10個亂數與平均值,如圖:
		 */
		System.out.println("Hw 5-2: 請設計一個方法為randAvg(),"
				+ "\n\t從10個 0~100(含100)的整數亂數中取平均值,"
				+ "\n\t並印出這10個亂數與平均值。");
		randAvg();
		/*
		 * 利用Overloading,設計兩個方法int maxElement(int x[][])與double maxElement(double x[][]),
		 * 可以找出二維陣列的最大值並回傳:
		 */
		System.out.println("\n\nHw 5-3: 利用Overloading,設計兩個方法"
				+ "\n\tint maxElement(int x[][])與double maxElement(double x[][]),"
				+ "\n\t可以找出二維陣列的最大值並回傳:");
		findMax();
		
		// Hw 5-4 另寫
		System.out.println("\n\nHw 5-4 另外寫");
		
		/*
		 * 身為程式設計師的你,收到一個任務,要幫系統的註冊新增驗證碼的功能,
		 * 請設計一個方法 genAuthCode(),當呼叫此方法時,會回傳一個8位數的驗證碼,
		 * 此驗證碼內容包含了英文大小寫與數字的亂數組合,如 GLSE3X81:
		 */
		System.out.println("\n\nHw 5-5: 回傳一個8位數的驗證碼"
				+ "\n\t此驗證碼內容包含了英文大小寫與數字的亂數組合。");
		genAuthCode();
		
		// Hw 5 結束
		System.out.println("\n\nHw 5 結束。");
	}

	// Method for 5-1
	private static void dealStarSquare() {
		// 宣告陣列side用來儲存 寬 與 高
		int[] side = new int[2];
		// 要求使用者輸入寬與高，並檢查
		askInput(side);
		// 呼叫 starSquare()方法
		starSquare(side[0], side[1]);
	}

	private static void askInput(int[] side) {
		// TODO Auto-generated method stub
		// 準備輸入
		Scanner sc = new Scanner(System.in);
		// FOR 依序輸入寬、高
		for (int i = 0; i < side.length; i++) {
			// 	IF 如果輸入非整數的情況
			if (!sc.hasNextInt()) {
				//	  提示輸入整數
				System.out.println("請輸入整數：");
				//	  重新準備輸入
				sc = new Scanner(System.in);
				//	  重設索引值，前面輸入作廢
				i = -1;
				//	ELSE 輸入整數情況，依序寫入寬、高
			} else {
				side[i] = sc.nextInt();
				// IF 檢查數入 < 0 的狀況
				if (side[i] < 0) {
					System.out.println("請輸入正整數：");
					sc = new Scanner(System.in);
					i = -1;
				} // IF 檢查數入 < 0 END
				// ELSE 寫入陣列，不需其它行為
			} //  IF END
		} // FOR END
	}

	private static void starSquare(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	// Method for 5-2
	private static void randAvg() {
		// TODO Auto-generated method stub
		// 1. 宣告陣列 randomArray[10] 儲存 10 個亂數
		int[] randomArray = new int[10];
		// 2. 宣告 int avg = getAvg(int[] arr); 計算並儲存平均
		int avg = getAvg(randomArray);
		// 3. 呼叫 printAvg(int[] arr, int avg); 列印陣剔與平均
		printAvg(randomArray, avg);
	}
	
	private static int getAvg(int[] randomArray) {
		// 宣告 avg 儲存平均並回傳
		int avg = 0;
		
		// FOR ARRAY
		for (int i = 0; i < randomArray.length; i++) {
			// 對所有陣列位置放入一個隨機數
			randomArray[i] = (int)(Math.random() * 101);
			// avg += randomArray[index]
			avg += randomArray[i];
		} // FOR END
		
		// avg /= Array 長度
		avg /= randomArray.length;
		
		return avg;
	}

	private static void printAvg(int[] randomArray, int avg) {
		// 輸出提示
		System.out.println("本次亂數結果：");
		// 輸出所有陣列元素
		for (int i = 0; i < randomArray.length; i++)
			System.out.print(randomArray[i] + " ");
		// 輸出平均值
		System.out.println("\n平均：" + avg);
	}
	
	// Method for 5-3
	private static void findMax() {
		// 宣告 testObj 物件
		Hw5_3 testObj = new Hw5_3();
		// 宣告 2 個陣列
		double[][] dArray = 
			{
				{0.0, 1.0, 2.0, 3.0},
				{0.1, 1.1, 2.1, 3.1},
				{0.2, 1.2, 2.2, 3.2},
				{0.3, 1.3, 2.3, -3.3}
			};
		int[][] iArray = 
			{
				{0, 1, 2, 3},
				{10, 11, 12, 13},
				{20, 21, 22, 23},
				{30, 31, 32, -33}
			};
		// 輸出同時呼叫物件方法
		System.out.printf(""
				+ "double 陣列的最大值為: %.2f%n"
				+ "int 陣列的最大值為: %d%n",
				testObj.maxElement(dArray), 
				testObj.maxElement(iArray));
	}
	
	// Method for 5-5
	private static void genAuthCode() {
		// TODO Auto-generated method stub
		// 1. 宣告 char[] charPool = new char[62]; 存放 A-Za-z0-9
		char [] charPool = new char[62];
		//for (char Up = 'A', low = 'a'; Up <= 'Z'; Up++, low++) {
		for (int i = 0; i < 26; i++) {
			charPool[i] = (char)(i + 'A');
			charPool[i+26] = (char)(i + 'a');
		}
		for (int i = 0; i < 10; i++)
			charPool[i+52] = (char)(i+'0');
		
		// 2. 宣告 String code = ""; 存放並回傳驗証碼
		String code = "";
		// 3. FOR 產生 8 碼串接回傳
		for (int i = 0; i < 8; i++) {
			code += charPool[(int)(Math.random()*62)];
		}
		// 4. 輸出驗証碼
		System.out.println("本次隨機產生驗証碼為：\n" + code);
		
		// Debug: printCharArray(charPool)
		//printCharArray(charPool);
	}

	private static void printCharArray(char[] charPool) {
		// 輸出所有陣列內容: 應為 A-Za-z0-9
		for (int i = 0; i < charPool.length; i++) {
			if (i % 7 == 0) System.out.println();
			System.out.print(charPool[i] + " ");
		}
	}
}
// Class for 5-3
class Hw5_3 {
	
	// int 陣列方法 overriding
	public int maxElement(int x[][]) {
		// 宣告 max 儲存最大值
		int max = 0;
		// 對陣列內的每個元素檢查，如果 > max : 將 max 設為該元素
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] > max) {
					max = x[i][j];
				}
			}
		}
		return max;
	}
	// double 陣列方法 overriding
	public double maxElement(double x[][]) {
		double max = 0;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] > max) {
					max = x[i][j];
				}
			}
		}
		return max;
	}	
}