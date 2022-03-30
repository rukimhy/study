package day23;

import java.util.Random;

class Terran1
{
	Unit1[] u = new Unit1[10];
	A[] sm = new A[2];
	
	public Terran1() {
		// TODO Auto-generated constructor stub
		Random r = new Random();
		
		for(int i =0;i<u.length;i++)
		{
			u[i] = (r.nextInt(2) == 0) ? new Marine1() : new Tank1();
		}
		
		sm[0]= new SCV1();
		sm[1]= new Medic1();
		
	}
	
	boolean check()
	{
		for(int i =0;i<u.length;i++)
		{
			if(u[i] != null)
			{
				return false;
			}
		}
		return true;
	}
	
	
}

interface A
{
	void handR(Unit1 u);
}

class Unit1
{
	private String name;
	private int hp;
	private int attack;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}

}

interface Heal1
{

}
interface Repair1
{

}
class Marine1 extends Unit1 implements Heal1
{
	// 마린 세팅 이름, hp, attack
	Marine1()
	{
		super.setName("마린");
		super.setHp(50);
		super.setAttack(6);
	}
	// 공격
	void shootAttack(Unit1 u)
	{
		if(u != null)
		{
			u.setHp(u.getHp()-super.getAttack());
			System.out.println(u.getName()+ "의 에너지가 "+ u.getHp() + "입니다.");
		}
		else
		{
			System.out.println("이미 죽어있습니다.");
		}
	}

}
class Tank1 extends Unit1 implements Repair1
{
	// 탱크 세팅 이름, hp, attack
	Tank1() {
		super.setName("탱크");
		super.setHp(45);
		super.setAttack(4);
	}
	// 공격
	void shootAttack(Unit1[] u, int index)
	{
		for(int i = index+1;i>=index-1;i--)
		{
			if(!(i < 0 || i >= 10))
			{
				if(u[i] != null)
				{
					u[i].setHp(u[i].getHp()-super.getAttack());
					System.out.println(u[i].getName()+ "의 에너지가 "+ u[i].getHp() + "입니다.");
					if(u[i].getHp()<=0)
					{
						u[i] = null;
					}
				}
				else
				{
					System.out.println("이미 죽어있습니다.");
				}
			}
		}
	}
}

class Medic1 implements A
{
	
	public void handR(Unit1 u)
	{
		if(u != null)
		{
			if(u instanceof Marine1)
			{
				u.setHp(u.getHp()+5);
				if(u.getHp()>50)
				{
					u.setHp(50);
				}
				System.out.println("매딕이" + u.getName()+"의 에너지를 "+u.getHp()+"로 치료를 했습니다.");
			}
			else
			{
				System.out.println("탱크라 치료를 할 수 없습니다.");
			}
		}
		else
		{
			System.out.println("이미 죽었습니다.");
		}
	}
	
}

class SCV1 implements A
{
	//리페어
	public void handR(Unit1 u)
	{
		if(u != null)
		{
			if(u instanceof Tank1)
			{
				u.setHp(u.getHp()+5);
				if(u.getHp()>45)
				{
					u.setHp(45);
				}
				System.out.println("SCV가" + u.getName()+"의 에너지를 "+u.getHp()+"로 수리를 했습니다.");
			}
			else
			{
				System.out.println("마린이라 수리를 할 수 없습니다.");
			}
		}
		else
		{
			System.out.println("이미 죽었습니다.");
		}
	}
}

public class Q48_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Terran1[] t = new Terran1[2];
		
		for(int i = 0;i<t.length;i++)
		{
			t[i] = new Terran1();
		}
		
		// 1. 공격 2. 힐또는 수리 3. null 체크 4. marine 에너지를 확인해서 null set
		
		int turn = 1;
		
		Random r = new Random();
		
		while(true)
		{
			int attck = r.nextInt(10);
			int horR = r.nextInt(10);
			int def = r.nextInt(10);
			int selSM = r.nextInt(2);
			
			System.out.println("턴 : "+ turn + "입니다.");
			
			if(turn % 2 == 1)
			{
				System.out.println("팀1 공격");
				if(t[0].u[attck] instanceof Marine1)
				{
					Marine1 m=(Marine1)t[0].u[attck];
					m.shootAttack(t[1].u[def]);
					
					if(t[1].u[def]!=null&&t[1].u[def].getHp() <= 0)
					{
						t[1].u[def] = null;
					}		
					t[0].sm[selSM].handR(t[0].u[horR]);
					
				}
				else
				{
					System.out.println("팀2 공격");
					Tank1 tank=(Tank1)t[0].u[attck];
					if(tank != null)
					{
						tank.shootAttack(t[1].u,def);
					}
					t[0].sm[selSM].handR(t[0].u[horR]);
				}
				
				
			}
			else
			{
				if(t[1].u[attck] instanceof Marine1)
				{
					Marine1 m=(Marine1)t[1].u[attck];
					m.shootAttack(t[0].u[def]);
					
					if(t[0].u[def]!=null &&t[0].u[def].getHp() <= 0)
					{
						t[0].u[def] = null;
					}
					t[1].sm[selSM].handR(t[1].u[horR]);
				}
				else
				{
					Tank1 tank=(Tank1)t[1].u[attck];
					if(tank != null)
					{
						tank.shootAttack(t[0].u,def);
					}
					t[1].sm[selSM].handR(t[1].u[horR]);
				}
			}
			
			
			if(t[0].check())
			{
				System.out.println("테란 2팀이 승리했습니다.");
				break;
			}
			if(t[1].check())
			{
				System.out.println("테란 1팀이 승리했습니다.");
				break;
			}
			
			turn++;
		}
	}

}