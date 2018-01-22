// 64. Minimum Path Sum   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 96520
// Total Submissions: 259892
// Difficulty: Medium
// Contributors: Admin
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
// which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Subscribe to see which companies asked this question

// Hide Tags Array Dynamic Programming
// Hide Similar Problems (M) Unique Paths (H) Dungeon Game

public class Solution {
    public int minPathSum(int[][] grid) {
        
        // grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
        
        // 1 2 3   // 1 3 6 
        // 2 3 1   // 3 6 7
        // 1 1 1   // 4 5 6
    
        int m=grid.length, n = grid[0].length;
        for (int i=1;i<m;i++){
            grid[i][0] += grid[i-1][0]; 
        }
        
        for (int j=1;j<n;j++){
            grid[0][j] += grid[0][j-1]; 
        }
        
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]); 
            }
        }
        
        return grid[m-1][n-1];
    }
}




O(mn) time and O(m+1) space
public class Solution {
    public int minPathSum(int[][] grid) {
        
        // grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
        
        // 1 2 3   // 1 3 6 
        // 2 3 1   // 3 6 7
        // 1 1 1   // 4 5 6
        
        // 1 3
        if (grid.length==0) return 0;
        int m=grid.length, n = grid[0].length;
        int[] dp = new int[m];


        
        dp[0] = grid[0][0];
        for (int i=1;i<m;i++){
        	dp[i] = dp[i-1] +  grid[i][0];
        }
        
        for (int j=1;j<n;j++){
        	dp[0] = dp[0] + grid[0][j];
        	for (int i=1;i<m;i++){
                dp[i] = Math.min(dp[i-1], dp[i]) + grid[i][j]; 
            }
        }
        
        return dp[m-1];
    }
}