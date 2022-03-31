package academy.day12;

import java.util.Random;

public class Q27_teacher {
	// ����
	static int random() {
		Random r = new Random();
		return r.nextInt(26) + 65;
	}

	// ���ڿ�
	static char print(int ran) {
		return (char) ran;
	}

	static String makeString(String str, char ch) {
		if (ch != 'Q') {
			return str += ch;
		} else {
			System.out.print(str + 'Q');
			return "";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "";
		while (true) {
			char ch = print(random());
			str = makeString(str, ch);
			if (str.equals("")) {
				break;
			}
		}

	}
}
