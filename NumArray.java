import java.util.*;

public class NumArray{
	int[] n;
	HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
	int max;
	
	public static void main(String[] args){
		int[] n = {};
		NumArray numArray = new NumArray(n);
	
		int a = numArray.sumRange(0, 2);
		System.out.println(a);
		
		a = numArray.sumRange(2, 5);
		System.out.println(a);
		
		a = numArray.sumRange(0, 5);
		System.out.println(a);
	}

    public NumArray(int[] nums) {
        n = nums;
		max = 0;
		if(n.length > 0)
			sumMap.put(0,n[0]);
    }

    public int sumRange(int i, int j) {
		//int sum = 0;
		
		if(n.length == 0)
			return 0;
		
		if(j>max){
			for(int l=max+1;l<=j;l++){
				int value = sumMap.get(l-1)+n[l];
				sumMap.put(l,value);
			}
			max = j;
		}
		
		
		if(i==0){
			return sumMap.get(j);
		}
        else{
			int sum_i = sumMap.get(i-1);
			int sum_j = sumMap.get(j);
			return (sum_j - sum_i);
		}
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/