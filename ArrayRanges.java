public class ArrayRanges{
	public static void main(String[] args){
		int[][] a = {1,4,3,6,8,12,9,16};
		int[][] b = new int[a.length][2];
		ranges(a,b);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i][0]+", "+b[i][1]);
		}
	}
}