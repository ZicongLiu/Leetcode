public class Solution {
    int count = 0;
    public int combinationSum4(int[] nums, int target) {
        combination4(nums, target, 0);
        return count;
    }
    
    private void combination4(int[] nums, int target, int sum){
        if (sum == target){
            count ++;
            return;
        }
        else if (sum > target){
            return;
        }
        else{
            for (int i = 0 ; i < nums.length; i ++){
                combination4(nums, target, sum + nums[i]);
            }
        }
    }
}