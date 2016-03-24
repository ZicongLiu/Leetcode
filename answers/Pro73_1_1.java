public class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        if (rowLength == 0){
            return ;
        }
        int colLength = matrix[0].length;
        boolean rowZero[] = new boolean[rowLength];
        boolean colZero[] = new boolean[colLength];
        
        for (int rowIdx = 0 ; rowIdx < rowLength ; rowIdx ++){
            for (int colIdx = 0 ; colIdx < colLength; colIdx ++){
                if(matrix[rowIdx][colIdx] == 0){
                    rowZero[rowIdx] = true;
                    colZero[colIdx] = true;
                }
            }
        }
        
        for (int rowIdx = 0 ; rowIdx < rowLength ; rowIdx ++){
            if (rowZero[rowIdx]){
                for (int colIdx = 0 ; colIdx < colLength ; colIdx ++){
                    matrix[rowIdx][colIdx] = 0;
                }
            }
        }
        
        for (int colIdx = 0 ; colIdx < colLength ; colIdx ++){
            if (colZero[colIdx]){
                for (int rowIdx = 0 ; rowIdx < rowLength ; rowIdx ++){
                    matrix[rowIdx][colIdx] = 0;
                }
            }
        }
    }
}