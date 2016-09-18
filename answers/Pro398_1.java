public class Solution {
    Random rand = new Random();
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int idx = 0 ; idx < nums.length ; idx ++){
            int num = nums[idx];
            if (target == num){
                if (rand.nextInt(count + 1) == count){
                    result = idx;
                }
                count ++;
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */