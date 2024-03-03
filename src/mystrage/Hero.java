package mystrage;
// 問題: 設定為 abstract 有沒有差?
//public abstract class Hero {
public class Hero {
	// 省略 getter/setter...
	
	private String name;
	private int level;
	private double exp;
	
	// 加上行為屬性
	private IAttackWay myAttackWay;
	private IMoveWay myMoveWay;
	private IDefendWay myDefendWay;
	
	// 建構子宣告
	public Hero() {
		this("David", 1, 0);
	}
	
	public Hero(String name, int level, double exp) {
		this.name = name;
		this.level = level;
		this.exp = exp;
	}
	
	// 加上行為屬性的建構子
	public Hero(String name, int level, double exp, 
			IAttackWay myAttackWay, IMoveWay myMoveWay, IDefendWay myDefendWay ) {
		this(name, level, exp);
		setAttackWay(myAttackWay);
		setMoveWay(myMoveWay);
		setDefendWay(myDefendWay);
	}
	
	// 設定行為的 setMethods
	public void setAttackWay(IAttackWay myAttackWay) {
		this.myAttackWay = myAttackWay;
	}
	public void setMoveWay(IMoveWay myMoveWay) {
		this.myMoveWay = myMoveWay;
	}
	public void setDefendWay(IDefendWay myDefendWay) {
		this.myDefendWay = myDefendWay;
	}
	
	// 視同 getMethods
	// 叫用 myAttackWay 物件中的 attack()
//	public abstract void attack();
	public void attack() {
		myAttackWay.attack();
	}
//	public abstract void move();
	// 叫用 myMoveWay 物件中的 move()
	public void move() {
		myMoveWay.move();
	}
	
//	public abstract void defend();
	// 叫用 myDefendWay 物件中的 defend()
	public void defend() {
		myDefendWay.defend();
	}
	
	// 新增 getName()
	String getName() {
		return name;
	}
}
