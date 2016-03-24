public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int curRow = 0;
        if (matrix.length == 0){
            return false;
        }
        int curCol = matrix[0].length - 1;
        while (curRow < matrix.length && curCol >= 0){
            if (target == matrix[curRow][curCol]){
                return true;
            }
            else if (target < matrix[curRow][curCol]){
                curCol --;
            }
            else{
                curRow ++;
            }
        }
        return false;
    }
}