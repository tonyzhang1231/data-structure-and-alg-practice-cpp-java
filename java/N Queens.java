// N Queens

N Queens 1

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> nQueens = new ArrayList<List<String>>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++) str.append('.');
        backtrack(nQueens, new ArrayList<String>(), str, new boolean[n], new boolean[2*n], new boolean[2*n], 0, n);
        return nQueens;
    }
    
    public void backtrack(List<List<String>> nQueens, List<String> currQueens, StringBuilder str, boolean[] cols, 
        boolean[] diag1, boolean[] diag2, int row, int size) {
        if(row == size) {
            nQueens.add(new ArrayList<String>(currQueens));
            return;
        }
        
        for(int i = 0; i < size; i++) {
            int i1 = row + i;
            int i2 = i - row + size - 1; 
            if(!cols[i] && !diag1[i1] && !diag2[i2]) {
                cols[i] = true;
                diag1[i1] = true;
                diag2[i2] = true;
                str.setCharAt(i, 'Q');
                currQueens.add(str.toString());
                str.setCharAt(i, '.');
                backtrack(nQueens, currQueens, str, cols, diag1, diag2, row+1, size);
                currQueens.remove(currQueens.size()-1);
                cols[i] = false;
                diag1[i1] = false;
                diag2[i2] = false;
            }
        }
    }
}


// N Queens 2

public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }
    
    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;
            
            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}