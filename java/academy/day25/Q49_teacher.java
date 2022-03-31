package academy.day25;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
	// �̸�, ��ȭ��ȣ, �ּ� ��� String
	private String name;
	private String tel;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		// �ּҰ� �ƴ϶� ���ڿ��� �ַ��� �Ҷ�
		// Object�� toString�� �������̵� �Ѵ�.
		return name + "�� ��ȣ�� " + tel + "�̰� �ּҴ� " + address + "�Դϴ�.";
	}

}

class ContactArrayList {
	private ArrayList<Contact> arrayList;

	public ContactArrayList() {
		arrayList = new ArrayList<Contact>();
	}

	// �߰�
	public void addContact(Contact contact) {
		arrayList.add(contact);
	}

	// ����
	public void removeContact(String name) {
		for (int i = 0; i < arrayList.size(); i++) {
			Contact contact = arrayList.get(i);
			String tempName = contact.getName();
			if (tempName.equals(name)) {
				arrayList.remove(i);
				return;
			}
		}
		System.out.println(name + "�� ���������ʽ��ϴ�.");
	}

	// ��ü���
	public void showAllContact() {
		for (Contact contact : arrayList) {
			// ��ü�� ����ϸ� ��ȭ��ȣ�ΰ� �� ������ �Ϸ���?
			System.out.println(contact);
		}
		System.out.println();
	}

	// �˻����
	public void showSerchContact(String name) {
		for (int i = 0; i < arrayList.size(); i++) {
			Contact temp = arrayList.get(i);
			if (temp.getName().equals(name)) {
				System.out.println(temp);
				return;
			}
		}
		System.out.println("�˻��ϴ� �̸��� �����ϴ�.");
	}
}

public class Q49_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ContactArrayList ca = new ContactArrayList();

		while (true) {
			System.out.print("1.�߰� 2. ���� 3. �˻� 4. ���� :");
			int sel = sc.nextInt();
			if (sel == 1) // �߰�
			{
				System.out.print("�̸� : ");
				String name = sc.next();
				System.out.print("��ȣ : ");
				String number = sc.next();
				System.out.print("�ּ� : ");
				String address = sc.next();
				Contact c = new Contact();
				c.setName(name);
				c.setTel(number);
				c.setAddress(address);
				ca.addContact(c);
			} else if (sel == 2) // ����
			{
				System.out.print("�̸� : ");
				String name = sc.next();
				ca.removeContact(name);
			} else if (sel == 3) // �˻�
			{
				System.out.print("1. ��ü�˻� 2. �̸��˻�");
				int twoSel = sc.nextInt();
				if (twoSel == 1) {
					ca.showAllContact();
				} else if (twoSel == 2) {
					System.out.print("�̸� : ");
					String name = sc.next();
					ca.showSerchContact(name);
				} else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}
			} else if (sel == 4) {
				System.out.println("��ȭ��ȣ ���α׷��� �����մϴ�.");
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}

	}

}
