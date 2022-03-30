package day8;

public class Q16_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arrSize = 5;
		int[][] arr = new int[arrSize][arrSize];

		int R = 0; // 행
		int C = -1; // 열
		int K = arrSize; // 반복횟수
		int SW = 1; // 증감
		int N = 1; // 값

		/* 달팽이 만들기 */
		while (true) {

			for (int i = 0; i < K; i++) { // 행고정 열변화
				C += SW;
				arr[R][C] = N++;
			}
			K--;
			if (K == 0)
				break;

			for (int j = 0; j < K; j++) { // 열고정 행변화
				R += SW;
				arr[R][C] = N++;
			}
			SW *= -1;

		}

		for (int i = 0; i < arrSize; i++) {
			for (int j = 0; j < arrSize; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println();
		}
	}

}
