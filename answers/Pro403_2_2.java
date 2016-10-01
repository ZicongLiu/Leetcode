public class Solution {
    HashMap<Integer, Boolean> dp = new HashMap<Integer, Boolean>();

    boolean canCross(int[] stones){
        return canCross(stones, 0 , 0);
    }
    boolean canCross(int[] stones, int pos, int k) {
        int key = pos | k << 11;

        if (dp.containsKey(key))
            return dp.get(key);

        for (int i = pos + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[pos];
            if (gap < k - 1)
                continue;
            if (gap > k + 1){
                dp.put(key, false);
                return false;
            }
            if (canCross(stones, i, gap)){
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, (pos == stones.length - 1));
        return pos == stones.length - 1;
    }
}