import java.util.*;

public class HouseRobber{
	int[] max_at;
	public static void main(String[] args){
		HouseRobber hr = new HouseRobber();
		
		int[] nums = {4,1,2,7,5,3,1};
		int loot = hr.rob(nums);
		System.out.println(loot);
	}
	
	public int rob(int[] nums){
		int sum,loot=0;
		max_at = new int[nums.length];
		
		for(int i=0;i<nums.length;i++){
			sum = 0;
			if(i<2){
				max_at[i] = nums[i];
				
				if(nums[i]>loot)
					loot = nums[i];
				continue;
			}
			for(int j=2;j<i+1;j++){
				
				
				for(int k=i-j;k>=0;){
					sum = nums[i];
					System.out.println("max at "+nums[k]+": "+max_at[k]);
					sum += max_at[k];
					k -= j;
					
					if(sum>max_at[i]){
						max_at[i] = sum;
						
						if(max_at[i] > loot)
							loot = max_at[i];
					
						
						System.out.println(nums[i]+" "+sum);
					}
				}
				
			}
		}
		return loot;
	}
}

/*
198. House Robber   

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint 
stopping you from robbing each of them is that adjacent houses have 
security system connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money 
of each house, determine the maximum amount of money you can rob tonight 
without alerting the police.
*/