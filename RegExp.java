public class RegExp{
	public static void main(String[] args){
		Boolean match = isMatch("bab","..*");
		System.out.println(match);
	}
	
	public static boolean isMatch(String s, String p){
		boolean match = true;
		boolean zeroOrMore = false;
		int i=0,j=0,n;
		String pn = p.replaceAll("(.)\\*","");
		System.out.println(p);
		System.out.println(pn);
		if(s.length()<pn.length())
			return false;
		
		String allTrue = ".*";
		if(p.compareTo(allTrue)==0)
			return match;
		if(s.length()==0 && (!(onlyZeroes(p,i))))
			return false;
		for(i=0,j=0;i<s.length()&&j<p.length();){
			zeroOrMore = false;
			System.out.println(s.charAt(i)+" "+i+" "+p.charAt(j)+" "+j);
			if(j+1<p.length() && p.charAt(j+1)=='*'){
				zeroOrMore = true;
			}
			if(zeroOrMore){
				System.out.println("zero: "+s.charAt(i)+" "+i+" "+p.charAt(j)+" "+j);
				while(i<s.length()&&(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')){
					i++;
				}
				j = j+2;
				if(j>1)
					n = j-2;
				else
					n = 0;
				if(j<p.length()&&p.charAt(n)=='.'&& p.charAt(j)=='.'){
					System.out.println("sjdh");
					while(j<p.length()&&p.charAt(n)==p.charAt(j)){
						j++;
					}
				}
				else{
					if(j<p.length()&&p.charAt(n)==p.charAt(j))
						j++;
				}
				
				System.out.println("zero2: "+i+" "+j);
			}
			else if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
				System.out.println("st up "+s.charAt(i)+" "+i+" "+p.charAt(j)+" "+j);
				i++;
				j++;
			}
			else{
				return false;
			}
			
			
			
			
		}
		//System.out.println("i: "+i+" j: "+j);
		//System.out.println("h "+hadZero(s,p,i,j));
		for(;j<p.length() && hadZero(s,p,i,j);){
			//System.out.println(p.charAt(j));
			if(j+1<p.length() && p.charAt(j+1)=='*'){
				//System.out.println("kjfhsjdh");
				j = j+2;
			}
			else if(i>0&&p.charAt(j)!=s.charAt(i-1)){
				//System.out.println(p.charAt(j));
				return false;
			}
			else
				j++;
		}
		
		//System.out.println("Cond1-3");
		//System.out.println(i<s.length());
		//System.out.println(j<p.length());
		//System.out.println(!onlyZeroes(p,j));
		//System.out.println("Cond1-3");
		
		
			
		if(i<s.length())
			return false;
		
		if(j<p.length()){
			if(!onlyZeroes(p,j)){
				while(j<p.length()){
					System.out.println(i+" "+j);
					if(j<p.length()-1 && p.charAt(j+1)=='*'){
						System.out.println("j"+j);
						j = j+2;
					}
					else if(j>0&&i>0&&p.charAt(j-1)=='*'&& s.charAt(i-1)!=p.charAt(j)){
						//System.out.println("fff");
						return false;
					}
					else if(j>0 && j<p.length()-1&& p.charAt(j-1)!='*'){
						return false;
					}
					else if(j==p.length()-1){
						System.out.println("3fff");
						if(j>0&&((p.charAt(j-1)!='*')||(p.charAt(j-2)!=p.charAt(j)))){
							return false;
						}
						j++;
					}
					else
						j++;
					
				}
			}
			/*
			else{
				System.out.println("fff");
				return false;
			}*/
				
		}
		
		return match;
	}
	
	public static boolean onlyZeroes(String p,int j){
		//System.out.println("o: "+j);
		//System.out.println(p.length());
		if(j==p.length()-1){
			return false;
		}
			
		while(j<p.length()-1){
			//System.out.println("o: "+j);
			//System.out.println("ssss");
			if(p.charAt(j+1)!='*'){
				return false;
			}
			j = j+2;
			//System.out.println("o2: "+j);
		}
		if(j<p.length())
			return false;
		return true;
	}
	
	public static boolean hadZero(String s,String p,int i,int j){
		while(j>0){
			//System.out.println("z "+i+" "+j);
			if(p.charAt(j)=='*' && s.charAt(i-1)==p.charAt(j-1)){
				return true;
			}
			j--;
		}
		//System.out.println("zr "+i+" "+j);
		return false;
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