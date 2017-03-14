public class Test1{
	public static void main(String[] args){
		Test1 ob = new Test1();
		String str = "The boy ran";
		String nStr = ob.reverseWords(str);
		System.our.println(nStr);
	}
	
	public String reverseWords(String str){
		char[] c = str.toCharArray();
		String temp = "";
		String rev = "";
		String nstr = "";
		
		for(int i=0;i<c.length;i++){
			if(c[i]!=' '){
				temp += c[i];
			}
			else{
				rev = temp.revese();
				nstr += rev + ' ';
				temp = "";
			}
		}
		
		return nstr;
	}
}
