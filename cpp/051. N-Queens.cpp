class Solution {
public:
    std::vector<vector<string>> solveNQueens(int n) {
        std::vector<bool> col(n,false), diag(2*n,false), diag2(2*n,false);
        std::vector<std::vector<std::string>> res;        
        std::vector<std::string> tmp(n, std::string(n, '.')); // std::string
        dfs(res, tmp, 0, n, col, diag, diag2);
        return res;
    }
    
    void dfs(vector<vector<string>>& res, vector<string>& tmp, int row, int& n, vector<bool>& col, 
        vector<bool>& diag, vector<bool>& diag2){
        if (row==n) {
            res.push_back(tmp);
            return;
        }
        for (int i=0;i<n;i++){
            if (col[i] || diag[n + row - i] || diag2[row + i]) continue;
            col[i] = true;
            diag[n + row - i] = true;
            diag2[row + i] = true;
            tmp[row][i] = 'Q';
            
            dfs(res, tmp, row + 1, n, col, diag, diag2);
            
            // reset
            col[i] = false;
            diag[n + row - i] = false;
            diag2[row + i] = false;
            tmp[row][i] = '.';
        }
    }
};

// std::string()