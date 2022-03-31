package academy.day14;

class Dog {
	String type;
	String kg;
	String color;

	void output() {
		System.out.println("������ ������ " + type + "�̰�, ũ��� " + kg + "�̸�, ������ " + color + "�̰� ¢�´�.");
	}
}

class Cat {
	String type;
	String kg;
	String color;

	void output() {
		System.out.println("������ ������ " + type + "�̰�, ũ��� " + kg + "�̸�, ������ " + color + "�̰� ������.");
	}
}

class Hamster {
	String type;
	String kg;
	String color;

	void output() {
		System.out.println("�ܽ��� ������ " + type + "�̰�, ũ��� " + kg + "�̸�, ������ " + color + "�̰� ������.");
	}
}

public class Q34_dog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * �� 3����, ������ 2����, �ܽ��� 1����
		 * �� : ��ī ���ĴϿ�(9~16kg, ����), ���޶�Ͼ�(1.3~3.2kg, �Ͼ�), �̴���(4~5kg, ����)
		 * "������ ������ XXX�̰�, ũ��� XXX�̸�, ������ XXX�̰� ¢�´�."
		 * ������ : ��ġŲ(3~5kg, ����), ����ũ��(4~5kg, �Ͼ�)
		 * "������ ������ XXX�̰�, ũ��� XXX�̸�, ������ XXX�̰� ������."
		 * �ܽ��� : ���۸���(40~60kg, ȸ��)
		 * "�ܽ��� ������ XXX�̰�, ũ��� XXX�̸�, ������ XXX�̰� ������."
		 * Ŭ���� �迭�� ������
		 */
		Dog[] dog = new Dog[3];
		Cat[] cat = new Cat[2];
		Hamster hamster = new Hamster();

		for (int i = 0; i < 3; i++) {
			dog[i] = new Dog();
		}
		for (int i = 0; i < 2; i++) {
			cat[i] = new Cat();
		}

		dog[0].type = "��ī ���ĴϿ�";
		dog[0].kg = "9~16kg";
		dog[0].color = "������";

		dog[1].type = "���޶�Ͼ�";
		dog[1].kg = "1.3~3.2kg";
		dog[1].color = "�Ͼ��";

		dog[2].type = "�̴���";
		dog[2].kg = "4~5kg";
		dog[2].color = "����";

		cat[0].type = "��ġŲ";
		cat[0].kg = "3~5kg";
		cat[0].color = "������";

		cat[1].type = "����ũ��";
		cat[1].kg = "4~5kg";
		cat[1].color = "�Ͼ��";

		hamster.type = "���۸���";
		hamster.kg = "40~60kg";
		hamster.color = "ȸ��";

		for (int i = 0; i < 3; i++) {
			dog[i].output();
		}

		for (int i = 0; i < 2; i++) {
			cat[i].output();
		}
		hamster.output();
	}

}
