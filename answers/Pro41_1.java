public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0 ; i < nums.length ; i ++){
            nums[i] --;
        }
        int idx = 0;
        while (idx < nums.length){
            if (nums[idx] >= nums.length || nums[idx] < 0){
                idx ++;
            }
            else{
                if (nums[idx] == nums[nums[idx]] || nums[idx] == idx){
                    idx ++;
                }
                else{
                    int swap = nums[nums[idx]];
                    nums[nums[idx]] = nums[idx];
                    nums[idx] = swap;
                }
            }
        }
        
        for (idx = 0 ; idx < nums.length ; idx ++){
            if (nums[idx] != idx){
                return idx + 1;
            }
        }
        return nums.length + 1;
    }
}