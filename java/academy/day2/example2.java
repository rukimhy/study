package academy.day2;

import java.util.Random;
import java.util.Scanner;

public class example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "Hello";

		if (a == "Hello") {
			System.out.println("asd");
		}

		if (a.equals("Hello")) {
			System.out.println("asd");
		}

		Random r = new Random();

		int num = r.nextInt(10); // 0~9
		int num1 = r.nextInt(10) + 1; // 1~10

	}

}
