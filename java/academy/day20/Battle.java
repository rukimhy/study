package day20;

public class Battle {	

	void attack(Unit a, Unit b) {
		System.out.println(a.name+"의 공격!!");
		b.energy -= a.set;
		System.out.println(b.name+"의 체력이 "+b.energy+" 만큼 남았다.");
		a.set = a.atk;
	}
	
	boolean check(Unit a, Unit b) {
		if(a.energy <= 0 || b.energy <= 0) {
			if(a.energy > 0) {
				System.out.println(a.name+"의 승리!");
			} else {
				System.out.println(b.name+"의 승리!");
			}
			return false;
		}
		return true;
	}
}
