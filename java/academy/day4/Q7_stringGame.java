package day4;

import java.util.Random;
import java.util.Scanner;

public class Q7_stringGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* ���ڿ� ������ "��õ�����ɷ°��߿�" 
		 * ���� �̿��ؼ� ���� �ϳ� �����ؼ� ��ǻ�Ͱ� ������ �ִ´�.
		 * ������ ���ڸ� �Է��ؼ� ���� ������ ������ �մϴ�.
		 * ������ ������ ��ǻ�Ͱ� ������ �ִ� ���ڿ� �� ���� �õ����� ���������� ���
		 * ��õ�����ɷ°��߿� ���ڰ� �ƴϸ� �õ� Ƚ���� ���Ե��� ����
		 */
		
		String str = "��õ�����ɷ°��߿�";
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		int cpu_r = r.nextInt(9); // 0~8
		char cpu_char = str.charAt(cpu_r);
		int usr_count = 0;
		
		System.out.println("----------------------------------------");
		System.out.println("��ǻ�Ϳ� �ϴ� ���� ���߱� �����Դϴ�.");
		System.out.println("[��.õ.��.��.��.��.��.��.��] �� ������ ���߼���.");
		System.out.println("----------------------------------------");
		
		while(true) 
		{
			System.out.print("�����ϴ� ���� �Է����ּ��� : ");
			char choice = scan.next().charAt(0);
			
			if(!(choice == '��' || choice == 'õ' || choice == '��' || choice == '��' || choice == '��' || choice == '��' || choice == '��' || choice == '��' || choice == '��')) 
			{
				System.out.println("�߸��� �Է��Դϴ�.");
			} 
			else 
			{
				if(choice != cpu_char) 
				{
					System.out.println("������ �ƴմϴ�!");
					usr_count++;
				} 
				else 
				{
					System.out.println("���ϵ帳�ϴ�. �����Դϴ�!");
					System.out.println("���� : "+ cpu_char);
					System.out.println("Ʋ�� Ƚ�� : "+ usr_count);
					break;
				}
			}
		}
	}
}
