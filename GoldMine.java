import java.util.*;

public class GoldMine{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		//System.out.println("# of test cases: "+t);
		int[] res = new int[t];
		
		for(int l=0;l<t;l++){
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int[][] goldField = new int[m][n];
			
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					goldField[i][j] = scanner.nextInt();
				}
			}
			
			res[l] = mineThisField(goldField,m,n);
		}
		
		for(int l=0;l<t;l++)
			System.out.println(res[l]);
	}
	
	private static int mineThisField(int[][] goldMine, int m, int n){
		//int[] res = new int[m];
		int fromLeftUp, fromLeft, fromLeftDown;
		
		for(int i=0;i<m;i++)
			res[i] = goldMine[i][0];
		
		for(int j=1;j<n;j++){
			for(int i=0;i<m;i++){
				if(i==0) 
					fromLeftUp = -1;
				else
					fromLeftUp = goldMine[i][j] + goldMine[i-1][j-1];
				
				if(i==m-1)
					fromLeftDown = -1;
				else
					fromLeftDown = goldMine[i][j] + goldMine[i+1][j-1];
				
				fromLeft = goldMine[i][j] + goldMine[i][j-1];
				
				res[i] = Math.max(fromLeft,Math.max(fromLeftDown, fromLeftUp));
			}
			
			for(int i=0;i<m;i++) goldMine[i][j] = res[i];
		}
		
		int max = -1;
		for(int i=0;i<m;i++)
			if(goldMine[i][n-1] > max) max = goldMine[i][n-1];
		
		
		return max;
	}
}