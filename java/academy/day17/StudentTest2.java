package academy.day17;

public class StudentTest2 {

	public static void main(String[] args) {
		Student2 studentLee = new Student2();
		studentLee.setStudentName("������");
		System.out.println(studentLee.serialNum);
		studentLee.serialNum++;

		Student2 studentSon = new Student2();
		studentSon.setStudentName("�ռ���");
		System.out.println(studentSon.serialNum);
		System.out.println(studentLee.serialNum);
	}

}
