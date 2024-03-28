package hw9;

/* class for 9-1 */
public class EatThread implements Runnable {
	/* Instance variable */
	Thread t; /* to run obj */
	private static boolean ready = false;
	
	/* Constructor */
	public EatThread() {}
	public EatThread(String name) {
		this();
		t = new Thread(this, name);
	}
	
	/* Method */
	@Override
	public void run() {	
		while (!ready) {} /* Not start if not ready */
		for (int i = 1; i <= 10; i++) {
			sleep((int)(Math.random()*2500) + 500);			
			System.out.printf("%s吃第%d碗飯%n", this.t.getName(), i);
		}
		System.out.println(this.t.getName() + "吃完了!");
	}

	/* 單純設定開始比賽 */
	public static void callReady() {
		ready = true;
	}
	
	public void myJoin() {
	/* 只是不想在程式中看到 try-catch */
		try {
			this.t.join();
		} catch (InterruptedException e) {
			System.out.println("Error occur when join: " + this.t.getName());
			e.printStackTrace();
		}
	}
	
	private void sleep(int i) {
		/* 只是不想在程式中看到 try-catch */
		try {
		Thread.sleep(i);
		} catch (InterruptedException ie) {
			System.out.println("Error occur when sleep: " + this.t.getName());
			ie.printStackTrace();
		}
	}
}
