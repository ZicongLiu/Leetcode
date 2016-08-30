public class Solution {
    int count = 0;
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        for (int sum = 1 ; sum <= target ; sum ++){
            for (int num : nums){
                if (num > sum){
                    continue;
                }
                else if (num == sum){
                    res[sum] ++;
                }
                else{
                    res[sum] += res[sum - num];
                }
            }
        }
        return res[target];
    }

}