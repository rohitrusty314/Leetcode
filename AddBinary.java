public class AddBinary{
	public static void main(String[] args){
		String a = "11";
		String b = "1";
		String c = add(a,b);
		System.out.println(a+" + "+b+" = "+c);
	}
	
	public static String add(String a, String b){
		
		//int i = (a.length()>b.length()?a.length()-1:b.length()-1);
		int i = a.length()-1;
		int j = b.length()-1;
		//System.out.println(i);
		
		int bit1,bit2,bit3;
		int carry = 0;
		String res = "";
		for(;i>-1 || j>-1;i--,j--){
			
			bit1 = (i>-1?a.charAt(i)-'0':0);
			bit2 = (j>-1?b.charAt(j)-'0':0);
			bit3 = carry + bit1 + bit2;
			
			
			res = Integer.toString(bit3%2) + res;
			carry = bit3/2;
			
		}
		if(carry>0)
			res = Integer.toString(carry) + res;
		return res;
		
	}
}

/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/