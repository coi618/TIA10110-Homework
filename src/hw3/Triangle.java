package hw3;

import java.util.Arrays;

public class Triangle {
	int shortSide;
	int middleSide;
	int longSide;

	// Constructor
	public Triangle() {
	}

	// How to optimize these 2 Constructors?
	public Triangle(int[] side) {
		this(side[0], side[1], side[2]);
	}

	public Triangle(int s, int m, int l) {
		int side[] = { s, m, l };
		Arrays.sort(side);
		this.shortSide = side[0];
		this.middleSide = side[1];
		this.longSide = side[2];
	}

	public boolean isTriangle() {
		// (1). A side <= 0 is not a triangle, since sides already sort, just check
		// shortSide
		if (shortSide <= 0)
			return false;
		// (2). 2 sides' sum(short + middle) > another side (long)
		if (shortSide + middleSide <= longSide)
			return false;

		// (3). 2 sides' subtract(long - middle) < another side (short)
		if (longSide - middleSide >= shortSide)
			return false;

		// All above pass, is a triangle
		return true;
	}

	public boolean isEquilTri() {
		// All sides are the same? Yes -> return true : No -> return false
		return (shortSide == middleSide && middleSide == longSide) ? true : false;
	}

	public boolean isIsoscTri() {
		// 2 sides equals? Yes -> return true : No -> return false
		return (shortSide == middleSide || middleSide == longSide ? true : false);
	}

	public boolean isRightTri() {
		// short side
		int result = -1;
		// side[0]^2 + side[1]^2 == side[2]^2
		result = Double.compare(Math.pow(shortSide, 2) + Math.pow(middleSide, 2), Math.pow(longSide, 2));
		return (result == 0);
	}

}
