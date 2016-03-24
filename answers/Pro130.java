class Pair{
    public Pair(int i , int j){
        this.i = i;
        this.j = j;
    }
    
    public int i, j;
}
public class Solution {
    public void escape(char[][] board, int i , int j){
        
        int m = board.length;
        int n = board[0].length;
        
        if (board[i][j] == 'O'){
            Queue<Pair> queue = new LinkedList<Pair>();
            
            queue.offer(new Pair(i, j));
            while(!queue.isEmpty()){
                Pair pair = queue.poll();
                if (board[pair.i][pair.j] != 'O'){
                    continue;
                }
                else{
                    board[pair.i][pair.j] = 'E';
                }
                
                if (pair.i < m - 1 && board[pair.i + 1][pair.j] == 'O'){
                    queue.offer(new Pair(pair.i + 1 , pair.j));
                }if (pair.j < n - 1 && board[pair.i][pair.j + 1] == 'O'){
                    queue.offer(new Pair(pair.i , pair.j + 1));
                }if (pair.i > 0 && board[pair.i - 1][pair.j] == 'O'){
                    queue.offer(new Pair(pair.i - 1 , pair.j));
                }if (pair.j > 0 && board[pair.i][pair.j - 1] == 'O'){
                    queue.offer(new Pair(pair.i , pair.j - 1));
                }
                
            }
        }
    }
    
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0){
            return;
        }
        int n = board[0].length;
        for (int i = 0  ; i < m ; i ++){
            if (board[i][0] == 'O'){
                escape(board, i , 0);
            }
            if (board[i][n - 1] == 'O'){
                escape(board, i, n - 1);
            }
        }
        
        for (int i = 0 ; i < n ; i++){
            if (board[0][i] == 'O'){
                escape(board, 0 , i);
            }
            if (board[m - 1][i] == 'O'){
                escape(board, m - 1 , i);
            }
        }
        
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j ++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if (board[i][j] == 'E'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}