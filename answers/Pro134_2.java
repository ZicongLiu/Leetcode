public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int totalGas = 0;
        for (int i = 0 ; i < gas.length ; i++){
            diff[i] = gas[i] - cost[i];
            totalGas += diff[i];
        }
        if (totalGas < 0){
            return -1;
        }
        int startIdx = 0;
        int sum = 0;
        for (int i = 0 ; i < gas.length ; i++){
            sum += diff[i];
            if (sum < 0){
                startIdx = (i + 1) % gas.length;
                sum = 0;
            }
        }
        return startIdx;
    }
}