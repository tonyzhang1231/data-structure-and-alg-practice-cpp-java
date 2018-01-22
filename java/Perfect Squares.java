// 279. Perfect Squares   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 62224
// Total Submissions: 177660
// Difficulty: Medium
// Contributors: Admin
// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


// dp
public class Solution {
    public int numSquares(int n) {
        
        // dp[i] = dp[i-j*j] + 1, dp[4] = 1 + dp[0]= 1
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1;i<=n;i++){
            for (int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j] + 1);
            }
        }
        return dp[n];
        
        
    }
}