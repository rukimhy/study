package academy.day12;

class Pencil {
	String color;

	public void print() {
		System.out.println(color + "�� ���ʷ� �����ϴ�.");
	}
}

class Eraser {
	String maker;

	public void print() {
		System.out.println(maker + "�� ��ǰ���� ����ϴ�.");
	}
}

class Pen {
	String color;
	String maker;

	public void print() {
		System.out.println(maker + "��ǰ�� " + color + "������ ���ϴ�.");
	}
}

public class Q29_pen {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		/*
		 * ����, ���찳, ���� �ִ�.
		 * ������ ������ ������ �ְ� ���� ����� �Ѵ�. -> "XXX�� ���ʷ� �����ϴ�." ��� (����,
		 * �Ķ�, ��Ȳ, ���)
		 * ���찳�� �����縦 ������ �ְ� ����� ����� �Ѵ�. -> "XXX�� ��ǰ���� ����ϴ�." ���
		 * (���ڸ�, ��ױ۷θ�)
		 * ���� ����� �����縦 ������ �ְ� ������ ����� �Ѵ�. ->
		 * "XXX ��ǰ�� XXX������ ���ϴ�." ��� (����-�𳪹�, �ʷ�-��Ʈ��Ʈ��, ���̺����-���͸�)
		 */

		Pencil pencil_1 = new Pencil();
		pencil_1.color = "����";
		Pencil pencil_2 = new Pencil();
		pencil_2.color = "�Ķ�";
		Pencil pencil_3 = new Pencil();
		pencil_3.color = "��Ȳ";
		Pencil pencil_4 = new Pencil();
		pencil_4.color = "���";

		Eraser eraser_1 = new Eraser();
		eraser_1.maker = "���ڸ�";
		Eraser eraser_2 = new Eraser();
		eraser_2.maker = "��ױ۷θ�";

		Pen pen_1 = new Pen();
		pen_1.color = "����";
		pen_1.maker = "�𳪹�";
		Pen pen_2 = new Pen();
		pen_2.color = "�ʷ�";
		pen_2.maker = "��Ʈ��Ʈ��";
		Pen pen_3 = new Pen();
		pen_3.color = "���̺����";
		pen_3.maker = "���͸�";

		pencil_1.print();
		pencil_2.print();
		pencil_3.print();
		pencil_4.print();

		eraser_1.print();
		eraser_2.print();

		pen_1.print();
		pen_2.print();
		pen_3.print();
	}
}
