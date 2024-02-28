package hwext;
//繼承 Pen
public class InkBrush extends Pen {

	// Constructor 
	InkBrush(String brand, double price) {
		super(brand, price);
	}
	
	@Override
	public void write() {
		System.out.println("沾墨汁再寫");
	}
	
	@Override
	public double getPrice() {
		// 原價打 9 折
		return super.getPrice() * 0.9;		
	}
}
