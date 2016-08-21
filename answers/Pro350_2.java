public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<Integer>();
        int idx1 = 0; int idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length){
            if (nums1[idx1] == nums2[idx2]){
                result.add(nums1[idx1]);
                idx1 ++;
                idx2 ++;
            }
            else if (nums1[idx1] > nums2[idx2]){
                idx2 ++;
            }
            else{
                idx1 ++;
            }
        }
        int[] res = new int[result.size()];
        for (int idx = 0 ; idx < result.size(); idx ++){
            res[idx] = result.get(idx);
        }
        return res;
    }
}