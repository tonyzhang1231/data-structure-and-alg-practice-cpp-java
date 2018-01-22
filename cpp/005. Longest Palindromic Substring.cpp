class Solution {
public:
    string longestPalindrome(string s) {
        if (s.size()==0) return "";
        int maxLen = 0;
        string res = "";
        for (int i=0;i<s.length();i++){
            string tmpStr = helper(s , i, i);
            if (tmpStr.length() > maxLen) {
                maxLen = tmpStr.length();
                res = tmpStr;
            }

            tmpStr = helper(s , i, i+1);
            if (tmpStr.length() > maxLen) {
                maxLen = tmpStr.length();
                res = tmpStr;
            }
        }
        return res;
    }

    string helper(string s, int i, int j){
        while (i>=0 && j<s.length() && s[i]==s[j]){
            i--;j++;
        }
        return s.substr(i+1,j-i-1);
    }
};
