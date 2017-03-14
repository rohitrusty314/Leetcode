import java.util.*;

public class Play100Again{
	public static void main(String[] args){
		Play100Again pg = new Play100Again();
		
		int maxChoosableInteger = 3;
		int desiredTotal = 79;
		System.out.println(maxChoosableInteger+1);
		System.out.println(1<<maxChoosableInteger+1);
		System.out.println((1<<maxChoosableInteger+1)-1);
		/*boolean won1 = pg.canIWin(maxChoosableInteger,desiredTotal);
		System.out.println(won1);
		System.out.println("-----------------------------------------------------------------------");
		
		maxChoosableInteger = 18;
		desiredTotal = 188;
		boolean won2 = pg.canIWin(maxChoosableInteger,desiredTotal);
		
		System.out.println(won2);
		
		System.out.println("-----------------------------------------------------------------------");
		
		maxChoosableInteger = 16;
		desiredTotal = 100;
		boolean won3 = pg.canIWin(maxChoosableInteger,desiredTotal);
		System.out.println(won1);
		System.out.println(won2);
		System.out.println(won3);*/
		
	}
	
	public boolean canIWin(int maxChoosableInteger, int desiredTotal){
		boolean won = false;
		int[] chooseFrom = new int[maxChoosableInteger];
		
		Stack<Integer> p1moves = new Stack<Integer>();
		Stack<Integer> p2moves = new Stack<Integer>();
		
		//start picking from max possible
		int p1counter = maxChoosableInteger-1;
		int p2counter = maxChoosableInteger-1;
		int p1,p2,player1=0,player2=0,target,p2min,nextPmove;
		
		
		int limit = (maxChoosableInteger*(maxChoosableInteger+1))/2;
		System.out.println(limit);
		if(limit<desiredTotal)
			return false;
		
		if(desiredTotal==0)
			return true;
		
		while(desiredTotal>0 && !won){
			p1counter = maxChoosableInteger-1;
			p2counter = maxChoosableInteger-1;
			
			System.out.println("\nLeft of target: "+desiredTotal);
			System.out.println("\nFind Player1's best move");
			do{
				p1 = maxAtNow(chooseFrom,p1counter);
				if(p1==-1){
					p1moves.push(player1);
					break;
				}
				chooseFrom[p1] = -1;
				player1 = p1+1;
				System.out.println("Player1: "+player1);
		
				target = desiredTotal - player1;
				//System.out.println(target);
				//p2min = minAtNow(chooseFrom)+1;
				//System.out.println(p2min);

				p2 = maxAtNow(chooseFrom,maxChoosableInteger-1);
				//chooseFrom[p2] = -1;
				nextPmove = p2+1;
				System.out.println("Player2: "+nextPmove);
			
				if(target<=0){
					System.out.println("Player 1 wins");
					break;
				}
				else if(target<=nextPmove){
					System.out.println("Need to decrement player1");
					System.out.println("counter"+p1counter);
					chooseFrom[p1] = 0;
					int min = minPnow(chooseFrom,maxChoosableInteger);
					
					if(p1counter==min && !p1moves.empty()){
						System.out.println("\nGo to previous move of Player1");
						int pla1 = p1moves.pop();
						int pla2 = p2moves.pop();
						desiredTotal = desiredTotal+pla1+pla2;
						chooseFrom[pla1-1] = 0;
						chooseFrom[pla2-1] = 0;
						int n = maxAtNow(chooseFrom,pla1-2);
						
						if(n==-1){
							if(!p1moves.empty()){
								System.out.print("\nP1 moves so far on n-1");
								System.out.println(p1moves);
								System.out.print("\nP2 moves so far n-1");
								System.out.println(p2moves);
								pla1 = p1moves.pop();
								pla2 = p2moves.pop();
								chooseFrom[pla1-1] = 0;
								chooseFrom[pla2-1] = 0;
								n = maxAtNow(chooseFrom,pla1-2);
								chooseFrom[n] = -1;
								player1 =  n+1;
								p1moves.push(player1);
								System.out.println("New Player1: "+player1);
								break;
							}
							else{
								return false;
							}
						}
						
						chooseFrom[n] = -1;
						player1 =  n+1;
						p1moves.push(player1);
						System.out.println("New Player1: "+player1);
						break;
						
					}
					else if(p1counter==0 && p1moves.empty()){
						break;
					}
					else{
						p1counter--;
					}				
				}
				else{
					System.out.println(player1+" New Push");
					
					p1moves.push(player1);
					System.out.print("\nP1 moves so far");
					System.out.println(p1moves);
				}

			}while(target<=nextPmove);
			
			desiredTotal -= player1;
		
			if(desiredTotal<=0){
				won = true;
				break;
			}
		
			System.out.println("\n\nFind Player2's best move");
			do{
				p2 = maxAtNow(chooseFrom,p2counter);
				
				if(p2==-1){
					p2moves.push(player2);
					break;
				}
				chooseFrom[p2] = -1;
				player2 = p2+1;
				System.out.println("Player2: "+player2);
		
				target = desiredTotal - player2;
				//System.out.println(target);
		
				p1 = maxAtNow(chooseFrom,maxChoosableInteger-1);
				//chooseFrom[p1] = -1;
				nextPmove = p1+1;
				System.out.println("Player1: "+nextPmove);
		
				if(target<=0){
					System.out.println("Player 2 wins");
					break;
				}
				else if(target<=nextPmove){
					System.out.println("Need to decrement player2");
					System.out.println("counter"+p2counter);
					chooseFrom[p2] = 0;
					int min = minPnow(chooseFrom,maxChoosableInteger);
					
					if(p2counter==min && !p2moves.empty()){
						System.out.println("\nGo to previous move of Player2");
						
						int pla1 = p1moves.pop();
						chooseFrom[pla1-1] = 0;
						/*
						if(!p1moves.empty()){
							pla1 = p1moves.pop();
							chooseFrom[pla1-1] = 0;
						}*/
						
						int pla2 = p2moves.pop();
						System.out.print("\nP1 moves so far ");
						System.out.println(p1moves);
						System.out.print("\nP2 moves so far ");
						System.out.println(p2moves);
						desiredTotal = desiredTotal+pla1+pla2;
						
						chooseFrom[pla2-1] = 0;
						int n = maxAtNow(chooseFrom,pla2-2);
						
						
						if(n==-1){
							return true;
						}
						chooseFrom[n] = -1;
						player2 =  n+1;
						p2moves.push(player2);
						System.out.println("New Player2: "+player2);
						break;
					}
					else if(p2counter==0 && p2moves.empty()){
						break;
					}
					else{
						p2counter--;
					}	
			
				}
				else{
					p2moves.push(player2);
				}
			}while(target<=nextPmove);
		
		
			System.out.println("\n\nThis round's score");
			System.out.println("Player1: "+player1);
			System.out.println("Player2: "+player2);
			System.out.print("\nP1 moves so far");
			System.out.println(p1moves);
			System.out.print("\nP2 moves so far");
			System.out.println(p2moves);
			
			desiredTotal -= player2;
		}
		return won;
	}
	
	public int minPnow(int[] chooseFrom,int maxChoosableInteger){
		for(int i=0;i<maxChoosableInteger;i++){
			if(chooseFrom[i]!=-1){
				return i;
			}
		}
		
		return -1;
		
	}
	
	public int maxAtNow(int[] chooseFrom,int from){
		for(int i=from;i>=0;i--){
			if(chooseFrom[i] != -1){
				return i;
			}
		}
		return -1;	
			
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