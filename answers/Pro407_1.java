class Cell{
    public int x;
    public int y;
    public int height;
    public Cell(int x , int y , int height){
        this.x = x;
        this.y = y;
        this.height = height;
    }
}
public class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int trapRainWater(int[][] heightMap) {
        int result = 0;
        if (heightMap.length == 0 || heightMap[0].length == 0){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(m * n,
         new Comparator<Cell>(){
           public int compare(Cell c1 , Cell c2){
               return c1.height - c2.height;
           } 
        });
        boolean[][] visited = new boolean[m][n];
        for (boolean[] v : visited){
            Arrays.fill(v, false);
        }
        
        for (int i = 0 ; i < m ; i ++){
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i,0, heightMap[i][0]));
            queue.offer(new Cell(i,n - 1, heightMap[i][n - 1]));
        }
        for (int i = 0 ; i < n ; i ++){
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m - 1, i , heightMap[m - 1][i]));
        }
        
        while (!queue.isEmpty()){
            Cell curCell = queue.poll();
            for (int[] direction : directions){
                int curX = curCell.x + direction[0];
                int curY = curCell.y + direction[1];
                if (curX < 0 || curY < 0 || curX >= m || curY >= n ||
                    visited[curX][curY]){
                        continue;
                }
                visited[curX][curY] = true;
                result += Math.max(0,
                 curCell.height - heightMap[curX][curY]);
                queue.offer(new Cell(curX, curY,
                 Math.max(curCell.height, heightMap[curX][curY])));
            }
        }
        return result;
    }
}