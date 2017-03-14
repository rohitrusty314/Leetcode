public class Median{
	public static void main(String[] args){
		int[] nums1 = {2,2,2,2};
		int[] nums2 = {2,2,2};
		
		/*
		for(int i=0;i<nums1.length;i++)
			System.out.print(nums1[i]+" ");
		System.out.print("\n");
		for(int i=0;i<nums2.length;i++)
			System.out.print(nums2[i]+" ");
		System.out.print("\n");
		*/
		
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println("Median: "+median);
		
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2){
		double median = 0.0;
		
		/*
		for(int i=0;i<nums1.length;i++)
			System.out.print(nums1[i]+" ");
		System.out.print("\n");
		for(int i=0;i<nums2.length;i++)
			System.out.print(nums2[i]+" ");
		System.out.print("\n");
		*/
		
		
		int total_len = nums1.length + nums2.length;
		//System.out.println(total_len);
		int max_index = total_len/2;
		
		//System.out.println(max_index);
		int[] res = new int[max_index+1];
		int k=0,i=0,j=0;
		while(k<=max_index&&j<nums2.length&&i<nums1.length){
			if(nums1[i]<nums2[j]){
				res[k]=nums1[i];
				i++;
				
			}
			else{
				res[k]=nums2[j];
				j++;
			}
			k++;
		}
		
		System.out.println(i+" "+j+" "+k);
		System.out.println(max_index);
		
		if(k<=max_index){
			if(i<nums1.length){
				while(k<=max_index&&i<nums1.length){
					res[k]=nums1[i];
					i++;
					k++;
				}
			}
			else if(j<nums2.length){
				while(k<=max_index&&j<nums2.length){
					res[k]=nums2[j];
					j++;
					k++;
				}
			}
			
		}
		
		System.out.println(i+" "+j+" "+k);
		System.out.println(max_index);
		
		for(int l=0;l<res.length;l++)
			System.out.print(res[l]+" ");
		System.out.println("\n");
		
		if(total_len%2==0){
			if(i<nums1.length&&j<nums2.length&&k<=max_index)
				res[max_index] = nums1[i]<nums2[j]?nums1[i]:nums2[j];
			else if(i<nums1.length&&k<=max_index)
				res[max_index] = nums1[i];
			else if(j<nums2.length&&k<=max_index)
				res[max_index] = nums2[j];
			
			System.out.println(res[max_index-1]);
			System.out.println(res[max_index]);
			median = (res[max_index-1]+res[max_index])/2.0;
		}
		else{
			if(total_len<2){
				if(nums1.length == 1)
					median = nums1[0];
				else
					median = nums2[0];
			}
			else
				median = res[max_index];
		}
			
		
		
		return median;
	}
}

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/