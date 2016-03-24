public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for (int idx1 = 0 ; idx1 < nums.length - 2 ; idx1 ++){
            while (idx1 > 0 && idx1 < nums.length - 2
             && nums[idx1] == nums[idx1 - 1]){
                idx1 ++;
            }
            int val1 , val2 , val3;
            val1 = nums[idx1];
            
            int idx2 = idx1 + 1, idx3 = nums.length - 1;
            while (idx2 < idx3){
                val2 = nums[idx2];
                val3 = nums[idx3];
                
                int sum = val1 + val2 + val3;
                
                if (sum == 0){
                    List<Integer> triple = new ArrayList<Integer>();
                    triple.add(val1);
                    triple.add(val2);
                    triple.add(val3);
                    
                    results.add(triple);
                    while(idx2 < idx3 && nums[idx3] == nums[idx3 - 1]){
                        idx3 --;
                    }
                    idx3 --;
                    idx2++;
                    while(idx2 < idx3 && nums[idx2 - 1] == nums[idx2]){
                        
                        idx2 ++;
                    }
                }else if (sum > 0){
                    
                    while(idx2 < idx3 && nums[idx3] == nums[idx3 - 1]){
                        idx3 --;
                    }
                    idx3 --;
                }else{
                    idx2 ++;
                    while(idx2 < idx3 && nums[idx2 - 1] == nums[idx2]){
                        
                        idx2 ++;
                    }
                }
            }
            
        }
        
        return results;
    }
}