public class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        // Arrays.sort(nums);
        long maxSum = 0;
        for (int i = 0 ; i < nums.length ; i ++){
            if (nums[i] <= maxSum + 1){
                maxSum += nums[i];
            }
            else{
                while (nums[i] > maxSum + 1){
                    count ++;
                    maxSum = 2 * maxSum + 1;
                    
                if (maxSum >= n){
                    return count;
                }
                    if (nums[i] <= maxSum + 1){
                        maxSum += nums[i];
                    }
                }
            }
            if (maxSum >= n){
                return count;
            }
        }
        if (maxSum == 0){
            maxSum = 1;
            count ++;
        }
        while (maxSum < n){
            maxSum = 2 * maxSum + 1;
            count++;
        }
        return count;
    }
}

// A more concise version
class Solution {  
public:  
    int minPatches(vector<int>& nums, int n) {  
        int cnt = 0, i = 0;  
        for (long known_sum = 1; known_sum <= n;) {  
            if (i < nums.size() && nums[i] <= known_sum) {  
                known_sum += nums[i++];  
            }  
            else {  
                known_sum <<= 1;  
                cnt++;  
            }  
        }  
        return cnt;  
    }  
};  