class Solution {
public:
    int numDistinct(string s, string t) {
        int m = s.size(), n = t.size();
        vector<vector<int>> dp(m+1, vector<int>(n+1,0));
        
        // dp[i][j]     =    numDistinct(s.substr(0,i), t.substr(0,j));
        
        for (int i=0;i<=m;i++) dp[i][0] = 1; // first col
        
        // dp[0][j] =0; if s empty t not empty, then 0
        // dp[i][j] = dp[i-1][j] if s[i-1]!=t[j-1]
        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j] if s[i-1]==t[j-1]
        for (int i=1; i<=m;i++){
            for (int j=1;j<=n;j++){
                if (s[i-1]==t[j-1]){
                    dp[i][j] = dp[i-1][j-1]+ dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
        
    }
};

// space can be reduced down to O(min(m,n))
