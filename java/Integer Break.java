// 343. Integer Break   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 34107
// Total Submissions: 76085
// Difficulty: Medium
// Contributors: Admin
// Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

// For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

// Note: You may assume that n is not less than 2 and not larger than 58.

// Hint:

// There is a simple O(n) solution to this problem.
// You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming Math
// Have you met this question in a real interview? Yes  

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2;i<=n;i++){
        	for (int j=1;j<=i/2;j++){
        		dp[i] = Math.max(dp[i],j*Math.max(dp[i-j],i-j));
        	}
        }
        return dp[n];
    }
}

// 1 = 0 + 1       dp[1] = 0
// 2 = 1 + 1 = 1*max(dp[1],1)  dp[2] = 1;
// 3 = 1 + 2 = 2 + 1 dp[3] = 1*max(dp[2],2) or 2*(1,dp[1]) = 2 or 2 = 2 
// 4 = 1 + 3 = 2 + 2 = 3 + 1    1*max(dp[3],3) or 2*max(dp[2],2) or 3*max(dp[1],1)  3 or 4 or 3 = 4
// 5 = 1 * max(dp[4],4) + 2*max(dp[3],3) 3 * max(dp[2],2) =6
// 6 = 1 * max(dp[5],5) + 2* (dp[4],4) + 3*dp[3],3  4*(dp[2],2) = 9
// 7 = 9, 12, 12, 8, 6, 0 = 12  2+3+2
// 8 = 12, 18, 18, 16 =18
// 9 = 18, 24, 27, 24 = 27   3 + 3 +3
//


// dp[i] = j * max(dp[i-j],i-j)  j = 1 to i/2