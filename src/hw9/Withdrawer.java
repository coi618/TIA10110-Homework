package hw9;

//class Withdrawer extends Thread {
class Withdrawer implements Runnable {
	/* Instance Variable */
	Account account;
	int money;
	
	/* Constructor */
	Withdrawer(Account account, int money) {
		this.account = account;
		this.money = money;
	}
	
	/* Methods */
	/* 帳戶餘額在 2000元 以下,熊大就會要求媽媽匯款給他。 
	 * 如果帳戶餘額低於熊大要提款的金額,熊大就會暫停提款 */
	@Override
	public void run() { /* wait() 不能寫在 withdrawer 的 run() -> IllegalMonitorStateException */
		synchronized (account) {
			for (int i = 0; i < 10; i++)
				account.withdraw(money);
			System.out.println("熊大已經不需要媽媽的匯款了。");
		}	
	}
}
