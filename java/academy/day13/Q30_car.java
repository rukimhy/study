package day13;

class Car {
	String color;
	String maker;
	int max_speed;
	
	void riding() {
		System.out.println("차는 "+color+"색이고, 제조사는 "+maker+"이며, 최고 속도는 "+max_speed+"입니다.");
	}
}

class Bicycle {
	String function;
	String maker;
	
	void riding() {
		System.out.println("자전거의 제조사는 "+maker+"이며, 기능은 "+function+"입니다.");
	}
}

class Bike {
	String color;
	String maker;
	int max_speed;
	
	void riding() {
		System.out.println("오토바이는 "+color+"색이고, 제조사는 "+maker+"이며, 최고 속도는 "+max_speed+"입니다.");
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
		
		car1.color = "은";
		car2.color = "검정";
		car3.color = "하얀";
		car4.color = "형광";
		
		car1.maker = "Ford";
		car2.maker = "BMW";
		car3.maker = "삼성";
		car4.maker = "현대";
		
		car1.max_speed = 220;
		car2.max_speed = 240;
		car3.max_speed = 200;
		car4.max_speed = 180;
		
		Bicycle bicycle1 = new Bicycle();
		Bicycle bicycle2 = new Bicycle();
		
		bicycle1.maker = "삼천리";
		bicycle2.maker = "자이언트";
		
		bicycle1.function = "산악용";
		bicycle2.function = "접이식용";
		
		Bike bike = new Bike();
		
		bike.color = "빨간";
		bike.maker = "대림";
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
