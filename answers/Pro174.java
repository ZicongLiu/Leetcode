public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if (m == 0){
            return 1;
        }
        int n = dungeon[0].length;
    
        int guaranteedHealth[][] = new int[m][n];
        guaranteedHealth[m - 1][n - 1] = (dungeon[m - 1][n - 1] > 0)
         ? 0 : Math.abs(dungeon[m - 1][n - 1]);
        
        for (int i = m - 2 ; i >= 0 ; i --){
            int health = guaranteedHealth[i + 1][n - 1] - dungeon[i][n - 1];
            guaranteedHealth[i][n - 1] = Math.max(0, health);
        }
        for (int i = n - 2 ; i >= 0 ; i --){
            int health = guaranteedHealth[m - 1][i + 1] - dungeon[m - 1][i];
            guaranteedHealth[m - 1][i] = Math.max(0, health);
        }
        for (int i = m - 2 ; i >= 0 ; i--){
            for (int j = n - 2 ; j >= 0 ; j --){
                guaranteedHealth[i][j] = Math.max(
                    Math.min(guaranteedHealth[i + 1][j]
                     , guaranteedHealth[i][j + 1]) - dungeon[i][j], 0);
            }
        }
        
        return guaranteedHealth[0][0] + 1;
    }
}