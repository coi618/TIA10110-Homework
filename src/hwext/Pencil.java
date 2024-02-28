package hwext;
// 繼承 Pen
public class Pencil extends Pen {

	// 建構子使用有沒有繼承?
	// 沒有: The constructor Pencil(String, int) is undefined
	Pencil(String brand, double price) {
		super(brand, price);
	}
	// 實作 write()
	@Override
	public void write() {
		System.out.println("削鉛筆再寫");
	}
	// 複寫 getPrice()
	@Override
	public double getPrice() {
		// 回傳原價打 8 折
		return super.getPrice() * 0.8;
	}

}
