package day15;

import java.util.Random;

class Dog
{
	String sort;
	String size;
	String color;

	public void bark()
	{
		System.out.println("강아지의 종류는 " + sort + "이고 크기는 " + size + "이며 색은 " +  color + ", 행동은 짖다");
	}
	
}

class Cat
{
	String sort;
	String size;
	String color;

	public void scratch()
	{
		System.out.println("고양이의 종류는 " + sort + "이고 크기는 " + size + "이며 색은 " +  color + ", 행동은 할퀸다");
	}
	
}

class Hamster
{
	String sort;
	String size;
	String color;

	public void hamster()
	{
		System.out.println("햄스터의 종류는 " + sort + "이고 크기는 " + size + "이며 색은 " +  color + ", 행동은 찍찍하고 운다");
	}
}

public class Q34_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog d[] = new Dog[3];
		Cat c[] = new Cat[2];
		Hamster h = new Hamster();

		h.sort = "정글리안";
		h.size = "40g~60g";
		h.color = "회색";

		Random r = new Random();

		String[] dog_sort = {"코카 스파니엘", "포메라니안", "미니핀"};
		String[] dog_size = {"9~16kg", "1.3~3.2kg", "4~5kg"};
		String[] dog_color = {"검정색", "하얀색", "갈색"};

		for (int i=0; i<3; i++)
		{	
			d[i] = new Dog();
			
			d[i].sort = dog_sort[i];
			d[i].size = dog_size[i];
			d[i].color = dog_color[i];
			
			d[i].bark();
		}
		
		String[] cat_sort = {"먼치킨", "스핑크스"};
		String[] cat_size = {"3~5kg", "4~5kg"};
		String[] cat_color = {"검정색", "하얀색"};
		
		for (int i=0; i<2; i++)
		{	
			c[i] = new Cat();
			
			c[i].sort = cat_sort[i];
			c[i].size = cat_size[i];
			c[i].color = cat_color[i];
			
			c[i].scratch();
		}
			
		h.hamster();

	}

}
