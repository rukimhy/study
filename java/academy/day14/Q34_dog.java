package day14;

class Dog{
	String type;
	String kg;
	String color;
	
	void output(){
		System.out.println("강아지 종류는 "+type+"이고, 크기는 "+kg+"이며, 색깔은 "+color+"이고 짖는다.");
	}
}

class Cat{
	String type;
	String kg;
	String color;
	
	void output(){
		System.out.println("고양이 종류는 "+type+"이고, 크기는 "+kg+"이며, 색깔은 "+color+"이고 할퀸다.");
	}
}

class Hamster{
	String type;
	String kg;
	String color;
	
	void output(){
		System.out.println("햄스터 종류는 "+type+"이고, 크기는 "+kg+"이며, 색깔은 "+color+"이고 찍찍운다.");
	}
}

public class Q34_dog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 개 3마리, 고양이 2마리, 햄스터 1마리
		   개 : 코카 스파니엘(9~16kg, 검정), 포메라니안(1.3~3.2kg, 하양), 미니핀(4~5kg, 갈색)
		   "강아지 종류는 XXX이고, 크기는 XXX이며, 색깔은 XXX이고 짖는다."
		   고양이 : 먼치킨(3~5kg, 검정), 스핑크스(4~5kg, 하양)
		   "고양이 종류는 XXX이고, 크기는 XXX이며, 색깔은 XXX이고 할퀸다."
		   햄스터 : 정글리안(40~60kg, 회색)
		   "햄스터 종류는 XXX이고, 크기는 XXX이며, 색깔은 XXX이고 찍찍운다."
		   클래스 배열로 만들어라
		 */
		Dog[] dog = new Dog[3];
		Cat[] cat = new Cat[2];
		Hamster hamster = new Hamster();
		
		for(int i = 0; i<3; i++) {
			dog[i] = new Dog();
		}
		for(int i = 0; i<2; i++) {
			cat[i] = new Cat();
		}
		
		dog[0].type = "코카 스파니엘";
		dog[0].kg = "9~16kg";
		dog[0].color = "검정색";
		
		dog[1].type = "포메라니안";
		dog[1].kg = "1.3~3.2kg";
		dog[1].color = "하얀색";
		
		dog[2].type = "미니핀";
		dog[2].kg = "4~5kg";
		dog[2].color = "갈색";
		
		cat[0].type = "먼치킨";
		cat[0].kg = "3~5kg";
		cat[0].color = "검정색";
		
		cat[1].type = "스핑크스";
		cat[1].kg = "4~5kg";
		cat[1].color = "하얀색";
		
		hamster.type = "정글리안";
		hamster.kg = "40~60kg";
		hamster.color = "회색";
		
		for(int i = 0; i<3; i++) {
			dog[i].output();
		}
		
		for(int i = 0; i<2; i++) {
			cat[i].output();
		}
		hamster.output();
	}

}
