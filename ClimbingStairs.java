public class ClimbingStairs{
	
	
	public static void main(String[] args){
		ClimbingStairs cs = new ClimbingStairs();
		int n = 43;
		int ways = cs.climbStairs(n);
		System.out.println(ways);
	}
	
	public int climbStairs(int n){
		if(n<3){
			return n;
		}
		/*
		else{
			return (climbStairs(n-1)+climbStairs(n-2));
		}
		*/
		int from_1_before = 2;
		int from_2_before = 1;
		int at_i = 0;
		
		for(int i=3;i<=n;i++){
			at_i = from_1_before+from_2_before;
			from_2_before = from_1_before;
			from_1_before = at_i;
		}
		
		return at_i;
	}
}

/*
70. Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct 
ways can you climb to the top?
*/