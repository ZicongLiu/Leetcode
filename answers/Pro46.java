public class Solution {
    Set<Integer> used = new HashSet<Integer>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> array = new ArrayList<Integer>();
    public List<List<Integer>> permute(int[] nums) {
        for (int idx = 0; idx < nums.length; idx++) {
            int num = nums[idx];
            if (used.contains(num)) {
                continue;
            } else {
                used.add(num);
                array.add(num);
                if (array.size() == nums.length) {
                    ArrayList<Integer> newList = new ArrayList<Integer>();
                    for (int ele : array) {
                        newList.add(ele);
                    }
                    result.add(newList);
                }

                permute(nums);
                array.remove(array.size() - 1);
                used.remove(num);
            }
        }
        return result;
    }
}