package hw6;

import java.util.Scanner;

public class CalTestDrive {

	public static void main(String[] args) {
//		System.out.println("請輸入 0.5, 9999999999999999, abc, !, \"0\", '0', 123, 0, -0, -3：");
//		CheckInput(); // 123, 0, -0, -3, 0.5, 9999999999999999, abc, !, "0" '0'
		
		Calculator test = new Calculator();
		String[] result = new String[10];
		result[0] = test.powerXY(0, 0); 	// "0的0次方沒有意義!"
		result[1] = test.powerXY(0, -1); 	// "次方為負值，結果回傳不為整數!"
		result[2] = test.powerXY(1, 0); 	// "1的0次方等於1"
		result[3] = test.powerXY(-2, 3);	// "-2的3次方等於-8"
		result[4] = test.powerXY(2, 31);	// 結果超出運算範圍
		result[5] = test.powerXY(-2, 32);	// 結果超出運算範圍
		result[6] = test.powerXY(-2, 31);	// "-2的31次方等於-2147483648"
		result[7] = test.powerXY(Integer.MAX_VALUE, 1);	// "2的30次方等於1073741824"
		
		
		int count = 0;
		while(result[count] != null) {
			System.out.println(result[count++]); // Print each string of test
		}
	}
	
	private static int CheckInput() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			if (!sc.hasNextInt()) {
				System.out.println("請輸入整數：");
				continue;
			}
			return sc.nextInt();
		}	
	}

}
