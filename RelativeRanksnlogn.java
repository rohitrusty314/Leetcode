public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> ranks = new HashMap<Integer, Integer>();
        int n = nums.length;
        int[] ranked = Arrays.copyOf(nums, n);
        Arrays.sort(ranked);
        
        int rank = n;
        for(int i=0;i<n;i++){
            //System.out.println(ranked[i]);
            ranks.put(ranked[i], rank--);
        }
        
        String[] res = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = medalOnRank(ranks.get(nums[i]));
            
        }
        return res;
            
    }
    
    private String medalOnRank(int rank){
        switch(rank){
            case 1: return "Gold Medal";
            case 2: return "Silver Medal";
            case 3: return "Bronze Medal";
            default: return Integer.toString(rank);
        }
    }
	
	
/*
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
*/