import java.util.*;

public class LongestIncSub{
	public static void main(String[] args){
		int[] nums = {10,9,2,5,3,7,101,18};
		int q = lengthOfLIS(nums);
		System.out.println(q);
	}
	
	public static int lengthOfLIS(int[] nums){
		HashMap<Integer, Integer> largestAt = new HashMap<Integer, Integer>();
		
		for(int i=0;i<nums.length;i++){
			for(int j=i-1;j>=0;j--){
				if(nums[i]>nums[j]){
					if(largestAt.containsKey(i)){
						if(largestAt.get(j)+1 > largestAt.get(i)){
							largestAt.put(i,largestAt.get(j)+1);
						}
					}
					else{
						largestAt.put(i,largestAt.get(j)+1);
					}
						
				}
				else if(!largestAt.containsKey(i)){
					largestAt.put(i,1);
				}	
			}
			
			if(!largestAt.containsKey(i))
				largestAt.put(i,1);
		}
		int max = 0;
		for(int i=0;i<nums.length;i++){
			//System.out.println(nums[i]+" "+largestAt.get(i));
			
			if(largestAt.get(i) > max)
				max = largestAt.get(i);
		}
		return max;
	}
}
/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/