public class Solution {
    boolean[][] rowFilled = new boolean[9][9];
    boolean[][] colFilled = new boolean[9][9];
    boolean[][] gridFilled = new boolean[9][9];
    
    private boolean fill(char[][] board, int pos){
        int curX = pos / 9;
        int curY = pos % 9;
        if (board[curX][curY] == '.'){
            for (int ava = 0 ; ava < 9 ; ava ++){
                if (rowFilled[curX][ava] || colFilled[curY][ava]
                    || gridFilled[curX / 3 * 3 + curY / 3][ava]){
                    continue;
                }
                else{
                    // have a try
                    rowFilled[curX][ava] = true;
                    colFilled[curY][ava] = true;
                    gridFilled[curX / 3 * 3 + curY / 3][ava] = true;
                    board[curX][curY] = (char)('0' + 1 + ava);
                    if (pos == 80){
                        return true;
                    }
                    
                    if (!fill(board, pos + 1)){
                        //recover
                        board[curX][curY] = '.';
                        rowFilled[curX][ava] = false;
                        colFilled[curY][ava] = false;
                        gridFilled[curX / 3 * 3 + curY / 3][ava] = false;
                    }
                    else{
                        return true;
                    }
                }
            }
            return false;
        }
        else{
            if (pos == 80){
                return true;
            }
            
            return fill(board, pos + 1);
        }
    }
    
    public void solveSudoku(char[][] board) {
        for (int i = 0 ; i < 9 ; i ++){
            for (int j = 0 ; j < 9 ; j++){
                if (board[i][j] == '.'){
                    continue;
                }
                int curVal = board[i][j] - '0' - 1;
                rowFilled[i][curVal] = true;
                colFilled[j][curVal] = true;
                gridFilled[i / 3 * 3 + j / 3][curVal] = true;
            }
        }
        
        fill(board, 0);
    }
}