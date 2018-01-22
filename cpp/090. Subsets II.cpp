class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& A) {

        vector<vector<int>> res;
        sort(A.begin(), A.end());
        vector<int> tmp;
        dfs(A, res, tmp, 0);
        return res;

    }

    void dfs(vector<int>& A, vector<vector<int>>& res, vector<int>& tmp, int start){
        res.push_back(tmp);
        for(int i=start;i<A.size();i++){
            if (i>start && A[i]==A[i-1]) continue;
            tmp.push_back(A[i]);
            dfs(A, res, tmp, i + 1);
            tmp.pop_back();
        }
    }
};
