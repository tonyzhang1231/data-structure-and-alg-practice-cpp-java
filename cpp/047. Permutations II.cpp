class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& A) {
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
            if (!(used[i] || i>0 && !used[i-1] && A[i-1]==A[i])){
                tmp.push_back(A[i]);
                used[i] = true;
                dfs(res, A, tmp, used);
                tmp.pop_back();
                used[i] = false;
            }
        }
    }
};

// 2. swap
class Solution {
public:
    void recursion(vector<int> num, int i, int j, vector<vector<int> > &res) {
        if (i == j-1) {
            res.push_back(num);
            return;
        }
        for (int k = i; k < j; k++) {
            if (i != k && num[i] == num[k]) continue;
            swap(num[i], num[k]);
            recursion(num, i+1, j, res);
        }
    }
    vector<vector<int> > permuteUnique(vector<int> &num) {
        sort(num.begin(), num.end());
        vector<vector<int> >res;
        recursion(num, 0, num.size(), res);
        return res;
    }
};
