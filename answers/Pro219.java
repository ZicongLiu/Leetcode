public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> kSlidingWindow = new HashSet<Integer>();
        for (int idx = 0 ; idx < nums.length ; idx ++){
            if (kSlidingWindow.contains(nums[idx])){
                return true;
            }
            kSlidingWindow.add(nums[idx]);
            if (kSlidingWindow.size() > k){
                kSlidingWindow.remove(nums[idx - k]);
            }
        }
        
        return false;
    }
}