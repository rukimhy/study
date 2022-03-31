package academy.day18;

import java.util.Scanner;

class Ballon {
	String color;

	void print() {
		System.out.println("ǳ�� : " + color);
	}
}

class Check {
	int indexCheck(String color, Ballon[] b) {
		int index = -1;
		for (int i = 0; i < b.length; i++) {
			if (b[i].color.equals(color)) {
				index = i;
			}
		}

		return index;
	}
}

class Air {
	Air(Ballon[] b) {
		String[] color = { "����", "�Ķ�", "���", "��Ȳ", "�ʷ�" };
		for (int i = 0; i < b.length; i++) {
			b[i] = new Ballon();
			b[i].color = color[i];
		}
	}
}

class Run {
	Run() {
		Ballon[] b = new Ballon[5];
		Air a = new Air(b);
		Check ch = new Check();

		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		String color = sc.next();

		int index = ch.indexCheck(color, b);

		System.out.println("ǳ�� " + color + " �� �ε��� : " + index);
	}
}

public class TestBallons {
	public static void main(String[] args) {
		new Run();
	}
}
