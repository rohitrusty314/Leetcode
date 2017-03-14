public class LongestPrefix{
	public static void main(String[] args){
		String[] strs = {"aa","a"};
		System.out.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs){
		
		if(strs.length < 1)
			return "";
		
		else if(strs.length < 2)
			return strs[0];
        
		
		int charCounter = -1, i=0;
		boolean next = true;
		do{
			charCounter++;
			//System.out.println("a: "+charCounter);
			//System.out.println("b: "+i);
			//System.out.println("c: "+strs.length);
			for(i=0;i<strs.length-1;i++){
				//System.out.println("here");
				if(charCounter>=strs[i].length()
					|| charCounter>=strs[i+1].length()){
					next = false;
					break;
				}
				else if(strs[i].charAt(charCounter) !=
						strs[i+1].charAt(charCounter)){
					next = false;
					break;
				}
			}
			
			
		}while(next);
		
		return strs[i].substring(0,charCounter);
	}
}