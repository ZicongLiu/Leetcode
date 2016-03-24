class Move{
    int fromX, toX;
    int fromY, toY;
    public Move(int fromX, int fromY, int toX, int toY){
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }
}
public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3){
            return false;
        }
        for (int moveIdx = 0 ; moveIdx < x.length ; moveIdx ++){
            // 1st line cross 4th line
            if (moveIdx >= 3){
                if (x[moveIdx - 3] >= x[moveIdx - 1]
                    && x[moveIdx] >= x[moveIdx - 2]){
                    return true;
                }
            }
            // 1st cross 5th
            if (moveIdx >= 4){
                if (x[moveIdx - 3] == x[moveIdx - 1]
                    && x[moveIdx - 2] <= x[moveIdx - 4] + x[moveIdx]){
                    return true;
                }
            }
            // 1st cross 6th
            if (moveIdx >= 5){
                if (x[moveIdx - 4] <= x[moveIdx - 2]
                    && x[moveIdx - 1] <= x[moveIdx - 3]
                    // No need to check 
                    // &&x[moveIdx - 5] <= x[moveIdx - 3] 
                    // && x[moveIdx] <= x[moveIdx - 2]
                    && x[moveIdx - 2] <= x[moveIdx - 4] + x[moveIdx]
                    && x[moveIdx - 3] <= x[moveIdx - 5] + x[moveIdx - 1]){
                        return true;
                    }
            }
        }
        return false;
    }
}