public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0){
            return 0;
        }
        int fullDepth = triangle.size();
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int depth = 1 ; depth < fullDepth ; depth ++){
            dp[depth][0] = dp[depth - 1][0] + triangle.get(depth).get(0);
            dp[depth][depth] = dp[depth - 1][depth-1] + triangle.get(depth).get(depth);
        }
        
        for (int depth = 2 ; depth < fullDepth ; depth ++){
            for (int col = 1 ; col < depth ; col ++){
                dp[depth][col] = Math.min(dp[depth - 1][col] , dp[depth - 1][col - 1]) + triangle.get(depth).get(col);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int col = 0 ; col < fullDepth ; col ++){
            if (dp[fullDepth - 1][col] < min){
                min = dp[fullDepth - 1][col];
            }
        }
        
        return min;
    }
}