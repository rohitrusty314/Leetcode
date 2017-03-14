 public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> ranks = new HashMap<Integer, Integer>();
        
        int countBig;
        for(int i=0;i<nums.length;i++){
            countBig = 0;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i])
                    ranks.put(nums[j], ranks.get(nums[j])+1);
                else countBig++;
            }
            
            ranks.put(nums[i], countBig+1);
            
        }
        
        /*
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i] +" "+ ranks.get(nums[i]));
        }
        */
        
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