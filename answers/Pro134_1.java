public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int[] sum = new int[gas.length];
        int totalGas = 0;
        // Of course I can combine the calculation of totalSum
        // with calculating max and min
        for (int i = 0 ; i < gas.length ; i++){
            diff[i] = gas[i] - cost[i];
            totalGas += diff[i];
        }
        if (totalGas < 0){
            return -1;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxIdx = 0, minIdx = 0;
        int curMax = 0 , curMin = 0;
        for (int i = 0 ; i < gas.length ; i++){
            if (curMax < 0){
                curMax = diff[i];
                maxIdx = i;
            }
            else{
                curMax += diff[i];
            }
            if (curMin > 0){
                curMin = diff[i];
            }
            else{
                curMin += diff[i];
            }
            if (curMin < min){
                min = curMin;
                minIdx = (i + 1) % gas.length;
            }
            if (curMax > max){
                max = curMax;
            }
        }
        return (max > totalGas - min) ? maxIdx : minIdx;
    }
}