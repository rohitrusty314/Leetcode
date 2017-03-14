/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public int getMinimumDifference(TreeNode root) {
        return getDiff(root);
    }
    
    private int getDiff(TreeNode root){
        if(root!=null){
            int a = rootMinus(root.val, root.left);
            int b = rootMinus(root.val, root.right);
            //System.out.print("a: "+a+" b: "+b);
            int c = getDiff(root.left);
            int d = getDiff(root.right);
            //System.out.print(" a: "+a+" b: "+b+" c: "+c+" d: "+d);
            
            return Math.min(Math.min(Math.min(a,b),c),d);
        }
        
        return Integer.MAX_VALUE;
    }
    
    private int rootMinus(int val, TreeNode child){
        if(child != null){
            int a,b,c,d;
            a = Math.abs(val - child.val);
            b = rootMinus(val, child.left);
            c = rootMinus(val, child.right);
            
            return Math.min(Math.min(a,b),c);
        }
        
        return Integer.MAX_VALUE;
		
	}


/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
	
Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
*/
