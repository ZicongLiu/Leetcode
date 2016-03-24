public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums)
            set.add(num);
        int maxLen = 0;
        for (int num : nums){
            if (!set.contains(num))
                continue;
            set.remove(num);
            int len = 1;
            int cur = num;
            while (set.contains(--cur)){
                len ++;
                set.remove(cur);
            }
            cur = num;
            while (set.contains(++cur)){
                len ++;
                set.remove(cur);
            }
            maxLen = Math.max(maxLen , len);
        }
        return maxLen;
    }
}