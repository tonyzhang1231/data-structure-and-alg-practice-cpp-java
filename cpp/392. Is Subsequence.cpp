class Solution {
public:
    bool isSubsequence(string s, string t) {
        vector<int> pres[26]; // 26 vectors of int
        for(int i = 0; i < t.size(); i++){
            pres[t[i] - 'a'].push_back(i);
        }
        int prev = -1;
        for(int i = 0; i < s.size(); i++){
            if(pres[s[i] - 'a'].size() == 0) return false;
            else{
                vector<int>::iterator it = upper_bound(pres[s[i] - 'a'].begin(), pres[s[i] - 'a'].end(), prev);
                if(it == pres[s[i] - 'a'].end()) return false;
                prev = *(it);
            }
        }
        return true;
    }
};