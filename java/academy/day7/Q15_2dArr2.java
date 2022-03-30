package day7;

public class Q15_2dArr2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		int count = 1;
		
		// 숫자 입력
		for(int i=0; i<5; i++) 
		{
			if(i%2 == 0) 
			{
				for(int j=0; j<5; j++) 
				{
					arr[i][j] = count;
					count++;
				}
			}
			else 
			{
				for(int j=4; j>=0; j--) 
				{
					arr[i][j] = count;
					count++;
				}
			}
		}
		
		// 숫자 출력
		for(int i=0; i<5; i++) 
		{
			for(int j=0; j<5; j++) 
			{
				if(i == 0 || i == 1) 
				{
					if(i == 1 && j == 0) System.out.print(arr[i][j]+" ");
					else System.out.print(" "+arr[i][j]+" ");
				}
				else System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
