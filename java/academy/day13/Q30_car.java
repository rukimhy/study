package academy.day13;

class Car {
	String color;
	String maker;
	int max_speed;

	void riding() {
		System.out.println("���� " + color + "���̰�, ������� " + maker + "�̸�, �ְ� �ӵ��� " + max_speed + "�Դϴ�.");
	}
}

class Bicycle {
	String function;
	String maker;

	void riding() {
		System.out.println("�������� ������� " + maker + "�̸�, ����� " + function + "�Դϴ�.");
	}
}

class Bike {
	String color;
	String maker;
	int max_speed;

	void riding() {
		System.out.println("������̴� " + color + "���̰�, ������� " + maker + "�̸�, �ְ� �ӵ��� " + max_speed + "�Դϴ�.");
	}
}

class User1 {
	Car car2;
	Car car4;
}

class User2 {
	Bicycle bicycle1;
	Bike bike;
}

public class Q30_car {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User1 user1 = new User1();
		User2 user2 = new User2();

		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		Car car4 = new Car();

		car1.color = "��";
		car2.color = "����";
		car3.color = "�Ͼ�";
		car4.color = "����";

		car1.maker = "Ford";
		car2.maker = "BMW";
		car3.maker = "�Ｚ";
		car4.maker = "����";

		car1.max_speed = 220;
		car2.max_speed = 240;
		car3.max_speed = 200;
		car4.max_speed = 180;

		Bicycle bicycle1 = new Bicycle();
		Bicycle bicycle2 = new Bicycle();

		bicycle1.maker = "��õ��";
		bicycle2.maker = "���̾�Ʈ";

		bicycle1.function = "��ǿ�";
		bicycle2.function = "���̽Ŀ�";

		Bike bike = new Bike();

		bike.color = "����";
		bike.maker = "�븲";
		bike.max_speed = 180;

		user1.car2 = car2;
		car2 = null;
		user1.car4 = car4;
		car4 = null;

		user2.bike = bike;
		bike = null;
		user2.bicycle1 = bicycle1;
		bicycle1 = null;

		user1.car2.riding();
		user1.car4.riding();
		user2.bicycle1.riding();
		user2.bike.riding();
	}

}
