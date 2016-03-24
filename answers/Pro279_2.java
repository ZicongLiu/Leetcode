public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        ArrayList<Integer> squares = new ArrayList<Integer>();
        for (int i = 1 ; i <= n ; i ++){
            if (i * i > n){
                break;
            }
            else{
                squares.add(i * i);
            }
        }
        for (int i = 2 ; i <= n ; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0 ; j < squares.size() ; j++){
                if (squares.get(j) > i){
                    break;
                }
                else if (squares.get(j) == i){
                    min = 1;
                    break;
                }
                else{
                   if (dp[i - squares.get(j)] + 1 < min){
                       min = dp[i - squares.get(j)] + 1;
                   }
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }
}