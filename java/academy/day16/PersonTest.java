package day16;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person personKim = new Person();
		personKim.name = "김유신";
		personKim.height = 85.5F;
		personKim.weight = 180.0F;
		
		Person personLee = new Person("이순신", 175, 75);
	}
}
