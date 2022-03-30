package day8;

public class Q17_2dArr4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		int count = 1;
		int i, j, x, y;
		i=0;
		j=2;
		
		while(true) 
		{
			x = i;
			y = j;
			
			arr[i][j] = count;
			if(i == 4 && j == 2) break;
			count++;
					
			i--;
			j++;
			
			if(i == -1) i = 4;
			if(j == 5) j = 0;
			if(i == 5) i = 0;
			
			if(arr[i][j] != 0) 
			{
				i = x+1;
				j = y;
			}
		}
		
		// Ãâ·Â
		for(int a=0; a<5; a++) 
		{
			for(int b=0; b<5; b++) 
			{
				System.out.printf("%d\t", arr[a][b]);
			}
			System.out.println();
		}
		
	}
}
