package hw8;

import java.util.Objects;

public class Train implements Comparable<Train> {
	/* 屬性 */
	private int number;
	private String type;
	private String start;
	private String dest;
	private double price;
	
	/* 建構子 */
	Train() {}
	Train(int number, String type, String start, String dest, double price) {
		super();
		setNumber(number);
		setType(type);
		setStart(start);
		setDest(dest);
		setPrice(price);
	}
	
	/* 方法 */
	/* Set */
	private void setNumber(int number) {
		this.number = number;
	}
	private void setType(String type) {
		this.type = type;
	}
	private void setStart(String start) {
		this.start = start;
	}
	private void setDest(String dest) {
		this.dest = dest;
	}
	private void setPrice(double price) {
		this.price = price;
	}
	/* Get */
	public int getNumber() {
		return number;
	}
	public String getType() {
		return type;
	}
	public String getStart() {
		return start;
	}
	public String getDest() {
		return dest;
	}
	public double getPrice() {
		return price;
	}
	
	/* 為了實現排序功能 */
	@Override
	public int compareTo(Train aTrain) {
		// 實作 compareTo 方法
		/* 1. 如果位址相同，直接回傳相同(0) */
		if (this == aTrain) return 0;
		else {
			/* 取 Train 的 number 差
			 * 如果差值為 0 則回傳 0
			 * 如果差值不為 0 則回傳 差/差的絕對值(1 or -1)
			 * EX:
			 * this.number = 5, aTrain.number = 10 => return (5-10)/|(5-10)| = -1
			 * this.number = 5, aTrain.number = 0 => return (5-0)/|(5-0)| = -1
			 * this.number = 5, aTrain.number = 5 => return (5-5) = 0  
			 */
			int diff = this.number - aTrain.number;
			return (diff == 0 ? 0 : diff/Math.abs(diff));
		}
	}
	
	/* 為了輸出方便 */
	@Override
	public String toString() {
		return "Train [number=" + number + "\ttype=" + type + 
			   "\tstart=" + start + "\tdest=" + dest + "\tprice=" + price + "]";
	}
	
	/* Bug: 未實作 equals(), hashCode()*/
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		return number == other.number;
	}
	
	
	
}
