package academy.day6;

import java.util.Random;
import java.util.Scanner;

public class Q5_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = ""; // ���ڿ���ü ���� ���� �̸��� str �̰� �ʱⰪ�� �ƹ����ڿ��� ����.
		Random r = new Random();// Random��ü�� �����Ҷ� ������ �̸��� r�̴�.
		Scanner sc = new Scanner(System.in);
		while (true)// ���ѹݺ�
		{
			int ran = r.nextInt(26) + 65;
			// ������ ���� ran ����� ���������� 0~25������ �����Ͽ���
			// 65�� ���� ���� ran ������ �ʱⰪ���� �����Ѵ�.
			if ((char) ran == 'Q')
			// ran ������ ��������ȯ�� �Ͽ��� ���� 'Q'�� �񱳸� �ؼ� ���̸� �Ʒ� ���ɾ� ����
			{
				break;// ���� ����� �ݺ���Ż���Ѵ�.
			} else// ���� if�� ������ �����̸� �����Ѵ�.
			{
				str += (char) ran;
				// ���ڿ� ���ϱ⿬���� �ϴµ� ran������ char������ ��������ȯ�� ����
				// str���ڿ� ������ �߰��Ѵ�.
			}
		}
		System.out.println(str);// ���ڿ� ���� str�� ���� ����Ѵ�.

		System.out.print("���� �Է� : ");
		char ch = sc.next().charAt(0);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (ch == str.charAt(i)) {
				count++;
			}
		}

		System.out.println(ch + "�� �� ������ " + count + "�Դϴ�.");

	}

}
