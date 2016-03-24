public class Solution {
    public int jump(int[] nums) {
        int curMax = 0;
        int lastMax = 0;
        int stepCnt = 0;
        
        for (int currentIdx = 0 ; currentIdx < nums.length ; currentIdx ++){
            // Of no use since you can always reach the last index
            // if (i < curMax){
            //     return -1;
            // }
            
            if (currentIdx > lastMax){
                lastMax = curMax;
                stepCnt ++;
            }
            
            curMax = Math.max(curMax, currentIdx + nums[currentIdx]);
        }
        
        return stepCnt;
    }
}