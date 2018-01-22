class Solution {
public:
    string shortestPalindrome(string s) {
        int j = 0;
        for (int i=s.size()-1;i>=0;i--){
            if (s[i]==s[j]) j++;
        }
        if (j==s.size()) return s;
        string suffix = s.substr(j);
        string rev = suffix;
        std::reverse(rev.begin(),rev.end());
        return rev + shortestPalindrome(s.substr(0,j)) + suffix;
    }
};


