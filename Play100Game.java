import java.util.*;

public class Play100Game{
	public static void main(String[] args){
		Play100Game pg = new Play100Game();
		
		int maxChoosableInteger = 18;
		int desiredTotal = 79;
		boolean won = pg.canIWin(maxChoosableInteger,desiredTotal);
		
		System.out.println(won);
	}
	
	public boolean canIWin(int maxChoosableInteger,int desiredTotal){
		boolean won = false;
		
		Stack<Integer> p1moves = new Stack<Integer>();
		Stack<Integer> p2moves = new Stack<Integer>();
		
		int[] chooseFrom = new int[maxChoosableInteger];
		int max1 = 0, max2 = 0,i,j,rem=0,k = maxChoosableInteger-1,l;
		int m = maxChoosableInteger-1;
		int max3 = 0,rem2=0;
		
		if(desiredTotal == 0)
			return true;
		
		while(desiredTotal > 0 && !won){
			rem=0;
			max2 = 0;
			rem2 = 0;
			//k = maxChoosableInteger-1;
			k = Math.max(k,m);
			m = k;
			
			
			while((rem<=max2||rem2<=max3) && k>=0){
				System.out.println("\n");
				i = maxAtNow(chooseFrom,k);
				chooseFrom[i] = -1;
				max1 = i+1;
			
				j = maxAtNow(chooseFrom, m);
				chooseFrom[j] = -1;
				max2 = j+1;
			
			
				rem = desiredTotal - max1;
				System.out.print("i: ");
				System.out.print(i+1);
				System.out.print(" j: ");
				System.out.print(j+1);
				System.out.print(" rem: ");
				System.out.print(rem);
				System.out.print(" dt: "+desiredTotal);

				//P1 wins
				if(rem<=0){
					break;
				}
				if(rem <= max2){
					System.out.println("\nhere");
					chooseFrom[i] = 0;
					chooseFrom[j] = 0;
					k--;
				}
				
				l = maxAtNow(chooseFrom, k);
				System.out.print(" l: ");
				System.out.print(l+1);
				max3 = l+1;
				
				rem2 = rem - max2;
				//If Player 2 has won
				//Let's try change player 1's moves and
				//try to force a win
				
				if(rem2<=0 && max1==1){
					break;
				}
				
				if(rem2 <= max3){
					//System.out.println("here2");
					chooseFrom[i] = 0;
					chooseFrom[j] = 0;
					m--;
				}
				
				System.out.print(" rem2: ");
				System.out.print(rem2);
				
				
				//chooseFrom[l] = -1;
				//max2 = l+1;
			}
			System.out.println("\nbreak");
			//System.out.println(max1);
			//System.out.println(max2);
			//System.out.println(rem);
			
			p1moves.push(max1);
			p2moves.push(max2);
			
			System.out.println(p1moves);
			System.out.println(p2moves);
			
			
			desiredTotal -= max1;
			if(desiredTotal <= 0){
				won = true;
			}
			desiredTotal -= max2;
		}
		return won;
	}
	
	
	public int maxAtNow(int[] chooseFrom,int from){
		for(int i=from;i>=0;i--){
			if(chooseFrom[i] != -1){
				return i;
			}
		}
		return 0;	
			
	}
}

/*
464. Can I Win

In the "100 game," two players take turns adding, to a running total, any integer from 1..10. 
The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 
1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the 
first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal 
will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.
*/