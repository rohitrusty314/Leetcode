import java.util.TreeMap;

public class RomanTest{
	 public static void main(String args[])
    {
        RomanToNumber ob = new RomanToNumber();
 
        // Considering inputs given are valid
        String str = "X";
        System.out.println("Integer form of Roman Numeral" +
                           " is " + ob.romanToDecimal(str));
						   
		System.out.println(ob.toRoman(3* ob.romanToDecimal(str)));
		//System.out.println(toRoman(3*4));
    }
	
	
	public final static TreeMap<Integer,String> map = new TreeMap<Integer,String>();
	
	static {
		map.put(1000,"M");
		map.put(900,"CM");
		map.put(500,"D");
		map.put(400,"CD");
		map.put(100,"C");
		map.put(90,"XC");
		map.put(50,"L");
		map.put(40,"XL");
		map.put(10,"X");
		map.put(9,"IX");
		map.put(5,"V");
		map.put(4,"IV");
		map.put(1,"I");
	}
	
	public  String toRoman(int number){
		int l = map.floorKey(number);
			if(number == l){
				return map.get(number);
			}
			return map.get(l)+toRoman(number-l);
	}
	
	public int charToNum(char c){
		if(c == 'I')
			return 1;
		if(c == 'V')
			return 5;
		if(c == 'X')
			return 10;
		if(c == 'L')
			return 50;
		if(c == 'C')
			return 100;
		if(c == 'D')
			return 500;
		if(c == 'M')
			return 1000;
		return -1;
	}
	
	public int romanToNumber(String s){
		int res = 0;
		
		for(int i=0;i<s.length();i++){
			
			int r1 = charToNum(s.charAt(i));
			
			if(i+1 < s.length()){
				int r2 = charToNum(s.charAt(i+1));
				
				if(r1>=r2){
					res += r1;
				}
				else{
					res += r2-r1;
					i++;
				}
			}
			else{
				res += r1;
				i++;
			}
		}
		
		return res;
	}
}