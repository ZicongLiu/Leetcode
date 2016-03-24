class Solution {  
public:  
    int findKthLargest(vector<int>& nums, int k) {  
        int length = nums.size();  
        if (length == 1) {  
            return nums[0];  
        }  
        vector<int> left;  
        vector<int> right;  
          
        for (int index=1; index<length; index++) {  
            if (nums[index] > nums[0]) {  
                right.push_back(nums[index]);  
            }else{  
                left.push_back(nums[index]);  
            }  
        }  
        length = right.size();  
        if (length >=k) {  
            return findKthLargest(right, k);  
        }else if(length == k-1){  
            return nums[0];  
        }else{  
            return findKthLargest(left, k-length-1);  
        }  
    }  
}; 