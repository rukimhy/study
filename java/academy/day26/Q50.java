package day26;
/*	성적 관리 프로그램 (파일 입출력)
	이름 | 국어 | 영어 | 수학 | 컴퓨터 | 평균 | 순위
	1.입력 2.조회 3.삭제 4.종료
	2번 조회 1.전체조회 2.선택조회
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Student{
	private String studentName;
	private int kor;
	private int eng;
	private int math;
	private int com;
	private double avg;
	private int no;

	Student(String studentName, int kor, int eng, int math, int com){
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
		return studentName+"\t"+kor+"\t"+eng+"\t"+math+"\t"+com+"\t"+avg+"\t"+no+"\n";
	}
}

public class Q50 {

	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);

		File f = new File("student.txt");
		if(f.exists()) {
			String source = "";
			FileWriter fw = new FileWriter("student.txt", true);
			fw.write(source);
			fw.close();

		} else {
			String source = "이름\t국어\t영어\t수학\t컴퓨터\t평균\t순위\n";
			FileWriter fw = new FileWriter("student.txt");
			fw.write(source);
			fw.close();
		}

		while(true) {
			System.out.print("1.입력 2.조회 3.삭제 4.종료 : ");
			String select = scan.nextLine();

			if(select.equals("4") ) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} 
			//입력
			else if(select.equals("1")) {
				System.out.print("이름 : ");
				String name = scan.next();
				int kor, eng, math, com;
				do {
					System.out.print("국어 : ");
					kor = scan.nextInt();
				} while(kor < 0 || kor > 100);

				do {
					System.out.print("영어 : ");
					eng = scan.nextInt();
				} while(eng < 0 || eng > 100);

				do {
					System.out.print("수학 : ");
					math = scan.nextInt();
				} while(math < 0 || math > 100);

				do {
					System.out.print("컴퓨터 : ");
					com = scan.nextInt();	
				} while(com < 0 || com > 100);

				Student student = new Student(name, kor, eng, math, com);
				System.out.println("추가되었습니다.");
				FileWriter fw = new FileWriter("student.txt", true);
				fw.write(student.toString());
				fw.close();

			} 

			//삭제
			else if(select.equals("3")) {
				System.out.print("이름을 입력해주세요 : ");
				String name = scan.nextLine();

				FileReader fr = new FileReader("student.txt");
				FileWriter fw = new FileWriter("tmp.txt");

				int i, j, count = 0, temp1 = 0, temp2 = 0;

				while((i=fr.read()) != -1)
				{
					if(count == 1) {
						if((char)i == '\n') {
							count = 2;
						}
						else {
							continue;
						}
					}

					else {
						if(name.charAt(0) == (char)temp2 && name.charAt(1) == (char)temp1 && name.charAt(2) == (char)i) {
							count = 1;									
						}
					}
					
					if(name.charAt(0) != (char)temp1) {
						fw.write((char)i);
					}
					temp2 = temp1;
					temp1 = i;
				}
				

				if(count < name.length()) {
					System.out.println("찾는 이름이 없습니다.");
				}
				fw.close();
				fr.close();

				File file = new File("tmp.txt");
				File file2 = new File("student.txt");
				file2.delete();
				file.renameTo(new File("student.txt"));

			}

			//조회
			else if(select.equals("2")) {
				System.out.print("1.전체 조회 || 2.선택 조회 : ");
				String select_2 = scan.nextLine();

				if(select_2.equals("1")) {
					FileReader fr = new FileReader("student.txt");
					int i;
					while((i=fr.read())!= -1)
					{
						System.out.print((char)i);
					}
					fr.close();
				} else if(select_2.equals("2")) {
					System.out.print("이름을 입력해주세요 : ");
					String name = scan.nextLine();
					System.out.println("이름\t국어\t영어\t수학\t컴퓨터\t평균\t순위");

					FileReader fr = new FileReader("student.txt");
					int i, count = 0, temp1 = 0, temp2 = 0;
					boolean chk = true;

					while((i=fr.read()) != -1)
					{

						if(count == name.length()) {
							System.out.print((char)i);
							if((char)i == '\n') {
								count = name.length()+50;
								break;
							}
						}
						if(count != name.length()) {
							if(name.charAt(0) == (char)temp2 && name.charAt(1) == (char)temp1 && name.charAt(2) == (char)i) {
								count = name.length();									
							}
						}

						if(count == name.length() && chk == true) {
							System.out.printf(name);
							chk = false;
						}
						temp2 = temp1;
						temp1 = i;
					}

					if(count < name.length()) {
						System.out.println("찾는 이름이 없습니다.");
					}
					fr.close();

				} else {
					System.out.println("잘못된 입력입니다.");
				}

			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

}

