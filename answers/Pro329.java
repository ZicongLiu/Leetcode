public class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int findLongestPath(int[][] matrix, int[][] pathLen ,  int x , int y){
        if (pathLen[x][y] != 0){
            return pathLen[x][y];
        }
        pathLen[x][y] = 1;
        for (int dirIdx = 0 ; dirIdx < directions.length ; dirIdx ++){
            int i = x + directions[dirIdx][0];
            int j = y + directions[dirIdx][1];
            
            if (i < 0 || j < 0 || i >= matrix.length 
                || j >= matrix[0].length || matrix[i][j] <= matrix[x][y]){
                continue;
            }
            else{
                pathLen[x][y] = Math.max(pathLen[x][y]
                    , findLongestPath(matrix, pathLen, i, j) + 1);
            }
        }
        
        return pathLen[x][y];
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int[][] pathLen = new int[m][n];
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < n ; j ++){
                max = Math.max(max, findLongestPath(matrix, pathLen, i, j));
            }
        }
        
        return max;
    }
}