// 115. Distinct Subsequences   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 63503
// Total Submissions: 207365
// Difficulty: Hard
// Contributors: Admin
// Given a string S and a string T, count the number of distinct subsequences of T in S.

// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// Here is an example:
// S = "rabbbit", T = "rabbit"

// Return 3.


// O(n) space
public class Solution {
    public int numDistinct(String s, String t) {
        // dp[i][j] = numDistinct(s[0:i], t[0:j])
        // if (s[i]==t[j]) dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
        // else dp[i+1][j+1] = dp[i][j+1];
        int m = s.length(), n = t.length();
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i=0;i<m;i++){
            int prev = dp[0];
            for (int j=0;j<n;j++){
                int temp = dp[j+1] // old dp[j+1]

                // update dp[j+1]
                if (s.charAt(i)==t.charAt(j)) dp[j+1] = prev + dp[j+1];
                // else dp[[j+1] = dp[j+1];

                prev = temp;
            }
        }
        // s = "ar" => "a", "r" + "a", ""
        // t = "r"
        
        return dp[n];
    }
}



public class Solution {
    public int numDistinct(String s, String t) {
        // dp[i][j] = numDistinct(s[0:i], t[0:j])
        // if (s[i]==t[j]) dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
        // else dp[i+1][j+1] = dp[i][j+1];
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            dp[i][0] = 1;
        }
        
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (s.charAt(i)==t.charAt(j)) dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                else dp[i+1][j+1] = dp[i][j+1];
            }
        }
        // s = "ar" => "a", "r" + "a", ""
        // t = "r"
        
        return dp[m][n];
    }
}