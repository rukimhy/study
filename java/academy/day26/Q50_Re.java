package academy.day26;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Student {
	private String studentName;
	private String kor;
	private String eng;
	private String math;
	private String com;
	private String avg;
	private String no;

	Student(String studentName, String kor, String eng, String math, String com, String avg, String no) {
		this.studentName = studentName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
		this.avg = avg;
		this.no = no;
	}

	Student(String studentName, String kor, String eng, String math, String com) {
		this.studentName = studentName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
		this.avg = Integer.toString(
				(Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math) + Integer.parseInt(com)) / 4);
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String toString() {
		return studentName + "\t" + kor + "\t" + eng + "\t" + math + "\t" + com + "\t" + avg + "\t" + no + "\n";
	}
}

class StudentArrayList {
	private ArrayList<Student> arrayList;

	public ArrayList<Student> getArrayList() {
		return arrayList;
	}

	public StudentArrayList() {
		arrayList = new ArrayList<Student>();
	}

	// arrlist�� �߰�
	public void addStudent(Student student) {
		arrayList.add(student);
	}

	// arrlist���� ����
	public boolean removeStudent(String studentName) {
		for (int i = 0; i < arrayList.size(); i++) {
			Student student = arrayList.get(i);
			String tempName = student.getStudentName();
			if (tempName.equals(studentName)) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println("���� �̸��Դϴ�.");
		return false;
	}

	// arrlist ��ü ���
	public void showAllStudent() {
		for (Student student : arrayList) {
			System.out.println(student);
		}
	}

	// arrlist �˻�
	public boolean searchStudent(String studentName) {
		for (int i = 0; i < arrayList.size(); i++) {
			Student student = arrayList.get(i);
			String tempName = student.getStudentName();
			if (tempName.equals(studentName)) {
				System.out.println(student.toString());
				return true;
			}
		}
		System.out.println("���� �̸��Դϴ�.");
		return false;
	}

	// �ؽ�Ʈ���� ����
	public void removeText(FileWriter fw) throws IOException {
		for (Student student : arrayList) {
			fw.write(student.toString());
		}
	}

	// ���� ����
	public void sortText() throws IOException, NumberFormatException {
		int num = 1;
		for (Student student : arrayList) {
			if (student.getStudentName().equals("�̸�"))
				continue;
			student.setNo(Integer.toString(num));
			num++;
		}

		int i, j;

		for (i = 1; i < arrayList.size(); i++) {
			int count = 0;
			Student studentI = arrayList.get(i);
			for (j = 1; j < arrayList.size(); j++) {
				Student studentJ = arrayList.get(j);
				int intStudentI = Integer.parseInt(studentI.getAvg());
				int intStudentJ = Integer.parseInt(studentJ.getAvg());

				if (intStudentI > intStudentJ) {
					count++;
				}
			}
			studentI.setNo(Integer.toString(arrayList.size() - count - 1));
		}

	}

}

public class Q50_Re {

	public static void main(String[] args) throws IOException, NumberFormatException {
		Scanner scan = new Scanner(System.in);
		StudentArrayList sal = new StudentArrayList();

		File f = new File("student.txt");
		if (f.exists()) {
			String[] splitedStr = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "euc-kr"));
			String line = null;
			splitedStr = null;

			while ((line = reader.readLine()) != null) {
				splitedStr = null;
				splitedStr = line.split("\t");

				for (int i = 0; i < splitedStr.length; i++) {
					splitedStr[i] = splitedStr[i].trim();
				}

				// �ڸ� �����͸� ���ϴ� ���Ŀ� �°� �ֱ�
				sal.addStudent(new Student(splitedStr[0], splitedStr[1], splitedStr[2], splitedStr[3], splitedStr[4],
						splitedStr[5], splitedStr[6]));

			}
			reader.close();

		} else {
			String source = "�̸�\t����\t����\t����\t��ǻ��\t���\t����\n";
			Student student = new Student("�̸�", "����", "����", "����", "��ǻ��", "���", "����");
			sal.addStudent(student);
			FileWriter fw = new FileWriter("student.txt");
			fw.write(source);
			fw.close();
		}

		while (true) {
			System.out.print("1.�Է� 2.��ȸ 3.���� 4.���� : ");
			String select = scan.nextLine();

			if (select.equals("4")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}

			// �Է�
			else if (select.equals("1")) {
				System.out.print("�̸� : ");
				String name = scan.nextLine();

				String kor, eng, math, com;
				do {
					System.out.print("���� : ");
					kor = scan.nextLine();
				} while (Integer.parseInt(kor) < 0 || Integer.parseInt(kor) > 100);

				do {
					System.out.print("���� : ");
					eng = scan.nextLine();
				} while (Integer.parseInt(eng) < 0 || Integer.parseInt(eng) > 100);

				do {
					System.out.print("���� : ");
					math = scan.nextLine();
				} while (Integer.parseInt(math) < 0 || Integer.parseInt(math) > 100);

				do {
					System.out.print("��ǻ�� : ");
					com = scan.nextLine();
				} while (Integer.parseInt(com) < 0 || Integer.parseInt(com) > 100);

				Student student = new Student(name, kor, eng, math, com);
				sal.addStudent(student);
				sal.sortText();
				FileWriter fw = new FileWriter("student.txt", true);
				fw.write(student.toString());
				fw.close();
				System.out.println("�߰��Ǿ����ϴ�.");
			}

			// ��ȸ
			else if (select.equals("2")) {
				System.out.print("1.��ü��ȸ 2.������ȸ : ");
				String select_2 = scan.nextLine();

				// ��ü ��ȸ
				if (select_2.equals("1")) {
					sal.showAllStudent();
				}
				// ���� ��ȸ
				else if (select_2.equals("2")) {
					System.out.print("�̸��� �Է����ּ��� : ");
					String name = scan.nextLine();
					sal.searchStudent(name);

				} else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}

			}

			// ����
			else if (select.equals("3")) {
				System.out.print("�̸��� �Է����ּ��� : ");
				String name = scan.nextLine();
				sal.removeStudent(name);
				sal.sortText();

				FileWriter fw = new FileWriter("tmp.txt");
				fw.close();
				fw = new FileWriter("tmp.txt", true);

				sal.removeText(fw);
				fw.close();

				File file = new File("tmp.txt");
				File file2 = new File("student.txt");
				file2.delete();
				file.renameTo(new File("student.txt"));
			}

			else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

}
