public class PalinSub2{
	public static void main(String[] args){
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		//String str = "dabbac";
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
		int i = s.length()/2;
		String po = null, pe = null;
		
		for(i=0;i<s.length();i++){
			po = expandPalindrome(s,i,i);
			//System.out.println("\n"+po);
			pe = expandPalindrome(s,i,i+1);
			//System.out.println("\n"+pe);
			String curr_max = po.length()>pe.length()?po:pe;
			palin = palin.length()>curr_max.length()?palin:curr_max;
		}
		
		
		return palin;
	}
	
	public static String expandPalindrome(String s, int j,int k){
		while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
			j--;
			k++;
		}
		//System.out.println(k-j-1);
		//for(int i= j+1;i<k;i++)
			//System.out.print(s.charAt(i)+" ");
		return (s.substring(j+1,k));
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