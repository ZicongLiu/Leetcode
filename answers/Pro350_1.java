public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for (int num1 : nums1){
            if (map1.containsKey(num1)){
                map1.put(num1, map1.get(num1) + 1);
            }
            else{
                map1.put(num1, 1);
            }
        }
        for (int num2 : nums2){
            if (map1.containsKey(num2) && map1.get(num2) > 0){
                map1.put(num2, map1.get(num2) - 1);
                result.add(num2);
            }
        }
        int[] res = new int[result.size()];
        for (int idx = 0 ; idx < result.size() ; idx ++){
            res[idx] = result.get(idx);
        }
        return res;
    }
}