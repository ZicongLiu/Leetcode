public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for (int num : nums){
            int resultLength = result.size();
            for (int idx = 0 ; idx < resultLength ; idx ++){
                List<Integer> newList = new ArrayList(result.get(idx));
                newList.add(num);
                // Collections.sort(newList);
                result.add(newList);
            }
        }
        
        return result;
    }
}