import java.util.TreeMap;

public class RomanToInteger{
	public static void main(String[] args){
		String s = "XII";
		StringBuffer s1 = new StringBuffer(s);
		
		int i = romanToInt(s);
		System.out.println(s1.reverse());
	}
	
	private final static TreeMap<Character, Integer> map = 
	new TreeMap<Character, Integer>();
	
	static{
		map.put('M',1000);
		map.put('D',500);
		map.put('C',100);
		map.put('L',50);
		map.put('X',10);
		map.put('V',5);
		map.put('I',1);
	}
	
	public static int romanToInt(String s){
		int r1,r2,res = 0;
		for(int i=0;i<s.length();i++){
			r1 = map.get(s.charAt(i));
			if(i+1<s.length()){
				r2 = map.get(s.charAt(i+1));
				
				if(r2 > r1){
					res += r2-r1;
					i++;
				}
				else{
					res += r1;
				}
			}
			else{
				res += r1;
			}
		}
		return res;
	}
}