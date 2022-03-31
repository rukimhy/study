package academy.day3;

import java.util.Random;
import java.util.Scanner;

public class Rock_paper_scissors {

	public static void main(String[] args) {
		// ���������� ����. ���ڿ��� �Է� �޾� "����" "����" "��". ��ǻ�ʹ� �������� ����
		// ���� ��. "������ �̰���ϴ�." "�����ϴ�." "��ǻ�Ͱ� �̰���ϴ�."
		// �̿��� �Է��� "�߸��� �Է��Դϴ�." ��� �� �ٷ� ����
		// 0 = ����, 1 = ����, 2 = ��

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �����մϴ�.");
		System.out.print("����, ����, �� �� �ϳ��� �Է��Ͻÿ� : ");
		String str = scan.next();
		int i = -1;
		int cpu_choice = rand.nextInt(3);

		if (str.equals("����")) {
			i = 0;
			if (cpu_choice == 0) {
				System.out.println("�����ϴ�.");
			} else if (cpu_choice == 1) {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			} else {
				System.out.println("������ �̰���ϴ�.");
			}
		} else if (str.equals("����")) {
			i = 1;
			if (cpu_choice == 0) {
				System.out.println("������ �̰���ϴ�.");
			} else if (cpu_choice == 1) {
				System.out.println("�����ϴ�.");
			} else {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			}
		} else if (str.equals("��")) {
			i = 2;
			if (cpu_choice == 0) {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			} else if (cpu_choice == 1) {
				System.out.println("������ �̰���ϴ�.");
			} else {
				System.out.println("�����ϴ�.");
			}
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}

}
