public class Solution {
    int count = 0;
    
    public void solveNQueens(int total, int row, int[] cols){
        if (total == row){
            count++;
            return;
        }
        for (int col = 0 ; col < total; col ++){
            if (isValid(cols, row, col)){
                cols[row] = col;
                solveNQueens(total, row + 1 , cols);   
                cols[row] = -1;
            }
        }
    }
    
    public boolean isValid(int[] cols, int row, int col){
        
        for (int i = 0 ; i < row ; i++){
            // check same col
            if (cols[i] == col){
                return false;
            }
            // check top left & top right
            if (row - col == i - cols[i] || row + col == i + cols[i]){
                return false;
            }
        }
        
        return true;
    }
    
    public int totalNQueens(int n) {
        int[] cols = new int[n];
        for (int i = 0 ; i < n ; i++){
            cols[i] = -1;
        }
        solveNQueens(n, 0, cols);
        return count;
    }
}