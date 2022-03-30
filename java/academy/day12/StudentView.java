package day12;

public class StudentView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		Student s1 = new Student();
		
		s.studentName = "홍길동";
		s.address = "주안";
		s1.studentName = "호랑이";
		s1.address = "부평";
		
		s.showStudentInfo();
		s1.showStudentInfo();
	}

}
