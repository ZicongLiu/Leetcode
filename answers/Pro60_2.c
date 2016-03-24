class Solution {
    int getPermutationNumber(int n) {
        int result = 1;
        for(int i=1;i<=n;++i) {
            result *=i;
        }

        return result;
    }
public:
    string getPermutation(int n, int k) {
        vector<int> result;        
        vector<int> nums;
        for(int i=1;i<=n;++i) {
            nums.push_back(i);
        }
        k=k-1;
        for(int i=0;i<n;++i) {
            int perms = getPermutationNumber(n-1-i);
            int index = k/perms;
            result.push_back(nums[index]);
            k%=perms;
            nums.erase(nums.begin()+index);
        }
        string s="";
        for(int i=0;i<result.size();++i) {
            s += std::to_string(result[i]);
        }
        return s;
    }
};