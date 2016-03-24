public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
            for (int i = 0 ; i < nums1.length ; i ++){
                nums1[i] = nums2[i];
            }
        }
        if (n == 0){
            return;
        }
        int idx1 = m - 1;
        int idx2 = n - 1;
        int idx = m + n - 1;
        while (idx >= 0){
            int max;
            if (idx2 < 0){
                max = nums1[idx1--];
            }
            else if (idx1 < 0){
                max = nums2[idx2--];
            }
            else if (nums1[idx1] > nums2[idx2]){
                max = nums1[idx1 --];
            }
            else{
                max = nums2[idx2 --];
            }
            nums1[idx--] = max;
        }
    }
}