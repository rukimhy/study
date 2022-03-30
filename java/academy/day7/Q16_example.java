package day7;

public class Q16_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = new int[5][5];
		int C, D, TR, START, END, TMP, count;
		TR = 1;
		START = 0;
		END = 1;
		count = 1;
		
		//첫번째 행
		for(C = START; C != END; C+=TR) {
			for(D = 0; D != 5; D++) {
				arr[C][D] = count;
				count++;
			}
		}
		
		//마지막 열
		START = 1;
		END = 4;
		for(C = START; C != 5; C++) {
			for(D = END; D == END; D++) {
				arr[C][D] = count;
				count++;
			}
		}
		
		//마지막 행
		START = 4;
		END = 3;
		TR = -1;
		for(C = START, D = END; D != -1; D+=TR) {
			arr[C][D] = count;
			count++;
		}
		
		//첫번째 열
		START = 3;
		END = 0;
		for(C=START, D=END; C != 0; C+=TR) {
			arr[C][D] = count;
			count++;
		}
		
		//두번째 행
		START = 1;
		END = 1;
		TR = 1;
		for(C=START, D=END; D != 4; D+=TR) {
			arr[C][D] = count;
			count++;
		}
		
		//네번째 열
		START = 2;
		END = 3;
		for(C=START, D=END; C != 4; C+=TR) {
			arr[C][D] = count;
			count++;
		}
		
		//네번째 행
		START = 3;
		END = 2;
		TR = -1;
		for(C=START, D=END; D != 0; D+=TR) {
			arr[C][D] = count;
			count++;
		}
		
		//마지막
		START = 2;
		END = 1;
		TR = 1;
		for(C=START, D=END; D!=3; D+=TR) {
			arr[C][D] = count;
			count++;
		}
		
		
		//출력
		for(C=0; C != 5; C++) {
			for(D=0; D != 5; D++) {
				System.out.printf("%d\t", arr[C][D]);
			}
			System.out.println();
		}
	}

}
