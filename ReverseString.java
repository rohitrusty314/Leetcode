public class ReverseString{
	public static void main(String[] args){
		String str = "hello";
		String revStr = reverseString(str);
		System.out.println(revStr);
	}
	
	public static String reverseString(String s){
		char[] c = s.toCharArray();
		int l = 0;
		int r = c.length-1;
		char temp;
		while(l<r){
			temp = c[l];
			c[l] = c[r];
			c[r] = temp;
			l++;
			r--;
		}
		
		return String.valueOf(c);
	}
}