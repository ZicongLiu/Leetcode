public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        int closest = -1;
        
        for (int idx1 = 0 ; idx1 < nums.length - 2 ; idx1 ++){
            int idx2 = idx1 + 1;
            int idx3 = nums.length - 1;
            while (idx2 < idx3){
                int sum = nums[idx1] + nums[idx2] + nums[idx3];
                int curDiff = Math.abs(sum - target);
                if (curDiff == 0){
                    return target;
                }
                if (curDiff < diff){
                    diff = curDiff;
                    closest = sum;
                }
                if (sum < target){
                    idx2 ++;
                }
                if (sum > target){
                    idx3 --;
                }
                
            }
        }
        
        return closest;
    }
}