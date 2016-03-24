public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mid = (len1 + len2) / 2, midVal = 0;
        int mid2 = mid + 1, mid2Val = 0;
        if (mid == 0){
            return (nums1.length == 0) ? nums2[0] : nums1[0];
        }
        int idx1 = 0 , idx2 = 0;
        int idx = 0;
        while (idx1 < nums1.length && idx2 < nums2.length){
            int compare1 = nums1[idx1], compare2 = nums2[idx2];
            idx ++;
            int compare = 0;
            if (compare1 <= compare2){
                compare = compare1;
                idx1 ++;
            }
            else{
                compare = compare2;
                idx2 ++;
            }
            if (idx == mid){
                midVal = compare;
            }
            if (idx == mid2){
                mid2Val = compare;
                break;
            }
        }
        if (idx < mid2){
            while (idx1 < nums1.length){
                idx++;
                if (idx == mid){
                    midVal = nums1[idx1];
                }
                if (idx == mid2){
                    mid2Val = nums1[idx1];
                }
                idx1++;
            }
            while (idx2 < nums2.length){
                idx++;
                if (idx == mid){
                    midVal = nums2[idx2];
                }
                if (idx == mid2){
                    mid2Val = nums2[idx2];
                }
                idx2++;
            }
        }
        
        
        if ((len1 + len2) % 2 == 0){
            return (midVal + mid2Val) * 1.0 / 2;
        }
        else{
            return mid2Val;
        }
    }
}