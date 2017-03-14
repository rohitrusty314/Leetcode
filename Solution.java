public class Solution{
	public static void main(String[] args){
		int[] sumOf = new int[2];
		int [] a = {2,7,11,15};
		int target = 9;
		sumOf  = twoSum(a,target);
		System.out.println("nums["+sumOf[0]+"] + nums["+sumOf[1]+"] = "+target);
	}
	
	public static int[] twoSum(int[] nums, int target){
		int[] res = new int[2];
		for(int i=0;i<nums.length-1;i++){
			//System.out.print(nums[i]+" ");
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target){
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		//System.out.print("\n");
		//System.out.print(target);
		return res;
	}

}

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
*/