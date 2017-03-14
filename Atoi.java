public class Atoi{
	public static void main(String[] args){
		String str = "18446744073709551617";
		//String str = "9223372036854775809";
		System.out.println(str);
		int num = myAtoi(str);
		System.out.println(num);
	}
	
	public static int myAtoi(String str) {
		System.out.println(str.length());
		if(str.length()<1)
			return 0;
		
		while(str.startsWith(" "))
			str = str.replaceFirst(" ","");
		//System.out.println(str);
        long num = 0L;
		int numi = 0;
		int c = 0;
		int neg = 0;
		
		if((str.charAt(0) != '-' && str.charAt(0) != '+')&& (!(str.charAt(0)>47&&str.charAt(0)<58))){
			System.out.println("here");
			return 0;
		}
			
		
		if(str.length()>1){
			c = str.charAt(1);
			if(!(c>47&&c<58)){
				if(str.charAt(0)>47&&str.charAt(0)<58)
					return str.charAt(0)-'0';
				return 0;
			}	
		}
		
		if(str.charAt(0) == '-')
			neg = 1;
		
		if(str.length() > 19){
			if(neg==1)
				return Integer.MIN_VALUE;
			else 
				return Integer.MAX_VALUE;
		}
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == '.')
				break;
			c = str.charAt(i);
			//System.out.println(str.charAt(i)+" "+c);
			if(c>47&&c<58)
				num = num*10+(str.charAt(i)-'0');
			else{
				if(i!=0&&str.charAt(i)!='+')
					break;
			}
		}
		System.out.println(num);
		if(num>Integer.MAX_VALUE||num<Integer.MIN_VALUE){
			if (neg==1)
				return Integer.MIN_VALUE;
			else
				return Integer.MAX_VALUE;
		}
		else
			numi = (int)num;
		
		if(neg==1)
			numi = (-1)*numi;
		return numi;
    }
}

/*
Implement atoi to convert a string to an integer.
*/