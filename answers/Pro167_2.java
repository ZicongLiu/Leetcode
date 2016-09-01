public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int idx1 = 0;
        while (numbers[idx1] <= target / 2){
            int rem = target - numbers[idx1];
            int idx2 = binarySearch(numbers, rem, idx1 + 1);
            if (idx2 != -1){
                result[0] = idx1 + 1;
                result[1] = idx2 + 1;
                break;
            }
            idx1 ++;
            
            while (numbers[idx1] <= target / 2
		 && numbers[idx1] == numbers[idx1 - 1]){
                idx1 ++;
            }
        }
        return result;
    }
    
    private int binarySearch(int[] numbers, int rem, int startIdx){
        int low = startIdx, high = numbers.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (numbers[mid] == rem){
                return mid;
            }
            else if (numbers[mid] > rem){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        if (numbers[low] != rem){
            return -1;
        }
        else{
            return low;
        }
    }
}