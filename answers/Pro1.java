public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> valueIdxMap = new HashMap<Integer, Integer>();
        
        for (int idx = 0 ; idx < nums.length ; idx ++){
            if (valueIdxMap.containsKey(target - nums[idx])){
                result[0] = valueIdxMap.get(target - nums[idx]);
                result[1] = idx;
                break;
            }
            valueIdxMap.put(nums[idx], idx);
        }
        
        return result;
        
    }
}