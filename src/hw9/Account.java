package hw9;

class Account {
	/* Instance variable */
	private static int balance; /* 熊大的帳戶 */
	
	/* Constructor */
	Account() {} 
	
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
	public void deposit(int amount) throws InterruptedException {
		if (getBalance() > 3000) {
			System.out.println("媽媽看到餘額在 3000 以上，暫停匯款。");
			wait();
		}
		setBalance(getBalance()+amount);
		System.out.println("媽媽存了 " + amount + "，帳戶共有 " + getBalance());
		System.out.println("熊大被媽媽告知帳戶已經有錢!");
		notify();
		
	}
	/* 提款 */
	public void withdraw(int amount) {		
		if (getBalance() < 2000) {
			System.out.println("媽媽被熊大要求匯款。");
			notify();
		}
		if (getBalance() < amount) {
			System.out.println("熊大看到帳戶沒錢，暫停提款。");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setBalance(getBalance() - amount);
		System.out.println("熊大領了 " + amount + "，帳戶共有 " + getBalance());
	}
}
