package academy.day16;

import java.util.Scanner;

//buyer
class Buyer {
	int money;

	int comindex = 0;
	int airindex = 0;
	int refindex = 0;
	int aircindex = 0;

	Computer[] coms = new Computer[10];
	Aircon[] air = new Aircon[10];
	Ref[] ref = new Ref[10];
	AirCleaner[] airc = new AirCleaner[10];

}

// computer
class Computer {
	String manufacture;
	String cpu;
	int price;

	void use() {
		System.out.println("�����簡" + manufacture + "��" + cpu + "��ǻ�͸� ����մϴ�.");
	}
}

// Aricon
class Aircon {
	String manufacture;
	String kind;
	int price;

	void start() {
		System.out.println("�����簡 " + manufacture + "�� " + kind + "�������� ����Ѵ�");
	}
}

// Ref
class Ref {
	String manufacture;
	String door;
	String L;
	int price;

	void manage() {
		System.out.println("�����簡 " + manufacture + "�� " + door + "�� " + L + "������� ��ǰ�� �����Ѵ�");
	}
}

// AirCleaner
class AirCleaner {
	String manufacture;
	int price;

	void start() {
		System.out.println("�����簡 " + manufacture + "�� " + "�������� ���⸦ �����ϰ� �Ѵ� ");
	}
}

public class Q37_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Computer[] comArr = new Computer[10];
		Aircon[] airconArr = new Aircon[10];
		Ref[] refArr = new Ref[10];
		AirCleaner[] airCleanerArr = new AirCleaner[10];

		for (int i = 0; i < 5; ++i) {
			comArr[i] = new Computer();
			comArr[i].manufacture = "Samsung";
			comArr[i].cpu = "i7";
			comArr[i].price = 200;
			airconArr[i] = new Aircon();
			airconArr[i].kind = "������";
			airconArr[i].manufacture = "Samsung";
			airconArr[i].price = 100;
			refArr[i] = new Ref();
			refArr[i].manufacture = "Samsung";
			refArr[i].door = "�繮";
			refArr[i].L = "600L";
			refArr[i].price = 200;
			airCleanerArr[i] = new AirCleaner();
			airCleanerArr[i].manufacture = "LG";
			airCleanerArr[i].price = 80;
		}
		for (int i = 5; i < 10; ++i) {
			comArr[i] = new Computer();
			comArr[i].manufacture = "LG";
			comArr[i].cpu = "i5";
			comArr[i].price = 150;
			airconArr[i] = new Aircon();
			airconArr[i].kind = "���ĵ�";
			airconArr[i].manufacture = "LG";
			airconArr[i].price = 250;
			refArr[i] = new Ref();
			refArr[i].manufacture = "LG";
			refArr[i].door = "4����";
			refArr[i].L = "800L";
			refArr[i].price = 350;
			airCleanerArr[i] = new AirCleaner();
			airCleanerArr[i].manufacture = "���̽�";
			airCleanerArr[i].price = 60;
		}

		Buyer[] b = new Buyer[3];

		for (int i = 0; i < 3; i++) {
			b[i] = new Buyer();
		}

		Scanner sc = new Scanner(System.in);

		System.out.println("1�� ���̾� ���� �Է��ϼ��� :");
		b[0].money = sc.nextInt();
		System.out.println("2�� ���̾� ���� �Է��ϼ��� :");
		b[1].money = sc.nextInt();
		System.out.println("3�� ���̾� ���� �Է��ϼ��� :");
		b[2].money = sc.nextInt();

		while (true) {
			for (int i = 0; i < 3; i++) {
				if (b[i].money >= 60) {
					// ������ ��� ���� ����
					System.out.print((i + 1) + "���̾� ��ǰ�� ���� ���ּ��� 1. ��ǻ�� 2.������ 3.����� 4.����û���� :");
					int select = sc.nextInt();
					if (select == 1)// ��ǻ��
					{
						System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(i7) 2.LG(i5) : ");
						select = sc.nextInt();
						if (select == 1) {
							// 1. ���� ������
							b[i].money -= 200;
							if (b[i].money < 0) {
								System.out.println("������ �ȳ�!");
								b[i].money += 200;
							} else {
								// 2. 0~4���� �Ｚ
								int j = 0;
								while (comArr[j] == null) {
									j++;
								}
								if (j >= 5) {
									System.out.println("����� �����ϴ�.");
								} else {
									b[i].coms[b[i].comindex++] = comArr[j];
									comArr[j] = null;
								}

							}

						} else if (select == 2) {
							// 1. ���� ������
							// 5~9���� LG
							// 1. ���� ������
							b[i].money -= 150;
							if (b[i].money < 0) {
								System.out.println("������ �ȳ�!");
								b[i].money += 150;
							} else {
								// 2. 0~4���� �Ｚ
								int j = 5;
								while (comArr[j] == null) {
									j++;
								}
								if (j >= 10) {
									System.out.println("����� �����ϴ�.");
								} else {
									// comindex++ => comindex = comindex +1
									b[i].coms[b[i].comindex++] = comArr[j];
									comArr[j] = null;
								}

							}
						} else {
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					} else if (select == 2) // ������
					{
						System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(��������) 2.LG(���ĵ���) : ");
						select = sc.nextInt();
						if (select == 1) {
							// 1. ���� ������
							b[i].money -= 100;
							if (b[i].money < 0) {
								System.out.println("������ �ȳ�!");
								b[i].money += 100;
							} else {
								// 2. 0~4���� �Ｚ
								int j = 0;
								while (airconArr[j] == null) {
									j++;
								}
								if (j >= 5) {
									System.out.println("����� �����ϴ�.");
								} else {
									b[i].air[b[i].airindex++] = airconArr[j];
									airconArr[j] = null;
								}

							}

						} else if (select == 2) {
							// 1. ���� ������
							// 5~9���� LG
							// 1. ���� ������
							b[i].money -= 200;
							if (b[i].money < 0) {
								System.out.println("������ �ȳ�!");
								b[i].money += 200;
							} else {
								// 2. 0~4���� �Ｚ
								int j = 5;
								while (airconArr[j] == null) {
									j++;
								}
								if (j >= 10) {
									System.out.println("����� �����ϴ�.");
								} else {
									// comindex++ => comindex = comindex +1
									b[i].air[b[i].airindex++] = airconArr[j];
									airconArr[j] = null;
								}

							}
						} else {
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					} else if (select == 3) // �����
					{
						System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(�繮,600L) 2.LG(4����, 800L) : ");
						select = sc.nextInt();
						if (select == 1) {
							// 1. ���� ������
							b[i].money -= 200;
							if (b[i].money < 0) {
								System.out.println("������ �ȳ�!");
								b[i].money += 200;
							} else {
								// 2. 0~4���� �Ｚ
								int j = 0;
								while (refArr[j] == null) {
									j++;
								}
								if (j >= 5) {
									System.out.println("����� �����ϴ�.");
								} else {
									b[i].ref[b[i].refindex++] = refArr[j];
									refArr[j] = null;
								}

							}

						} else if (select == 2) {
							// 1. ���� ������
							// 5~9���� LG
							// 1. ���� ������
							b[i].money -= 350;
							if (b[i].money < 0) {
								System.out.println("������ �ȳ�!");
								b[i].money += 350;
							} else {
								// 2. 0~4���� �Ｚ
								int j = 5;
								while (refArr[j] == null) {
									j++;
								}
								if (j >= 10) {
									System.out.println("����� �����ϴ�.");
								} else {
									// comindex++ => comindex = comindex +1
									b[i].ref[b[i].refindex++] = refArr[j];
									refArr[j] = null;
								}

							}
						} else {
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					} else if (select == 4) // ����û����
					{
						System.out.print("������ �� ����� �������ּ��� 1.LG 2.���̽� : ");
						select = sc.nextInt();
						if (select == 1) {
							// 1. ���� ������
							b[i].money -= 80;
							if (b[i].money < 0) {
								System.out.println("������ �ȳ�!");
								b[i].money += 80;
							} else {
								// 2. 0~4���� �Ｚ
								int j = 0;
								while (airCleanerArr[j] == null) {
									j++;
								}
								if (j >= 5) {
									System.out.println("����� �����ϴ�.");
								} else {
									b[i].airc[b[i].aircindex++] = airCleanerArr[j];
									airCleanerArr[j] = null;
								}

							}

						} else if (select == 2) {
							// 1. ���� ������
							// 5~9���� LG
							// 1. ���� ������
							b[i].money -= 60;
							if (b[i].money < 0) {
								System.out.println("������ �ȳ�!");
								b[i].money += 60;
							} else {
								// 2. 0~4���� �Ｚ
								int j = 5;
								while (airCleanerArr[j] == null) {
									j++;
								}
								if (j >= 10) {
									System.out.println("����� �����ϴ�.");
								} else {
									// comindex++ => comindex = comindex +1
									b[i].airc[b[i].aircindex++] = airCleanerArr[j];
									airCleanerArr[j] = null;
								}

							}
						} else {
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					} else {
						System.out.println("�߸��� �Է��Դϴ�.!!!!!!!!!!!!!");
					}
					for (int x = 0; x < 3; x++) {
						System.out.println((x + 1) + "Buyer�� ���� �ݾ��� " + b[x].money + "�Դϴ�.");
					}

				}

			}
			if (b[0].money < 60 && b[1].money < 60 && b[2].money < 60) {
				System.out.println("���� ������ �����մϴ�.");
				break;
			}
		}

		for (int i = 0; i < 3; i++) {
			int k = 0;
			while (b[i].coms[k] != null) {
				System.out.println((i + 1) + "�� ���̾�� ");
				b[i].coms[k].use();
				k++;
			}
			k = 0;
			while (b[i].air[k] != null) {
				System.out.println((i + 1) + "�� ���̾�� ");
				b[i].air[k].start();
				;
				k++;
			}
			k = 0;
			while (b[i].ref[k] != null) {
				System.out.println((i + 1) + "�� ���̾�� ");
				b[i].ref[k].manage();
				k++;
			}
			k = 0;
			while (b[i].airc[k] != null) {
				System.out.println((i + 1) + "�� ���̾�� ");
				b[i].airc[k].start();
				k++;
			}
		}

	}
}
