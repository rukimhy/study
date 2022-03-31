package academy.day27;

class DoubleThreadTest1 extends Thread {
	public DoubleThreadTest1(String str) {
		setName(str);
	}

	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println(i + getName());
		}
		System.out.println("��" + getName());
	}
}

public class DoubleThread1 {

	public static void main(String[] args) throws InterruptedException {
		DoubleThreadTest1 t1 = new DoubleThreadTest1(" : ���� ���� �ڹ�");
		DoubleThreadTest1 t2 = new DoubleThreadTest1(" : ���� ����� �ڹ�");
		System.out.println("***** ������ ���� �� ******");
		t1.start();
		t2.start();
		t1.join();
		// t2.join();
		System.out.println("***** ������ ���� �� ******");
	}

}
