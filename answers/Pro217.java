public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<Integer>();
        for (int num : nums){
            if (uniqueElements.contains(num)){
                return true;
            }
            uniqueElements.add(num);
        }
        
        return false;
    }
}