package mystrage;

public class warrior extends Hero {
	public warrior() {}
	public warrior(String name, int level, double exp) {
		super(name, level, exp);
	}
	public warrior(String name, int level, double exp,
		IAttackWay myAttackWay, IMoveWay myMoveWay, IDefendWay myDefendWay) {
		super(name, level, exp, myAttackWay, myMoveWay, myDefendWay);
	}
}
