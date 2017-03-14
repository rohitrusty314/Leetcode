public class StrStr{
	public static void main(String[] args){
		String haystack = "aaa";
		String needle = "aaaa";
		int indexOfNeedle = strStr(haystack,needle);
		System.out.println(indexOfNeedle);
	}
	
	public static int strStr(String haystack, String needle){
		int len = needle.length();
		
		if(len == 0) return 0;
		if(haystack.length() == 0) return -1;
		if(len>haystack.length()) return -1;
		
		char init = needle.charAt(0);
		int at = haystack.indexOf(init,0);
		
		
		
		String match;
		
		while(at != -1){
			if((at+len)>haystack.length()) return -1;
			
			match = haystack.substring(at,at+len);
			//System.out.println(match);
			//System.out.println(needle.compareTo(match));
			if(needle.compareTo(match) == 0)
				return at;
			at = haystack.indexOf(init,at+1);
			
		}
		return -1;
	}
}
/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/