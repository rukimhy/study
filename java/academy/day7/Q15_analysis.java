package day7;

public class Q15_analysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = new int[5][5];
		int R, C, TR, START, END, SW, K;

		TR = 0; // tmp라고 봐도 좋은 값. START와 END값을 바꿔주기 위한 역할을 한다.
		START = 0; // 반복문에서 시작값
		END=4; // START를 4로 바꿔주기 위한 값
		SW=1; // 음수 또는 양수로 전환되어 반복문에서 C++ 또는 C--로 역할을 한다.
		K=0; // count 해주는 역할
		
		// 숫자를 입력하는 반복문 [R][C]
		for(R=0; R!=5; R++) //R은 0부터 4까지
		{
			for(C=START; C!=(END+SW); C+=SW) // C는 1과 4를 반복한다 // C=1 일 때 4까지, C=4 일 때 0까지 // SW가 +1일 경우 순차진행, SW가 -1일 경우 역진행
			{
				K++;
				array[R][C] = K;
			}
			
			// START와 END값을 바꾼다.
			TR = START;
			START = END;
			END = TR;
			
			SW = SW*(-1); // SW가 음수 또는 양수로 전환
		}

		// 숫자 출력해주는 반복문
		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.printf("%d\t",array[i][j]);
			}
			System.out.println();
		}
	}

}
