package day15;

import java.util.Random;

class Fire
{
	
}

class Monkey
{
	String color;
	Fire f = new Fire();;

	void checkFire()
	{
		if(f != null)
		{
			System.out.println(color+"원숭이가 불을 가지고 있습니다.");
		}
	}
}



public class Q35_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Monkey[] m = new Monkey[5];
		Fire f = new Fire();

		String[] monColor = {"빨간", "노랑", "파랑","초록","검정"};

		for(int i =0;i<5;i++)
		{
			m[i] = new Monkey();
			m[i].color = monColor[i];
		}

		m[0].f = f;

		Random r = new Random();

		int d = r.nextInt(2); // 좌우 선택
		int p = r.nextInt(5)+1; // 몇번전달 될지

		System.out.println(d+"/"+p);

		if(d == 0) // 좌
		{
			int j = 4;
			m[4].f = m[0].f;
			m[0].f = null;
			m[4].checkFire();
			
			for(int i = 0;i<p-1;i++)
			{
				m[j-1].f = m[j].f;
				m[j].f = null;
				j--;
				m[j].checkFire();
			}
			
		}
		else // 우
		{
			for(int i =0;i<p;i++)
			{
				if(i+1 == 5)
				{
					m[0].f = m[i].f;
					m[i].f = null;
					m[0].checkFire();
				}
				else
				{
					m[i+1].f = m[i].f;
					m[i].f = null;
					m[i+1].checkFire();
				}
			}
		}

	}

}
