package hw5;

public class MyRectangle {
	private double width;
	private double depth;
	
	// Constructor
	public MyRectangle() { }
	
	public MyRectangle(double width, double depth) {
//		this.width = width;
//		this.depth = depth;
		setWidth(width);
		setDepth(depth);
	}
	
	// 將收到的引數指定給width屬性
	public void setWidth(double width) {
		if(width > 0) 
			this.width = width;
		else
			System.out.println("請對寬給正數。");
	}
	// 將收到的引數指定給depth屬性
	public void setDepth(double depth) {
		if(depth > 0) 
			this.depth = depth;
		else
			System.out.println("請對長給正數。");		
	}
	// 能計算該長方形的面積
	public double getArea() {
		return width * depth;
	}
}
