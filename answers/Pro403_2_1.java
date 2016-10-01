public class Solution {
    public boolean canCross(int[] stones){
        return canCross(stones, 0, 0);
    }
    public boolean canCross(int[] stones, int pos , int k) {
        for (int i = pos + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[pos];
            if (gap < k - 1) continue;
            if (gap > k + 1) return false;
            if (canCross(stones, i, gap)) return true;
        }
        return pos == stones.length - 1;
    }
}