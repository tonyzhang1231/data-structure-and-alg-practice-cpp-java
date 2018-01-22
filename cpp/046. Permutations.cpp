// two solutions
// 1. 

class Solution {
public:
    vector<vector<int>> permute(vector<int>& A) {
        vector<vector<int>> res;
        if (A.size()==0) return res;
        std::sort(A.begin(), A.end());
        vector<int> tmp;
        vector<bool> used(A.size(), false);
        dfs(res, A, tmp, used);
        return res;
    }
    
    void dfs(vector<vector<int>>& res, vector<int>& A, vector<int>& tmp, vector<bool>& used){
        if (tmp.size()==A.size()){
            res.push_back(tmp);
            return;
        }
        
        for (int i=0;i<A.size();i++){
            if (!used[i]){
                tmp.push_back(A[i]);
                used[i] = true;
                dfs(res, A, tmp, used);
                tmp.pop_back();
                used[i] = false;
            }
        }
    }
};