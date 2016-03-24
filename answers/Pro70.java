public class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        int cs[] = new int[n + 1];
        cs[0] = 1;
        cs[1] = 1;
        for (int idx = 2; idx <= n ; idx ++){
            cs[idx] = cs[idx - 1] + cs[idx - 2];
        }
        
        return cs[n];
    }
}