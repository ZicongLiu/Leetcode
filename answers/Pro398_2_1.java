public class Solution {
    private Map<Integer, List<Integer>> indexes = new HashMap<>();

    public Solution(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (!indexes.containsKey(num))
                indexes.put(num, new ArrayList<Integer>());
            indexes.get(num).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indexes = this.indexes.get(target);
        int i = (int) (Math.random() * indexes.size());
        return indexes.get(i);
    }
    
}