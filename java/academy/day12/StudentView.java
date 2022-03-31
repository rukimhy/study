package academy.day12;

public class StudentView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		Student s1 = new Student();

		s.studentName = "ȫ�浿";
		s.address = "�־�";
		s1.studentName = "ȣ����";
		s1.address = "����";

		s.showStudentInfo();
		s1.showStudentInfo();
	}

}
