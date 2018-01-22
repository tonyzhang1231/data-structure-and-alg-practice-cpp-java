// 375. Guess Number Higher or Lower II   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 14736
// Total Submissions: 42030
// Difficulty: Medium
// Contributors: Admin
// We are playing the Guess Game. The game is as follows:

// I pick a number from 1 to n. You have to guess which number I picked.

// Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

// However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

// Example:

// n = 10, I pick 8.

// First round:  You guess 5, I tell you that it's higher. You pay $5.
// Second round: You guess 7, I tell you that it's higher. You pay $7.
// Third round:  You guess 9, I tell you that it's lower. You pay $9.

// Game over. 8 is the number I picked.

// You end up paying $5 + $7 + $9 = $21.
// Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

// Hint:

// The best strategy to play the game is to minimize the maximum loss you could possibly face. 
// Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
// Take a small example (n = 3). What do you end up paying in the worst case?
// Check out this article if you're still stuck.
// The purely recursive implementation of minimax would be worthless for even a small n. 
// You MUST use dynamic programming.
// As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, 
// instead of the worst-case loss?
// Credits:
// Special thanks to @agave and @StefanPochmann for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming
// Hide Similar Problems (M) Flip Game II (E) Guess Number Higher or Lower (M) Can I Win



// For each number x in range[i~j]
// we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
// --> // the max means whenever you choose a number, the feedback is always bad and therefore 
// leads you to a worse branch.
// then we get DP([i~j]) = min{xi, ... ,xj}  
// --> // this min makes sure that you are minimizing your cost.


O(N^3)
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++)
            for (int i = 1; i + len - 1<= n; i++) {
                int j = i + len - 1;  // j > i
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
            }
        return dp[1][n];
    }
}

O(N^3)
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int j=2;j<=n;j++){
            for (int i=j-1;i>=1;i--){
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i;k<=j;k++){
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k-1], dp[k+1][j]));
                }
            }
        }
        return dp[1][n];
    }
}

O(N^3)
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        return DP(table, 1, n);
    }
    
    int DP(int[][] t, int s, int e){  // for loop + divide and conquer, => use memorization
        if(s >= e) return 0;
        if(t[s][e] != 0) return t[s][e];
        int res = Integer.MAX_VALUE;
        for(int x=s; x<=e; x++){
            int tmp = x + Math.max(DP(t, s, x-1), DP(t, x+1, e));
            res = Math.min(res, tmp);
        }
        t[s][e] = res;
        return res;
    }
}