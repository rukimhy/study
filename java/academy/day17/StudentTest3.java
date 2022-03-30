package day17;

public class StudentTest3 {

	public static void main(String[] args) {
		Student3 studentLee = new Student3();
		studentLee.setStudentName("이지원");
		System.out.println(studentLee.serialNum);
		System.out.println(studentLee.studentName+" 학번:"+studentLee.studentID);
		
		Student3 studentSon = new Student3();
		studentSon.setStudentName("손수경");
		System.out.println(studentSon.serialNum);
		System.out.println(studentSon.studentName+" 학번:"+studentSon.studentID);
		
		studentLee.setStudentName("이지원");
		System.out.println(Student3.serialNum);
		System.out.println(studentLee.studentName+" 학번:"+studentLee.studentID);
		
		studentSon.setStudentName("손수경");
		System.out.println(Student3.serialNum);
		System.out.println(studentSon.studentName+" 학번:"+studentSon.studentID);
	}

}
