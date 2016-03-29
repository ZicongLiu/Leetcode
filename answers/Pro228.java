public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0)
            return result;
        int start = nums[0];
        int end = nums[0];
        int last = nums[0];
        for (int idx = 1 ; idx < nums.length ; idx ++){
            int cur = nums[idx];
            if (cur == last + 1){
                end = cur;
                last = cur;
                continue;
            }
            else{
                if (start != end)
                    result.add(String.valueOf(start) + "->"
                     + String.valueOf(end));
                else
                    result.add(String.valueOf(start));
                start = cur;
                end = cur;
            }
            last = cur;
        }
        if (start != end)
            result.add(String.valueOf(start) + "->" + String.valueOf(end));
        else
            result.add(String.valueOf(start));
        return result;
    }
    
    
}