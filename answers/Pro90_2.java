public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public void findSubsets(List<Integer> curList, int[] nums, int curIdx){
        if (curIdx == nums.length){
            result.add(new ArrayList(curList));
            return;
        }
        curList.add(nums[curIdx]);
        findSubsets(curList, nums, curIdx + 1);
        curList.remove(curList.size() - 1);
        int diff = 1;
        while (curIdx + diff < nums.length
         && nums[curIdx + diff - 1] == nums[curIdx + diff]){
            diff ++;
        }
        findSubsets(curList, nums, curIdx + diff);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        findSubsets(new ArrayList<Integer>(), nums, 0);
        return result;
    }
}