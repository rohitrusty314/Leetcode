import java.util.*;

public class OnesAndZeros{
	public static void main(String[] args){
		//String[] strs = {"10","0001","111001","1","0"};
		String[] strs = {"0","11","1000","01","0","101","1","1","1","0","0","0","0","1","0","0110101","0","11","01","00","01111","0011","1","1000","0","11101","1","0","10","0111"};

		int m = 9,n = 80;
		int max = findMaxForm(strs,m,n);
		System.out.println(max);
	}
	
	public static int findMaxForm(String[] strs, int m, int n){
		int q = 0;
		if(strs.length == 0) return 0;
		
		if(possible(strs[0],m,n)){
			
			int newm = bincount(strs[0],'0');
			int newn = bincount(strs[0],'1');
			
			int countInc = 1 + findMaxForm(Arrays.copyOfRange(strs,1,strs.length),m-newm,n-newn);
			int countEx = findMaxForm(Arrays.copyOfRange(strs,1,strs.length),m,n);
			
			q = Math.max(countInc, countEx);
			
			
		}
		else
			q = findMaxForm(Arrays.copyOfRange(strs,1,strs.length),m,n);
		
		return q;
	}

	public static int bincount(String str, char bin){
		int count = 0;
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)==bin) count++;
		return count;
	}
	
	public static boolean possible(String str, int m, int n){
		if(str.length() > m + n) return false;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='0') m--;
			else if(str.charAt(i)=='1') n--;
		}
		if(m<0 || n<0) return false;
		return true;
	}
}
/*
In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.


*/