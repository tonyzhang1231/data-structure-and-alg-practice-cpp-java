class Solution {
public:
    int totalNQueens(int n) {
        vector<bool> col(n,false), diag(2*n,false), diag2(2*n,false);
        int res = 0;
        dfs(0, n ,col, diag, diag2, res);
        return res;
    }
    
    void dfs(int row, int& n, vector<bool>& col, vector<bool>& diag, vector<bool>& diag2, int& res){
        if (row == n){
            res++;
            return;
        }
        
        for (int j=0;j<n;j++){
            if (col[j] || diag[n - row + j] || diag2[row + j]) continue;
            col[j] = true;
            diag[n - row + j]= true;
            diag2[row + j] = true;
            
            dfs(row + 1, n , col, diag, diag2, res);
            
            col[j] = false;
            diag[n - row + j]= false;
            diag2[row + j] = false;
            
        }
        
        
    }
};

// the same solution, 
int totalNQueens(int n) {
    bool flag[5*n] = {false};
    int num = 0;
    dfs(num,flag,0,n);
    return num;
}

void dfs(int& num, bool* flag, int row, int n){
    if(row == n){ // find a solution
        ++num;
        return;
    }
    for(int i = 0; i<n;i++){
        if(!flag[i] && !flag[row+i+n] && !flag[4*n + row - i]){
            flag[i] = 1;  flag[row+i+n] = 1; flag[4*n + row - i] = 1; // set flag
            dfs(num,flag,row+1,n);
            flag[i] = 0; flag[row+i+n] = 0; flag[4*n + row - i] = 0; // reset flag
        }
    }
}
