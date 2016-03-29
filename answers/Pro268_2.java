public class Solution {
    public int missingNumber(int[] nums) {
        int[] nums2 = new int[nums.length + 1];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            nums2[nums[i]] = -1;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] != -1) {
                return i;
            }
        }
        return -1;
    }
}