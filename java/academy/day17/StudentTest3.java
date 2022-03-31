package academy.day17;

public class StudentTest3 {

	public static void main(String[] args) {
		Student3 studentLee = new Student3();
		studentLee.setStudentName("������");
		System.out.println(studentLee.serialNum);
		System.out.println(studentLee.studentName + " �й�:" + studentLee.studentID);

		Student3 studentSon = new Student3();
		studentSon.setStudentName("�ռ���");
		System.out.println(studentSon.serialNum);
		System.out.println(studentSon.studentName + " �й�:" + studentSon.studentID);

		studentLee.setStudentName("������");
		System.out.println(Student3.serialNum);
		System.out.println(studentLee.studentName + " �й�:" + studentLee.studentID);

		studentSon.setStudentName("�ռ���");
		System.out.println(Student3.serialNum);
		System.out.println(studentSon.studentName + " �й�:" + studentSon.studentID);
	}

}
