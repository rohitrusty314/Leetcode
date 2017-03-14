public class RevVowels{
	public static void main(String[] args){
		String s = "aA";
		String rs = reverseVowels(s);
		System.out.println(rs);
	}
	
	public static String reverseVowels(String s){
		int l = 0;
		int r = s.length()-1;
		char[] schar = s.toCharArray();
		char temp;
		while(l<r){
			if(!isVowel(schar[l])){
				l++;
				continue;
			}
			if(!isVowel(schar[r])){
				r--;
				continue;
			}
			temp = schar[l];
			schar[l] = schar[r];
			schar[r] = temp;
			l++;
			r--;
			
		}
		
		return String.valueOf(schar);
	}
	
	public static boolean isVowel(char c){
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
		c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
			return true;
		}
		return false;
	}
}