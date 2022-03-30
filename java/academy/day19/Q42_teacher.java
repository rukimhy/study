package day19;

import java.util.Random;

class Unit
{
	int price;
	int hp;
	int attack;
	int defense;
	String target;
	double speed;
	String characteristic;
}

class Marine extends Unit
{
	Marine()
	{
		super.price = 50;
		super.hp = 50;
		super.attack = 6;
		super.defense = 0;
		super.target = "지상, 공중";
		super.speed = 1.875;
		super.characteristic = "지상, 소형, 생체";
	}

	void print()
	{
		System.out.println("마린의 생산비용은 미네랄 " + super.price + ", 체력 " + super.hp + ", 공격력 " + super.attack + " 방어력 " + super.defense + ", 공격대상 " + super.target + ", 이동속도 " + super.speed + ", 유닛 특성" + super.characteristic + "입니다.");
	}

	void energyPrint()
	{
		System.out.println("마린 에너지 : "+hp);
	}
	void attackPrint()
	{
		System.out.println("마린이 "+attack+"공격력으로 공격을 합니다.");
	}
}
class Juggling extends Unit
{
	Juggling() // 생성자
	{
		super.price = 50;
		super.hp = 35;
		super.attack = 5;
		super.defense = 0;
		super.target = "지상";
		super.speed = 2.612;
		super.characteristic = "지상, 소형, 생체";
	}

	void print()
	{
		System.out.println("저글링의 생산비용은 미네랄 " + super.price + ", 체력 " + super.hp + ", 공격력 " + super.attack + " 방어력 " + super.defense + ", 공격대상 " + super.target + ", 이동속도 " + super.speed + ", 유닛 특성" + super.characteristic + "입니다.");
	}

	void energyPrint()
	{
		System.out.println("저글링 에너지 : "+hp);
	}
	void attackPrint()
	{
		System.out.println("저글링이 "+attack+"공격력으로 공격을 합니다.");
	}

}

class EndCheck
{
	boolean check = true;
	int end = -1;
}


class Controller
{
	int attack(Marine[] m, Juggling[] j, Random r, int sun)
	{
		//객체가 null인지 체크, 에너지가 0이 되면 null로 체인지
		int zergIndex = r.nextInt(10);
		int terranIndex = r.nextInt(10);
		if(j[zergIndex] != null && m[terranIndex] != null)
		{
			if(sun == 0)
			{
				
				j[zergIndex].hp=j[zergIndex].hp-m[terranIndex].attack;
				m[terranIndex].attackPrint();
				j[zergIndex].energyPrint();
				if(j[zergIndex].hp<=0)
				{
					j[zergIndex] = null;
				}
				return 1;
			}
			else
			{
				m[terranIndex].hp = m[terranIndex].hp - j[zergIndex].attack;
				j[zergIndex].attackPrint();
				m[terranIndex].energyPrint();
				if(m[terranIndex].hp<=0)
				{
					m[terranIndex] = null;
				}
				return 0;
			}
		}
		else
		{
			if(sun == 0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
	
	EndCheck check(Marine[] m, Juggling[] j)
	{
		EndCheck e = new EndCheck();
		int mCount = 0;
		int jCount = 0;
		
		for(int i = 0;i<m.length;i++)
		{
			if(m[i] == null)
			{
				mCount++;
			}
		}
		for(int k = 0;k<j.length;k++)
		{
			if(j[k] == null)
			{
				jCount++;
			}
		}
		
		if(mCount == 10)
		{
			e.check = false;
			e.end = 0;
			return e;
		}
		else if(jCount == 10)
		{
			e.check = false;
			e.end = 1;
			return e;
		}
		else
		{
			return e;
		}
	}

	
}

public class Q42_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marine[] m = new Marine[10];
		Juggling[] j = new Juggling[10];
		Controller c = new Controller();
		EndCheck e = new EndCheck();

		for(int i = 0;i<10;i++)
		{
			m[i] = new Marine();
			j[i] = new Juggling();
		}

		Random r = new Random();

		int sun = r.nextInt(2);

		while(e.check)
		{
			sun=c.attack(m, j, r, sun);
			e=c.check(m, j);
		}
		
		if(e.end == 0)
		{
			System.out.println("저그에 승리입니다.");
		}
		else if(e.end == 1)
		{
			System.out.println("테란이 승리입니다.");
		}
		else
		{
			System.out.println("잘못된 결과입니다.");
		}
	}

}
