package academy.day13;

class Animal {
	String type;
	String food;

	void output() {
		System.out.println("������ " + type + ", ���̴� " + food);
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

		monkey.type = "������";
		monkey.food = "�ٳ���";

		dog.type = "��";
		dog.food = "���ٱ�";

		chicken.type = "��";
		chicken.food = "����";

		pig.type = "����";
		pig.food = "����";

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
