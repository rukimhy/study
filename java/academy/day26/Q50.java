package academy.day26;
/*	���� ���� ���α׷� (���� �����)
	�̸� | ���� | ���� | ���� | ��ǻ�� | ��� | ����
	1.�Է� 2.��ȸ 3.���� 4.����
	2�� ��ȸ 1.��ü��ȸ 2.������ȸ
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Student {
	private String studentName;
	private int kor;
	private int eng;
	private int math;
	private int com;
	private double avg;
	private int no;

	Student(String studentName, int kor, int eng, int math, int com) {
		this.studentName = studentName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
		this.avg = (kor + eng + math + com) / 4;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String toString() {
		return studentName + "\t" + kor + "\t" + eng + "\t" + math + "\t" + com + "\t" + avg + "\t" + no + "\n";
	}
}

public class Q50 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		File f = new File("student.txt");
		if (f.exists()) {
			String source = "";
			FileWriter fw = new FileWriter("student.txt", true);
			fw.write(source);
			fw.close();

		} else {
			String source = "�̸�\t����\t����\t����\t��ǻ��\t���\t����\n";
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
				String name = scan.next();
				int kor, eng, math, com;
				do {
					System.out.print("���� : ");
					kor = scan.nextInt();
				} while (kor < 0 || kor > 100);

				do {
					System.out.print("���� : ");
					eng = scan.nextInt();
				} while (eng < 0 || eng > 100);

				do {
					System.out.print("���� : ");
					math = scan.nextInt();
				} while (math < 0 || math > 100);

				do {
					System.out.print("��ǻ�� : ");
					com = scan.nextInt();
				} while (com < 0 || com > 100);

				Student student = new Student(name, kor, eng, math, com);
				System.out.println("�߰��Ǿ����ϴ�.");
				FileWriter fw = new FileWriter("student.txt", true);
				fw.write(student.toString());
				fw.close();

			}

			// ����
			else if (select.equals("3")) {
				System.out.print("�̸��� �Է����ּ��� : ");
				String name = scan.nextLine();

				FileReader fr = new FileReader("student.txt");
				FileWriter fw = new FileWriter("tmp.txt");

				int i, j, count = 0, temp1 = 0, temp2 = 0;

				while ((i = fr.read()) != -1) {
					if (count == 1) {
						if ((char) i == '\n') {
							count = 2;
						} else {
							continue;
						}
					}

					else {
						if (name.charAt(0) == (char) temp2 && name.charAt(1) == (char) temp1
								&& name.charAt(2) == (char) i) {
							count = 1;
						}
					}

					if (name.charAt(0) != (char) temp1) {
						fw.write((char) i);
					}
					temp2 = temp1;
					temp1 = i;
				}

				if (count < name.length()) {
					System.out.println("ã�� �̸��� �����ϴ�.");
				}
				fw.close();
				fr.close();

				File file = new File("tmp.txt");
				File file2 = new File("student.txt");
				file2.delete();
				file.renameTo(new File("student.txt"));

			}

			// ��ȸ
			else if (select.equals("2")) {
				System.out.print("1.��ü ��ȸ || 2.���� ��ȸ : ");
				String select_2 = scan.nextLine();

				if (select_2.equals("1")) {
					FileReader fr = new FileReader("student.txt");
					int i;
					while ((i = fr.read()) != -1) {
						System.out.print((char) i);
					}
					fr.close();
				} else if (select_2.equals("2")) {
					System.out.print("�̸��� �Է����ּ��� : ");
					String name = scan.nextLine();
					System.out.println("�̸�\t����\t����\t����\t��ǻ��\t���\t����");

					FileReader fr = new FileReader("student.txt");
					int i, count = 0, temp1 = 0, temp2 = 0;
					boolean chk = true;

					while ((i = fr.read()) != -1) {

						if (count == name.length()) {
							System.out.print((char) i);
							if ((char) i == '\n') {
								count = name.length() + 50;
								break;
							}
						}
						if (count != name.length()) {
							if (name.charAt(0) == (char) temp2 && name.charAt(1) == (char) temp1
									&& name.charAt(2) == (char) i) {
								count = name.length();
							}
						}

						if (count == name.length() && chk == true) {
							System.out.printf(name);
							chk = false;
						}
						temp2 = temp1;
						temp1 = i;
					}

					if (count < name.length()) {
						System.out.println("ã�� �̸��� �����ϴ�.");
					}
					fr.close();

				} else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}

			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

}
