public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        if (matrix.length == 0)
            return false;
        int startCol = matrix[0].length - 1;
        while (startCol >= 0 && startRow < matrix.length){
            int compare = matrix[startRow][startCol];
            if (compare == target)
                return true;
            else{
                if (target < compare){
                    startCol --;
                }
                else{
                    startRow ++;
                }
            }
        }
        return false;
    }
}