package academy.day2;

public class ImplicitConversion {

	public static void main(String[] args) {

		byte bNum = 10;
		int iNum = bNum;

		System.out.println("bNum = " + bNum);
		System.out.println("iNum = " + iNum);

		int iNum2 = 20;
		float fNum = iNum2;

		System.out.println("iNum2 = " + iNum2);
		System.out.println("fNum = " + fNum);

		double dNum;
		dNum = fNum + iNum;
		System.out.println("dNum = " + dNum);

	}

}
