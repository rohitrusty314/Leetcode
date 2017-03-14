public class ZigZag{
	public static void main(String[] args){
		String str = "";
		int numRows = 3;
		String ziggy = convert(str,numRows);
		System.out.println(ziggy);
		String exp = "PAHNAPLSIIGYIR";
		System.out.println(exp.compareTo(ziggy)==0);
	}
	
	public static String convert(String s, int numRows){
		if(numRows<2)
			return s;
		String ziggy = "";
		//int cols = (s.length()/(numRows+(numRows-2)))*(numRows-1)+1;
		int cols = s.length(),i=0,j=0;
		//System.out.println(cols);

		char[][] zig = new char[numRows][cols];
		int k=0;
		for(j=0;j<cols&&k<s.length();j++){
			for(i=0;i<numRows&&k<s.length();i++){
				int cur_col = j%(numRows-1);
				if(cur_col==0){
					zig[i][j]=s.charAt(k);
					k++;
				}
				else{
					zig[numRows-cur_col-1][j] = s.charAt(k);
					k++;
					break;
				}
			}
		}
		
		for(int m=0;m<numRows;m++){
			for(int n=0;n<j;n++){
				
				int a = zig[m][n];
				//System.out.print(zig[m][n]+a+" ");
				if(a>0)
				ziggy = ziggy+zig[m][n];
			}
			//System.out.print("\n");
		}
		
		//System.out.println(ziggy);
		//ziggy.replaceAll(" ","");
		return ziggy;
	}
}

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
  0 1 2 3 4 5 6 
0 P   A   H   N
1 A P L S I I G
2 Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

  0 1 2 3 4 5 6
0 P     I     N
1 A   L S   I G
2 Y A   H R
3 P     I

  0 1 2 3 4 5
0 P       H G
1 A     S I
2 Y   I   R
3 P L     I
4 A       N
*/