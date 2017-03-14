public class PalindromeNum{
	public static void main(String[] args){
		int num = -2147447412;
		boolean isIt = isPalindrome(num);
		System.out.println(isIt);
	}
	
	public static boolean isPalindrome(int x){
		return ((Integer.toString(x)).compareTo((new StringBuilder(Integer.toString(x))).reverse().toString())==0);
	}
}

/*
Determine whether an integer is a palindrome. 
Do this without extra space.
*/