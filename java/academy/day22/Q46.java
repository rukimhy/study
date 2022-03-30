package day22;

import java.util.Random;

interface Booster{}

abstract class Vehicle
{
	int distance;
	int gauge;
	abstract void move();
}

class Car extends Vehicle implements Booster
{
	Car()
	{
		super.distance = 0;
		super.gauge = 0;
	}
	void printDistance() 
	{
		System.out.println("자동차의 주행거리 : "+distance);
	}
	void printGauge() 
	{
		System.out.println("자동차의 게이지 : "+gauge);
	}
	@Override
	void move() 
	{
		Random r = new Random();
		int meter = r.nextInt(21);
		distance += meter;
		System.out.println("자동차는 "+meter+"만큼 이동했습니다.");
	}
	public String toString() 
	{
		return "자동차";
	}
}

class Bicycle extends Vehicle implements Booster
{
	Bicycle()
	{
		super.distance = 0;
		super.gauge = 0;
	}
	void printDistance() 
	{
		System.out.println("자전거의 주행거리 : "+distance);
	}
	void printGauge() 
	{
		System.out.println("자전거의 게이지 : "+gauge);
	}
	@Override
	void move() 
	{
		Random r = new Random();
		int meter = r.nextInt(21);
		distance += meter;
		System.out.println("자전거는 "+meter+"만큼 이동했습니다.");
	}
	public String toString() 
	{
		return "자전거";
	}
}

class Motorcycle extends Vehicle implements Booster
{
	Motorcycle()
	{
		super.distance = 0;
		super.gauge = 0;
	}
	void printDistance() 
	{
		System.out.println("오토바이의 주행거리 : "+distance);
	}
	void printGauge() 
	{
		System.out.println("오토바이의 게이지 : "+gauge);
	}
	@Override
	void move() 
	{
		Random r = new Random();
		int meter = r.nextInt(21);
		distance += meter;
		System.out.println("오토바이는 "+meter+"만큼 이동했습니다.");
	}
	
	public String toString() 
	{
		return "오토바이";
	}
}

public class Q46 {
	
	public static void booster(Booster b, int a) 
	{
		if(b instanceof Vehicle) 
		{
			Vehicle v = (Vehicle)b;
			v.distance += a;
			System.out.println(v+" : "+a+"만큼 부스터 합니다.");
			v.gauge = -1;
		}
	}

	public static void main(String[] args) {
		Random r = new Random();
		Car car = new Car();
		Bicycle bicycle = new Bicycle();
		Motorcycle motorcycle = new Motorcycle();
		int count = 1;

		while(true) 
		{
			System.out.println("========="+count+"턴=========");
			int randomChoice = r.nextInt(3)+1; // 1:자동차x 2:자전거x 3:오토바이x
			if(randomChoice == 1) 
			{
				System.out.println("자동차 움직이지 못합니다.");
				bicycle.move();
				motorcycle.move();
			} 
			else if(randomChoice == 2) 
			{
				System.out.println("자전거 움직이지 못합니다.");
				car.move();
				motorcycle.move();

			} 
			else 
			{
				System.out.println("오토바이 움직이지 못합니다.");
				car.move();
				bicycle.move();
			}
			
			car.gauge++;
			bicycle.gauge++;
			motorcycle.gauge++;
			
			car.printGauge();
			bicycle.printGauge();
			motorcycle.printGauge();
			
			if(bicycle.gauge == 2) 
			{
				booster(bicycle, 5);
			}
			if(motorcycle.gauge == 3) 
			{
				booster(motorcycle, 3);
			} 
			if(car.gauge == 4) 
			{
				booster(car, 2);
			}
			
			car.printDistance();
			bicycle.printDistance();
			motorcycle.printDistance();
			
			if(bicycle.distance >= 500 || motorcycle.distance >= 500 || car.distance >= 500) 
			{
				if(bicycle.distance >= 500) 
				{
					System.out.println("자전거 우승");
				} 
				else if(motorcycle.distance >= 500) 
				{
					System.out.println("오토바이 우승");
				} 
				else 
				{
					System.out.println("자동차 우승");
				}
				break;
			}
			
			count++;
			System.out.println("=====================");
		}
	}

}
