public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0){
            return;
        }
        boolean[][] swapped = new boolean[n][n];        
        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < n ; j ++){
                if (swapped[i][j]){
                    continue;
                }
                int startX = i , startY = j;
                int swapX = startY, swapY = n - 1 - startX;
                swapped[i][j] = true;
                int swap = matrix[startX][startY];
                
                while (startX != swapX || startY != swapY){
                    int tmp = matrix[swapX][swapY];
                    matrix[swapX][swapY] = swap;
                    swap = tmp;
                    swapped[swapX][swapY] = true;
                    // swap swapX & swapY
                    swapX = swapX + swapY;
                    swapY = swapX - swapY;
                    swapX = swapX - swapY;
                    swapY = n - 1 - swapY;
                }
                matrix[startX][startY] = swap;
            }
        }
    }
}


// Solution WITHOUT boolean array
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int limit = (n-1)/2;
        for(int i=0;i<= limit; i++){
            for(int j=i;j<n-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}