package day27;

class RunnableTest implements Runnable{
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println("��մ� �ڹ� : "+i);
		}
	}
}

public class ThreadFormRunnable {

	public static void main(String[] args) {
		RunnableTest r = new RunnableTest();
		Thread t = new Thread(r);
		t.start();
	}

}
