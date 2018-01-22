class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> res;
        if (n>45) return res;
        vector<int> tmp;
        dfs(res, tmp, k,n,1);
        return res;
    }
    
    void dfs(vector<vector<int>>& res, vector<int>& tmp, int k, int n, int start){
        if (n<0) return;
        if (k==0 and n==0){
            res.push_back(tmp);
            return;
        }
        
        for (int i=start;i<=9;i++){
            if (i>n) break;
            tmp.push_back(i);
            dfs(res, tmp, k-1,n-i,i+1);
            tmp.pop_back();
        }
    }
};