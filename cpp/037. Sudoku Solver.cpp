class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board, 0,0);
    }

    bool solve(vector<vector<char>>& board, int i, int j){
        if (i==9) return true;
        if (j==9) return solve(board, i+1, 0);
        
        if (board[i][j]!='.') return solve(board, i, j+1);

        for (int k=1;k<=9;k++){
            board[i][j] = (char) (k + '0');
            if (isValid(board, i ,j)){
                if (solve(board, i ,j+1)) return true;
            }
            board[i][j] = '.';
        }
        return false;
    }

    bool isValid(vector<vector<char>>& board, int i, int j) {
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][j] == board[i][col]) return false;
        }
        for (int row = 0; row < 9; row++) {
            if (row != i && board[i][j] == board[row][j]) return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {//see how to iterate the submatrix
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {//col < j / 3 * 3 + 3, not col < i / 3 * 3 + 3 !!!!!!!!!!!!
                if ((row != i || col != j) && board[i][j] == board[row][col]) return false;//use ||, not && !!!!!!!!!!!!!!
            }
        }
        return true;
    }

};
