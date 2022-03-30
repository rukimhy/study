package day7;

public class Q14_2dArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		int count = 1;
		
		for(int i=0; i<5; i++) 
		{
			for(int j=0; j<5; j++) 
			{
				arr[i][j] = count;
				count++;
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i == 0 || i == 1) {
					if(i == 1 && j == 4) System.out.print(arr[i][j]+" ");
					else System.out.print(" "+arr[i][j]+" ");
				}
				else System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}