package academy.day21;

abstract class Car2 {
	abstract void start();

	abstract void drive();

	abstract void stop();

	abstract void turnoff();

	void washCar() {
		System.out.println("������ �մϴ�.");
	}

	final void run() {
		start();
		drive();
		stop();
		turnoff();
		washCar();
	}
}

class Sonata extends Car2 {
	void start() {
		System.out.println("Sonata �õ��� �մϴ�.");
	};

	void drive() {
		System.out.println("Sonata �޸��ϴ�.");
	};

	void stop() {
		System.out.println("Sonata ����ϴ�.");
	};

	void turnoff() {
		System.out.println("Sonata �õ��� ���ϴ�.");
	};
}

class Avante extends Car2 {
	void start() {
		System.out.println("Avante �õ��� �մϴ�.");
	};

	void drive() {
		System.out.println("Avante �޸��ϴ�.");
	};

	void stop() {
		System.out.println("Avante ����ϴ�.");
	};

	void turnoff() {
		System.out.println("Avante �õ��� ���ϴ�.");
	};
}

class Grandeur extends Car2 {
	void start() {
		System.out.println("Grandeur �õ��� �մϴ�.");
	};

	void drive() {
		System.out.println("Grandeur �޸��ϴ�.");
	};

	void stop() {
		System.out.println("Grandeur ����ϴ�.");
	};

	void turnoff() {
		System.out.println("Grandeur �õ��� ���ϴ�.");
	};
}

class Genesis extends Car2 {
	void start() {
		System.out.println("Genesis �õ��� �մϴ�.");
	};

	void drive() {
		System.out.println("Genesis �޸��ϴ�.");
	};

	void stop() {
		System.out.println("Genesis ����ϴ�.");
	};

	void turnoff() {
		System.out.println("Genesis �õ��� ���ϴ�.");
	};
}

public class CarTest2 {

	public static void main(String[] args) {
		Car2[] carList = new Car2[4];
		carList[0] = new Sonata();
		carList[1] = new Grandeur();
		carList[2] = new Avante();
		carList[3] = new Genesis();

		for (int i = 0; i < carList.length; i++) {
			carList[i].run();
			System.out.println("=================");
		}
	}

}
