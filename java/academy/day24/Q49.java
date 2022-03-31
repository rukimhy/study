package academy.day24;

import java.util.ArrayList;
/* �̸�, ��ȭ��ȣ, �ּ� ����
 * 1.�߰� - �̸�, ��ȭ��ȣ, �ּҸ� �Է¹޴´�.
 * 2.���� - �̸��� �Է¹޾� �����Ѵ�.
 * 3.�˻� - (1)��ü �˻� (2)�̸� �˻�
 * �̸� �˻��� �̸��� �Է¹޾� �̸��� �ִ� ��� ������ ����ϰ� ������ "���� ����Դϴ�." ���
 * 4.����
 */
import java.util.Scanner;

class Human {
	private String humanName;
	private String humanPhoneNumber;
	private String humanAddress;

	Human(String humanName, String humanPhoneNumber, String humanAddress) {
		this.humanName = humanName;
		this.humanPhoneNumber = humanPhoneNumber;
		this.humanAddress = humanAddress;
	}

	public String getHumanName() {
		return humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	public String getHumanPhoneNumber() {
		return humanPhoneNumber;
	}

	public void setHumanPhoneNumber(String humanPhoneNumber) {
		this.humanPhoneNumber = humanPhoneNumber;
	}

	public String getHumanAddress() {
		return humanAddress;
	}

	public void setHumanAddress(String humanAddress) {
		this.humanAddress = humanAddress;
	}

	public String toString() {
		return "�̸�:" + humanName + " ��ȭ��ȣ:" + humanPhoneNumber + " �ּ�:" + humanAddress;
	}
}

class HumanArrayList {
	private ArrayList<Human> arrayList;

	public HumanArrayList() {
		arrayList = new ArrayList<Human>();
	}

	public void addHuman(Human human) {
		arrayList.add(human);
	}

	public boolean removeHuman(String humanName) {
		for (int i = 0; i < arrayList.size(); i++) {
			Human human = arrayList.get(i);
			String tempName = human.getHumanName();
			if (tempName.equals(humanName)) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println("���� �̸��Դϴ�.");
		return false;
	}

	public void showAllHuman() {
		for (Human human : arrayList) {
			System.out.println(human);
		}
		System.out.println();
	}

	public boolean searchHuman(String humanName) {
		for (int i = 0; i < arrayList.size(); i++) {
			Human human = arrayList.get(i);
			String tempName = human.getHumanName();
			if (tempName.equals(humanName)) {
				System.out.println(human.toString());
				return true;
			}
		}
		System.out.println("���� �̸��Դϴ�.");
		return false;
	}
}

public class Q49 {

	public static void main(String[] args) {
		HumanArrayList hal = new HumanArrayList();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("1.�߰� 2.���� 3.�˻� 4.���� : ");
			String select = scan.nextLine();

			if (select.equals("4")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			} else if (select.equals("1")) {
				System.out.print("�̸� : ");
				String name = scan.nextLine();
				System.out.print("��ȭ��ȣ : ");
				String phone = scan.nextLine();
				System.out.print("�ּ� :");
				String address = scan.nextLine();

				Human human = new Human(name, phone, address);
				hal.addHuman(human);
				System.out.println("�߰��Ǿ����ϴ�.");

			} else if (select.equals("2")) {
				System.out.print("�̸��� �Է����ּ��� : ");
				String name = scan.nextLine();
				System.out.println();
				hal.removeHuman(name);
				System.out.println("�����Ǿ����ϴ�.");
			} else if (select.equals("3")) {
				System.out.print("1.��ü�˻� 2.�̸��˻� : ");
				String select_3 = scan.nextLine();

				if (select_3.equals("1")) {
					hal.showAllHuman();
				} else if (select_3.equals("2")) {
					System.out.print("�̸��� �Է����ּ��� : ");
					String name = scan.nextLine();
					System.out.println();
					hal.searchHuman(name);
				} else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}

			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

}
