package academy.day15;

import java.util.Scanner;

class Computer {
	String maker;
	String type;
	int price;

	void output() {
		System.out.println("�����簡 " + maker + "�̰�, " + type + " CPU ��ǻ�͸� ����Ѵ�.");
	}
}

class AirConditioner {
	String maker;
	String type;
	int price;

	void output() {
		System.out.println("�����簡 " + maker + "�̰�, " + type + " �������� ����Ѵ�.");
	}
}

class Refrigerator {
	String maker;
	String type;
	int liter;
	int price;

	void output() {
		System.out.println("�����簡 " + maker + "�̰�, " + type + ", " + liter + "L ������� ��ǰ�� �����Ѵ�.");
	}
}

class AirCleaner {
	String maker;
	int price;

	void output() {
		System.out.println("�����簡 " + maker + "�� ����û���Ⱑ ���⸦ �����ϰ� �Ѵ�.");
	}
}

class Buyer {
	int money;
	Computer[] computer = new Computer[10];
	AirConditioner[] air_conditioner = new AirConditioner[10];
	Refrigerator[] refrigerator = new Refrigerator[10];
	AirCleaner[] air_cleaner = new AirCleaner[10];
}

public class Q37_computer {

	public static void main(String[] args) {
		/*
		 * ��ǻ�� - ������, CPU, ����, ���("�����簡 XXX�̰�, XXX CPU ��ǻ�͸� ����Ѵ�.")
		 * ������ - ������, ����, ����, ���("�����簡 XXX�̰�, XX�� �������� ����Ѵ�.")
		 * ����� - ������, ��, ����, ����,
		 * ���("�����簡 XXX�̰�, XX��, ��L ������� ��ǰ�� �����Ѵ�.")
		 * ����û���� - ������, ����, ���("�����簡 XXX�� ����û���Ⱑ ���⸦ �����ϰ� �Ѵ�.")
		 * 
		 * ����
		 * ��ǻ�� 10���� �ִ�. 5���� �Ｚ, i7, 200�� / 5���� LG, i5, 150��
		 * ������ 10�밡 �ִ�. 5���� ������, �Ｚ, 100�� / 5���� ���ĵ�, LG, 250��
		 * ����� 10�밡 �ִ�. 5���� �Ｚ, �繮, 600L, 200�� / 5���� LG, 4����, 800L, 350��
		 * ����û���� 10�밡 �ִ�. 5���� LG, 80�� / 5���� ���̽�, 60��
		 * 
		 * ���̾� - ��, 10�� ��� ��ǻ��, ������, �����, ����û���� �迭
		 * ���̾�� �� 3���� �ִ�. ���̾�� ���� ���� �Է¹޾Ƽ� ���� ������ �ְ� ������ ���۵ȴ�.
		 * 3���� ���̾�� 1������ ���������� ������ ���. ������ ���̾ ���� 60 �̸��̸� ��ǰ��
		 * ������ �� ���� ������ �� ���� ���̾�� �Ѿ��.
		 * ������ ����(ùȭ��) -> XXX ���̾� 1.��ǻ�� 2.������ 3.����� 4.����û���� : (����
		 * �Է�)
		 * ���� �Է��ϸ� 1.��ǻ�� -> ������ �� ����� �������ּ��� 1.�Ｚ(i7) 2.LG(i5) : (����
		 * �Է�)
		 * 2.������ -> ������ �� ����� �������ּ��� 1.�Ｚ(��������) 2.LG(���ĵ���) : (����
		 * �Է�)
		 * 3.����� -> ������ �� ����� �������ּ��� 1.�Ｚ(�繮, 600L) 2.LG(4����, 800L) :
		 * (���� �Է�)
		 * 4.����û���� -> ������ �� ����� �������ּ��� 1.LG 2.���̽� : (���� �Է�)
		 * ���̾ ���� �ְ� ��ǰ�� ������ ���̾ ����ִ� �迭�� ����ָ� �ȴ�.
		 * ���� ���� �����ϸ� "���� �����մϴ�." ����ϰ� ���� ���̾��� ùȭ������ �̵��Ѵ�.
		 * ���� ���忡 ��ǰ�� ���ٸ� "����� �����ϴ�." ����ϰ� ���� ���̾��� ùȭ������ �̵��Ѵ�.
		 * ���� ���̾ 3000���� �ִµ� ��ǻ�� �Ｚ���� ������ ���̾��� ���� 2800���� ���� �Ǿ��
		 * �Ѵ�.
		 * �̷��� 3���� ���̾��� ���� ��� 60�� �̸��� �Ǹ� ���α׷��� �����Ѵ�.
		 * ���α׷��� ����� ���� 1~3�� ���̾ �� ��ǰ�� ����� ����Ѵ�.
		 */
		Scanner scan = new Scanner(System.in);

		Computer[] samsung_computer = new Computer[5];
		AirConditioner[] samsung_air_conditioner = new AirConditioner[5];
		Refrigerator[] samsung_refrigerator = new Refrigerator[5];
		AirCleaner[] lg_air_cleaner = new AirCleaner[5];
		Computer[] lg_computer = new Computer[5];
		AirConditioner[] lg_air_conditioner = new AirConditioner[5];
		Refrigerator[] lg_refrigerator = new Refrigerator[5];
		AirCleaner[] daison_air_cleaner = new AirCleaner[5];

		for (int i = 0; i < 5; i++) {
			samsung_computer[i] = new Computer();
			samsung_air_conditioner[i] = new AirConditioner();
			samsung_refrigerator[i] = new Refrigerator();
			lg_air_cleaner[i] = new AirCleaner();
			samsung_computer[i].maker = "�Ｚ";
			samsung_air_conditioner[i].maker = "�Ｚ";
			samsung_refrigerator[i].maker = "�Ｚ";
			lg_air_cleaner[i].maker = "LG";
			samsung_computer[i].price = 200;
			samsung_air_conditioner[i].price = 100;
			samsung_refrigerator[i].price = 200;
			lg_air_cleaner[i].price = 80;
			samsung_computer[i].type = "i7";
			samsung_air_conditioner[i].type = "��������";
			samsung_refrigerator[i].type = "�繮��";
			samsung_refrigerator[i].liter = 600;
		}
		for (int i = 0; i < 5; i++) {
			lg_computer[i] = new Computer();
			lg_air_conditioner[i] = new AirConditioner();
			lg_refrigerator[i] = new Refrigerator();
			daison_air_cleaner[i] = new AirCleaner();
			lg_computer[i].maker = "LG";
			lg_air_conditioner[i].maker = "LG";
			lg_refrigerator[i].maker = "LG";
			daison_air_cleaner[i].maker = "���̽�";
			lg_computer[i].price = 150;
			lg_air_conditioner[i].price = 250;
			lg_refrigerator[i].price = 350;
			daison_air_cleaner[i].price = 60;
			lg_computer[i].type = "i5";
			lg_air_conditioner[i].type = "���ĵ���";
			lg_refrigerator[i].type = "4������";
			lg_refrigerator[i].liter = 800;
		}

		// ���̾� ��ü ����
		Buyer[] buyer = new Buyer[3];
		for (int i = 0; i < 3; i++) {
			buyer[i] = new Buyer();
			System.out.print((i + 1) + "�� buyer�� ���� �ݾ��� �Է��ϼ��� : ");
			buyer[i].money = scan.nextInt();
		}

		// �ʱ�ȭ
		int buyer_number = 0;

		int samsung_computer_count = 0;
		int samsung_aircon_count = 0;
		int samsung_refrigerator_count = 0;
		int lg_aircleaner_count = 0;

		int lg_computer_count = 0;
		int lg_aircon_count = 0;
		int lg_refrigerator_count = 0;
		int daison_aircleaner_count = 0;

		// ���ӽ��� ���ѹݺ�
		while (true) {
			if (buyer[buyer_number].money < 60) {
				buyer_number++;
				continue;
			} else {
				// ���̾���� ���� �ݾ� ���
				System.out.println("-------------------");
				for (int i = 0; i < 3; i++) {
					System.out.println((i + 1) + "�� buyer�� ���� �ݾ� : " + buyer[i].money);
				}
				System.out.println("-------------------");
			}

			// ���� ùȭ��
			System.out.print(buyer_number + 1 + "�� buyer > 1.��ǻ�� 2.������ 3.����� 4.����û���� : ");
			int main_choice = scan.nextInt();

			// ��ǻ�� ����
			if (main_choice == 1) {
				System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(i7) 2.LG(i5) : ");
				int computer_choice = scan.nextInt();

				// �Ｚ ��ǻ�� ����
				if (computer_choice == 1) {
					if (samsung_computer_count == 5) {
						System.out.println("����� �����ϴ�.");
					} else {
						if (buyer[buyer_number].money - samsung_computer[samsung_computer_count].price >= 0) {
							buyer[buyer_number].money -= samsung_computer[samsung_computer_count].price;
							buyer[buyer_number].computer[samsung_computer_count] = new Computer();
							buyer[buyer_number].computer[samsung_computer_count] = samsung_computer[samsung_computer_count];
							samsung_computer[samsung_computer_count] = null;
							samsung_computer_count++;
							buyer_number++;
						} else {
							System.out.println("���� �����մϴ�.");
							buyer_number++;
						}
					}
				}
				// LG ��ǻ�� ����
				else if (computer_choice == 2) {
					if (lg_computer_count == 5) {
						System.out.println("����� �����ϴ�.");
					} else {
						if (buyer[buyer_number].money - lg_computer[lg_computer_count].price >= 0) {
							buyer[buyer_number].money -= lg_computer[lg_computer_count].price;
							buyer[buyer_number].computer[lg_computer_count + 5] = new Computer();
							buyer[buyer_number].computer[lg_computer_count + 5] = lg_computer[lg_computer_count];
							lg_computer[lg_computer_count] = null;
							lg_computer_count++;
							buyer_number++;
						} else {
							System.out.println("���� �����մϴ�.");
							buyer_number++;
						}
					}
				} else {
					System.out.println("�߸��� �Է��Դϴ�.");
					buyer_number++;
				}
			}
			// ������ ����
			else if (main_choice == 2) {
				System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(��������) 2.LG(���ĵ���) : ");
				int aircon_choice = scan.nextInt();

				// �Ｚ ������ ����
				if (aircon_choice == 1) {
					if (samsung_aircon_count == 5) {
						System.out.println("����� �����ϴ�.");
					} else {
						if (buyer[buyer_number].money - samsung_air_conditioner[samsung_aircon_count].price >= 0) {
							buyer[buyer_number].money -= samsung_air_conditioner[samsung_aircon_count].price;
							buyer[buyer_number].air_conditioner[samsung_aircon_count] = new AirConditioner();
							buyer[buyer_number].air_conditioner[samsung_aircon_count] = samsung_air_conditioner[samsung_aircon_count];
							samsung_air_conditioner[samsung_aircon_count] = null;
							samsung_aircon_count++;
							buyer_number++;
						} else {
							System.out.println("���� �����մϴ�.");
							buyer_number++;
						}
					}
				}
				// LG ������ ����
				else if (aircon_choice == 2) {
					if (lg_aircon_count == 5) {
						System.out.println("����� �����ϴ�.");
					} else {
						if (buyer[buyer_number].money - lg_air_conditioner[lg_aircon_count].price >= 0) {
							buyer[buyer_number].money -= lg_air_conditioner[lg_aircon_count].price;
							buyer[buyer_number].air_conditioner[lg_aircon_count + 5] = new AirConditioner();
							buyer[buyer_number].air_conditioner[lg_aircon_count
									+ 5] = lg_air_conditioner[lg_aircon_count];
							lg_air_conditioner[lg_aircon_count] = null;
							lg_aircon_count++;
							buyer_number++;
						} else {
							System.out.println("���� �����մϴ�.");
							buyer_number++;
						}
					}
				} else {
					System.out.println("�߸��� �Է��Դϴ�.");
					buyer_number++;
				}

			}
			// ����� ����
			else if (main_choice == 3) {
				System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(�繮, 600L) 2.LG(4����, 800L) : ");
				int refrigerator_choice = scan.nextInt();

				// �Ｚ ����� ����
				if (refrigerator_choice == 1) {
					if (samsung_refrigerator_count == 5) {
						System.out.println("����� �����ϴ�.");
					} else {
						if (buyer[buyer_number].money - samsung_refrigerator[samsung_refrigerator_count].price >= 0) {
							buyer[buyer_number].money -= samsung_refrigerator[samsung_refrigerator_count].price;
							buyer[buyer_number].refrigerator[samsung_refrigerator_count] = new Refrigerator();
							buyer[buyer_number].refrigerator[samsung_refrigerator_count] = samsung_refrigerator[samsung_refrigerator_count];
							samsung_refrigerator[samsung_refrigerator_count] = null;
							samsung_refrigerator_count++;
							buyer_number++;
						} else {
							System.out.println("���� �����մϴ�.");
							buyer_number++;
						}
					}
				}

				// LG ����� ����
				else if (refrigerator_choice == 2) {
					if (lg_refrigerator_count == 5) {
						System.out.println("����� �����ϴ�.");
					} else {
						if (buyer[buyer_number].money - lg_refrigerator[lg_refrigerator_count].price >= 0) {
							buyer[buyer_number].money -= lg_refrigerator[lg_refrigerator_count].price;
							buyer[buyer_number].refrigerator[lg_refrigerator_count + 5] = new Refrigerator();
							buyer[buyer_number].refrigerator[lg_refrigerator_count
									+ 5] = lg_refrigerator[lg_refrigerator_count];
							lg_refrigerator[lg_refrigerator_count] = null;
							lg_refrigerator_count++;
							buyer_number++;
						} else {
							System.out.println("���� �����մϴ�.");
							buyer_number++;
						}
					}
				} else {
					System.out.println("�߸��� �Է��Դϴ�.");
					buyer_number++;
				}
			}
			// ����û���� ����
			else if (main_choice == 4) {
				System.out.print("������ �� ����� �������ּ��� 1.LG 2.���̽� : ");
				int aircleaner_choice = scan.nextInt();

				// LG ����û���� ����

				if (aircleaner_choice == 1) {
					if (lg_aircleaner_count == 5) {
						System.out.println("����� �����ϴ�.");
					} else {
						if (buyer[buyer_number].money - lg_air_cleaner[lg_aircleaner_count].price >= 0) {
							buyer[buyer_number].money -= lg_air_cleaner[lg_aircleaner_count].price;
							buyer[buyer_number].air_cleaner[lg_aircleaner_count] = new AirCleaner();
							buyer[buyer_number].air_cleaner[lg_aircleaner_count] = lg_air_cleaner[lg_aircleaner_count];
							lg_air_cleaner[lg_aircleaner_count] = null;
							lg_aircleaner_count++;
							buyer_number++;
						} else {
							System.out.println("���� �����մϴ�.");
							buyer_number++;
						}
					}
				}

				// ���̽� ����û���� ����
				else if (aircleaner_choice == 2) {
					if (daison_aircleaner_count == 5) {
						System.out.println("����� �����ϴ�.");
					} else {
						if (buyer[buyer_number].money - daison_air_cleaner[daison_aircleaner_count].price >= 0) {
							buyer[buyer_number].money -= daison_air_cleaner[daison_aircleaner_count].price;
							buyer[buyer_number].air_cleaner[daison_aircleaner_count + 5] = new AirCleaner();
							buyer[buyer_number].air_cleaner[daison_aircleaner_count
									+ 5] = daison_air_cleaner[daison_aircleaner_count];
							daison_air_cleaner[daison_aircleaner_count] = null;
							daison_aircleaner_count++;
							buyer_number++;
						} else {
							System.out.println("���� �����մϴ�.");
							buyer_number++;
						}
					}
				} else {
					System.out.println("�߸��� �Է��Դϴ�.");
					buyer_number++;
				}
			}
			// �߸��� �Է�
			else {
				System.out.println("�߸��� �Է��Դϴ�.");
				buyer_number++;
			}

			// �ʱ�ȭ
			if (buyer_number == 3)
				buyer_number = 0;

			// ������
			if (buyer[0].money < 60 && buyer[1].money < 60 && buyer[2].money < 60) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 10; j++) {
						if (buyer[i].computer[j] != null) {
							System.out.print((i + 1) + "�� buyer�� ");
							buyer[i].computer[j].output();
						}
						if (buyer[i].air_conditioner[j] != null) {
							System.out.print((i + 1) + "�� buyer�� ");
							buyer[i].air_conditioner[j].output();
						}
						if (buyer[i].refrigerator[j] != null) {
							System.out.print((i + 1) + "�� buyer�� ");
							buyer[i].refrigerator[j].output();
						}
						if (buyer[i].air_cleaner[j] != null) {
							System.out.print((i + 1) + "�� buyer�� ");
							buyer[i].air_cleaner[j].output();
						}
					}
				}
				break;
			}
		}

	}
}
