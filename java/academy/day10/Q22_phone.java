package academy.day10;

import java.util.Scanner;

public class Q22_phone {

	public static void numToAlpha(char str_i, int count, char[][] alphabet_arr) {
		if (str_i == '2') {
			if (count == 3) {
				count = 2;
			}
			System.out.print(alphabet_arr[0][count]);
		} else if (str_i == '3') {
			if (count == 3) {
				count = 2;
			}
			System.out.print(alphabet_arr[1][count]);
		} else if (str_i == '4') {
			if (count == 3) {
				count = 2;
			}
			System.out.print(alphabet_arr[2][count]);
		} else if (str_i == '5') {
			if (count == 3) {
				count = 2;
			}
			System.out.print(alphabet_arr[3][count]);
		} else if (str_i == '6') {
			if (count == 3) {
				count = 2;
			}
			System.out.print(alphabet_arr[4][count]);
		} else if (str_i == '7') {
			System.out.print(alphabet_arr[5][count]);
		} else if (str_i == '8') {
			if (count == 3) {
				count = 2;
			}
			System.out.print(alphabet_arr[6][count]);
		} else if (str_i == '9') {
			System.out.print(alphabet_arr[7][count]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���ڿ��� int������ �ٲٴ� ��� : int a = Integer.parseInt(str);
		/*
		 * #, *, 0, 1�� �״�� ���
		 * 2(ABC) 3(DEF) 4(GHI) 5(JKL) 6(MNO) 7(PQRS) 8(TUV) 9(WXYZ)
		 * 77884448 (QUIT) ���� ����
		 * �Լ� 2�� �̻� ���
		 */
		Scanner scan = new Scanner(System.in);

		char[][] alphabet_arr = { { 'A', 'B', 'C' }, { 'D', 'E', 'F' },
				{ 'G', 'H', 'I' }, { 'J', 'K', 'L' }, { 'M', 'N', 'O' },
				{ 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y', 'Z' } };

		while (true) {
			System.out.print("0~9, *, # �߿��� �Է��Ͻÿ� : ");
			String str = scan.next();

			int pass_count = 0;

			if (str.equals("77884448")) {
				System.out.println("QUIT = ���α׷� ����");
				break;
			}

			for (int i = 0; i < str.length(); i++) {
				char str_i = str.charAt(i);
				int count = 0;

				if (pass_count == 2 || pass_count == 1 || pass_count == 3) {
					pass_count--;
					continue;
				}

				if (str_i == '#' || str_i == '*' || str_i == '0' || str_i == '1')
					System.out.print(str_i);
				else {
					if (str.length() == 1) {
						numToAlpha(str_i, count, alphabet_arr);
						break;
					} else if (str.length() == 2) {
						if (str_i == str.charAt(i + 1)) {
							pass_count = 1;
							count = 1;
						}

						numToAlpha(str_i, count, alphabet_arr);
						continue;
					} else if (str.length() == 3) {
						if (str_i == str.charAt(i + 1) && str_i == str.charAt(i + 2)) {
							pass_count = 2;
							count = 2;
						}

						numToAlpha(str_i, count, alphabet_arr);
						continue;
					} else if (i + 3 >= str.length() || i + 2 >= str.length() || i + 1 >= str.length()) {
						if (i + 1 >= str.length()) {
							count = 0;
						} else if (i + 2 >= str.length()) {
							if (str_i == str.charAt(i + 1)) {
								count = 1;
								pass_count = 1;
							} else {
								count = 0;
							}
						} else {
							if (str_i == str.charAt(i + 1) && str_i == str.charAt(i + 2)) {
								pass_count = 2;
								count = 2;
							} else if (str_i == str.charAt(i + 1)) {
								pass_count = 1;
								count = 1;
							} else {
								count = 0;
							}
						}
					} else {
						if (str_i == str.charAt(i + 1) && str_i == str.charAt(i + 2) && str_i == str.charAt(i + 3)) {
							pass_count = 3;
							count = 3;
						} else if (str_i == str.charAt(i + 1) && str_i == str.charAt(i + 2)) {
							pass_count = 2;
							count = 2;
						} else if (str_i == str.charAt(i + 1)) {
							pass_count = 1;
							count = 1;
						}
					}
					numToAlpha(str_i, count, alphabet_arr);

					if (str_i == 2 || str_i == 3 || str_i == 4 || str_i == 5 || str_i == 6 || str_i == 8) {
						if (pass_count == 3)
							pass_count = 2;
					}
				} // else�� ��

			} // for�� ��
			System.out.println();

		} // while�� ��
	}
}