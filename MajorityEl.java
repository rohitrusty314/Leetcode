import java.util.*;

public class MajorityEl{
	public static void main(String[] args){
		int[] nums = {3,3,4};
		int el = majorityElement(nums);
		System.out.println(el);
	}
	
	static int majorityElement(int[] nums){
		int p = 0;
		int r = nums.length - 1;
		int major = divideNums(nums, p, r);
		return major;
	}
	
	static int divideNums(int[] nums, int p, int r){
		if(p<r){
			int q = (int) Math.floor((p+r)/2);
			
			int lmajor = divideNums(nums,p,q);
			int rmajor = divideNums(nums,q+1,r);
			if(lmajor==rmajor) return lmajor;
			
			int lcount = getCount(nums,p,r,lmajor);
			int rcount = getCount(nums,p,r,rmajor);
			
			
			if(lcount>q) return lmajor;
			else return rmajor;		
		}
		return nums[p];
	}
	
	static int getCount(int[] nums,int p,int r,int x){
		int count = 0;
		for(int i=p;i<=r;i++){
			//System.out.println("nums[i]: "+nums[i]);
			if(x==nums[i]) count++;
		}
		System.out.println("x: "+x+" count: "+count);
		return count;
	}
}

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than floor( n/2 ) times.

You may assume that the array is non-empty and the majority element always exist in the array.

*/