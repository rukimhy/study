package scoreTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student
{
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int com;
	private double avg;
	private int rank;


	public Student(String name, int kor, int eng, int math, int com) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
		this.avg = (kor+eng+math+com)/4.0;
	}

	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getCom() {
		return com;
	}
	public double getAvg() {
		return avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	public void print()
	{
		System.out.println(getName()+":"+getKor()+"\t"+getEng()+"\t"+getMath()+"\t"
				+getCom()+"\t"+getAvg()+"\t"+getRank());
	}
}

class Rank implements Comparator<Student>
{
	@Override
	public int compare(Student a,Student b)
	{
		if(a.getAvg()<b.getAvg()) return 1;
		if(a.getAvg()>b.getAvg()) return -1;
		return 0;
	}
}



public class ScoreTest {


	public static void writeText(ArrayList<Student> list) throws IOException
	{
		FileWriter fw = new FileWriter("ScoreMake.txt",false);
		String open = "이름"+"\t\t"+"국어"+"\t\t"+"영어"+"\t\t"+"수학"
				+"\t\t"+"컴퓨터"+"\t\t"+"평균"+"\t\t"+"순위"+"\r\n";

		fw.write(open);

		for(int i = 0;i<list.size();i++)
		{
			String str = list.get(i).getName()+"\t\t"+list.get(i).getKor()+"\t\t"+
					list.get(i).getEng()+"\t\t"+list.get(i).getMath()+"\t\t"+
					list.get(i).getCom()+"\t\t"+list.get(i).getAvg()+"\t\t"+
					list.get(i).getRank()+"\r\n";
			fw.write(str);
		}

		fw.close();
	}

	public static int inputScore(Scanner sc,String name)
	{
		int score = 0;
		while(true)
		{
			System.out.println(name);
			score = sc.nextInt();
			if(score >=0 && score <=100)
				break;
		}
		return score;
	}

	public static void init(ArrayList<Student> list) throws NumberFormatException, IOException
	{
		File f = new File("ScoreMake.txt"); 
		if(f.exists()) 
		{ 
			list.clear(); 
			FileReader fr = new FileReader("ScoreMake.txt"); 
			BufferedReader reader1 = new BufferedReader(fr); 
			String line1; 
			String[] splitLine1 = null; 
			while((line1=reader1.readLine()) != null) 
			{ 
				splitLine1 = line1.split("\t\t");
				if(!splitLine1[1].equals("국어"))
				{
					Student s = new Student(splitLine1[0], Integer.parseInt(splitLine1[1]),Integer.parseInt(splitLine1[2]), Integer.parseInt(splitLine1[3]), Integer.parseInt(splitLine1[4]));
					s.setRank(Integer.parseInt(splitLine1[6]));
					list.add(s);
				}
			} 

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		ArrayList<Student> list = new ArrayList<Student>();
		//파일에 있는 내용을 추가해주는 작업 필요
		//만약 파일이 없으면 자동으로 생성을 해줌
		init(list);
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.print("1. 입력 2. 조회 3. 삭제 4. 종료 : ");
			int sel = sc.nextInt();
			if(sel == 1)
			{
				System.out.print("이름 : ");
				String name = sc.next();
				Student s = new Student(name,inputScore(sc, "국어 :"),inputScore(sc, "영어 :"),
						inputScore(sc, "수학 :"),inputScore(sc, "컴퓨터 :"));

				list.add(s);

				Collections.sort(list, new Rank());

				for(int i =0;i<list.size();i++)
				{
					list.get(i).setRank(i+1);
				}

				//파일을 다시 업로드 시켜야함
				writeText(list);

			}
			else if(sel == 2)
			{
				System.out.print("1. 전체조회 2. 선택조회");
				int select = sc.nextInt();
				if(select == 1)
				{
					for(int i =0;i<list.size();i++)
					{
						list.get(i).print();
					}
				}
				else if(select == 2)
				{
					System.out.println("이름 : ");
					String name = sc.next();
					int i;
					for(i =0;i<list.size();i++)
					{
						if(list.get(i).getName().equals(name))
						{
							list.get(i).print();
							break;
						}
					}
					if(i == list.size())
					{
						System.out.println("찾는 사람이 없습니다.");
					}
				}
				else
				{
					System.out.println("잘못된 입력입니다.");
				}
			}
			else if(sel == 3)
			{
				System.out.println("이름 : ");
				String name = sc.next();
				int i;
				for(i =0;i<list.size();i++)
				{
					if(list.get(i).getName().equals(name))
					{
						System.out.println(list.get(i).getName()+"을 삭제합니다.");
						list.remove(i);

						break;
					}
				}
				if(i == list.size())
				{
					System.out.println("찾는 사람이 없습니다.");
				}
				else
				{
					for(int j =0;j<list.size();j++)
					{
						list.get(j).setRank(j+1);
					}
					//파일 업로드 작업 실행
					writeText(list);
				}
			}
			else if(sel == 4)
			{
				System.out.println("프로그램 종료를 합니다.");
				break;
			}
			else
			{
				System.out.println("잘못된 입력입니다.");
			}

		}

	}

}
