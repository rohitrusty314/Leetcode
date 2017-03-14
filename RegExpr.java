public class RegExpr{
	public static void main(String[] args){
		Boolean match = isMatch("bab","..*"	);
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aa","a");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" false\n");
		
		
		match = isMatch("aa","aa");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aaa","aa");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" false\n");
		
		match = isMatch("aa", "a*");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aa", ".*");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("ab", ".*");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aab", "c*a*b");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aab", "aab");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aab", "acb");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" false\n");
		
		match = isMatch("aab", "a.b");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aaaa", "aa*a*b*a");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("bccaabcacbacaccca","b*.*baa*b*.a*bc*c");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" false\n");
		
		match = isMatch("ab",".*c");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" false\n");
		
		match = isMatch("ac",".*c");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aaca","ab*a*c*a");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("a","ab*");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aasdfasdfasdfasdfas","aasdf.*asdf.*asdf.*asdf.*s");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("abb","a.*b");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("abbcd","a.*bcd.*");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("bbbacbcbcbbbbabbbab","b*c*c*.*.*.*ab*c");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" false\n");
		
		match = isMatch("aabcbcbcaccbcaabc",".*a*aa*.*b*.c*.*a*");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aaca","ab*a*c*a");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("aabcbcbcaccbcaabc",".*a*aa*.*b*.c*.*a*");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
		match = isMatch("abbabaaaaaaacaa","a*.*b.a.*c*b*a*c*");
		System.out.print("Answer: ");
		System.out.print(match);
		System.out.print(" true\n");
		
	}
	
	public static boolean isMatch(String s,String p){
		
		System.out.println("\n"+s);
		System.out.println(p);
		String exitMsg = "Unchecked";
		
		//if the given string has less than required characters
		String pn = p.replaceAll("(.)\\*","");
		if(s.length()<pn.length()){
			System.out.println("Not enough chars");
			return false;
		}
		
		//If the given RegEx will always fit the given input
		String allTrue = ".*";
		if(p.compareTo(allTrue)==0){
			System.out.println("RegEx matches any input");
			return true;
		}
		
		
		
		int i=0,j=0,occr=0;
		
		for(;i<s.length()&&j<p.length();){
			occr = 0;
			if(j<p.length()-1 && p.charAt(j+1)=='*'){
				System.out.println(p.charAt(j)+ " * encountered");
				occr = occurences(s,i,p,j);
				System.out.println(p.charAt(j)+" should occur "+occr+" times");
				j = j+2;
				i = i+occr;
				//break;
			}
			else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
				i++;
				j++;
				exitMsg = "Checked";
			}
			else{
				System.out.println("this "+i+" "+j);
				System.out.println("this "+p.charAt(j)+" "+s.charAt(i));
				System.out.println("Character mismatch");
				return false;
			}
				
			
		}
		
		if(i<s.length()){
			System.out.println("String longer than allowed by Regex");
			return false;
		}
		
		if(j<p.length()){
			System.out.print("Only zeroes: ");
			System.out.print(onlyZeroes(p,j));
			System.out.print("\n");
			
			if(onlyZeroes(p,j))
				return true;
			System.out.println("String is smaller than RegEx");
			return false;
		}
		
		System.out.println(exitMsg);
		return true;
	}
	
	public static boolean onlyZeroes(String p,int j){
		while(j<p.length()-1&&p.charAt(j+1)=='*'){
			j = j+2;
		}
		if(j==p.length())
			return true;
		return false;
	}
	
	public static int occurences(String s,int i,String p,int j){
		int m,n,count1=0,count2=0;
		
		int k,l;
		//System.out.println(p.charAt(j));
		if(p.charAt(j)=='.'){
			k = i;
			l = j+2;
			System.out.println("this "+l+" "+k);
			
			System.out.println("Here's the problem.");
			if(l<p.length()&&k<s.length()&&p.charAt(l)==s.charAt(k)){
				System.out.println("this "+l+" "+k);
				System.out.println("this "+p.charAt(l)+" "+s.charAt(k));
				for(;l<p.length()-1&&k<s.length();l++,k++){
					if((p.charAt(l)=='.'||p.charAt(l)==s.charAt(k))&& p.charAt(l+1)=='*'){
						return 0;
					}
					if(p.charAt(l)!=s.charAt(k)){
						System.out.println(l+" "+k);
						System.out.println(p.charAt(l)+" "+s.charAt(k));
						break;
					}
					
				}
			}
		}
		
		
		int h = j+2;
		int g = h;
		for(m=i;m<s.length();m++){
			if(s.charAt(m)==p.charAt(j)||p.charAt(j)=='.'){
				
				count1++;
				
					
			}
			else{
				System.out.println(m+" "+j);
				System.out.println(s.charAt(m)+" "+p.charAt(j));
				
				if(h<p.length()-1&&s.charAt(m)==p.charAt(h)&&p.charAt(h+1)=='*'){
					h = h+2;
				}
				else{
					System.out.println("Mismatch!");
					break;
				}	
				
			}
		}
		//count1 = m-i;
		System.out.println("total occurences in string "+count1);
		
		for(n=j+2;n<p.length();n++){
			if(p.charAt(j)==p.charAt(n) || p.charAt(j)=='.'){
				if(n<p.length()-1 && p.charAt(n+1) == '*'){
					n++;
				}
				else{
					count2++;
				}
			}
		}
		
		System.out.println("total occurences in regex "+count2);
		
		if(count1==0)
			return count1;
		
		if((count1-count2)<0)
			return 0;
		return (count1-count2);
	}
}