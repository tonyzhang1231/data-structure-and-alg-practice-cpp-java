// 97. Interleaving String   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 62835
// Total Submissions: 262384
// Difficulty: Hard
// Contributors: Admin
// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming String

// Here is some explanation:

// DP table represents if s3 is interleaving at (i+j)th position when s1 is at ith position, 
// and s2 is at jth position. 0th position means empty string.

// So if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving. 
// If only s1 is empty, then if previous s2 position is interleaving and
// current s2 position char is equal to s3 current position char, it is considered interleaving. 
// similar idea applies to when s2 is empty. 
// when both s1 and s2 is not empty, then if we arrive i, j from i-1, j, 
// then if i-1,j is already interleaving and i and current s3 position equal, it s interleaving. 
// If we arrive i,j from i, j-1, then if i, j-1 is already interleaving and j and current s3 position equal. 
// it is interleaving.

// dp[i][j] = true means s3.substring(0,i+j) is interleaving of s1.substring(0,i) and s2.substring(0,j)
// if (s3.charAt(i+j-1) == s1.charAt(i-1) ) dp[i][j] = dp[i-1][j]


public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
	    int length1 = s1.length(), length2 = s2.length(), length3 = s3.length();
	    if (length3 != length1 + length2)
	        return false;
	    boolean[][] dp = new boolean[length1 + 1][length2 + 1];
	    dp[0][0] = true;
	    for (int i = 0; i < length1; i++)
	        dp[i+1][0] = s1.charAt(i)==s3.charAt(i) && dp[i][0];
	    for (int i = 0; i < length2; i++)
	        dp[0][i+1] = s2.charAt(i)==s3.charAt(i) && dp[0][i];
	    for (int i = 0; i < length1; i++) {
	        for (int j = 0; j < length2; j++) {
	            dp[i+1][j+1] = (dp[i][j+1] && s1.charAt(i) == s3.charAt(i + j + 1)) || (dp[i+1][j] && s2.charAt(j) == s3.charAt(i + j + 1));
	        }
	    }
	    return dp[s1.length()][s2.length()];
	}
}