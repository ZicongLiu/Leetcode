public class Solution {
    int max_value = 9;
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowFilled = new boolean[board.length][max_value];
        boolean[][] colFilled = new boolean[board[0].length][max_value];
        boolean[][] gridFilled = new boolean[9][max_value];
        
        for (int i = 0; i < board.length; i ++){
            for (int j = 0 ; j < board[0].length ; j ++){
                if (board[i][j] == '.'){
                    continue;
                }
                int curVal = board[i][j] - '0' - 1;
                if (rowFilled[i][curVal] || colFilled[j][curVal]
                    || gridFilled[i / 3 * 3 + j / 3][curVal]){
                    return false;
                }
                rowFilled[i][curVal] = true;
                colFilled[j][curVal] = true;
                gridFilled[i / 3 * 3 + j / 3][curVal] = true;
            }
        }
        
        return true;
    }
}