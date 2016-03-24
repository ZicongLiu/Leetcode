public class Solution {
    int[][] directions = {{-1,0},{0,-1},{-1,-1},{1,0}
                          ,{0,1},{1,1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        if (board.length == 0){
            return;
        }
        for(int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                int liveNeighbors = 0;
                for (int dirIdx = 0 ; dirIdx < 8 ; dirIdx ++){
                    int x = i + directions[dirIdx][0];
                    int y = j + directions[dirIdx][1];
                    if (x < 0 || y < 0 || x >= board.length
                     || y >= board[0].length){
                        continue;
                    }
                    liveNeighbors += board[x][y] & 1;
                }
                
                if (liveNeighbors < 2 || liveNeighbors > 3){
                    board[i][j] = (0 << 1) + board[i][j];
                } else if (liveNeighbors == 2){
                    board[i][j] = (board[i][j] << 1) + board[i][j];
                } else if (liveNeighbors == 3){
                    board[i][j] = (1 << 1) + board[i][j];
                }
            }
        }
        
        for (int i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[0].length ; j++){
                board[i][j] = (board[i][j] >>> 1);
            }
        }
    }
}