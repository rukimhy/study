package day18;
/* 유닛에 가격, 에너지, 공격력, 방어력, 공격대상, 속도, 유형이 있다.
 * 유닛을 상속받은 클래스는 프린트하는 기능이 있다.
 * 저글링 - 50, 35, 5, 0, "지상", 2.612, "지상, 소형, 생체"
 * 히드라 - 100, 80, 10, 0, "지상, 공중", 1.742, "지상, 중형, 생체"
 * 러커 - 250, 125, 20, 1, "지상", 2.813, "지상, 중형, 생체"
 * 마린 - 50, 50, 6, 0, "지상, 공중", 1.875, "지상, 소형, 생체"
 * 파이어뱃 - 75, 50, 16, 1, "지상", 1.875, "지상, 소형, 생체"
 * 프린트 기능 - 위 내용이 다 나오면서 유닛이름이 다 나오게 출력
 */

class unit{
	int price;
	int energy;
	int atk;
	int def;
	String object;
	double speed;
	String type;
}

class Zergling extends unit{
	Zergling(){
		price = 50;
		energy = 35;
		atk = 5;
		def = 0;
		object = "지상";
		speed = 2.612;
		type = "지상, 소형, 생체";
	}
	
	void print() {
		System.out.println("저글링 "+price+" "+energy+" "+atk+" "+def+" "+object+" "+speed+" "+type);
	}
}

class Hydra extends unit{
	Hydra(){
		price = 100;
		energy = 80;
		atk = 10;
		def = 0;
		object = "지상, 공중";
		speed = 1.742;
		type = "지상, 중형, 생체";
	}
	void print() {
		System.out.println("히드라 "+price+" "+energy+" "+atk+" "+def+" "+object+" "+speed+" "+type);
	}
}

class Lurker extends unit{
	Lurker(){
		price = 250;
		energy = 125;
		atk = 20;
		def = 1;
		object = "지상";
		speed = 2.813;
		type = "지상, 중형, 생체";
	}
	void print() {
		System.out.println("러커 "+price+" "+energy+" "+atk+" "+def+" "+object+" "+speed+" "+type);
	}
}

class Marine extends unit{
	Marine(){
		price = 50;
		energy = 50;
		atk = 6;
		def = 0;
		object = "지상, 공중";
		speed = 1.875;
		type = "지상, 소형, 생체";
	}
	void print() {
		System.out.println("마린 "+price+" "+energy+" "+atk+" "+def+" "+object+" "+speed+" "+type);
	}
}

class Firebat extends unit{
	Firebat(){
		price = 75;
		energy = 50;
		atk = 16;
		def = 1;
		object = "지상";
		speed = 1.875;
		type = "지상, 소형, 생체";
	}
	void print() {
		System.out.println("파이어뱃 "+price+" "+energy+" "+atk+" "+def+" "+object+" "+speed+" "+type);
	}
}

class Collection{
	Zergling zergling = new Zergling();
	Hydra hydra = new Hydra();
	Lurker lurker = new Lurker();
	Marine marine = new Marine();
	Firebat firebat = new Firebat();
}

public class Q41_starcraft {

	public static void main(String[] args) {
		/*
		Zergling zergling = new Zergling();
		Hydra hydra = new Hydra();
		Lurker lurker = new Lurker();
		Marine marine = new Marine();
		Firebat firebat = new Firebat();
		
		zergling.print();
		hydra.print();
		lurker.print();
		marine.print();
		firebat.print();
		*/
		Collection collect = new Collection();
		collect.zergling.print();
		collect.hydra.print();
		collect.lurker.print();
		collect.marine.print();
		collect.firebat.print();
	}

}
