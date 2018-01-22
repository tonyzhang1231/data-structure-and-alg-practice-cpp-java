class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> v2i;
        vector<int> res; 
        for (int i=0;i<nums.size();i++){
            if (v2i.find(nums[i])!= v2i.end()){
                res.push_back(v2i[nums[i]]);
                res.push_back(i);
                return res;
            }else{
                v2i[target - nums[i]] = i;
            }
        }
        return res;
    }
};