package hw5;

public class MyRectangleMain {

	public static void main(String[] args) {
		// Hw 5-4
		var recBring = new MyRectangle(10, 20);
		var recNone = new MyRectangle();
		
		// Set recNone by setter()
		recNone.setWidth(10);
		recNone.setDepth(20);
		
		// Print 2 rectangles' area
		System.out.println("recBring's area is " + recBring.getArea());
		System.out.println("recNone's area is " + recNone.getArea());

	}

}
