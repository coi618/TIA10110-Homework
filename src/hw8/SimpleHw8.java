package hw8;

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
//		List<Train> upLine = new ArrayList<Train>();
		/***************************************************/
		// Hw 8-2-1
		System.out.println("\n\nHw8-2-1: 請寫一隻程式，能印出不重複的Train物件");
		/* 使用 Set */
		/***************************************************/
		// Hw 8-2-2
		System.out.println("\n\nHw8-2-2: 請寫一隻程式，讓Train物件印出時，能以班次編號由大到小印出");
		/* 使用 ArrayList */
		/***************************************************/
		// Hw 8-2-3		
		System.out.println("\n\nHw8-2-3: 承上，不僅能讓班次編號由大排到小印出， 還可以不重複印出Train物件");
		//
	}
	
	
}
