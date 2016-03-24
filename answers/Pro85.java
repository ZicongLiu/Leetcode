public class Solution {
    public int maximalRectangle(char[][] matrix) {
        Stack<Integer> stack = new Stack<Integer>();
        int m = matrix.length;
        if (m == 0){
            return 0;
        }
        int n = matrix[0].length;
        
        int[][] nums = new int[m][n];
        
        for (int i = m - 1 ; i >= 0 ; i --){
            for (int j = 0 ; j < n ; j ++){
                if (i == m - 1){
                    nums[i][j] = matrix[i][j] - '0';
                }
                else{
                    if (matrix[i][j] == '1'){
                        nums[i][j] = nums[i + 1][j] + (matrix[i][j] - '0');
                    }
                    else{
                        nums[i][j] = 0;
                    }
                }
            }
        }
        
        int max = 0;
        
        for (int i = m - 1 ; i >= 0 ; i --){
            stack = new Stack<Integer>();
            for (int j = 0 ; j <= n ; j ++){
                if (j != n && (stack.isEmpty() || nums[i][stack.peek()] < nums[i][j])){
                    stack.push(j);
                    continue;
                }
                else{
                    while (!stack.isEmpty() && (j == n || nums[i][stack.peek()] >= nums[i][j])){
                        int idx = stack.pop();
                        int height = nums[i][idx];
                        int width = (stack.isEmpty()) ? j : j - stack.peek() - 1 ;
                        max = Math.max(width * height, max);
                    }
                    
                    if (j < n){
                        stack.push(j);
                    }
                }
            }
        }
        return max;
    }
}