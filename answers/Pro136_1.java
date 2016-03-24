public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums){
            if (set.contains(num)){
                set.remove(num);
            }
            else{
                set.add(num);
            }
        }
        Iterator<Integer> ite = set.iterator();
        if (ite.hasNext()){
            return ite.next();
        }
        else{
            return 0;
        }
    }
}