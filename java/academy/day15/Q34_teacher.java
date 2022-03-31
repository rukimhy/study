package academy.day15;

import java.util.Random;

class Dog {
	String sort;
	String size;
	String color;

	public void bark() {
		System.out.println("�������� ������ " + sort + "�̰� ũ��� " + size + "�̸� ���� " + color + ", �ൿ�� ¢��");
	}

}

class Cat {
	String sort;
	String size;
	String color;

	public void scratch() {
		System.out.println("�������� ������ " + sort + "�̰� ũ��� " + size + "�̸� ���� " + color + ", �ൿ�� ������");
	}

}

class Hamster {
	String sort;
	String size;
	String color;

	public void hamster() {
		System.out.println("�ܽ����� ������ " + sort + "�̰� ũ��� " + size + "�̸� ���� " + color + ", �ൿ�� �����ϰ� ���");
	}
}

public class Q34_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog d[] = new Dog[3];
		Cat c[] = new Cat[2];
		Hamster h = new Hamster();

		h.sort = "���۸���";
		h.size = "40g~60g";
		h.color = "ȸ��";

		Random r = new Random();

		String[] dog_sort = { "��ī ���ĴϿ�", "���޶�Ͼ�", "�̴���" };
		String[] dog_size = { "9~16kg", "1.3~3.2kg", "4~5kg" };
		String[] dog_color = { "������", "�Ͼ��", "����" };

		for (int i = 0; i < 3; i++) {
			d[i] = new Dog();

			d[i].sort = dog_sort[i];
			d[i].size = dog_size[i];
			d[i].color = dog_color[i];

			d[i].bark();
		}

		String[] cat_sort = { "��ġŲ", "����ũ��" };
		String[] cat_size = { "3~5kg", "4~5kg" };
		String[] cat_color = { "������", "�Ͼ��" };

		for (int i = 0; i < 2; i++) {
			c[i] = new Cat();

			c[i].sort = cat_sort[i];
			c[i].size = cat_size[i];
			c[i].color = cat_color[i];

			c[i].scratch();
		}

		h.hamster();

	}

}
