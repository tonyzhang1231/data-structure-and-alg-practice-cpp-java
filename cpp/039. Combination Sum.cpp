class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& A, int target) {
        vector<vector<int>> res;
        if (A.size()==0) return res;
        sort(A.begin(), A.end());
        vector<int> tmp;
        dfs(A, target, res, tmp, 0);
        return res;
    }

    void dfs(vector<int>& A, int target, vector<vector<int>>& res,  vector<int>& tmp, int start){

        if (target <=0){
            if (target==0)
                res.push_back(tmp);
            return;
        }

        for (int i=start; i<A.size();i++){
            if (A[i]>target) break;  // terminate earlier
            tmp.push_back(A[i]);
            dfs(A, target - A[i], res, tmp, i);
            tmp.pop_back();
        }

    }
};
