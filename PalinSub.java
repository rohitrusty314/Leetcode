public class PalinSub{
	public static void main(String[] args){
		//String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String str = "babad";
		//String str = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
		System.out.println(str);
		/*
		StringBuilder sb = new StringBuilder(str); 
		String s = sb.reverse().toString();
		System.out.println(s);
		*/
		System.out.println(str.length());
		String palin = longestPalindrome(str);
		System.out.println(palin);
		System.out.println(palin.length());
	}
	
	public static String longestPalindrome(String s){
		//System.out.println(s);
		if(s.length()==1)
			return s;
		String palin = "";
		//System.out.println(palin.length());
		for(int i=0;i<s.length();i++){
			for(int j=s.length()-1;j>i;j--){
				if(s.charAt(i)==s.charAt(j)){
					//System.out.print(i+" "+j);
					//System.out.println("\n");
					//String sub_str = s.substring(i,j+1);
					if(isPalindrome(s,i,j)){
						String new_palin = s.substring(i,j+1);
						//System.out.println(new_palin);
						if(palin.length()<new_palin.length())
							palin = new_palin;
					}
				}
				
			}
			if(palin.length()==s.length()-i)
				break;
		}
		if(palin.length()==0)
			return s.substring(0,1);
		return palin;
	}
	
	public static boolean isPalindrome(String s,int i,int j){
		
		/*StringBuilder sb = new StringBuilder(s); 
		String rs = sb.reverse().toString();
		//System.out.println(rs);
		if(s.compareTo(rs)==0){
			//System.out.println("jd");
			return true;
		}
			
		return false;
		*/
		
		for(int k=i,l=j;l-k>0;k++,l--){
			if(s.charAt(k)!=s.charAt(l))
				return false;
		}
		return true;
		
	}
}

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/