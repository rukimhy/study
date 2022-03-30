package day20;

import java.util.Random;

public class Burf{

	void burf(Unit unit, Random r) {
		int random_burf = r.nextInt(3); // 0 공격력업, 1 체력업, 2 체력다운
		int random_atk = r.nextInt(51)+50;
		int random_energy = r.nextInt(101)+100;

		//atkUP
		if(random_burf == 0) {
			System.out.println("버프 : "+unit.name+"의 공격력이 "+random_atk+"만큼 증가했다.");
			unit.set = unit.atk + random_atk; 
		} 
		//energyUP
		else if(random_burf == 1) {
			unit.energy += random_energy;
			System.out.println("버프 : "+unit.name+"의 에너지가 "+random_energy+"만큼 증가했다.");
		} 
		//energyDOWN
		else {
			unit.energy -= random_energy;
			System.out.println("디버프 : "+unit.name+"의 에너지가 "+random_energy+"만큼 감소했다.");
		}

	}
}

