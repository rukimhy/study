package day3;

import java.util.Scanner;

public class Q4_99dan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 전체 출력 2. 단입력 3. 종료
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("9x9단을 출력하는 프로그램입니다.");
			System.out.println("1. 전체 출력");
			System.out.println("2. 단 입력");
			System.out.println("3. 종료");
			System.out.print("메뉴를 선택해주세요 : ");
			int choice = scan.nextInt();
			
			if(!(choice == 1 || choice == 2 || choice == 3)) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("--------------");
				//continue;
			} else {
				if(choice == 1) {
					for(int i = 2; i <= 9; i++) {
						for(int j = 1; j <= 9; j++) {
							System.out.println(i + "X" + j + "=" + i*j);
						}
						System.out.println();
					}
				} else if(choice == 2) {
					System.out.print("단을 입력해주세요 : ");
					int num = scan.nextInt();
					
					if(!(num>=2 && num <=9)) {
						System.out.println("잘못된 입력입니다.");
						//continue;
					} else {
						int i = num;
						for(int j = 1; j<=9; j++) {
							System.out.println(i + "X" + j + "=" + i*j);
						}
						System.out.println();
						
					}
				} else {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}
				
		}

	}

}
