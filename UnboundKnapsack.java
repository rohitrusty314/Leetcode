import java.util.*;


public class UnboundKnapsack{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		System.out.println("Test cases # "+t);
		int[] res = new int[t];
		
		for(int i=0;i<t;i++){
			int n = scanner.nextInt();
			int w = scanner.nextInt();
			int[] values = new int[n];
			int[] weights = new int[n];
			
			for(int j=0;j<n;j++)
				values[j] = scanner.nextInt();
			
			for(int j=0;j<n;j++)
				weights[j] = scanner.nextInt();
			
			
			res[i] = getMaxPossibleValue(values, weights, n, w);
		}
		
		for(int i=0;i<t;i++) System.out.println(res[i]);
		
	}
	
	private static int getMaxPossibleValue(int[] values, int[] weights, int n, int w){
		int[] c = new int[w+1];
		
		c[0] = 0;
		
		for(int i=1;i<=w;i++){
			int max = -1;
			
			for(int j=0;j<n;j++){
				if(weights[j] <= i){
					int temp = values[j] + c[i-weights[j]];
					if(temp > max) max = temp;
				}
			}
			System.out.println(max);
			c[i] = max;
		}
		
		return c[w];
	}
}