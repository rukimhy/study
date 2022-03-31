package academy.day2;

public class IfExample2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int age = 9;
		int charge;

		if (age < 8) {
			charge = 1000;
			System.out.println("���� �� �Ƶ��Դϴ�.");
		}
		if (age < 14) {
			charge = 2000;
			System.out.println("�ʵ��л��Դϴ�.");
		}
		if (age < 20) {
			charge = 2500;
			System.out.println("��, �����л��Դϴ�.");
		} else {
			charge = 3000;
			System.out.println("�Ϲ����Դϴ�.");
		}
		System.out.println("������" + charge + "���Դϴ�.");

	}
}