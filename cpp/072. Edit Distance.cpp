class Solution {
public:
    int minDistance(string a, string b) {
        // if a[i] == b[j] dp[i][j] = dp[i-1][j-1]
        // else dp[i][j] = min(dp[i-1][j-1],  dp[i-1][j],  dp[i][j-1]) + 1
        // dp[i][j] = minDistance(a.substr(0,i), b.substr(0,j));
        
        int m = a.size(), n = b.size();
        if (m==0) return n;
        if (n==0) return m;
        
        vector<vector<int>> dp(m+1, vector<int>(n+1,0));
        
        for (int i=0;i<=m;i++) dp[i][0] = i;
        for (int j=0;j<=n;j++) dp[0][j] = j;
        
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (a[i-1]==b[j-1]) dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1;
            }
        }
        return dp[m][n];
        
        
    }
};