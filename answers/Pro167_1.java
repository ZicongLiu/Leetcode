public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int idx1 = 0, idx2 = numbers.length - 1;
        while (numbers[idx1] + numbers[idx2] != target){
            if (numbers[idx1] + numbers[idx2] < target){
                idx1 ++;
                while (idx1 < idx2 && numbers[idx1] == numbers[idx1 - 1]){
                    idx1 ++;
                }
            }
            else{
                idx2 --;
                while (idx1 < idx2 && numbers[idx2] == numbers[idx2 + 1]){
                    idx2 --;
                }
            }
        }
        result[0] = idx1 + 1; 
        result[1] = idx2 + 1;
        return result;
    }
}