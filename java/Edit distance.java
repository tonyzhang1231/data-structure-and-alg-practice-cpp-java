
// Let following be the function definition :-

// f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

// Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.

// f(i, j) = f(i - 1, j - 1)
// Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper

// f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
// f(i, j - 1) represents insert operation
// f(i - 1, j) represents delete operation
// f(i - 1, j - 1) represents replace operation


O(mn) time and O(mn) space
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1]; // for string, usually need 1 more space
        for(int i = 0; i <= m; i++)
            dp[i][0] = i;
        for(int i = 1; i <= n; i++)
            dp[0][i] = i;
        
        for(int i = 0; i < m; i++) {  // if 1 more space is used, dp[i+1][j+1] <=> s.charAt(i) t.charAt(j)
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i+1][j],dp[i][j+1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}



// O(mn) time and O(m) space
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // int[][] dp = new int[m + 1][n + 1]; // for string, usually need 1 more space
        // for(int i = 0; i <= m; i++)
        //     dp[i][0] = i;
        // for(int i = 1; i <= n; i++)
        //     dp[0][i] = i;
        int[] dp = new int[m + 1];
        for(int i = 0; i <= m; i++)
            dp[i] = i;
        
        // ""  "a"  "b"
        // 0    1
        // 1    
        // 2
        // 3

        for(int j = 0; j < n; j++) { // we have n columns to do
        	int prev = dp[0]; // old dp[0]
        	dp[0] = j+1; // update dp[0]
        	for(int i = 0; i < m; i++) {  // if 1 more space is used, dp[i+1][j+1] <=> s.charAt(i) t.charAt(j)
        		int temp = dp[i+1]; // old dp[i+1]

        		// update dp[i+1]
                if(word1.charAt(i) == word2.charAt(j))
                    dp[i+1] = prev; // old dp[i]
                else {
                    dp[i+1] = Math.min(prev, Math.min(dp[i+1],dp[i])) + 1;
                }

                // prev = old dp[i+1];
                prev = temp;
            }
        }
        return dp[m];
    }
}