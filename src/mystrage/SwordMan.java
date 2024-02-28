package mystrage;

public class SwordMan extends Hero {
	
	public SwordMan() {
		super();
	}
	
	public SwordMan(String name, int level, double exp) {
		super(name, level, exp);
	}
	
	// 自訂建構子，加上行為屬性
	public SwordMan(String name, int level, double exp,
			IAttackWay myAttackWay, IMoveWay myMoveWay, IDefendWay myDefendWay) {
		super(name, level, exp, myAttackWay, myMoveWay, myDefendWay);
	}
	
	// 在父類別中建立出實作行為(getMethods)方法，子類別繼承即可
	
//	@Override
//	public void attack() {
//		System.out.println("揮劍");
//	}
//	
//	@Override
//	public void move() {
//		System.out.println("跑步");
//	}
//	
//	@Override
//	public void defend() {
//		System.out.println("做防禦動作");
//	}
	
}
