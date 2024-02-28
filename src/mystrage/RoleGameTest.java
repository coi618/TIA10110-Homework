package mystrage;

public class RoleGameTest {

	public static void main(String[] args) {
		Hero saber = new SwordMan("亞拉岡", 1, 0);
		Hero archer = new ArrowMan("勒苟拉斯", 1, 0);
		
		// 設定行為
		saber.setAttackWay(new SwordAttack());
		saber.setMoveWay(new Run());
		saber.setDefendWay(new NormalDefend());
		
		archer.setAttackWay(new ArrowAttack());
		archer.setMoveWay(new Run());
		archer.setDefendWay(new NormalDefend());
		
		// 宣告其它角色
		Hero[] ringHeros= new Hero[5];
		ringHeros[0] = saber;
		ringHeros[1] = archer;
		ringHeros[2] = new wizard("甘道夫", 1, 0, new MagicAttack(), new Run(), new NormalDefend());
		ringHeros[3] = new warrior("金靂", 1, 0, new Slash(), new Run(), new NormalDefend());
		ringHeros[4] = new villager("彿羅多", 1, 0, new NoAttack(), new Run(), new NoDefend());
		for (int i = 0; i < ringHeros.length; i++) {
			System.out.printf("名字: %s\t攻擊: ", ringHeros[i].getName());
			ringHeros[i].attack();
			System.out.print("\t防禦: ");
			ringHeros[i].defend();
			System.out.print("\t移動: ");
			ringHeros[i].move();
			System.out.println();
		}
//		saber.attack();
//		saber.move();
//		
//		archer.attack();
//		archer.move();
	}

}
