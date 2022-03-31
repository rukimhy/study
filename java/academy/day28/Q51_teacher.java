package academy.day28;

import java.util.Random;

class Yabai extends Thread {
	// 1. String ���� ����
	// 2. toString �������̵�
	String name;
	private int value;

	public Yabai(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public void run() {
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			this.value += r.nextInt(20) + 1;
		}
	}

	public int getValue() {
		return value;
	}
}

public class Q51_teacher {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Yabai y1 = new Yabai("1�����");
		Yabai y2 = new Yabai("2�����");

		y1.start();
		y2.start();

		y1.join();
		y2.join();

		System.out.println(y1.name + "�� ���� " + y1.getValue() + "�Դϴ�.");
		System.out.println(y2.name + "�� ���� " + y2.getValue() + "�Դϴ�.");

		if (y1.getValue() > y2.getValue()) {
			System.out.println(y1.name + "�� �̰���ϴ�.");
		} else if (y1.getValue() < y2.getValue()) {
			System.out.println(y2.name + "�� �̰���ϴ�.");
		} else {
			System.out.println("���º��Դϴ�.");
		}

	}

}
