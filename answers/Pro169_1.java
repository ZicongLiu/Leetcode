public class Solution {
    public int majorityElement(int[] nums) {
        int curNum = -1;
        int curCount = 0;
        int idx1 = 0, idx2 = 1;
        while (idx1 < nums.length && idx2 < nums.length) {
            if (nums[idx1] == nums[idx2]) {
                curCount++;
                curNum = nums[idx1];
                idx2++;
            } else {
                if (nums[idx1] == curNum) {
                    if (curCount > 0) {
                        curCount--;
                        idx2++;

                        continue;
                    }
                    else{
                        curNum = -1;
                    }

                }
                idx1 = idx2 + 1;
                idx2 = idx2 + 2;
            }
        }
        if (idx1 == nums.length - 1 && curNum == -1) {
            curNum = nums[idx1];
        }
        return curNum;
    }
}