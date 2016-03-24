public class Solution {
    private double findMedian(int[] nums1, int[] nums2,
                            int startIdx1, int startIdx2 , int remaining){
        if (nums1.length - startIdx1 < nums2.length - startIdx2){
            return findMedian(nums2, nums1, startIdx2, startIdx1, remaining);
        }
        // Since length1 > length2, no need to add this snippet
        // if (startIdx1 == nums1.length){
        //     return nums2[startIdx2 + remaining - 1];
        // }
        if (startIdx2 == nums2.length){
            return nums1[startIdx1 + remaining - 1];
        }
        if (remaining == 1){
            return Math.min(nums1[startIdx1], nums2[startIdx2]);
        }
        int offset2 = Math.min(nums2.length - startIdx2, remaining / 2);
        int offset1 = remaining - offset2;
        if (nums1[startIdx1 + offset1 - 1] == nums2[startIdx2 + offset2 - 1]){
            return nums1[startIdx1 + offset1 - 1];
        }
        else if (nums1[startIdx1 + offset1 - 1] > nums2[startIdx2 +  offset2 - 1]){
            return findMedian(nums1, nums2,
             startIdx1, startIdx2 + offset2, remaining - offset2);
        }
        else{
            return findMedian(nums1, nums2,
             startIdx1 + offset1, startIdx2, remaining - offset1);
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 != 0){
            return findMedian(nums1, nums2, 0, 0, (m + n) / 2 + 1);    
        }
        else{
            return (findMedian(nums1, nums2, 0, 0, (m + n) / 2)
                  + findMedian(nums1, nums2, 0, 0, (m + n) / 2 + 1)) / 2;
        }
    }
}