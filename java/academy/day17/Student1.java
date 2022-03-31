package academy.day17;

public class Student1 {
	public String studentName;
	public int grade;
	public int money;

	public Student1(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}

	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}

	public void takeSubway(Subway subway) {
		subway.take(1500);
		this.money -= 1500;
	}

	public void showInfo() {
		System.out.println(studentName + "���� ���� ���� " + money + "�� �Դϴ�.");
	}
}
