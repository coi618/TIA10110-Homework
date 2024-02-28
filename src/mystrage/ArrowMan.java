package mystrage;

public class ArrowMan extends Hero {
	
	public ArrowMan() {
		super();
	}

	public ArrowMan(String name, int level, double exp) {
		super(name, level, exp);
	}

	// 自訂建構子，加上行為屬性
	public ArrowMan(String name, int level, double exp,
			IAttackWay myAttackWay, IMoveWay myMoveWay, IDefendWay myDefendWay) {
		super(name, level, exp, myAttackWay, myMoveWay, myDefendWay);
	}
	// 在父類別中建立出實作行為(getMethods)方法，子類別繼承即可
	
//	@Override
//	public void attack() {
//		System.out.println("放弓箭");
//	}

//	@Override
//	public void move() {
//		System.out.println("跑步");
//	}

//	@Override
//	public void defend() {
//		System.out.println("做防禦動作");
//	}
}
