package mystrage;

public class wizard extends Hero {

	public wizard() {}
	public wizard(String name, int level, double exp) {
		super(name, level, exp);
	}
	public wizard(String name, int level, double exp,
		IAttackWay myAttackWay, IMoveWay myMoveWay, IDefendWay myDefendWay) {
		super(name, level, exp, myAttackWay, myMoveWay, myDefendWay);
	}
}
