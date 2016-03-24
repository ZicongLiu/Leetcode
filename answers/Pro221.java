public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int maxSide = 0;
        for (int i = 0 ; i < m ; i++){
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0 ; i < n ; i++){
            dp[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < m ; i++){
            for (int j = 1 ; j < n ; j ++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                     Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < n ; j ++){
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}