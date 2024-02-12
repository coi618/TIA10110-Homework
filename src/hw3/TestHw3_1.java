package hw3;

public class TestHw3_1 {

	public static void main(String[] args) {

		int[] side = { 0, 0, 0 };
		Triangle A = new Triangle(side);
		checkTriType(A);
		// check array, should return NOT triangle

		Triangle B = new Triangle(-1, 3, 5);
		checkTriType(B);
		// check variables, should return NOT triangle

		Triangle C = new Triangle(3, 3, 3);
		checkTriType(C);
		// should return Equil

		Triangle D = new Triangle(5, 3, 3);
		checkTriType(D);
		// check sort, should return Isoscel

		Triangle E = new Triangle(5, 4, 3);
		checkTriType(E);
		// should return right

		Triangle F = new Triangle(6, 4, 3);
		checkTriType(F);
		// should return General
	}

	private static void checkTriType(Triangle myTri) {
		// 顯示邊長，讓使用者可以直覺判斷結果
		System.out.printf("(%d, %d, %d)", myTri.shortSide, myTri.middleSide, myTri.longSide);

		// 判斷1. 檢查是否為三角形
		if (!myTri.isTriangle())
			System.out.println("不是一個三角形");

		// 判斷2. 正三角
		else if (myTri.isEquilTri())
			System.out.println("是一個正三角形");

		// 判斷3. 等腰三角形
		else if (myTri.isIsoscTri()) {
			System.out.println("是一個等腰三角形");
			// 同時為等腰三角形與直角三角形的情況 (1, 1, √2)
			// 雖然無法在本題中算到，還是保留邏輯運算過程
			if (myTri.isRightTri())
				System.out.println("也是一個直角三角形");
		}

		// 判斷4. 直角三角形
		else if (myTri.isRightTri())
			System.out.println("是一個直角三角形");

		// 以上皆不符合者判定為其他
		else
			System.out.println("是一個一般的三角形");

	}

}
