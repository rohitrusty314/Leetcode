
public class LongestSub{
	public static void main(String[] args){
		int len = lengthOfLongestSubstring("abcabcbb");
		System.out.println(len);
	}
	
	public static int lengthOfLongestSubstring(String s){
		//System.out.println(s);
		int sub_len = 1, curr_len = 0, dup_at = 0;
		if (s.length() == 0)
			return 0;
		for(int i=0;i<s.length();i++){
			dup_at = charAtiNotRepeated(s,i,curr_len);
			if(dup_at == -1){
				curr_len += 1;
				if(curr_len>sub_len)
					sub_len = curr_len;
			}
			else{
				if(curr_len>sub_len)
					sub_len = curr_len;
				curr_len = 1;
				i = i-dup_at+1;
			}
		}
		return(sub_len);
	}
	
	public static int charAtiNotRepeated(String s,int c,int l){
		int found = -1;
		//System.out.println(l);
		//System.out.print(s.charAt(c)+" ");
		
		for(int i=1;i<=l;i++){
			//System.out.print("i "+i+" l "+l+" ");
			//System.out.print(s.charAt(c-i));
			if(s.charAt(c-i) == s.charAt(c)){
				//System.out.print("\n");
				return i;
			}
		}
		//System.out.print("\n");
		return found;
	}
}
/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
"pwke" is a subsequence and not a substring.
*/