package hw6;

public class Calculator {
	
	public String powerXY(int x, int y) {
//		// 準備一個 int 存數學結果
//		int resultInt;
//		// 準備一個 String 存字串結果
//		String resultStr = ""; 
		// 準備二個 double intMax/intMin 儲存 int 最大/小值，用來檢查回傳是否超出int範圍
		double intMax = Integer.MAX_VALUE;
		double intMin = Integer.MIN_VALUE;
		// 準備一個 double 儲存 pow 運算
		double resultDouble;
		
		try {
			// 例外1: x, y 皆為 0，回傳 "0的0次方沒有意義!"
			if (x == 0 && y == 0)
				throw new CalException("0的0次方沒有意義!");
			// 例外2: y < 0，回傳 "次方為負值，結果回傳不為整數!"
			if (y < 0)
				throw new CalException("次方為負值，結果回傳不為整數!");
			// 計算 pow 的值，存在 resultDouble 準備做範圍比較
			resultDouble = Math.pow(x, y);
			// 例外3: 超出 int 範圍
			if(resultDouble > Integer.MAX_VALUE || resultDouble < Integer.MIN_VALUE)
				throw new CalException(x + "的" + y + "次方結果超出運算範圍");
//			// 正常請況: 計算 x^y
//			resultInt = (int)resultDouble;
			// 轉成字串並回傳
			return x + "的" + y + "次方等於" + (int)resultDouble;
		} catch (CalException calEx){
			// 回傳 Exception 訊息
			return calEx.getMessage();
		}		
	}
}
