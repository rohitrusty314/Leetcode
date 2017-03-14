import java.io.*;
import java.util.*;

public class Padovan{
	public static void main(String[] args){
		Padovan p = new Padovan();
		//String input = p.getInput();
		//System.out.println(input);
		Scanner s = new Scanner(System.in);
		//int cases = s.nextInt();
		int tests = s.nextInt();
		int[] output = new int[tests];
		
		for(int i=0;i<tests;i++){
			int n = s.nextInt();
			
			HashMap<Integer,Long> memo = new HashMap<Integer,Long>();
			output[i] = p.padovan(memo,n);
			//System.out.println("target: "+n);
			//System.out.println("nth Padovan number: "+output[i]);
			
		}
		for(int i=0;i<tests;i++){
			System.out.println(output[i]);
		}
	}
	
	public int padovan(HashMap<Integer,Long> memo,int n){
		long p;
		if(n<=2){
			return 1;
		}
		else if(memo.containsKey(n)){
			return (int)(memo.get(n)%1000000007);
		}
		else{
			p = padovan(memo,n-2) + padovan(memo,n-3);
			memo.put(n,p);
		}
		return (int)p%1000000007;
	}
	
	public String getInput(){
		String input = null;
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			//System.out.println("Enter something: ");
			input = is.readLine();
		} catch (IOException e){
			System.out.println("IOException: "+e);
		}
		return input;
	}
}

/*
A Padovan Sequence is a sequence which is represented by the following recurrence
P(n) = P(n-2) + P(n-3)
P(0) = P(1) = P(2) = 1
Now given a number N your task is to find the Nth no in this sequence.

Note: Since the output could be very long take mod 1000000007
 

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each line contains an integer N.

Output:
For each test case in a new line print the nth no of the Padovan sequence.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
12
4
Output:
21
2
*/