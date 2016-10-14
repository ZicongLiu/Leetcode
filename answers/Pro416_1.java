public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        
        return dfs(nums, target, 0, 0);
    }
    
    private boolean dfs(int[] nums, int target, int numIdx, int curSum){
        if (curSum == target){
            return true;
        }
        if (numIdx >= nums.length || curSum > target){
            return false;
        }
        boolean flag = false;
        for (int idx = numIdx ; idx < nums.length ; idx ++){
            flag = flag || 
                dfs(nums, target, idx + 1, curSum + nums[idx]);
            if (flag){
                return true;
            }
        }
        return false;
    }
}