package hw9;

import java.io.PrintWriter;

public class SimpleHw9 {

	public static void main(String[] args) {
		/* 快胃王比賽 */
		System.out.println("快胃王比賽");
		mottohayaku();
		/* 生活費 */
		System.out.println("生活費");
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
		// TODO Auto-generated method stub
		PrintWriter out = new PrintWriter(System.out, true);
		Account account = new Account(out);	/* 熊大的帳戶 */
		Withdrawer brown = new Withdrawer(account, 1000, "Brown");
		Depositor mamaBrown = new Depositor(account, 2000, "MamaBrown");
		brown.start();
		mamaBrown.start();
		while(brown.isAlive()) {} /* 如果熊大還需要錢，就用無限迴圈卡往 */
		mamaBrown.interrupt(); /* 如果熊大不需要錢了，中止媽媽匯錢的行為 */
		while(mamaBrown.isAlive()) {} /* 在熊大媽媽結束前，用無限迴圈卡往 main */
		System.out.println("結束要生活費");		
	}
}

class Depositor extends Thread {
	/* Instance Variable */
	Account account;
	int money;
	String name;
	
	/* Constructor */
	Depositor(Account account, int money, String name) {
		this.account = account;
		this.money = money;
		this.name = name;
	}
	
	/* Methods */
	/* 只要看到熊大帳戶的餘額超過 3000元,就會停止匯款給熊大
	 * 媽媽告知他錢已經入帳戶 */
	public void run() { /* wait() 不能寫在 withdrawer 的 run() -> IllegalMonitorStateException */
		synchronized (account) {
			try {
				for (int i = 0; i < 10; i++)
					account.deposit(money, name);
				System.out.println(name + "完成 10 次匯款。");
			} catch (InterruptedException ie) {
				System.out.println(name + " 停止匯款。");
			}
		}
	}
}

class Withdrawer extends Thread {
	/* Instance Variable */
	Account account;
	int money;
	String name;
	
	/* Constructor */
	Withdrawer(Account account, int money, String name) {
		this.account = account;
		this.money = money;
		this.name = name;
	}
	
	/* Methods */
	/* 帳戶餘額在 2000元 以下,熊大就會要求媽媽匯款給他。 
	 * 如果帳戶餘額低於熊大要提款的金額,熊大就會暫停提款 */
	@Override
	public void run() { /* wait() 不能寫在 withdrawer 的 run() -> IllegalMonitorStateException */
		synchronized (account) {
			for (int i = 0; i < 10; i++)
				account.withdraw(money, name);
			System.out.println(name + " 已經不需要媽媽的匯款了。");
		}	
	}
}

class Account {
	/* Instance variable */
	PrintWriter out; /* 為了排版 */
	private static int balance; /* 熊大的帳戶 */
	
	/* Constructor */
	Account(PrintWriter out) { /* ? */
		this.out = out;
	}
	
	/* Methods */
	/* 設定帳戶金額 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	/* 取得帳戶餘額 */
	public int getBalance() {
		return balance;
	}
	/* 存款 */
	public void deposit(int amount, String name) throws InterruptedException {
		if (getBalance() > 3000) {
			System.out.println(name + " 看到餘額在 3000 以上，暫停匯款。");
			wait();
		}
		setBalance(getBalance()+amount);
		System.out.println(name + " 存了 " + amount + "，帳戶共有 " + getBalance());
		System.out.println("Brown 被 " + name +" 告知帳戶已經有錢!");
		notify();
		
	}
	/* 提款 */
	public void withdraw(int amount, String name) {		
		if (getBalance() < 2000) {
			System.out.println("MamaBrown 被 Brown 要求匯款。");
			notify();
		}
		if (getBalance() < amount) {
			System.out.println(name + " 看到帳戶沒錢，暫停提款。");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setBalance(getBalance() - amount);
		System.out.println(name + " 領了 " + amount + "，帳戶共有 " + getBalance());
	}
}