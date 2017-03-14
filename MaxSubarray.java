import java.util.*;

public class MaxSubarray{
	public static void main(String[] args){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int b = maxSubArray(nums);
		
		System.out.println(b);
	}
	
	public static int maxSubArray(int[] nums){
		int p = 0;
		int r = nums.length-1;
		int sum = maxSum(nums,p,r);
		return sum;
	}
	
	static int maxSum(int[] nums, int p, int r){
		if(p<r){
			int q = (int)Math.floor((p+r)/2);
			int lsum = maxSum(nums,p,q);
			int rsum = maxSum(nums,q+1,r);
			int msum = mergeSum(nums,p,q,r);
			if(lsum>=rsum && lsum>=msum)
				return lsum;
			else if(rsum>=lsum && rsum>=msum)
				return rsum;
			else
				return msum;
		}
		
		return nums[p];
	}
	
	static int mergeSum(int[] nums, int p, int q, int r){
		int left_sum = 0;
		int sum = 0;
		for(int i=q;i>=p;i--){
			sum = sum + nums[i];
			if(sum>left_sum || i == q){
				left_sum = sum;
			}
		}
		
		int right_sum = 0;
		sum = 0;
		for(int i=q+1;i<=r;i++){
			sum = sum + nums[i];
			if(sum>right_sum || i == q+1){
				right_sum = sum;
			}				
		}
		
		return left_sum+right_sum;
	}
}

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/