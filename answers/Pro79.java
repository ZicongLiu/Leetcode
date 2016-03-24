public class Solution {
    // int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean wordSearch(char[][] board, boolean[][] visited,
     int curX, int curY, String word, int wordIdx){
        int m = board.length;
        int n = board[0].length;
        
        if (wordIdx >= word.length()){
            return true;
        }
        if (curX < 0|| curY < 0|| curX >= board.length|| curY >= board[0].length
            || word.charAt(wordIdx) != board[curX][curY]
            || visited[curX][curY] == true){
            return false;
        }
        
        visited[curX][curY] = true;
        
        boolean result=wordSearch(board,visited, curX-1, curY, word, wordIdx+1) 
                    || wordSearch(board,visited, curX+1, curY, word, wordIdx+1)
                    || wordSearch(board,visited, curX, curY-1, word, wordIdx+1)
                    || wordSearch(board,visited, curX, curY+1, word, wordIdx+1);
        visited[curX][curY] = false;
        
        return result;
    }
    
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[0].length ; j ++){
                if (wordSearch(board, visited, i, j, word, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
}