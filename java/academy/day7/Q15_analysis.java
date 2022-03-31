package academy.day7;

public class Q15_analysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = new int[5][5];
		int R, C, TR, START, END, SW, K;

		TR = 0; // tmp��� ���� ���� ��. START�� END���� �ٲ��ֱ� ���� ������ �Ѵ�.
		START = 0; // �ݺ������� ���۰�
		END = 4; // START�� 4�� �ٲ��ֱ� ���� ��
		SW = 1; // ���� �Ǵ� ����� ��ȯ�Ǿ� �ݺ������� C++ �Ǵ� C--�� ������ �Ѵ�.
		K = 0; // count ���ִ� ����

		// ���ڸ� �Է��ϴ� �ݺ��� [R][C]
		for (R = 0; R != 5; R++) // R�� 0���� 4����
		{
			for (C = START; C != (END + SW); C += SW) // C�� 1�� 4�� �ݺ��Ѵ� // C=1 �� �� 4����, C=4 �� �� 0���� // SW��
														// +1�� ��� ��������, SW�� -1�� ��� ������
			{
				K++;
				array[R][C] = K;
			}

			// START�� END���� �ٲ۴�.
			TR = START;
			START = END;
			END = TR;

			SW = SW * (-1); // SW�� ���� �Ǵ� ����� ��ȯ
		}

		// ���� ������ִ� �ݺ���
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%d\t", array[i][j]);
			}
			System.out.println();
		}
	}

}
