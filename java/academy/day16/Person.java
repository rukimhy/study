package day16;

public class Person {
	String name;
	float height;
	float weight;
	
	Person(){}
	
	Person(String pname){
		name = pname;
	}
	
	Person(String pname, float pheight, float pweight){
		name = pname;
		height = pheight;
		weight = pweight;
	}
}