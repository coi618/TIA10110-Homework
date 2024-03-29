package hw9;

import java.io.PrintWriter;

public class SimpleHw9 {

	public static void main(String[] args) {
		/* 快胃王比賽 */
		System.out.println("快胃王比賽");
		mottohayaku();
		/* 生活費 */
		System.out.println("\n生活費");
		showMeMoney();
	}
	/* 快胃王比賽 */
	private static void mottohayaku() {
		EatThread james = new EatThread("詹姆士");
		EatThread moon = new EatThread("饅頭人");
		
		/* Get Ready */
		james.t.start();
		moon.t.start();
		EatThread.callReady();
		System.out.println("-----大胃王快食比賽開始!-----");
		james.myJoin();
		moon.myJoin();
		System.out.println("-----大胃王快食比賽結束!-----");
	}

	/* 生活費 */
	/*
	 * 熊大在念大學,生活費倚靠媽媽。
	 * 媽媽怕熊大一天到晚領錢亂花,不好好唸書,
	 * 所以只要看到熊大帳戶的餘額超過 3000元,就會停止匯款給熊大;
	 * 但要是帳戶餘額在 2000元 以下,熊大就會要求媽媽匯款給他。
	 * 如果帳戶餘額低於熊大要提款的金額,熊大就會暫停提款,
	 * 直到媽媽告知他錢已經入帳戶。
	 * 假設媽媽一次匯款 2000 元,熊大一次提款 1000元,
	 * 寫一個Java程式模擬匯款10次與提款10次的情形。
	 * */
	private static void showMeMoney() {
		Account account = new Account();	/* 熊大的帳戶 */
		Withdrawer brown = new Withdrawer(account, 1000);
		Depositor mamaBrown = new Depositor(account, 2000);
		Thread t1 = new Thread(brown, "熊大");
		Thread t2 = new Thread(mamaBrown, "媽媽");
		t1.start();
		t2.start();
		while(t1.isAlive()) {} /* 如果熊大還需要錢，就用無限迴圈卡往 */
		t2.interrupt(); /* 如果熊大不需要錢了，中止媽媽匯錢的行為 */
		while(t2.isAlive()) {} /* 在熊大媽媽結束前，用無限迴圈卡往 main */
		System.out.println("結束要生活費");		
	}
}


