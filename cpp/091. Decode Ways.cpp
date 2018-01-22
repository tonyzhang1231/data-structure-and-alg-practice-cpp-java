class Solution {
public:
    int numDecodings(string s) {
        // dp[i] = dp[i-1] if s[i-1]!='0'
        // dp[i] = 0 if s[i-2:i-1] >26
        // dp[i] = dp[i-2] if s[i-2:i] == '10' or '20'
        
        if (s.size()==0 || s[0]=='0') return 0;
        
        int pre2 = 1, pre1 = 1; // start with 1
        
        for (int i=1;i<s.size();i++){
            if (s[i]=='0'){
                if (s[i-1]=='2'||s[i-1]=='1') {
                    int tmp = pre1;
                    pre1 = pre2;
                    pre2 = tmp;
                }else{
                    return 0;
                }
            }else{ // s[i]!=0
                if (s[i-1]=='1'||s[i-1]=='2' && s[i]<='6'){
                    int oldpre1 = pre1;
                    pre1 = pre1 + pre2;
                    pre2 = oldpre1;
                }else{
                    // pre1 = pre1;
                    pre2 = pre1;
                }
            }
        }
        return pre1;
        
    }
};