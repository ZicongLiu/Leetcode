public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> ascendingStack = new Stack<Integer>();
        
        if (heights.length == 0){
            return 0;
        }
        if (heights.length == 1){
            return heights[0];
        }
        
        int max = 0;
        for (int i = 0 ; i < heights.length ; i ++){
            if (ascendingStack.isEmpty()
             || heights[i] > heights[ascendingStack.peek()]){
                ascendingStack.push(i);
                continue;
            }
            else{
                while (!ascendingStack.isEmpty()
                 && heights[ascendingStack.peek()] >= heights[i]){
                    int heightIdx = ascendingStack.pop();
                    int height = heights[heightIdx];
                    int width = (ascendingStack.isEmpty())
                     ? i : i - ascendingStack.peek() - 1;
                    max = Math.max(width * height , max);
                }
                ascendingStack.push(i);
            }
        }
        
        while (!ascendingStack.isEmpty()){
            int heightIdx = ascendingStack.pop();
            int height = heights[heightIdx];
            int width = (ascendingStack.isEmpty())
             ? heights.length: heights.length - ascendingStack.peek() - 1;
            max = Math.max(width * height , max);
        }
        
        return max;
    }
}