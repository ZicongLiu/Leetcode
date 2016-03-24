public class Solution {
    public int trap(int[] height) {
        int startIdx = 0 , endIdx = height.length -1;
        
        if (height.length == 0){
            return 0;
        }
        int lHeight = height[startIdx];
        int rHeight = height[endIdx];
        int lowerHeight = 0;
        int totalWater = 0;
        
        while(startIdx < endIdx){
            lowerHeight = Math.min(lHeight , rHeight);
            if (lHeight == lowerHeight){
                lHeight = height[++startIdx];
                while (startIdx < endIdx && lowerHeight >= lHeight){
                    totalWater += lowerHeight - lHeight;
                    startIdx ++;
                    lHeight = height[startIdx];
                }
            }
            else if (rHeight == lowerHeight){
                rHeight = height[--endIdx];
                while (startIdx < endIdx && lowerHeight >= rHeight){
                    totalWater += lowerHeight - rHeight;
                    endIdx --;
                    rHeight = height[endIdx];
                }
            }
        }
        
        return totalWater;
    }
}