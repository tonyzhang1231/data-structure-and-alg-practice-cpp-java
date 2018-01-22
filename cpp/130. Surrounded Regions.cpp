class Solution {
public:
    void solve(vector<vector<char>>& board) {
        if (!board.size()) return;
        int m = board.size(), n = board[0].size();
        for (int i=0;i<m;i++){
            dfs(board, i, 0, m, n);
            dfs(board, i, n-1, m, n);
        }
        
        for (int j=0;j<n;j++){
            dfs(board, 0, j, m, n);
            dfs(board, m-1, j, m, n);
        }
        
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='1') board[i][j]='O';
            }
        }

    }
    
    vector<vector<int>> dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    void dfs(vector<vector<char>>& board, int i, int j, int m, int n){
        if (i>=0 && i<m && j>=0 && j<n && board[i][j]=='O'){
            board[i][j] = '1';
            for (auto& dir:dirs){
                dfs(board, i+ dir[0], j + dir[1], m,n);
            }
        }
    }
};