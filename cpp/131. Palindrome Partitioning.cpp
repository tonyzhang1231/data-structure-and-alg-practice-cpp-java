class Solution {
public:
    // first find all the pal substr and backtrack
    vector<vector<string>> partition(string s) {
        int n = s.size();
        vector<vector<bool>> isPal(n, vector<bool>(n,false));
        for (int i=0;i<n;i++){
            makePal(s, isPal, i, i, n);
            makePal(s, isPal, i, i+1, n);
        }
        
        vector<vector<string>> res;
        vector<string> tmp;
        dfs(res, s, tmp, 0, isPal);
            
        return res;
    }
    
    void dfs(vector<vector<string>>& res, string& s,vector<string>& tmp, int start, vector<vector<bool>>& isPal){
        if (start == s.size()) {
            res.push_back(tmp);
            return;
        }
        
        for (int i=start;i<s.size();i++){
            if (isPal[start][i]){
                tmp.push_back(s.substr(start, i-start + 1));
                dfs(res, s, tmp,i+1, isPal);
                tmp.pop_back();
            }
        }
    }
    
    void makePal(string& s, vector<vector<bool>>& isPal, int i, int j, int n){
        while(i>=0 and j<n and s[i]==s[j]){
            isPal[i][j] = true;
            i--;j++;
        }
    }
};