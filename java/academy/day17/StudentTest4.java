package academy.day17;

public class StudentTest4 {

	public static void main(String[] args) {
		Student4 studentLee = new Student4();
		studentLee.setStudentName("������");
		System.out.println(Student4.getSerialNum());
		System.out.println(studentLee.studentName + " �й�:" + studentLee.studentID);

		Student4 studentSon = new Student4();
		studentSon.setStudentName("�ռ���");
		System.out.println(Student4.getSerialNum());
		System.out.println(studentSon.studentName + " �й�:" + studentSon.studentID);
	}

}
