class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n = s.size();
        vector<bool> dp(n+1, false);
        unordered_set<string> wordSet(wordDict.begin(), wordDict.end());
        dp[0] = true;
        int maxlen = getmaxLen(wordDict);
        for (int i=1;i<=n;i++){
            for (int j=i-1;j>=0 and i-j<=maxlen;j--){
                if (dp[j] and wordSet.find(s.substr(j, i-j))!=wordSet.end()  ){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
    
    int getmaxLen(vector<string>& dict){
        int res = 0;
        for (auto& word: dict){
            // if (word.size()>res){
            //     res = word.size();
            // }
            res = word.size()>res?word.size():res;
        }
        return res;
    }
};


