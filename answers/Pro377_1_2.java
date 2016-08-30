public class Solution {
    Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
    public int combinationSum4(int[] nums, int target) {
        int count = 0;
        if (target < 0){
            return 0;
        }
        if (target == 0){
            return 1;
        }
        for (int num : nums){
            if (sums.containsKey(target - num)){
                count += sums.get(target - num);
                continue;
            }
            count += combinationSum4(nums, target - num);
        }
        
        sums.put(target, count);
        return count;
    }

}