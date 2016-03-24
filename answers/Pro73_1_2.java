public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0){
            return;
        }
        int n = matrix[0].length;
        boolean zeroInFirstRow = false;
        boolean zeroInFirstCol = false;
        for (int rowIdx = 0 ; rowIdx < m ; rowIdx ++){
            if (matrix[rowIdx][0] == 0){
                zeroInFirstCol = true;
                break;    
            }
        } 
        for (int colIdx = 0 ; colIdx < n ; colIdx ++){
            if (matrix[0][colIdx] == 0){
                zeroInFirstRow = true;
                break;
            }
        }
        
        for (int rowIdx = 0 ; rowIdx < m ; rowIdx ++){
            for (int colIdx = 0 ; colIdx < n ; colIdx ++){
                if (matrix[rowIdx][colIdx] == 0){
                    matrix[rowIdx][0] = 0;
                    matrix[0][colIdx] = 0;
                }
            }
        }
        
        for (int rowIdx = 1 ; rowIdx < m ; rowIdx ++){
            for (int colIdx = 1 ; colIdx < n ; colIdx ++){
                if (matrix[rowIdx][0] == 0 || matrix[0][colIdx] == 0){
                    matrix[rowIdx][colIdx] = 0;
                }
            }
        }
        
        if (zeroInFirstRow){
            for (int colIdx = 0 ; colIdx < n ; colIdx ++){
                matrix[0][colIdx] = 0;
            }
        }
        if (zeroInFirstCol){
            for (int rowIdx = 0 ; rowIdx < m ; rowIdx ++){
                matrix[rowIdx][0] = 0;
            }
        }
        
    }
}