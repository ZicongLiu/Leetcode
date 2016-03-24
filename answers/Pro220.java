public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> almostUniqueElements = new TreeSet<Integer>();
        
        for (int idx = 0 ; idx < nums.length ; idx ++){
            if ((almostUniqueElements.floor(nums[idx]) != null && 
            (nums[idx] <= t + almostUniqueElements.floor(nums[idx]))) ||
            (almostUniqueElements.ceiling(nums[idx]) != null &&
            (almostUniqueElements.ceiling(nums[idx]) <= t + nums[idx] ))
            ){
                return true;
            }
            
            almostUniqueElements.add(nums[idx]);
            if (almostUniqueElements.size() > k){
                almostUniqueElements.remove(nums[idx - k]);
            }
        }
        
        return false;
    }
}