package academy.day11;

import java.util.Random;
import java.util.Scanner;

public class Q26_RCPfunc {

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
		if (usr_sum[0] == 1 || usr_sum[0] == -2) {
			System.out.println("������ �̰���ϴ�.");
			usr_sum[1]++;
		} else if (usr_sum[0] == 0) {
			System.out.println("�����ϴ�.");
			usr_sum[2]++;
		} else {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			usr_sum[3]++;
		}
		return usr_sum;
	}

	// ���� ����
	public static void output() {
		// TODO Auto-generated method stub
		// ���������� ���� �Լ�ȭ�ϴµ� �ִ��� �߰� �ɰ��� �ϰ� ���ι��� �Լ� �ϳ��� ȣ��
		// 0 = ����, 1 = ����, 2 = ��

		int[] sum = new int[4];

		game_start();

		while (true) {

			int usr_number = usr_input_check();
			if (usr_number == -1)
				break;
			else {
				int cpu_choice = cpu_random();
				int usr_sum = usr_number - cpu_choice;
				sum[0] = usr_sum;

				sum = RCP(sum);
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		output();
	}

}
