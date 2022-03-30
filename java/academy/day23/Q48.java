package day23;

import java.util.Random;

interface Repairable{}
interface Heal{}

class Unit{
	int hitPoint;
	final int MAX_HP;
	final int MAX_ATK;
	Unit(int hp, int atk){
		MAX_HP = hp;
		MAX_ATK = atk;
	}
	void attack(Unit u, int count) {

	};
}

class Tank extends Unit implements Repairable{
	Tank(){
		super(45, 4);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Tank";
	}

	@Override
	void attack(Unit u, int count) {
		u.hitPoint -= super.MAX_ATK;
		System.out.println(this.toString()+"의 공격! "+u.toString()+"["+count+"]"+"에게 "+super.MAX_ATK+"만큼 피해를 주었다.");
	}
}

class Marine extends Unit implements Heal{
	Marine(){
		super(50, 6);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Marine";
	}

	@Override
	void attack(Unit u, int count) {
		u.hitPoint -= super.MAX_ATK;
		System.out.println(this.toString()+"의 공격! "+u.toString()+"["+count+"]"+"에게 "+super.MAX_ATK+"만큼 피해를 주었다.");
	}
}

class SCV extends Unit implements Repairable{
	SCV(){
		super(100, 100);
	}

	void repair(Repairable r, int count) {
		if(r instanceof Unit) {
			Unit u = (Unit)r;
			if(u.hitPoint != u.MAX_HP) {
				if(u.MAX_HP - u.hitPoint < 5) {
					u.hitPoint = u.MAX_HP;
					System.out.println(this.toString()+"가 "+u.toString()+"["+count+"]"+"의 체력을 +"+(u.MAX_HP - u.hitPoint)+" 회복했습니다.");
				} else {
					u.hitPoint += 5;
					System.out.println(this.toString()+"가 "+u.toString()+"["+count+"]"+"의 체력을 +5 회복했습니다.");
				}
			} else {
				System.out.println("이미 에너지가 가득 차있습니다.");
			}
		}
	}

	public String toString() {
		return "SCV";
	}
}

class Medic extends Unit implements Heal{
	Medic(){
		super(100, 100);
	}

	void heal(Heal h, int count) {
		if(h instanceof Unit) {
			Unit u = (Unit)h;
			if(u.hitPoint != u.MAX_HP) {
				if(u.MAX_HP - u.hitPoint < 5) {
					u.hitPoint = u.MAX_HP;
					System.out.println(this.toString()+"가 "+u.toString()+"["+count+"]"+"의 체력을 +"+(u.MAX_HP - u.hitPoint)+" 회복했습니다.");
				} else {
					u.hitPoint += 5;
					System.out.println(this.toString()+"가 "+u.toString()+"["+count+"]"+"의 체력을 +5 회복했습니다.");
				}
			} else {
				System.out.println("이미 에너지가 가득 차있습니다.");
			}
		}
	}
	public String toString() {
		return "Medic";
	}
}

public class Q48 {

	public static void main(String[] args) {
		Random r = new Random();

		Unit[] team_1 = new Unit[10];
		Unit[] team_2 = new Unit[10];
		SCV scv_1 = new SCV();
		SCV scv_2 = new SCV();
		Medic medic_1 = new Medic();
		Medic medic_2 = new Medic();

		for(int i = 0; i < 10; i++) {
			int random = r.nextInt(2);
			if(random == 0) {
				team_1[i] = new Tank();
			} else {
				team_1[i] = new Marine();
			}
		}

		for(int i = 0; i < 10; i++) {
			int random = r.nextInt(2);
			if(random == 0) {
				team_2[i] = new Tank();
			} else {
				team_2[i] = new Marine();
			}
		}

		int count = 1;
		int team_1_dead = 0;
		int team_2_dead = 0;

		while(true) {
			System.out.println("==="+count+"번째 턴===========================");
			int random_heal = r.nextInt(10);
			int scv_or_medic = r.nextInt(2);
			int random_attack = r.nextInt(10);
			int random_damage = r.nextInt(10);

			//team_1 턴			
			if(count % 2 == 1) {

				System.out.println("team_1의 턴");

				while(team_1[random_heal] == null)
				{
					random_heal = r.nextInt(10);
				}
				//scv가 리페어
				if(scv_or_medic == 0) 
				{ 
					if(team_1[random_heal] instanceof Tank) {
						Tank t = (Tank)team_1[random_heal];
						scv_1.repair(t, random_heal);
					} else {
						System.out.println(scv_1.toString()+"이 "+team_1[random_heal].toString()+"["+random_heal+"]"+"을 리페어할 수 없습니다.");
					}
				}

				//medic이 힐
				else { 
					if(team_1[random_heal] instanceof Marine) {
						Marine m = (Marine)team_1[random_heal];
						medic_1.heal(m, random_heal);
					} else {
						System.out.println(medic_1.toString()+"이 "+team_1[random_heal].toString()+"["+random_heal+"]"+"을 치료할 수 없습니다.");
					}
				}


				while(team_1[random_attack] == null) {
					random_attack = r.nextInt(10);
				}
				while(team_2[random_damage] == null) {
					random_damage = r.nextInt(10);
				}

				//공격
				if(team_1[random_attack] instanceof Tank) {
					if(random_damage == 0) {
						team_1[random_attack].attack(team_2[random_damage], random_damage);
						if(team_2[random_damage+1] != null) {
							team_1[random_attack].attack(team_2[random_damage+1], random_damage+1);
							if(team_2[random_damage+1].hitPoint <= 0) {
								team_2[random_damage+1] = null;
								team_2_dead++;
							}
						}
					}else if(random_damage == 9) {
						team_1[random_attack].attack(team_2[random_damage], random_damage);
						if(team_2[random_damage-1] != null) {
							team_1[random_attack].attack(team_2[random_damage-1], random_damage-1);
							if(team_2[random_damage-1].hitPoint <= 0) {
								team_2[random_damage-1] = null;
								team_2_dead++;
							}
						}
					}else {
						team_1[random_attack].attack(team_2[random_damage], random_damage);
						if(team_2[random_damage-1] != null) {
							team_1[random_attack].attack(team_2[random_damage-1], random_damage-1);
							if(team_2[random_damage-1].hitPoint <= 0) {
								team_2[random_damage-1] = null;
								team_2_dead++;
							}
						}
						if(team_2[random_damage+1] != null) {
							team_1[random_attack].attack(team_2[random_damage+1], random_damage+1);
							if(team_2[random_damage+1].hitPoint <= 0) {
								team_2[random_damage+1] = null;
								team_2_dead++;
							}
						}
					}
				} else {
					team_1[random_attack].attack(team_2[random_damage], random_damage);
				}
				if(team_2[random_damage].hitPoint <= 0) {
					team_2[random_damage] = null;
					team_2_dead++;
				}

			} 

			//team_2 턴			
			else {

				System.out.println("team_2의 턴");

				while(team_2[random_heal] == null) {
					random_heal = r.nextInt(10);
				}
				//scv가 리페어
				if(scv_or_medic == 0) { 
					if(team_2[random_heal] instanceof Tank) {
						Tank t = (Tank)team_2[random_heal];
						scv_2.repair(t, random_heal);
					} else {
						System.out.println(scv_2.toString()+"이 "+team_2[random_heal].toString()+"["+random_heal+"]"+"을 리페어할 수 없습니다.");
					}
				} 

				//medic이 힐
				else { 
					if(team_2[random_heal] instanceof Marine) {
						Marine m = (Marine)team_2[random_heal];
						medic_2.heal(m, random_heal);
					} else {
						System.out.println(medic_2.toString()+"이 "+team_2[random_heal].toString()+"["+random_heal+"]"+"을 치료할 수 없습니다.");
					}
				}


				//공격
				while(team_2[random_attack] == null) {
					random_attack = r.nextInt(10);
				}
				while(team_1[random_damage] == null) {
					random_damage = r.nextInt(10);
				}
				if(team_2[random_attack] instanceof Tank) {
					if(random_damage == 0) {
						team_2[random_attack].attack(team_1[random_damage], random_damage);
						if(team_1[random_damage+1] != null) {
							team_2[random_attack].attack(team_1[random_damage+1], random_damage+1);
							if(team_1[random_damage+1].hitPoint <= 0) {
								team_1[random_damage+1] = null;
								team_1_dead++;
							}
						}
					}else if(random_damage == 9) {
						team_2[random_attack].attack(team_1[random_damage], random_damage);
						if(team_1[random_damage-1] != null) {
							team_2[random_attack].attack(team_1[random_damage-1], random_damage-1);
							if(team_1[random_damage-1].hitPoint <= 0) {
								team_1[random_damage-1] = null;
								team_1_dead++;
							}
						}
					}else {
						team_2[random_attack].attack(team_1[random_damage], random_damage);
						if(team_1[random_damage-1] != null) {
							team_2[random_attack].attack(team_1[random_damage-1], random_damage-1);
							if(team_1[random_damage-1].hitPoint <= 0) {
								team_1[random_damage-1] = null;
								team_1_dead++;
							}
						}
						if(team_1[random_damage+1] != null) {
							team_2[random_attack].attack(team_1[random_damage+1], random_damage+1);
							if(team_1[random_damage+1].hitPoint <= 0) {
								team_1[random_damage+1] = null;
								team_1_dead++;
							}
						}
					}
				} else {
					team_2[random_attack].attack(team_1[random_damage], random_damage);
				}
				if(team_1[random_damage].hitPoint <= 0) {
					team_1[random_damage] = null;
					team_1_dead++;
				}

			}

			if(team_1_dead == 10 || team_2_dead == 10) {
				if(team_1_dead == 10) {
					System.out.println("team_2가 승리했습니다.");
				} else {
					System.out.println("team_1가 승리했습니다.");
				}
				break;
			}
			System.out.print("team_1의 체력 = ");
			for(int i=0; i<10; i++) {
				if(team_1[i] != null) {
					System.out.print(team_1[i].toString()+"["+i+"] "+team_1[i].hitPoint+" / ");
				}
			}
			System.out.println();

			System.out.print("team_2의 체력 = ");
			for(int i=0; i<10; i++) {
				if(team_2[i] != null) {
					System.out.print(team_2[i].toString()+"["+i+"] "+team_2[i].hitPoint+" / ");
				}
			}
			System.out.println();

			count++;
		}

	}

}
