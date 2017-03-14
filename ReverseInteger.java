public class ReverseInteger{
	public static void main(String[] args){
		int num = -123;
		int reve = -321;
		int rev = reverse(num);
		
		System.out.println(num);
		System.out.println(rev);
		System.out.println(rev==reve);
	}
	
	public static int reverse(int x){
		long rev = 0L;
		int revi = 0;
		long rem = 0L;
		int neg = 0;
		if(x<0){
			System.out.println("here");
			neg = 1;
			x = x*(-1);
		}
			
		while(x>0){
			rem = x%10;
			x = x/10;
			rev = rev*10 + rem;
		}
		
		if(rev>=Integer.MAX_VALUE)
			return 0;
		else
			revi = (int)rev;
		if(neg == 1)
			rev = (-1)*rev;
		return revi;
	}
}

/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/