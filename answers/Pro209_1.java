public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int low = 0 , high = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (high < nums.length){
            if (sum >= s){
                minLen = Math.min(high - low , minLen);
                sum -= nums[low];
                low ++;
            }
            else{
                sum += nums[high];
                high ++;
            }
        }
        boolean changed = false;
        while (low < nums.length && sum >= s){
            changed = true;
            sum -= nums[low];
            low ++;
            if (sum < s){
                break;
            }
        }
        if (changed){
            minLen = Math.min(minLen, high - low + 1);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}