public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> result = new HashSet<Integer>();
        for (int num1 : nums1){
            set1.add(num1);
        }
        for (int num2 : nums2){
            if (set1.contains(num2)){
                result.add(num2);
            }
        }
        int[] resultArr = new int[result.size()];
        int idx = 0;
        for (int res : result){
            resultArr[idx] = res;
            idx ++;
        }
        return resultArr;
        
    }
}