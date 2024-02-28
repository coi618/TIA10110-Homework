package mystrage;

public class villager extends Hero {
	public villager() {}
	public villager(String name, int level, double exp) {
		super(name, level, exp);
	}
	public villager(String name, int level, double exp,
		IAttackWay myAttackWay, IMoveWay myMoveWay, IDefendWay myDefendWay) {
		super(name, level, exp, myAttackWay, myMoveWay, myDefendWay);
	}
}
