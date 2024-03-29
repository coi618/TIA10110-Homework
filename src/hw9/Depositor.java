package hw9;

//class Depositor extends Thread {
class Depositor implements Runnable {
	/* Instance Variable */
	Account account;
	int money;
	
	/* Constructor */
	Depositor(Account account, int money) {
		this.account = account;
		this.money = money;
	}
	
	/* Methods */
	/* 只要看到熊大帳戶的餘額超過 3000元,就會停止匯款給熊大
	 * 媽媽告知他錢已經入帳戶 */
	public void run() { /* wait() 不能寫在 withdrawer 的 run() -> IllegalMonitorStateException */
		synchronized (account) {
			try {
				for (int i = 0; i < 10; i++)
					account.deposit(money);
				System.out.println("媽媽完成 10 次匯款。");
			} catch (InterruptedException ie) {
				System.out.println("媽媽停止匯款。");
			}
		}
	}
}
