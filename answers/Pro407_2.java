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
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length, n = heightMap[0].length;
        int[][] water = new int[m][n];

        // Scan by rows
        for (int idxRow = 0; idxRow < m; idxRow++) {
            int left = 0, right = n - 1;
            water[idxRow][left] = water[idxRow][right] = 0;
            while (left < right) {
                boolean leftToRight =
                 (heightMap[idxRow][left] <= heightMap[idxRow][right]);
                int min = Math.min(heightMap[idxRow][left],
                        heightMap[idxRow][right]);
                int curVal = min;
                do {
                    int curPos;
                    if (leftToRight) {
                        left++;
                        curPos = left;
                    } else {
                        right--;
                        curPos = right;
                    }
                    curVal = heightMap[idxRow][curPos];
                    if (curVal <= min) {
                        water[idxRow][curPos] = min - curVal;
                    }
                } while (left < right && curVal <= min);
            }
            water[idxRow][left] = 0;
        }

        // Scan by columns
        for (int idxCol = 0; idxCol < n; idxCol++) {
            int up = 0, down = m - 1;
            water[up][idxCol] = water[down][idxCol] = 0;
            while (up < down) {
                boolean upToDown =
                 (heightMap[up][idxCol] <= heightMap[down][idxCol]);
                int min = Math.min(heightMap[up][idxCol],
                        heightMap[down][idxCol]);
                int curVal = min;
                do {
                    int curPos;
                    if (upToDown) {
                        up++;
                        curPos = up;
                    } else {
                        down--;
                        curPos = down;
                    }
                    curVal = heightMap[curPos][idxCol];
                    if (curVal <= min) {
                        water[curPos][idxCol] =
                         Math.min(min - curVal, water[curPos][idxCol]);
                    }
                    else{
                        water[curPos][idxCol] = 0;
                    }
                } while (up < down && curVal <= min);
            }
            water[up][idxCol] = 0;
        }

        int sum = 0;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                sum += water[i][j];
            }
        }

        // balance water
        boolean spillWater = true;
        while(spillWater){
            spillWater = false;
            for(int i = 1; i < heightMap.length - 1; i++){
                for(int j = 1; j < heightMap[0].length - 1; j++){
                    /*If this slot has ever gotten wet,
                     exammine its 4 neightbors*/
                    if(water[i][j] != 0){
                        for(int[] direction : directions){
                            int neighborRow = i + direction[0];
                            int neighborCol = j + direction[1];
                            int currentHeight = water[i][j] + heightMap[i][j];
                            int neighborHeight =
                             water[neighborRow][neighborCol] + 
                              heightMap[neighborRow][neighborCol];
                            if(currentHeight > neighborHeight){
                                int spilledWater = currentHeight -
                                 Math.max(neighborHeight, heightMap[i][j]);
                                water[i][j] = Math.max(0,
                                 water[i][j] - spilledWater);
                                sum -= spilledWater;
                                spillWater = true;
                            }
                        }    
                    }    
                }
            }
        }
        return sum;
    }
}