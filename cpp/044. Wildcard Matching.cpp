class Solution {
public:
    bool isMatch(string s, string p) {
        
        int m = s.size(), n = p.size();
        bool dp[m+1][n+1];
        for (int i=0;i<m+1;i++)
            for (int j=0;j<n+1;j++)
                dp[i][j] = false;
        
        dp[0][0] = true;
        
        // p=="", s non empty
        for (int i=1;i<m+1;i++){
            dp[i][0] = false;
        }
        
        // s=="", p non empty
        for (int j=1;j<n+1;j++){
            dp[0][j] = p[j-1]=='*' && dp[0][j-1];
        }
        
        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (s[i-1]==p[j-1] || p[j-1]=='?') dp[i][j] = dp[i-1][j-1];
                else if(p[j-1]=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
};