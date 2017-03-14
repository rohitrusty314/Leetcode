public class SomePattern{
	public static void main(String[] args){
		int n = 10;
		int count;
		String s = "1";
		String temp = "";
		for(int i=0;i<n;i++){
			temp = "";
			for(int j=s.length()-1;j>=0;){
				//System.out.println(s.charAt(j));
				count = 1;
				
				for(int k=j-1;k>=0 && s.charAt(j) == s.charAt(k);k--)
					count++;
				temp = Integer.toString(count)+s.charAt(j)+temp;
				
				j = j-count;
			}
			//System.out.println(temp);
			s = temp;
		}
		System.out.println(s);
	}
}