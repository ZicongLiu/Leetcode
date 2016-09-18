class Solution {
public:
    typedef pair<int, int> pp; // <value, index>

    static bool comp(const pp& i, const pp& j) { return (i.first < j.first); }

    vector<pp> mNums;

    Solution(vector<int> nums) {
        for(int i = 0; i < nums.size(); i++) {
            mNums.push_back(pp({nums[i], i}));
        }
        sort(mNums.begin(), mNums.end(), comp);
    }

    int pick(int target) {
        pair<vector<pp>::iterator, vector<pp>::iterator> bounds =
         equal_range(mNums.begin(), mNums.end(), pp({target,0}), comp);
        int s = bounds.first - mNums.begin();
        int e = bounds.second - mNums.begin();
        int r = e - s;
        return mNums[s + (rand() % r)].second;
    }
};