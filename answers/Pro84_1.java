public class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0 ; i < heights.length ; i ++){
            int height = heights[i];
            int left = i , right = i;
            while (left > 0 && heights[left - 1] >= height){
                left --;
            }
            while (right < heights.length - 1
             && heights[right + 1] >= height){
                right ++;
            }
            int width = right - left + 1;
            
            max = Math.max(width * height, max);
        }
        
        return max;
    }
}