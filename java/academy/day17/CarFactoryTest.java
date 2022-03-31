package academy.day17;

class Car {
	static int carNum = 10000;

	int getCarNum() {
		this.carNum++;
		return carNum;
	}
}

class CarFactory {
	private CarFactory() {
	}

	private static CarFactory instance = new CarFactory();

	public static CarFactory getInstance() {
		if (instance == null) {
			instance = new CarFactory();
		}
		return instance;
	}

	Car createCar() {
		Car car = new Car();

		return car;
	}
}

public class CarFactoryTest {

	public static void main(String[] args) {
		CarFactory factory = CarFactory.getInstance();
		Car mySonata = factory.createCar();
		Car yourSonata = factory.createCar();
		System.out.println(mySonata.getCarNum());
		System.out.println(yourSonata.getCarNum());
	}

}
