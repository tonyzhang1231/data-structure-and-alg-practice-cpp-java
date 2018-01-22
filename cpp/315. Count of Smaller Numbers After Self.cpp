// almost the same as 325 count of range sum
// beat 65.92%

class Solution {
public:
    void sortCount(vector<int> &ans, vector<int> &nums, vector<int>::iterator begin, vector<int>::iterator end) {
        if (end - begin <= 1)
            return;
        
        auto mid = begin + (end - begin) / 2;
        sortCount(ans, nums, begin, mid);
        sortCount(ans, nums, mid, end);

        // for each i, count the small numbers on right part
        for (auto i = begin, j = mid; i != mid; ++i) {

        	// can be replaced by binary search, I think
            while (j != end && nums[*i] > nums[*j]) ++j;
                
            ans[*i] += j - mid; // added to result
        }

        // merge sort inplace 
        inplace_merge(begin, mid, end, [&](int a, int b) { return nums[a] < nums[b]; });
    }

    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n, 0), indexes(n);
        iota(indexes.begin(), indexes.end(), 0); // return 0,1,2...,n-1
        sortCount(ans, nums, indexes.begin(), indexes.end());
        return ans;
    }
};