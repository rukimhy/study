package academy.day8;

public class Q16_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arrSize = 5;
		int[][] arr = new int[arrSize][arrSize];

		int R = 0; // ��
		int C = -1; // ��
		int K = arrSize; // �ݺ�Ƚ��
		int SW = 1; // ����
		int N = 1; // ��

		/* ������ ����� */
		while (true) {

			for (int i = 0; i < K; i++) { // ����� ����ȭ
				C += SW;
				arr[R][C] = N++;
			}
			K--;
			if (K == 0)
				break;

			for (int j = 0; j < K; j++) { // ������ �ຯȭ
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
