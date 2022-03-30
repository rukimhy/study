package day21;

abstract class Car2{
	abstract void start();
	abstract void drive();
	abstract void stop();
	abstract void turnoff();
	
	void washCar() {
		System.out.println("세차를 합니다.");
	}
	
	final void run() {
		start();
		drive();
		stop();
		turnoff();
		washCar();
	}
}

class Sonata extends Car2{
	void start() {
		System.out.println("Sonata 시동을 켭니다.");
	};
	void drive() {
		System.out.println("Sonata 달립니다.");
	};
	void stop() {
		System.out.println("Sonata 멈춥니다.");
	};
	void turnoff() {
		System.out.println("Sonata 시동을 끕니다.");
	};
}

class Avante extends Car2{
	void start() {
		System.out.println("Avante 시동을 켭니다.");
	};
	void drive() {
		System.out.println("Avante 달립니다.");
	};
	void stop() {
		System.out.println("Avante 멈춥니다.");
	};
	void turnoff() {
		System.out.println("Avante 시동을 끕니다.");
	};
}

class Grandeur extends Car2{
	void start() {
		System.out.println("Grandeur 시동을 켭니다.");
	};
	void drive() {
		System.out.println("Grandeur 달립니다.");
	};
	void stop() {
		System.out.println("Grandeur 멈춥니다.");
	};
	void turnoff() {
		System.out.println("Grandeur 시동을 끕니다.");
	};
}

class Genesis extends Car2{
	void start() {
		System.out.println("Genesis 시동을 켭니다.");
	};
	void drive() {
		System.out.println("Genesis 달립니다.");
	};
	void stop() {
		System.out.println("Genesis 멈춥니다.");
	};
	void turnoff() {
		System.out.println("Genesis 시동을 끕니다.");
	};
}

public class CarTest2 {

	public static void main(String[] args) {
		Car2[] carList = new Car2[4];
		carList[0] = new Sonata();
		carList[1] = new Grandeur();
		carList[2] = new Avante();
		carList[3] = new Genesis();
		
		for(int i=0; i<carList.length; i++) {
			carList[i].run();
			System.out.println("=================");
		}
	}

}
