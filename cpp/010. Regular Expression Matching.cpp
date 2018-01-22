class Solution {
public:
    bool isMatch(string s, string p) {
        int m = s.size(), n = p.size();
        bool dp[m+1][n+1]; //default is arbitrary
        dp[0][0] = true;
        
        // p == "", s not empty
        for (int i=1;i<=m;i++){
            dp[i][0] = false;
        }
        
        // s == "", p not empty
        for (int j=1;j<=n;j++){
            dp[0][j] = p[j-1]=='*' && dp[0][j-2]; // assume the first of p is not '*'
        }
        
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (s[i-1]==p[j-1] || p[j-1]=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p[j-1]=='*'){
                    if (s[i-1]==p[j-2] || p[j-2]=='.')
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    else
                        dp[i][j] = dp[i][j-2];
                }else
                    dp[i][j] = false; // must add this, since init value are arbitrary
            }
        }
        return dp[m][n];
    }
};