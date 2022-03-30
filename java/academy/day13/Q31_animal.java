package day13;

class Animal {
	String type;
	String food;
	
	void output() {
		System.out.println("Á¾·ù´Â "+type+", ¸ÔÀÌ´Â "+food);
	}
}

public class Q31_animal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tmp = "";
		
		Animal monkey = new Animal();
		Animal dog = new Animal();
		Animal chicken = new Animal();
		Animal pig = new Animal();
		
		monkey.type = "¿ø¼þÀÌ";
		monkey.food = "¹Ù³ª³ª";
		
		dog.type = "°³";
		dog.food = "»À´Ù±Í";
		
		chicken.type = "´ß";
		chicken.food = "¸ðÀÌ";
		
		pig.type = "µÅÁö";
		pig.food = "¿©¹°";
		
		monkey.output();
		dog.output();
		chicken.output();
		pig.output();
		
		System.out.println("---------");
		
		tmp = monkey.food;
		monkey.food = pig.food;
		pig.food = chicken.food;
		chicken.food = dog.food;
		dog.food = tmp;

		monkey.output();
		dog.output();
		chicken.output();
		pig.output();
	}

}
