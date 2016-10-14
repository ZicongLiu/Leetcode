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
        
        boolean[] canPartition = new boolean[target + 1];
        Arrays.fill(canPartition, false);
        canPartition[0] = true;
        for (int num : nums){
            for (int partition = target ; partition >= num ; partition --){
                if (canPartition[partition - num]){
                    canPartition[partition] = true;
                }
            }
        }
        return canPartition[target];
    }
    
    
}