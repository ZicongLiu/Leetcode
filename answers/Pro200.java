public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0 ; i < grid.length ; i ++){
            for (int j = 0 ; j < grid[0].length ; j ++){
                if (grid[i][j] == '1'){
                    wander(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }
    
    public void wander(char[][] grid, int i , int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        if (grid[i][j] == '1'){
            grid[i][j] = 'X';      
            wander(grid, i , j + 1);
            wander(grid, i + 1 , j);
            wander(grid, i - 1 , j);
            wander(grid, i , j - 1);
        }

    }
}