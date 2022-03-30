package day26;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner stdin = new Scanner(System.in);
		String source = "안녕하세요. 인천직업능력개발원 입니다.";
		String s = stdin.next();
		FileWriter fw = new FileWriter(s);
		fw.write(source);
		fw.close();
		System.out.print(s + "파일이 생성되었습니다.");
	}

}
