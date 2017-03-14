import java.util.*;

public class Search2D{
	public static void main(String[] args){
		int[][] matrix =   {{1,4,7,11,15},
							{2,5,8,12,19},
							{3,6,9,16,22},
							{10,13,14,17,24},
							{18,21,23,26,30}};
		int target = 5;
		boolean b = searchMatrix(matrix,target);
		System.out.println(b);
		
	}
	
	public static boolean searchMatrix(int[][] matrix, int target){
		int pm = 0;
		int rm = matrix.length - 1;
		
		int pn = 0;
		int rn = matrix[0].length - 1;
		//System.out.println("m: "+m+" n: "+n);
		boolean b = divideSearch(matrix,target,pm,rm,pn,rn);
		
		return b;
	}
	
	public static boolean divideSearch(int[][] matrix,int target, int pm, int rm, int pn, int rn){
	     if(pm<rm || pn<rn){
			 int qm = (int) Math.floor((pm+rm)/2);
			 int qn = (int) Math.floor((pn+rn)/2);
			 
			 System.out.println(matrix[qm][qn]);
			
			 if(target == matrix[qm][qn]) return true;
			 
			 if(target>matrix[qm][qn]&&target<matrix[rm][rn] &&target<matrix[pm][pn]){
				  System.out.println("go after the middle: ");
				  System.out.println(pm+" "+qm+" "+rm+" "+pn+" "+qn+" "+rn);
				 boolean b1 = divideSearch(matrix,target,qm,rm,qn+1,rn);
				 System.out.println("go 2: ");
				 boolean b2 = divideSearch(matrix,target,qm+1,rm,qn,qn);
				 if(b1==true || b2==true) return true;
				 else return false;
			 }
			 
			 if(target<matrix[qm][qn]&&target>matrix[pm][pn]){
				 System.out.println("go before the middle: ");
				 System.out.println(pm+" "+qm+" "+rm+" "+pn+" "+qn+" "+rn);
				 boolean b3 = divideSearch(matrix,target,pm,qm-1,qn,qn);
				 boolean b4 = divideSearch(matrix,target,pm,qm,pn,qn-1);
				 
				 if(b3==true || b4==true) return true;
			 }
			 //if(b1==false && b2==false && b3==false && b4==false) return false;
		 }
		 //if(target==matrix[rm][rn]) return true;
		 return false;
	}
}

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.
*/
