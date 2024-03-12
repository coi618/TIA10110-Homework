package hw7;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

public class SimpleHw7 {

	public static void main(String[] args) throws IOException {
		
		// Hw 7-1. 讀取檔案資訊
		System.out.println("Hw 7-1: 請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:\r\n"
				+ "\tSample.txt檔案共有xxx個位元組,yyy個字元,zzz列資料");
//		readFileInfo();
		/***************************************************/

		// Hw 7-2
		System.out.println("\n\nHw 7-2: 請寫一隻程式,能夠亂數產生10個1~1000的整數,"
				+ "並寫入一個名為Data.txt的檔案裡\n\t"
				+ "(請使用 append 功能讓每次執行結果都能被保存起來)");
//		randomAndStore();
		/***************************************************/

		// Hw 7-3	
		System.out.println("\n\nHw 7-3: 請從無到有試著完成一個方法名為copyFile，"
				+ "這個方法有兩個參數。\n\t呼叫此方法時，"
				+ "第一個參數所代表的檔案會複製到第二個參數代表的檔案");
		doCopyFile();
	}

	// Method for 7-1
	private static void readFileInfo() {
		// 宣告檔案路徑(String folder)使用相對路徑, 
		// 檔案名稱(String fileName)
		String folder = "./src/hw7";
		String fileName = "Sample.txt";
		
		// 宣告 int cCount, lineCount 儲存字元數與列數
		int cCount = 0, lineCount = 0;
		
		// 宣告 File 物件()，建立時使用 folder+fileName
		File f = new File(folder, fileName);
		
		// Check: 檢查檔案路徑，確認檔案存在
//		System.out.println("Path: "+f.getAbsolutePath());
//		System.out.printf("%s is %sexist%n", fileName, f.exists() ? "" : "Not " );
		// 如果檔案存在，才執行計算
		if(f.exists()) {
			// 呼叫 getCharCount(f) 取得字元數
			cCount = getCharCount(f);
			// 呼叫 getLineCount(f) 取得列數
			lineCount = getLineCount(f);
			// 呼叫輸出方法 printInfo(File f)
			printInfo(fileName, f.length(), cCount, lineCount);	
		} else {
			System.out.printf("%s is Not exist%n", fileName);
		}	
	}

	private static int getCharCount(File f) {
		// 宣告字元暫存 c
		int c;
		// 宣告字元計數器 cCount
		int cCount = 0;
		
		// The try-with-resources Statement 自動回收 resource
		/* https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html */
		// 宣告 FileReader fr 使用 f
		try(FileReader fr = new FileReader(f)) {
			// 讀取字元，直到EOF(-1)
			while((c = fr.read()) != -1) { 
				cCount++;
			} // End while (c != -1)
		} catch (IOException ioe) {
			// 處裡例外
			System.out.println("發生例外，待處理");
			ioe.printStackTrace();
		}
		// 回傳字元數
		return cCount;
	}

	private static int getLineCount(File f) {
		// 宣告字串暫存 s
		String s;
		// 宣告列計數器 lineCount
		int lineCount = 1;
		// 宣告 BufferedReader( FileReader )使用 f
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
			// 讀取字串，直到 null
			while((s = br.readLine()) != null) {
//				System.out.println(s); // 查看檔案內容
				lineCount++;
			}
		} catch (IOException ioe) {
			// 處裡例外
			System.out.println("發生例外，待處理");
			ioe.printStackTrace();
		}
		// 回傳列數
		return lineCount;
	}

	public static void printInfo(String fileName, long size, int charCount, int lineCount) {
		System.out.printf("%s 檔案共有 %d 個位元組，%d 個字元，%d 列資料%n"
				, fileName, size, charCount, lineCount);
	}

	// Method for 7-2
	private static void randomAndStore() {
		// TODO 1. 宣告 int[] chooseNum = new int[10]; 用來存放10個數字
		int[] chooseNum = new int[10];
		// 宣告路徑名稱 String folder = "./src/hw7/";
		String folder = "src/hw7/";
		// 宣告檔案名稱 String fileName = "Data.txt";
		String fileName = "Data.txt";
		
		// HOWTO? 如果路徑不存在，建立資料夾
		// 建立檔案物件
		File f = new File(folder, fileName);
		
		// TODO 2. FOR 10: 呼叫 random 產生亂數，存入陣列
		for (int i = 0; i < chooseNum.length; i++) { 
			chooseNum[i] = (int)(Math.random()*1000) + 1;
		} // End FOR 10
		// 儲存到檔案
		saveToData(chooseNum, f);		
		
		// TODO 6. 輸出檔案絕對路徑
		System.out.printf("程式結束。%n%s 在 %s"
				,fileName, f.getAbsolutePath());
	}

	private static void saveToData(int[] chooseNum, File f) {

		// TODO 3. 檢查 Data.txt 是否存在? 不存在就建立一個
		try {
			if(f.createNewFile()) 
				System.out.println("建立 Data.txt 檔");
		} catch (IOException ioe) {
			// 處裡例外
			System.out.println("發生例外，待處理");
			ioe.printStackTrace();
		}
		
		// TODO 4. 開啟 Data.txt，使用附加模式
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
			// TODO 5. 將 chooseNum 存入 Data.txt
			bw.write(Arrays.toString(chooseNum));
			bw.newLine();
		} catch (IOException ioe) {
			// 處裡例外
			System.out.println("發生例外，待處理");
			ioe.printStackTrace();
		}
	}

	// Method for 7-3
	private static void doCopyFile() {
		// TODO 1. Ask user input file1, Ask user input file2
		// TODO 2. Check file1 exist, file2 not exist(or should replace)
		// TODO 3. Buffered read file1, Buffered write file 2. line by line
		// TODO 4. Print files' absolute path
	}
}
