package academy.day3;

public class Q6_makingStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-------------------");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-------------------");

		for (int i = 0; i < 5; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-------------------");

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}

			if (i >= 1) {
				for (int j = 0; j < (2 * i) + 1; j++) {
					System.out.print("*");
				}
			} else {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
