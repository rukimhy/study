package academy.day26;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner stdin = new Scanner(System.in);
		String source = "�ȳ��ϼ���. ��õ�����ɷ°��߿� �Դϴ�.";
		String s = stdin.next();
		FileWriter fw = new FileWriter(s);
		fw.write(source);
		fw.close();
		System.out.print(s + "������ �����Ǿ����ϴ�.");
	}

}
