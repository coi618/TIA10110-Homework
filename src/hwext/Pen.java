package hwext;

// 抽象方法存在，類別設定為抽象 
public abstract class Pen {
	// 屬性(Instance variable)
	// 設定為 private，需透過 setter/getter取用(封裝)
	private String brand;
	private double price;
	
	// 建構子(Constructor) 
	// 1. 如何決定建構子存取權?
	// 2. 可以在建構子裡寫 setter 嗎?
	Pen() {}
	public Pen(String brand, double price) {
		setBrand(brand);
		setPrice(price);
	}
	
	// 方法(Method)
	// public，透過方法存取物件屬性
	private void setPrice(double price) {
		if (price > 0)
			this.price = price;
		else
			System.out.println("請確認產品價格!");
	}
	private void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	// 抽象方法存在，類別設定為抽象
	public abstract void write();
}
