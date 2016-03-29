public class Solution {
    public int missingNumber(int[] nums) {
        int sumExp = 0;
        int sumAct = 0;
        int n = nums.length;
        for (int i = 0 ; i <= n ; i++){
            sumExp += i;
        }
        for (int num : nums){
            sumAct += num;
        }
        return sumExp - sumAct;
    }
}