package day23;

import java.util.Random;

/*
 * 테란 대 테란
 * 각 팀원 : 메딕 1명 SCV 1명 ( 병원 )
 * 랜덤으로 탱크와 마린으로 10명씩 생성이 된다.
 * 1팀 -> 2팀 순으로 턴제로 게임을 진행한다.
 * 자기 턴일 때 공격과 수리 또는 힐을 한다. -> 공격 + (수리 or 힐)
 * 공격은 랜덤으로 정해지는 인덱스에 있는 유닛이 공격을 한다.
 * 수리 또는 힐은 랜덤으로 정해지는 인덱스 유닛이 수리 또는 힐을 합니다.
 * 수리와 힐에 대한 선택도 랜덤으로 한다.
 * 수리와 힐은 각각 5씩 증가 시켜줍니다.
 * 만약 에너지가 풀이면 진행하지 않습니다.
 * 
 * 마린 : 에너지(50), 공격력(6)
 * 탱크 : 에너지(45), 공격력(4) -> 스플래쉬 데미지, 공격대상 인덱스 위,아래 모두 공격을 받습니다.
 * 마지막까지 살아남은 팀이 우승입니다.
 * 테란 1팀
 * 테란 2팀
 * */

class Terran2{
	AttUnit[] unit = new AttUnit[10];
	Backup[] backup = new Backup[2];
	
	Terran2() {
		Random r = new Random();
		
		for(int i = 0; i < unit.length ; i++) {
			unit[i] = (r.nextInt(2) == 0) ? new Marine2() : new Tank2();
		}
		
		backup[0] = new Medic2();
		backup[1] = new SCV2();
	}
	
	void attack(AttUnit[] enemy) {
		Random r = new Random();
		
		int i = r.nextInt(unit.length);
		
		if(unit[i] != null) {
			unit[i].attack(enemy);
		}
		else {
			System.out.println(" >> 공격 실패 : 우리 팀의 유닛이 이미 죽은 상태입니다.");
		}
	}
	void healOrRepair() {
		Random r = new Random();
		int bIndex = r.nextInt(2);
		int aIndex = r.nextInt(unit.length);
		if(unit[aIndex] != null) {
			backup[bIndex].healOrRepair(unit[aIndex]);			
		}
		
	}

}

interface Backup{
	void healOrRepair(AttUnit object);
}
class Medic2 implements Backup{
	public void healOrRepair(AttUnit object) {
		if(object instanceof Marine2) {
			if(object.getEnergy() != 50) {
				object.setEnergy(object.getEnergy() + 5);
				
				if(object.getEnergy() > 50) {
					object.setEnergy(50);
				}
				System.out.println(" > 메딕이 마린을 치료했습니다.");
			}
			else {
				System.out.println("\t >> 해당 개체의 에너지가 이미 full입니다.");
			}
		}
		else {
			System.out.println("\t >> 메딕은 탱크를 수리할 수 없습니다.");
		}
	}
}
class SCV2 implements Backup{
	public void healOrRepair(AttUnit object) {
		if(object instanceof Tank2) {
			if(object.getEnergy() != 45) {
				object.setEnergy(object.getEnergy() + 5);
				
				if(object.getEnergy() > 45) {
					object.setEnergy(45);
				}
				System.out.println(" > SCV이 탱크를 수리했습니다.");
			}
			else {
				System.out.println("\t >> 해당 개체의 에너지가 이미 full입니다.");
			}
		}
		else {
			System.out.println("\t >> SCV는 마린을 치료 할 수 없습니다.");
		}
	}
}

abstract class AttUnit{
	String name;
	int energy;
	int power;
	
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public String getName() {
		return name;
	}
	
	abstract void attack(AttUnit[] object);
}

class Marine2 extends AttUnit{
	Marine2(){
		super.name = "마린";
		super.energy = 50;
		super.power = 6;
	}
	
	void attack(AttUnit[] enemy) {
		Random r = new Random();
		int i = r.nextInt(10);
		System.out.println(" > " + this.name + "의 공격!");
		if(enemy[i] != null) {
			enemy[i].setEnergy(enemy[i].getEnergy() - this.power);
			System.out.println("\t 상대 " + enemy[i].getName() + "의 에너지가 " + enemy[i].getEnergy() + "만큼 남았습니다.");
			if(enemy[i].getEnergy() < 0) {
				System.out.println(" << 상대" + enemy[i].getName() + "이/가 죽었습니다.>>");
			}			
		}
		else {
			System.out.println("\t >> 공격 실패 : 상대 유닛이 이미 죽은 상태입니다.");
		}
	}
}

class Tank2 extends AttUnit{
	Tank2() {
		super.name = "탱크";
		super.energy = 45;
		super.power = 4;
	}
	void attack(AttUnit[] enemy) {
		Random r = new Random();
		int choice = r.nextInt(10);
		
		for(int i = choice+1; i >= choice-1 ; i--) {
			if(i >= 0 && i < 10) {
				System.out.println(" > " + this.name + "의 공격!");
				if(enemy[i] != null) {
					enemy[i].setEnergy(enemy[i].getEnergy() - this.power);
					System.out.println("\t 상대 " + enemy[i].getName() + "[" + i +"] 의 에너지가 " + enemy[i].getEnergy() + "만큼 남았습니다.");
					if(enemy[i].getEnergy() < 0) {
						System.out.println(" << 상대" + enemy[i].getName() + "이/가 죽었습니다.>>");
						enemy[i] = null;
					}									
				}
				else {
					System.out.println("\t >> 공격 실패 : 상대 유닛이 이미 죽은 상태입니다.");
				}
			}
		}
		
	}
}

class Game{
	Game(){
		Terran2[] team = new Terran2[2];
		
		for(int i = 0; i < team.length ; i++) {
			team[i] = new Terran2();
		}
		
		int turn = 0;
		int our = 1;
		while(true) {
			turn++;
			our = (our == 0)? 1 : 0;
			int enemy = (our == 0)? 1 : 0;
			System.out.println("\n\n=============== 테란 " + (our+1) + "팀의 " + turn +" 번째 턴 ===============");
			team[our].attack(team[enemy].unit);
			if(checkEnd(team[enemy].unit)) {
				System.out.println(" \n>>> 테란 " + (our+1) + " 팀의 승리!");
				break;
			}
			team[our].healOrRepair();
			
		}
	}
	
	boolean checkEnd(AttUnit[] object) {
		for(int i = 0; i < object.length ; i++) {
			if(object[i] != null)
				return false;
		}
		return true;
	}
}

public class Q48_student {

	public static void main(String[] args) {
		
		new Game();
	}

}
