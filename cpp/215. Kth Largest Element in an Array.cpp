215. Kth Largest Element in an Array

// 1. pq
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, std::greater<int>> q;
        
        for (auto& i:nums){
            q.push(i);
            if (q.size()>k){
                q.pop();
            }
        }
        
        return q.top();
    }
};


// 2. multiset
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        multiset<int> mset;
        int n = nums.size();
        for (int i = 0; i < n; i++) { 
            mset.insert(nums[i]);
            if (mset.size() > k)
                mset.erase(mset.begin());
        }
        return *mset.begin();
    }
};

// multiset 就是 red black tree, Search, insertion, and removal operations have logarithmic complexity.
// constructor
// http://en.cppreference.com/w/cpp/container/multiset/multiset