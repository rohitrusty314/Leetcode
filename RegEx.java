public class RegEx{
	public static void main(String[] args){
		Boolean match = isMatch("aa","a*");
		System.out.println(match);
	}
	
	public static boolean isMatch(String s, String p){
		//System.out.println(p.indexOf('.'));
		//System.out.println(p.indexOf('*'));
		//System.out.println(s.length());
		char c;
		if(p.indexOf('.')==-1 && p.indexOf('*')==-1)
			return(p.compareTo(s)==0);
		for(int i=0,j=0;i<s.length()&&j<p.length();){
			if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
				i++;
				j++;
			}
			else{
				if(p.charAt(j)=='*'){
					//System.out.println("here");
					c = p.charAt(j-1);
					
					if(c=='.'){
						if(j==p.length()-1)
							return true;
						else{
							while(i<s.length() && s.charAt(i) == c){
								//System.out.println(i);
								i++;
							}
							j++;
						}
					}
					
					//System.out.println(i);
					//System.out.println(c);
					System.out.println(s.charAt(i));
					while(i<s.length() && s.charAt(i) == c){
						//System.out.println(i);
						i++;
					}
				}
				else if(p.charAt(j+1)=='*'){
					System.out.println(i+" "+j);
					i++;
					j += 2;
					System.out.println(i+" "+j);
				}
				else
					return false;
			}
		}
		return true;
	}
}

/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/