package hw7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SimpleHw7 {
	/* For OS mapping values */
	public static final int MACOS = 0;
	public static final int WINDOWS = 1;
	public static final int LINUX = 2;

	public static void main(String[] args) throws IOException {
		
		// Hw 7-1. 讀取檔案資訊
//		System.out.println("Hw 7-1: 請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:\r\n"
//				+ "\tSample.txt檔案共有xxx個位元組,yyy個字元,zzz列資料");
//		readFileInfo();
		/***************************************************/

		// Hw 7-2
//		System.out.println("\n\nHw 7-2: 請寫一隻程式,能夠亂數產生10個1~1000的整數,"
//				+ "並寫入一個名為Data.txt的檔案裡\n\t"
//				+ "(請使用 append 功能讓每次執行結果都能被保存起來)");
//		randomAndStore();
		/***************************************************/

		// Hw 7-3	
//		System.out.println("\n\nHw 7-3: 請從無到有試著完成一個方法名為copyFile，"
//				+ "這個方法有兩個參數。\n\t呼叫此方法時，"
//				+ "第一個參數所代表的檔案會複製到第二個參數代表的檔案");
//		doCopyFile();
		
		System.out.println("\n\nHw 7-4: 請寫一支程式，利用老師提供的Dog與Cat類別分別產生兩個物件，"
				+ "\n\t寫到C:\\data\\Object.ser裡。(MAC: ~/data/Object.ser)"
				+ "\n\t注意物件寫入需注意的事項，若C:\\內沒有data資料夾，請用程式新增這個資料夾");
		saveObj();
		
		System.out.println("Hw7 結束");
	}

	// Method for 7-1  /*  */
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

	// Method for 7-2  /*  */
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

	// Method for 7-3  /*  */
	private static void doCopyFile() throws IOException {
		// 宣告 file1，file2 路徑
		String path1 = "", path2;
		// 宣告 file1, file2
		File file1 = new File(path1); 
		File file2 = null;
		// 宣告覆蓋
		boolean replace = false;
		// 宣告暫存字串 s 
		String s;
		
		while (!file1.exists()) {
			// TODO 1. Ask user input file1, Ask user input file2
			path1 = askPath("目前在 " + file1.getAbsolutePath() + "\n請輸入 file1 路徑: ");
//			String path1_2 = "/Users/coi618/javawork/copyFile.txt";
//			System.out.println("path1.equals(path1_2): " + path1.equals(path1_2));
			// TODO 2. Check file1 exist, file2 not exist(or should replace)
			file1 = new File(path1);
		}
		while (true) {
			path2 = askPath("請輸入 file2 路徑: ");
//			String path2_2 = "/Users/coi618/javawork/pasteFile.txt";
//			System.out.println("path2.equals(path2_2): " + path2.equals(path2_2));
			file2 = new File(path2);
			if(!file2.exists()) /* 檔案不存在，可接受 */
				break; 
			else if(replace = askReplace("file2 己存在，是否覆蓋?(Yes/No) ")) { /* 檔案可覆蓋，可接受 */
				break; 
			}
		}
		
		// TODO 3. Buffered read file1, Buffered write file 2. line by line
		BufferedReader br = new BufferedReader(new FileReader(file1));
		BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
		/* 將檢查 s 不為 null */
		while ((s = br.readLine()) != null) {
			bw.write(s);
			bw.newLine();
		}
		
		bw.close(); br.close(); /* close buffered-I/O */
		// TODO 4. Print checkOfFiles
		System.out.println("file1.equals(file2): " + file1.equals(file2));
	}

	private static String askPath(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.println(str);
		return sc.nextLine();
	}

	private static boolean askReplace(String str) {
		System.out.print(str);
		Scanner sc = new Scanner(System.in);
		return ("YES".equalsIgnoreCase(sc.next()) ? true : false);
	}

	// Method for 7-4  /*  */
	private static void saveObj() throws IOException {
		// TODO Auto-generated method stub
		/* 1. Class Dog, Cat 加上 Serializable */
		/* 2. 呼叫貓狗，各建立兩個物件(lino, taro, puppy, fox) */
		/* 3. 判斷OS, 分別呼叫不同方法(回傳路徑)建立 data 資料夾 */
		/* 4. 產生檔案 */
		/* 5. 將物件存入檔案 */
	
		/* 1. Class Dog, Cat 加上 Serializable DONE */
		/* 2. 呼叫貓狗，各建立兩個物件(lion, taro, puppy, fox) DONE*/
		Dog[] dog = new Dog[2];
		Cat[] cat = new Cat[2];
		dog[0] = new Dog("Lion");
		dog[1] = new Dog("TaRo");
		cat[0] = new Cat("puppy");
		cat[1] = new Cat("fox");
		/* 3. 判斷OS, 分別呼叫不同方法(回傳路徑)建立 data 資料夾(沒測試 MAC) */
		/* 4. 產生檔案 */
		int os = checkOS();
//		System.out.println("OS: " + os);
		String path;
		/* throws IOException */
		if (os == WINDOWS) path = mkdirByWin();
		else if (os == MACOS) path = mkdirByMAC();
		else path = mkdirByLinux();
//		System.out.println("使用路徑: " + path);
		
		/* 5. 將物件存入檔案 */
		storeObj(path, dog, cat);
		/*  */
	}

	private static int checkOS() {
		/** Check os and return mapping Number **/
		String osNameLow = System.getProperty("os.name").toLowerCase();
//		System.out.printf("osNameLow: %s%n", osNameLow);
		/* Sol 1. Check with Regex matches */
//		String[] os = {"^.*mac.*$", "^.*window.*$", "I DONT KNOW"}; /* HERE IS BUG IN LINUX*/
//		for (int i = 0; i < os.length; i++) {
//		System.out.printf("osName.toLowerCase().matches(%s): %b%n", 
//				os[i], osNameLow.matches(os[i]));
//		}
		/* Sol 2. Use String with contains() */
//		String[] os = {"mac", "windows", "I DONT KNOW"};
//		for (int j = 0; j < os.length; j++) {
//			System.out.printf("osNameLow.contains(%s): %b%n", 
//					os[j], osNameLow.contains(os[j]));
//		}
		/* Sol 3. Use String with contains() + Map */
		/* 宣告 HashMap os 裝 osCode-os比較字串 */
		Map os = new HashMap();
		os.put(MACOS, "mac");
		os.put(WINDOWS, "windows");
		os.put(LINUX, "IDONTKNOW");
		/* 取出所有的 key，包裝成 Set 的型態 (看不懂，先照抄) */
		Set osCode = os.keySet();
		
		Iterator it = osCode.iterator();
		/* osNameLow 比對所有os(Value), 對到就回傳 */
		while (it.hasNext()) {
			Object myKey = it.next();
//			System.out.println((int)myKey + os.get(myKey).toString());
			if (osNameLow.contains(os.get(myKey).toString())) {
				return (int)myKey;
			}
		}
		return LINUX; /* 因為沒判斷 LINUX，如果沒比出任何結果就回傳 LINUX */
	}

	private static String mkdirByLinux() throws IOException {
		// TODO 先用 MAC 的方法
		return mkdirByMAC();
	}

	private static String mkdirByMAC() throws IOException {
		// TODO Auto-generated method stub
		
		/* 1. 取得絕對路徑 */
		/* 2. 切到 userName，在這個路徑下 */
		/* 3. call&return checkPath() */
		/*  */
		File current = new File("");
		System.out.println(current.getAbsolutePath());
		String currPath = current.getAbsolutePath();
//		currPath = "/Users/coi618/javawork/tmp";
		/* 取得 MAC 的家目錄: 以 String path = getAbsolutePath()
		 * 1. 在家目錄下
		 * 條件: 數到字串結束
		 * 2. 在家目錄上
		 * 條件: 數到第三個 '/'
		 * homePath = getAbsolutePath().substring(0, count); 
		 * */
		int count, slashCount = 0;
		for (count = 0; count < currPath.length(); count++) {
			if('/' == currPath.charAt(count)) {
				/* 已到達第三個斜線 */
				if(++slashCount == 3)
					break;
			}
		}
		String homePath = currPath.substring(0, count);
//		System.out.println("homePath: " + homePath);
		File data = new File(homePath + "/data");
		File objSer = new File(homePath + "/data/Object.ser");
		
		return checkPath(data, objSer);
	}

	private static String mkdirByWin() throws IOException{
		File data = new File("C:/data");
		File objSer = new File("C:/data/Object.ser");
		
		return checkPath(data, objSer);
	}

	private static String checkPath(File data, File objSer) throws IOException {
		/* 1. 檢查資料夾(C:\\data)是否存在，如果不存在，建立一個 */
		if (!(data.exists() && data.isDirectory())) data.mkdir();
		/* 2. 建立 Object.ser 檔案  */
		/*
		 * 檔案存在 -> 詢問使用者是否覆蓋 -> 是: 回傳路徑
		 * 否 -> 詢問使用其他路徑 -> 檢查檔案存在
		 * */
		while(objSer.exists() && objSer.isFile()) {
			if(askReplace(objSer.getPath() + "已經存在，是否覆寫?(yes/no) ")) {
				return objSer.getPath();
			}
			objSer = new File(askPath("請輸入其他路徑: "));
		}
		/* 處裡檔案不存在的情況 */
		objSer.createNewFile(); /* throws IOException */
		/* 3. 回傳 Object.ser 檔案路徑 */
		return objSer.getPath();
	}

	private static void storeObj(String path, Dog[] dog, Cat[] cat) throws IOException {
		// TODO 以路徑打開檔案，存入2貓2狗

		/* 開啟檔案，準被儲存資料 */ /* throws Exception, why ? */
		var oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
		/* 把狗物件存入檔案 */
		for (int i = 0; i < dog.length; i++) {
			oos.writeObject(dog[i]);
		}
		/* 把貓物件存入檔案 */
		for (int i = 0; i < cat.length; i++) {
			oos.writeObject(cat[i]);
		}
		/* 關閉檔案 */
		oos.close();
	}
}
