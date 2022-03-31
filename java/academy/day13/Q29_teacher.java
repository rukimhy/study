package academy.day13;

class pencil {
	String pencilcolor;

	String getColor() {
		return pencilcolor;
	}

	void setColor(String color) {
		pencilcolor = color;
	}

	public void pencilmake() {
		System.out.println(pencilcolor + "�� ���ʷ� �����ϴ�.");
	}
}

class Eraser {
	String EraserFrom;

	String getForm() {
		return EraserFrom;
	}

	void setForm(String form) {
		EraserFrom = form;
	}

	public void Erasermake() {
		System.out.println("���찳�� " + EraserFrom + "�� ��ǰ���� ����ϴ�.");
	}
}

class pen {
	String penColor;
	String penFrom;

	String getColor() {
		return penColor;
	}

	void setColor(String color) {
		penColor = color;
	}

	String getForm() {
		return penFrom;
	}

	void setForm(String form) {
		penFrom = form;
	}

	public void penmake() {
		System.out.println("���� " + penFrom + " ��ǰ�� " + penColor + "������ ���ϴ�.");
	}
}

class piltong {
	pencil p1;
	pencil p2;
}

public class Q29_teacher {

	public static void main(String[] args) {

		piltong pt = new piltong();
		pencil pencil1 = new pencil();
		pencil pencil2 = new pencil();
		pencil pencil3 = new pencil();
		pencil pencil4 = new pencil();

		pencil1.setColor("����");
		pencil2.setColor("�Ķ�");
		pencil3.setColor("��Ȳ");
		pencil4.setColor("���");

		pt.p1 = pencil2;
		pt.p2 = pencil4;

		// pencil1.pencilcolor = "����";
		// pencil2.pencilcolor = "�Ķ�";
		// pencil3.pencilcolor = "��Ȳ";
		// pencil4.pencilcolor = "���";

		Eraser Eraser1 = new Eraser();
		Eraser Eraser2 = new Eraser();

		Eraser1.EraserFrom = "���ڸ�";
		Eraser2.EraserFrom = "��ױ۷θ�";

		pen pen1 = new pen();
		pen pen2 = new pen();
		pen pen3 = new pen();

		pen1.penColor = "����";
		pen2.penColor = "�ʷ�";
		pen3.penColor = "���̺����";

		pen1.penFrom = "�𳪹�";
		pen2.penFrom = "��Ʈ��Ʈ��";
		pen3.penFrom = "���͸�";

		pencil1.pencilmake();
		pencil2.pencilmake();
		pencil3.pencilmake();
		pencil4.pencilmake();

		Eraser1.Erasermake();
		Eraser2.Erasermake();

		pen1.penmake();
		pen2.penmake();
		pen3.penmake();

	}
}
