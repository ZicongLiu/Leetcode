public class Solution {
        List<List<String>> puzzles = new ArrayList<List<String>>();
        
        public void solveNQueens(int n, int curRow, int[][] puzzle){
            if (curRow == n){
                puzzles.add(generatePuzzle(puzzle));
                return ;
            }
            for (int col = 0 ; col < n ; col ++){
                if (isValid(puzzle, curRow, col)){
                    puzzle[curRow][col] = 1;
                    solveNQueens(n, curRow + 1, puzzle);
                    puzzle[curRow][col] = 0;
                }
            }
        }
        
        public List<List<String>> solveNQueens(int n) {
            int[][] puzzle = new int[n][n];
            
            solveNQueens(n, 0, puzzle);
            
            return puzzles;
        }
        
        public boolean isValid(int[][] puzzle, int row, int col){
            // check row
            for (int i = 0 ; i < col ; i++){
                if (puzzle[row][i] == 1){
                    return false;
                }
            }
            
            // check column
            for (int i = 0 ; i < row ; i++){
                if (puzzle[i][col] == 1){
                    return false;
                }
            }
            // check top left
            for (int i = 1 ; i <= Math.min(row, col) ; i++){
                if (puzzle[row - i][col - i] == 1){
                    return false;
                }
            }
            // check top right
            for (int i = 1 ; i <= Math.min(row, puzzle.length - col - 1) ; i ++){
                if (puzzle[row - i][col + i] == 1){
                    return false;   
                }
            }
            
            return true;
        }
        
        public List<String> generatePuzzle(int[][] puzzle){
            List<String> result = new ArrayList<String>();
            for (int i = 0 ; i < puzzle.length ; i ++){
                String newLine = "";
                for (int j = 0 ; j < puzzle[0].length ; j++){
                    if (puzzle[i][j] == 0){
                        newLine += ".";
                    }
                    else{
                        newLine += "Q";                    
                    }
                }
                result.add(newLine);
            }
            
            return result;
        }
}