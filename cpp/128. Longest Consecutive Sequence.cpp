// 128. Longest Consecutive Sequence


class Solution {
public:
    int longestConsecutive(vector<int>& A) {
        unordered_set<int> s(A.begin(), A.end());
        // for (const auto& a:A){
        //     s.insert(a);
        // }
        int res = 0;
        for (const auto& a:A){
            
            if (s.find(a-1)!=s.end()) continue;
            
            int m = 1;
            while (s.find(a+m)!=s.end()){
                m++;
            }
            res = max(res, m);
        }
        return res;
    }
};