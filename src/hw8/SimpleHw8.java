package hw8;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class SimpleHw8 {

	// Main  /*  */
	public static void main(String[] args) {
		
		// Hw 8-1
		System.out.println("Hw8-1: 請建立一個Collection物件並將以下資料加入: "
				+ "\n\tInteger(100)、Double(3.14)、Long(21L)、Short(“100”)、Double(5.1)、“Kitty”、"
				+ "\n\tInteger(100)、Object物件、“Snoopy”、BigInteger(“1000”)"
				+ "\n\t• 印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach)"
				+ "\n\t• 移除不是java.lang.Number相關的物件"
				+ "\n\t• 再次印出這個集合物件的所有元素，觀察是否已將非Number相關的物件移除成功");
//		collectionIO();
		/***************************************************/
		
		/* 定義 Class & Data */
		System.out.println("\n\nDefine Class & Data");
		System.out.println("請設計一個Train類別，並包含以下屬性:\n"
				+ "- 班次\tnumber\t型別為\tint\n- 車種\ttype\t型別為\tString\n- 出發地\tstart\t型別為\tString"
				+ "\n- 目的地\tdest\t型別為\tString\n- 票價\tprice\t型別為\tdouble\n"
				+ "• 設計對應的getter/setter方法，並在main方法裡透過建構子產生以下7個Train的物件，"
				+ "\n  放到每小題 需使用的集合裡\n"
				+ " - (202, “普悠瑪”, “樹林”, “花蓮”, 400)\n - (1254, “區間”, “屏東”, “基隆”, 700)"
				+ "\n - (118, “自強”, “高雄”, “台北”, 500)\n - (1288, “區間”, “新竹”, “基隆”, 400)"
				+ "\n - (122, “自強”, “台中”, “花蓮”, 600)\n - (1222, “區間”, “樹林”, 七堵, 300)"
				+ "\n - (1254, “區間”, “屏東”, “基隆”, 700)");
		System.out.println("\n根據使用的集合，練習各種取值寫法，如迭代器、for迴圈或foreach等");
		
		/* 宣告 Train Collection，add 物件 */
		List<Train> northBound = new ArrayList<Train>();
		northBound.add(new Train(202, "普悠瑪", "樹林", "花蓮", 400));
		northBound.add(new Train(1254, "區間", "屏東", "基隆", 700));
		northBound.add(new Train(118, "自強", "高雄", "台北", 500));
		northBound.add(new Train(1288, "區間", "新竹", "基隆", 400));
		northBound.add(new Train(122, "自強", "台中", "花蓮", 600));
		northBound.add(new Train(1222, "區間", "樹林", "七堵", 300));
		northBound.add(new Train(1254, "區間", "屏東", "基隆", 700));
		
		Collections.sort(northBound);
		/***************************************************/
		// Hw 8-2-1
		System.out.println("\n\nHw8-2-1: 請寫一隻程式，能印出不重複的Train物件");
		/* 使用 HashSet */
		pickBySet(northBound);
		/***************************************************/
		// Hw 8-2-2
		System.out.println("\n\nHw8-2-2: 請寫一隻程式，讓Train物件印出時，能以班次編號由大到小印出");
		/* 使用 ArrayList */
		sortByList(northBound);
		/***************************************************/
		// Hw 8-2-3		
		System.out.println("\n\nHw8-2-3: 承上，不僅能讓班次編號由大排到小印出， 還可以不重複印出Train物件");
		/* 試著使用 TreeMap */
	}
	
	/* Hw 8-2-1 Bug: 重複出現了 */
	private static void pickBySet(List<Train> northBound) {
		/* 1. 宣告 HashSet<Train> */
		/* 2. 放入 Train 物件 */
		/* 3. 取出(輸出) Train 物件 */
		
		/* 1. 宣告 HashSet<Train> */
		Set<Train> trainSet = new HashSet<Train>();
		/* 2. 放入 Train 物件 */
		for (Iterator<Train> it = northBound.iterator(); it.hasNext(); ) {
			trainSet.add(it.next());
		}
		/* 3. 取出(輸出) Train 物件 */
		Iterator it = trainSet.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if (tmp instanceof Train train) {
				System.out.println(train);
			}
			else {
				System.out.println("Should not run here...");
			}
		}
		
	}
	
	/* Hw 8-2-2 */
	private static void sortByList(List<Train> northBound) {
		for (Train t : northBound) {
			System.out.println(t);
		}
		
	}
	
	
}
