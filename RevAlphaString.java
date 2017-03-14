public class RevAlphaString{
	public static void main(String[] args){
		String str = "a,b$c";
		String revStr = reverseString(str);
		System.out.println("Input: "+str);
		System.out.println("Output: "+revStr);
	}
	
	public static String reverseString(String str){
		int l=0;
		int r = str.length()-1;
		char t = '0';
		char[] stringChars = str.toCharArray();
		while(l<r){
			if((stringChars[l]<'A' || stringChars[l]> 'Z') && 
			(stringChars[l]<'a' || stringChars[l]> 'z')){
				System.out.println("Special l: "+stringChars[l]);
				l++;
				continue;
			}
			if((stringChars[r]<'A' || stringChars[r]> 'Z') && 
			(stringChars[r]<'a' || stringChars[r]> 'z')){
				System.out.println("Special r: "+stringChars[r]);
				r--;
				continue;
			}
			System.out.println("Swap "+stringChars[l] +" : "+stringChars[r]);
			t = stringChars[l];
			stringChars[l] = stringChars[r];
			stringChars[r] = t;
			l++;
			r--;
			
		}
		return String.valueOf(stringChars);
	}
}