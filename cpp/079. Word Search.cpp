class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size(), n = board[0].size();
        
        for (int i = 0;i<m;i++){
            for (int j=0;j<n;j++){
                if (dfs(board, word, i,j,0)) return true;
            }
        }
        return false;
        
    }
    
    int dirs[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
    
    bool dfs(vector<vector<char>>& board, string& word, int i, int j, int pos){
        if (pos == word.size()) return true;
        if (i<0 || i>= board.size() || j<0 || j>=board[0].size() || board[i][j] == '#') return false;
        if (board[i][j]!=word[pos]) return false;
        
            
        char c = board[i][j];
        board[i][j] = '#';
        for (auto& dir: dirs){
            if (dfs(board, word, i+dir[0], j+dir[1], pos+1)) return true;
        }
        board[i][j] = c;
        return false;
        
    }
};