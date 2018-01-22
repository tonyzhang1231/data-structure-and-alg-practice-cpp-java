class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& A, int target) {
        std::sort(A.begin(),A.end());
        vector<vector<int>> res;
        vector<int> tmp;
        dfs(res, A, target, tmp, 0);
        return res;
    }
    
    void dfs(vector<vector<int>>& res, vector<int>& A, int target, vector<int>& tmp, int start){
        if(target<0) return;
        if (target==0){
            res.push_back(tmp);
            return;
        }
        
        for (int i=start;i<A.size();i++){
            if (A[i] > target) break; // early terminate
            if (i>start and A[i]==A[i-1]) continue; // avoid dup
            tmp.push_back(A[i]);
            dfs(res, A, target - A[i], tmp, i+1);
            tmp.pop_back();
            
        }
    }
    
};