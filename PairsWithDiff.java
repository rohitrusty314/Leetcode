import java.io.*;
import java.util.*;

public class PairsWithDiff{
	public static void main(String[] args){
		PairsWithDiff p = new PairsWithDiff();
		
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		//System.out.println(tests);
		
		int[] output = new int[tests];
		
		for(int i=0;i<tests;i++){
			int n = s.nextInt();
			int[] a = new int[n];
			for(int j=0;j<n;j++){
				a[j] = s.nextInt();
			}
			int k = s.nextInt();
			output[i] = p.maxDiff(a,n,k);
		}
		
		for(int i=0;i<tests;i++){
			System.out.println(output[i]);
		}
	}
	
	public int maxDiff(int[] a,int n,int k){
		int sum = 0;
		Arrays.sort(a);
		for(int i=n-1;i>0;i--){
			//System.out.println(a[i]);
			if(a[i]-a[i-1]<k){
				sum += a[i]+a[i-1];
				i--;
			}
		}
		
		return sum;
	}
}

/*
Given an array of integers A[] and a number k.You can pair two number of array if difference between them is strictly less than k. 
The task is to find maximum possible sum of such disjoint pairs. Sum of P pairs is sum of all 2P numbers of pairs.

Examples:

Input  : A[] = {3, 5, 10, 15, 17, 12, 9}, K = 4
Output : 62
Then disjoint pairs with difference less than K are,
(3, 5), (10, 12), (15, 17)	
max sum which we can get is 3 + 5 + 10 + 12 + 15 + 17 = 62
Note that an alternate way to form disjoint pairs is,
(3, 5), (9, 12), (15, 17), but this pairing produces less sum.

Input  : A[] = {5, 15, 10, 300}, k = 12
Output : 25
Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains 3 lines . The first line of each test case is an integer N denoting the size of the array A. In the next line are N space separated values of the array A. In the next line is an integer x.


Output:
For each test case output in a new line the maximum possible sum of disjoint pairs

Constraints:
1<=T<100
1<=N<=100
1<=A[] <=1000

Example:
Input:
2
7
3 5 10 15 17 12 9
4
4
5 15 10 300
12

Output:
62
25
*/