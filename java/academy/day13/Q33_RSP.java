package academy.day13;

import java.util.Random;
import java.util.Scanner;

class Win {
	int count;

	void print() {
		System.out.println("������ �̰���ϴ�.");
	}
}

class Draw {
	int count;

	void print() {
		System.out.println("�����ϴ�.");
	}
}

class Lose {
	int count;

	void print() {
		System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
	}
}

public class Q33_RSP {

	// ��ǻ�� ���� ����
	public static int cpu_random() {
		Random r = new Random();
		int cpu_choice = r.nextInt(3);
		return cpu_choice;
	}

	// usr_input �Է�
	public static String usr_input_input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("����, ����, �� �� �ϳ��� �Է��ϼ��� : ");
		String usr_choice = scan.next();

		return usr_choice;
	}

	// usr_input �Ǻ�
	public static int usr_input_check() {
		int usr_number;
		while (true) {
			String usr_choice = usr_input_input();
			if (usr_choice.equals("����")) {
				usr_number = -1;
				break;
			} else {
				if (!(usr_choice.equals("����") || usr_choice.equals("����") || usr_choice.equals("��"))) {
					System.out.println("�߸��� �Է��Դϴ�.");
				}

				else {
					if (usr_choice.equals("����"))
						usr_number = 0;
					else if (usr_choice.equals("����"))
						usr_number = 1;
					else
						usr_number = 2;
					break;
				}
			}
		}
		return usr_number;
	}

	// ���� ����
	public static void game_start() {
		System.out.println("----------------------------------------");
		System.out.println("��ǻ�Ϳ� �ϴ� ���� ���� �� �����Դϴ�.");
		System.out.println("����, ����, �� �� �ϳ��� �Է��ϼ���.");
		System.out.println("[����]��� �Է��ϸ� ������ �����ϴ�.");
		System.out.println("----------------------------------------");
	}

	// ���������� �Ǻ�
	public static int[] RCP(int usr_sum[]) {

		return usr_sum;
	}

	// ���� ����
	public static void output() {
		// TODO Auto-generated method stub
		Win win = new Win();
		Draw draw = new Draw();
		Lose lose = new Lose();

		win.count = 0;
		draw.count = 0;
		lose.count = 0;

		game_start();

		while (true) {

			int usr_number = usr_input_check();
			if (usr_number == -1) {
				System.out.println("�¸� : " + win.count + " // ��� : " + draw.count + " // �й� : " + lose.count);
				break;
			} else {
				int cpu_choice = cpu_random();
				int usr_sum = usr_number - cpu_choice;

				if (usr_sum == 1 || usr_sum == -2) {
					win.print();
					win.count++;
				} else if (usr_sum == 0) {
					draw.print();
					draw.count++;
				} else {
					lose.print();
					lose.count++;
				}
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		output();
	}

}
