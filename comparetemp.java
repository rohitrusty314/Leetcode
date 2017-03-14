public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean won = false;
		int[] chooseFrom = new int[maxChoosableInteger];
		
		Stack<Integer> p1moves = new Stack<Integer>();
		Stack<Integer> p2moves = new Stack<Integer>();
		
		//start picking from max possible
		int p1counter = maxChoosableInteger-1;
		int p2counter = maxChoosableInteger-1;
		int p1,p2,player1=0,player2=0,target,p2min,nextPmove;
		
		
		if(desiredTotal==0)
			return true;
		
		while(desiredTotal>0 && !won){
			p1counter = maxChoosableInteger-1;
			p2counter = maxChoosableInteger-1;
			
			//System.out.println("\n\nFind Player1's best move");
			do{
				p1 = maxAtNow(chooseFrom,p1counter);
				
				if(p1==-1){
					p1moves.push(player1);
					break;
				}
				
				chooseFrom[p1] = -1;
				player1 = p1+1;
				//System.out.println("Player1: "+player1);
		
				target = desiredTotal - player1;
				//System.out.println(target);
				//p2min = minAtNow(chooseFrom)+1;
				//System.out.println(p2min);

				p2 = maxAtNow(chooseFrom,maxChoosableInteger-1);
				//chooseFrom[p2] = -1;
				nextPmove = p2+1;
				//System.out.println("Player2: "+nextPmove);
			
				if(target<=0){
					//System.out.println("Player 1 wins");
					break;
				}
				else if(target<=nextPmove){
					//System.out.println("Need to decrement player1");
					//System.out.println("counter"+p1counter);
					chooseFrom[p1] = 0;
				
					if(p1counter==0 && !p1moves.empty()){
						int pla1 = p1moves.pop();
						int pla2 = p2moves.pop();
						desiredTotal = desiredTotal+pla1+pla2;
						chooseFrom[pla1-1] = 0;
						chooseFrom[pla2-1] = 0;
						int n = maxAtNow(chooseFrom,pla1-2);
						chooseFrom[n] = -1;
						player1 =  n+1;
						p1moves.push(player1);
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
					p1moves.push(player1);
				}

			}while(target<=nextPmove);
			
			desiredTotal -= player1;
		
			if(desiredTotal<=0){
				won = true;
				break;
			}
		
			//System.out.println("\n\nFind Player2's best move");
			do{
				p2 = maxAtNow(chooseFrom,p2counter);
				
				if(p2==-1){
					p2moves.push(player2);
					break;
				}
				chooseFrom[p2] = -1;
				player2 = p2+1;
				//System.out.println("Player2: "+player2);
		
				target = desiredTotal - player2;
				//System.out.println(target);
		
				p1 = maxAtNow(chooseFrom,maxChoosableInteger-1);
				//chooseFrom[p1] = -1;
				nextPmove = p1+1;
				//System.out.println("Player1: "+nextPmove);
		
				if(target<=0){
					//System.out.println("Player 2 wins");
					break;
				}
				else if(target<=nextPmove){
					//System.out.println("Need to decrement player2");
					//System.out.println("counter"+p2counter);
					chooseFrom[p2] = 0;
			
					if(p2counter==0 && !p2moves.empty()){
						//System.out.println("\nGo to previous move of Player2");
						int pla2 = p2moves.pop();
						int pla1 = p1moves.pop();
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
		
			desiredTotal -= player2;
		}
		return won;
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