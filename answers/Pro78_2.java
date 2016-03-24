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
        findSubsets(curList, nums, curIdx + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        findSubsets(new ArrayList<Integer>(), nums, 0);
        
        return result;
    }
}