package academy.day17;

public class TakeTrans {

	public static void main(String[] args) {
		Student1 studentJames = new Student1("James", 5000);
		Student1 studentTomas = new Student1("Tomas", 10000);

		Bus bus100 = new Bus(100);
		studentJames.takeBus(bus100);
		studentJames.showInfo();
		bus100.showInfo();

		Subway subwayGreen = new Subway("2ȣ��");
		studentTomas.takeSubway(subwayGreen);
		studentTomas.showInfo();
		subwayGreen.showInfo();
	}

}
