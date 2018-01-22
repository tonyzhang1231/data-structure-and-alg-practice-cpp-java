class Solution {
public:

    vector<string> map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if (digits == "") return res;
        string tmp;
        dfs(digits, res, tmp, 0); // can not do dfs(digits, res, "", 0);
        return res;
    }

    // dfs
    void dfs(const string& digits, vector<string>& res, string& tmp, int start){
        if (start == digits.length()){
            res.push_back(tmp); // make a copy of tmp
            return;
        }

        string letters = map[digits[start] - '0'];
        for (int i=0;i<letters.length();i++){
            tmp += letters[i];
            dfs(digits, res, tmp, start + 1);
            tmp.erase(tmp.size()-1);
        }

    }
};
