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
		System.out.println("�ڵ����� ����Ÿ� : "+distance);
	}
	void printGauge() 
	{
		System.out.println("�ڵ����� ������ : "+gauge);
	}
	@Override
	void move() 
	{
		Random r = new Random();
		int meter = r.nextInt(21);
		distance += meter;
		System.out.println("�ڵ����� "+meter+"��ŭ �̵��߽��ϴ�.");
	}
	public String toString() 
	{
		return "�ڵ���";
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
		System.out.println("�������� ����Ÿ� : "+distance);
	}
	void printGauge() 
	{
		System.out.println("�������� ������ : "+gauge);
	}
	@Override
	void move() 
	{
		Random r = new Random();
		int meter = r.nextInt(21);
		distance += meter;
		System.out.println("�����Ŵ� "+meter+"��ŭ �̵��߽��ϴ�.");
	}
	public String toString() 
	{
		return "������";
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
		System.out.println("��������� ����Ÿ� : "+distance);
	}
	void printGauge() 
	{
		System.out.println("��������� ������ : "+gauge);
	}
	@Override
	void move() 
	{
		Random r = new Random();
		int meter = r.nextInt(21);
		distance += meter;
		System.out.println("������̴� "+meter+"��ŭ �̵��߽��ϴ�.");
	}
	
	public String toString() 
	{
		return "�������";
	}
}

public class Q46 {
	
	public static void booster(Booster b, int a) 
	{
		if(b instanceof Vehicle) 
		{
			Vehicle v = (Vehicle)b;
			v.distance += a;
			System.out.println(v+" : "+a+"��ŭ �ν��� �մϴ�.");
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
			System.out.println("========="+count+"��=========");
			int randomChoice = r.nextInt(3)+1; // 1:�ڵ���x 2:������x 3:�������x
			if(randomChoice == 1) 
			{
				System.out.println("�ڵ��� �������� ���մϴ�.");
				bicycle.move();
				motorcycle.move();
			} 
			else if(randomChoice == 2) 
			{
				System.out.println("������ �������� ���մϴ�.");
				car.move();
				motorcycle.move();

			} 
			else 
			{
				System.out.println("������� �������� ���մϴ�.");
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
					System.out.println("������ ���");
				} 
				else if(motorcycle.distance >= 500) 
				{
					System.out.println("������� ���");
				} 
				else 
				{
					System.out.println("�ڵ��� ���");
				}
				break;
			}
			
			count++;
			System.out.println("=====================");
		}
	}

}
