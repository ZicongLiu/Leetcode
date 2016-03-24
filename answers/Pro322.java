public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0 ; i < dp.length ; i ++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int coinIdx = 0 ; coinIdx < coins.length ; coinIdx ++){
            for (int money = coins[coinIdx] ; money <= amount ; money ++){
                if (dp[money - coins[coinIdx]] == Integer.MAX_VALUE){
                    continue;
                }
                dp[money] =
                    Math.min(dp[money], dp[money - coins[coinIdx]] + 1);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}