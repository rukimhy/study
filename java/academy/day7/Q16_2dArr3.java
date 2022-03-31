package academy.day7;

public class Q16_2dArr3 {

	public static void main(String[] args) {
		int arr[][] = new int[5][5];
		int C, D, TR, count;
		TR = 1;
		count = 1;

		// ù��° ��
		for (C = 0; C != 1; C += TR) {
			for (D = 0; D != 5; D += TR) {
				arr[C][D] = count;
				count++;
			}
		}

		// ������ ��
		for (C = 1; C != 5; C += TR) {
			for (D = 4; D == 4; D += TR) {
				arr[C][D] = count;
				count++;
			}
		}

		// ������ ��
		TR = -1;
		for (C = 4, D = 3; D != -1; D += TR) {
			arr[C][D] = count;
			count++;
		}

		// ù��° ��
		for (C = 3, D = 0; C != 0; C += TR) {
			arr[C][D] = count;
			count++;
		}

		// �ι�° ��
		TR = 1;
		for (C = 1, D = 1; D != 4; D += TR) {
			arr[C][D] = count;
			count++;
		}

		// �׹�° ��
		for (C = 2, D = 3; C != 4; C += TR) {
			arr[C][D] = count;
			count++;
		}

		// �׹�° ��
		TR = -1;
		for (C = 3, D = 2; D != 0; D += TR) {
			arr[C][D] = count;
			count++;
		}

		// ������
		TR = 1;
		for (C = 2, D = 1; D != 3; D += TR) {
			arr[C][D] = count;
			count++;
		}

		// ���
		for (C = 0; C != 5; C++) {
			for (D = 0; D != 5; D++) {
				System.out.printf("%d\t", arr[C][D]);
			}
			System.out.println();
		}
	}
}
